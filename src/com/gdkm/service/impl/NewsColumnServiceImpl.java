package com.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdkm.dao.NewsColumnDao;
import com.gdkm.po.NewsColumn;
import com.gdkm.service.NewsColumnService;


@Service
@Transactional
public class NewsColumnServiceImpl implements NewsColumnService{
    //注入newsColumnDao
	@Autowired
	private NewsColumnDao newsColumnDao;

	//查询新闻列表
	@Override
	public List<NewsColumn> findAllNewsColumn() {
		return newsColumnDao.findAllNewsColumn();
	}

	@Override
	public NewsColumn findNewsColumnById(int newscolumnId) {
		return newsColumnDao.findNewsColumnById(newscolumnId);
	}
	
	
}
