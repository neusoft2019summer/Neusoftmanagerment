package com.neusoft.managerment.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	//取得所有维修表单列表,分页模式
	public List<MaintainRecordModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	 //取得维修类型个数
	public int selectcountbyall() throws Exception;
	
	

}
