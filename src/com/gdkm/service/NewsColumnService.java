package com.gdkm.service;

import java.util.List;

import com.gdkm.po.NewsColumn;

public interface NewsColumnService {
   //查询所有栏目
	public List<NewsColumn> findAllNewsColumn();
	
	//通过id查询新闻栏目
	public NewsColumn findNewsColumnById(int newscolumnId);
}
