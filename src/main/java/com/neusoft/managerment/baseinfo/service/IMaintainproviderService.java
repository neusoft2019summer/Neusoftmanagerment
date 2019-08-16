package com.neusoft.managerment.baseinfo.service;

import com.neusoft.managerment.baseinfo.model.MaintainProviderModel;

/**
 *    模块：基础信息   表：维修单位 类型 maintainprovider
 *    author : 张梓琪
 *    version: 1.0
 */
public interface IMaintainproviderService {
	//增加
	public void add(MaintainProviderModel maintainmodel)throws Exception;
	//删除
	public void delete(MaintainProviderModel maintainmodel)throws Exception;
	//修改
	public void update(MaintainProviderModel maintainmodel)throws Exception;

	
}
