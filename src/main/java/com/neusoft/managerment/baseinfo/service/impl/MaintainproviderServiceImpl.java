package com.neusoft.managerment.baseinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.IMaintainProviderMapper;
import com.neusoft.managerment.baseinfo.model.MaintainProviderModel;
import com.neusoft.managerment.baseinfo.service.IMaintainproviderService;
/**
 *    模块：基础信息   表：维修单位 maintainprovider
 *    author : 张梓琪
 *    version: 1.0
 */

//客户类型的业务实现类
@Service("MainTainService")
@Transactional(rollbackFor=Exception.class)
public class MaintainproviderServiceImpl implements IMaintainproviderService{

	@Autowired
	public IMaintainProviderMapper maintainmapper = null;
	@Override
	public void add(MaintainProviderModel maintainmodel) throws Exception {
		maintainmapper.create(maintainmodel);
		
	}

	@Override
	public void delete(MaintainProviderModel maintainmodel) throws Exception {
		maintainmapper.delete(maintainmodel);
		
	}

	@Override
	public void update(MaintainProviderModel maintainmodel) throws Exception {
		maintainmapper.update(maintainmodel);
		
	}

}
