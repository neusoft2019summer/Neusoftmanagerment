package com.neusoft.managerment.communityinfo.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.communityinfo.model.CommunityActiveModel;
import com.neusoft.managerment.communityinfo.service.ICommunityService;
import com.neusoft.managerment.message.ResultMessage;

@RestController
@RequestMapping(value="/community")
public class CommunityController {
	@Autowired
	ICommunityService communityservice = null;
	//查询所有新闻
	
	//增加新闻
	@RequestMapping(value="/add")
	public ResultMessage<CommunityActiveModel> add(CommunityActiveModel com) throws Exception{
		
		communityservice.add(com);
		return new ResultMessage<CommunityActiveModel>("ok","增加成功");
	}
	
	//删除活動
		@RequestMapping(value="/delete")
		public ResultMessage<CommunityActiveModel> delete(CommunityActiveModel com) throws Exception{
			
			communityservice.delete(com);
			return new ResultMessage<CommunityActiveModel>("ok","删除成功");
		}
		//修改活動
		@RequestMapping(value="/modify")
		public ResultMessage<CommunityActiveModel>modify (CommunityActiveModel com) throws Exception{
					
			communityservice.modify(com);
			return new ResultMessage<CommunityActiveModel>("ok","修改成功");
		}
		//查询所有活動
		@RequestMapping(value="/tolist")
		public List<CommunityActiveModel> listbyall(CommunityActiveModel com) throws Exception{
			return communityservice.getListByAll();
		}
		//查询指定地點類型活動
		@RequestMapping(value="/tolistbyplace")
		public List<CommunityActiveModel> listbyplace(String activeplace) throws Exception{
			return communityservice.getListByplace(activeplace);
		}
	/*
	 * //查询指定时间類型活動
	 * 
	 * @RequestMapping(value="/tolistbytime") public List<CommunityActiveModel>
	 * listbytime(Date activetime) throws Exception{ return
	 * communityservice.getListBytime(activetime); }
	 */
	
	@RequestMapping(value="/list/condition/page")
	public ResultMessage<CommunityActiveModel>  getListByConditionWitPage(@RequestParam(required = false,defaultValue ="1") int activeno,@RequestParam(required = false) String activeplace,
																		 @RequestParam(required = false )String activetype,@RequestParam(required = false) String activecontent,
			                                                              @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date startActiveDate,
			                                                              @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endActiveDate, 
			                                                              @RequestParam(required = false,defaultValue ="1") int page,@RequestParam(required = false,defaultValue ="5") int rows) throws Exception{
		
		ResultMessage<CommunityActiveModel> result = new ResultMessage<CommunityActiveModel>("ok","分页查询成功");
		result.setCount(communityservice.getCountByConditionWithpage(activeno, activeplace, activetype, activecontent, startActiveDate, endActiveDate));
		result.setList(communityservice.getListByConditionWithPage(activeno, activeplace, activetype, activecontent, startActiveDate, endActiveDate, page, rows));
		
		return result;
		
		
	}

}
