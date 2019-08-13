package com.neusoft.managerment.feeinfo.service;

import com.neusoft.managerment.feeinfo.model.MaintainRecordModel;

/*
 * 维修报修业务层接口
 * @Author: 吕海东
 */
public interface IMaintainRecordService {

	//增加
	public void add(MaintainRecordModel maintainrecord) throws Exception;
	//修改
	public void modify(MaintainRecordModel maintainrecord) throws Exception;
	//删除
	public void delete(MaintainRecordModel maintainrecord) throws Exception;
	
	
}
