package com.neusoft.managerment.office.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.managerment.office.mapper.INewsMapper;
import com.neusoft.managerment.office.model.NewsModel;
import com.neusoft.managerment.office.service.INewsService;


//新闻的业务实现类
@Service("newsservice")
public class NewsServiceImpl implements INewsService  {
	/*
	private SqlSessionFactory sessionfactory = null;
	@Autowired
	private INewsMapper newsmapper = null;

	@Override
	public void relesenews(NewsModel newsmodel) throws Exception {
		newsmapper.create(newsmodel);
		
	}

	@Override
	public void deletenews(NewsModel newsmodel) throws Exception {
		// TODO Auto-generated method stub
		newsmapper.delete(newsmodel);
		
	}

	@Override
	public void modifynews(NewsModel newsmodel) throws Exception {
		// TODO Auto-generated method stub
		newsmapper.update(newsmodel);
		
	}

	@Override
	public List<NewsModel> searchnewsbyall() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsModel searchnewsbytype() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	*/

}
