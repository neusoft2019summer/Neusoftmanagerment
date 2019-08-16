package com.neusoft.managerment.office.service;

import java.util.List;


import com.neusoft.managerment.office.model.NewsModel;

/*
 * 2019.8.9
   *      张梓琪
 * 新闻的业务接口
 * */
public interface INewsService {
	//发布新闻
	public void relesenews(NewsModel newsmodel) throws Exception;
	//删除新闻
	public void deletenews(NewsModel newsmodel) throws Exception;
	//修改新闻
	public void modifynews(NewsModel newsmodel) throws Exception;
	//查询新闻
	public List<NewsModel> getnewsbyall() throws Exception;
	public List<NewsModel> getnewsbytype(String newstype)throws Exception;
	
	//取得所有新闻列表,分页模式
   public List<NewsModel> getListByAllWithPage(int rows,int page) throws Exception;
	 

}
