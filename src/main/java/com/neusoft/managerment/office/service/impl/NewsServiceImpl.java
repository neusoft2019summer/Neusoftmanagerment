package com.neusoft.managerment.office.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.office.mapper.INewsMapper;
import com.neusoft.managerment.office.model.NewsModel;
import com.neusoft.managerment.office.service.INewsService;


//新闻的业务实现类
@Service("newsservice")
public class NewsServiceImpl implements INewsService  {
	
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
	public List<NewsModel> getnewsbyall() throws Exception {
		return newsmapper.selectListByAll();
	}

	@Override
	public List<NewsModel> getnewsbytype(String newstype) throws Exception {
		List<NewsModel> list = newsmapper.selectListType(newstype);
		return list;
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<NewsModel> getListByAllWithPage(int rows, int page) throws Exception {
		return newsmapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getcountbyall() throws Exception {
		return newsmapper.selectcountbyall();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getcountbyall();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	@Transactional(readOnly = true)
	public NewsModel getByNo(int newsno) throws Exception {
		
		return newsmapper.selectbyno(newsno);
	}

	
}

