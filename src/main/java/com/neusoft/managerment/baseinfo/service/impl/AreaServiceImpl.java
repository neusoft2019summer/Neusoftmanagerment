package com.neusoft.managerment.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.IAreaMapper;
import com.neusoft.managerment.baseinfo.model.AreaModel;
import com.neusoft.managerment.baseinfo.service.IAreaService;
/**
 *    模块：基础信息   表：小区 Area
 *    author : 吕淑兰
 *    version: 1.0
 */

//小区的业务实现类
@Service("areaService")
@Transactional(rollbackFor=Exception.class)
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private IAreaMapper areaMapper=null;
	
	@Override
	public void add(AreaModel areaModel) throws Exception {
		areaMapper.create(areaModel);

	}

	@Override
	public void modify(AreaModel areaModel) throws Exception {
		areaMapper.update(areaModel);

	}

	@Override
	public void delete(AreaModel areaModel) throws Exception {
		areaMapper.delete(areaModel);

	}

	@Override
	public List<AreaModel> getAreaListByAll() throws Exception {
		
		return areaMapper.selectAreaListByAll();
	}

	@Override
	public AreaModel getAreaByNo(int no) throws Exception {
		
		return areaMapper.selectAreaByNo(no);
	}

}
