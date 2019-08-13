package com.neusoft.managerment.feeinfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.feeinfo.model.MaintainRecordModel;

/*
 * 维修报修的DAO层MyBatis Mapper接口
 * @Author: 张梓琪
 */

@Mapper
public interface IMaintainRecordMapper {
	
	//增添维修报修1
	public void insert(MaintainRecordModel maintainrecord) throws Exception;
	//修改v
	public void update(MaintainRecordModel maintainrecord) throws Exception;
	//删除
	public void delete(MaintainRecordModel maintainrecord) throws Exception;
	//取得所有部门列表分页
	
	

}
