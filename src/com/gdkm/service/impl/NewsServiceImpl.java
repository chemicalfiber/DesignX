package com.gdkm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdkm.dao.NewsDao;
import com.gdkm.po.News;
import com.gdkm.po.NewsColumn;
import com.gdkm.service.NewsService;
import com.gdkm.util.Page;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
    //注入newsDao
	@Autowired
	private NewsDao newsDao;
	//新增新闻
	@Override
	public int addNews(News news) {
		return newsDao.addNews(news);
	}
	 
	//查询新闻列表
	public Page<News> findNewsList(int page,int rows,String title,String newsColumnId){
		News news = new News();
		if(StringUtils.isNotBlank(title)) {
			news.setTitle(title);
		}
		if(StringUtils.isNotBlank(newsColumnId)) {
			NewsColumn newsColumn= new NewsColumn();
			newsColumn.setNewsColumnId(Integer.parseInt(newsColumnId));
			news.setNewsColumn(newsColumn);
		}
		news.setStart((page-1) * rows);
		news.setRows(rows);
		List<News> newsList = newsDao.findNewsList(news);
		int count = newsDao.findNewsListCount(news);
		Page<News> pageNewsList = new Page<News>();
		pageNewsList.setPage(page);
		pageNewsList.setRows(newsList);
		pageNewsList.setSize(rows);
		pageNewsList.setTotal(count);
		return pageNewsList;
	}
	//删除新闻

	@Override
	public int deleteNews(int newsId) {
		return newsDao.deleteNews(newsId);
	}
    //通过id查询新闻
	@Override
	public News findNewsById(int newsId) {
		return newsDao.findNewsById(newsId);
	}
    //查询新闻列表
	@Override
	public List<News> findNewsListByPic() {
		List<News> newsList = newsDao.findNewsListByPic();
		return newsList;
	}
	
}










