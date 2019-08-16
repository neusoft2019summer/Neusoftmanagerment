package com.neusoft.managerment.baseinfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.baseinfo.model.MaintainProviderModel;

/**
 *    模块：系统基础信息模块   表：维修单位maintainprovide
 *    author : 张梓琪
 *    version: 1.0
 */
//维修单位的Mapper接口
@Mapper
public interface IMaintainProviderMapper {
	//增加
	public void create (MaintainProviderModel maintanprovidermodel) throws Exception;
	//删除 
	public void delete (MaintainProviderModel maintanprovidermodel)throws Exception;
	//修改 
	public void update (MaintainProviderModel maintanprovidermodel)throws Exception;
		
	

}
