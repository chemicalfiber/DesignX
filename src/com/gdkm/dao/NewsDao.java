package com.gdkm.dao;

import java.util.List;

import com.gdkm.po.News;

public interface NewsDao {
   //创建新闻
	public int addNews(News news);
	//查询新闻列表
	public List<News> findNewsList(News news);
	//查询新闻数
	public int findNewsListCount(News news);
	//删除新闻
	int deleteNews(int newsId);
	//通过id查询新闻
	public News findNewsById(int newsId);
	//查询图片新闻列表
	public List<News> findNewsListByPic();
}
