package com.gdkm.service;

import java.util.List;

import com.gdkm.po.News;
import com.gdkm.util.Page;

public interface NewsService {
   //新增新闻
	public int addNews(News news);
	//查询新闻列表
	public Page<News> findNewsList(int page,int rows,String title,String newsColumnId);
	//删除新闻
	int deleteNews(int newsId);
	//通过id查询新闻
	public News findNewsById(int newsId);
	//查询图片新闻列表
	public List<News> findNewsListByPic();
}
