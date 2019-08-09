package com.neusoft.managerment.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.IBuildingMapper;
import com.neusoft.managerment.baseinfo.model.BuildingModel;
import com.neusoft.managerment.baseinfo.service.IBuildingService;

/**
 *    模块：基础信息  表：楼宇  Building
 *    author : 吕淑兰
 *    version: 1.0
 */
//楼宇的业务实现类
@Service("build")
@Transactional(rollbackFor=Exception.class)
public class BuildingServiceImpl implements IBuildingService {
	@Autowired
	private IBuildingMapper buildMapper=null;
	
	@Override
	public void add(BuildingModel buildModel) throws Exception {
		buildMapper.create(buildModel);

	}

	@Override
	public void modify(BuildingModel buildModel) throws Exception {
		buildMapper.update(buildModel);

	}

	@Override
	public void delete(BuildingModel buildModel) throws Exception {
		buildMapper.delete(buildModel);

	}

	@Override
	public List<BuildingModel> getBuildListByAll() throws Exception {
		
		return buildMapper.selectBuildListByAll();
	}

	@Override
	public List<BuildingModel> getBuildListByAllWithArea() throws Exception {
		
		return buildMapper.selectBuildListByAllWithArea();
	}

	@Override
	public List<BuildingModel> getBuildListByAllWithBuildType() throws Exception {
		
		return buildMapper.selectBuildListByAllWithBuildType();
	}

	@Override
	public List<BuildingModel> getBuildListByAllWithAreaAndBuildType() throws Exception {
		
		return buildMapper.selectBuildListByAllWithAreaAndBuildType();
	}

	@Override
	public List<BuildingModel> getBuildListByArea(int areaNo) throws Exception {
		
		return buildMapper.selectBuildListByArea(areaNo);
	}

	@Override
	public List<BuildingModel> getBuildListByBuildType(int buildTypeNo) throws Exception {
		
		return buildMapper.selectBuildListByBuildType(buildTypeNo);
	}

	@Override
	public BuildingModel getBuildByNo(int no) throws Exception {
		
		return buildMapper.selectBuildByNo(no);
	}

}
