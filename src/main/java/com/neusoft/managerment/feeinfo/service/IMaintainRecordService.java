package com.neusoft.managerment.feeinfo.service;

import java.util.List;

import com.neusoft.managerment.feeinfo.model.MaintainRecordModel;
import com.neusoft.managerment.office.model.NewsModel;

/*
 * 维修报修业务层接口
 * @Author: 张梓琪
 */
public interface IMaintainRecordService {

	//增加
	public void add(MaintainRecordModel maintainrecord) throws Exception;
	//修改
	public void modify(MaintainRecordModel maintainrecord) throws Exception;
	//删除
	public void delete(MaintainRecordModel maintainrecord) throws Exception;
	
	//取得所有维修保单列表,分页模式
    public List<MaintainRecordModel> getListByAllWithPage(int rows,int page) throws Exception;
    //取得维修保单个数
    public int getcountbyall() throws Exception;
   //取得维修页数
	public int getPageCountByAll(int rows) throws Exception;
	 
}
