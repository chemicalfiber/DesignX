package com.gdkm.dao;

import java.util.List;

import com.gdkm.po.NewsColumn;

public interface NewsColumnDao {
     //查询所有新闻栏目
	public List<NewsColumn> findAllNewsColumn();
	//通过id查询新闻栏目
	public NewsColumn findNewsColumnById(int newscolumnId);
}
