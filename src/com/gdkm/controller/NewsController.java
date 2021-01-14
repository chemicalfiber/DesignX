package com.gdkm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdkm.po.Admin;
import com.gdkm.po.News;
import com.gdkm.po.NewsColumn;
import com.gdkm.service.NewsColumnService;
import com.gdkm.service.NewsService;
import com.gdkm.util.EncodeUtil;
import com.gdkm.util.Page;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
    @Autowired
    private NewsColumnService newsColumnService;
	//创建新闻（先单独上传文件之后，给出文件的保密路径，在保存新闻）
	@RequestMapping(value="/admin/news/addNews.action",method=RequestMethod.POST)
	public String addNews(@RequestParam("title")String title,@RequestParam("newsColumn")String newsColumn,
			@RequestParam("message")String message,@RequestParam("pic")String pic,HttpServletRequest request) {
		Integer newsColumnId=Integer.parseInt(newsColumn);
		NewsColumn nc=new NewsColumn();
		nc.setNewsColumnId(newsColumnId);
		String account = ((Admin)request.getSession().getAttribute("ADMIN_SESSION")).getAccount();
		String datePattern = "yyyy-MM-dd HH:mm:ss";
		String createTime  = new SimpleDateFormat(datePattern).format(new Date());
		News news=new News();
		news.setNewsColumn(nc);
		news.setTitle(title);
		news.setMessage(message);
		news.setPic(pic);
		news.setAccount(account);
		news.setNum(0);
		news.setCreateTime(createTime);
		int rows=newsService.addNews(news);
		if(rows > 0) {
			return "redirect:list.action";
		}else {
			return "redirect:add.action";
		}
	}
	
	//查询新闻列表，如果有搜索条件，则按照搜索条件查询新闻列表
	@RequestMapping("/admin/news/list.action")
	public String findNewsList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,
			String title,String newsColumnId,Model model,HttpServletRequest request) {
		  //对搜索的内容进行分页时候重新编码，解决乱码
		if(request.getMethod().toUpperCase()=="GET" && title!=null) {
			try {
				title=EncodeUtil.IsoToUtf8(title);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Page<News> pageNewsList= newsService.findNewsList(page, rows, title, newsColumnId);
		//添加搜索条件
	    List<NewsColumn> newsColumnList = newsColumnService.findAllNewsColumn();
	    model.addAttribute("newsColumnList", newsColumnList);
	    model.addAttribute("title", title);
	    model.addAttribute("newsColumnId", newsColumnId);
	    model.addAttribute("page", pageNewsList);
		return "admin/news";
	}
	
	//删除新闻
	@RequestMapping("/admin/news/delete.action")
	@ResponseBody
	public String deleteAdmin(int newsId) {
		int rows= newsService.deleteNews(newsId);
		if(rows > 0) {
			return "OK";
		}else{
			return "FAIL";
	}
}
	//根据id查询新闻详细
	@RequestMapping("/admin/news/view.action")
	@ResponseBody
	public News viewNews(int newsId,Model model) {
		News news = newsService.findNewsById(newsId);
		return news;
	}
	
	//-----------------------网站前台资讯模块-------------------------------
	//网站前台查询所有新闻列表
	@RequestMapping("/webs/toNews.action")
	 public String findWebNewsList(@RequestParam(defaultValue="1")int page,
			                       @RequestParam(defaultValue="5")int rows,
			                        String title,String newsColumnId,
			                        Model model,HttpServletRequest request) {
		//获取网站前台新闻列表分页数据
		Page<News> pageNewsList = newsService.findNewsList(page, rows, title, newsColumnId);
		List<NewsColumn> newsColumnList = newsColumnService.findAllNewsColumn();
		model.addAttribute("websNewsColumnList", newsColumnList);
		model.addAttribute("page", pageNewsList);
		return "web/news";
	}
	//网站前台根据id查询新闻详细
	@RequestMapping("/webs/newsview.action")
	public String viewWebNews(int newsId,Model model) {
		News news = newsService.findNewsById(newsId);
		model.addAttribute("websNews", news);
		return "webs/newsview";
	}
	
	//网站前台查询所有图片新闻列表
	@RequestMapping(value = "/webs/toPicNews.action",method = RequestMethod.GET)
	public String toWebpicnews(Model model) {
		List<News> picNewsList = newsService.findNewsListByPic();
		model.addAttribute("websPicNewsList", picNewsList);
		return "webs/picnews";
	}
	//网站前台按照栏目查询新闻信息
	@RequestMapping("/webs/findNewsByColumn.action")
	public String findWebNewsByColumn(@RequestParam(defaultValue="1")int page,
			                       @RequestParam(defaultValue="4")int rows,
			                        String title,String newsColumnId,
			                        Model model,HttpServletRequest request) {
		//按照栏目查询新闻列表
		Page<News> pageNewsList = newsService.findNewsList(page, rows, title, newsColumnId);
		List<NewsColumn> newsColumnList = newsColumnService.findAllNewsColumn();
		NewsColumn newsColumn = newsColumnService.findNewsColumnById(Integer.parseInt(newsColumnId));
		model.addAttribute("page", pageNewsList);
		model.addAttribute("websNewsColumnlist", newsColumnList);
		model.addAttribute("websNewsColumn", newsColumn);
		return "web/news";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
