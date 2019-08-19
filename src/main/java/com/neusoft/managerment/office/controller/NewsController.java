package com.neusoft.managerment.office.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.neusoft.managerment.message.ResultMessage;
import com.neusoft.managerment.office.model.NewsModel;
import com.neusoft.managerment.office.service.INewsService;


@RestController
@RequestMapping(value="/news")
public class NewsController {
	
	@Autowired
	INewsService newservice = null;
	//查询所有新闻
	@RequestMapping(value="/tolist")
	public List <NewsModel>tolist()  throws Exception{
		
		return newservice.getnewsbyall();
	}
	//选择新闻类型
	@RequestMapping(value="/tolistbytype")
	public List<NewsModel> tolistbytype(String newstype) throws Exception{
		
		return newservice.getnewsbytype(newstype);
		
		
	}
	//删除新闻
	@RequestMapping(value="/delete")
	public ResultMessage<NewsModel> delete(NewsModel newsmodel) throws Exception{
		
		 newservice.deletenews(newsmodel);
		 return new ResultMessage<NewsModel>("OK","删除新闻成功");		
	}
	
	//增添
	@RequestMapping(value="/add")
	public ResultMessage<NewsModel> add(NewsModel newsmodel) throws Exception{
		
		newservice.relesenews(newsmodel);
		return new ResultMessage<NewsModel>("OK","增加新闻成功");		
	}
	
	//修改
		@RequestMapping(value="/modify")
		public ResultMessage<NewsModel> modify(NewsModel newsmodel) throws Exception{
			
			newservice.modifynews(newsmodel);
			return new ResultMessage<NewsModel>("OK","修改新闻成功");		
		}
		
	//取得新闻编号
		@RequestMapping(value="/get")
		public ResultMessage<NewsModel> get(int newsno) throws Exception{
			ResultMessage<NewsModel> result=new ResultMessage<NewsModel>("OK","取得新闻成功");
			result.setModel(newservice.getByNo(newsno));
			return result;
			
		}
		
	//取得新聞列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<NewsModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<NewsModel> result=new ResultMessage<NewsModel>("OK","新闻列表分页模式成功");	
		result.setList(newservice.getListByAllWithPage(rows, page));
		result.setCount(newservice.getcountbyall());
		result.setPageCount(newservice.getPageCountByAll(rows));
		result.setPage(page);
		result.setRows(rows);
		return result;
		}

}
