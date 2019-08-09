package com.neusoft.managerment.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.IBuildingTypeMapper;
import com.neusoft.managerment.baseinfo.model.BuildingTypeModel;
import com.neusoft.managerment.baseinfo.service.IBuildingTypeService;
/**
 *    模块：基础信息  表：建筑类型 BuildingType
 *    author : 吕淑兰
 *    version: 1.0
 */
//建筑类型的业务实现类
@Service("buildType")
@Transactional(rollbackFor=Exception.class)
public class BuildingTypeServiceImpl implements IBuildingTypeService {
	@Autowired
	private IBuildingTypeMapper buildTypeMapper=null;
	
	@Override
	public void add(BuildingTypeModel buildTypeModel) throws Exception {
		buildTypeMapper.create(buildTypeModel);

	}

	@Override
	public void modify(BuildingTypeModel buildTypeModel) throws Exception {
		buildTypeMapper.update(buildTypeModel);

	}

	@Override
	public void delete(BuildingTypeModel buildTypeModel) throws Exception {
		buildTypeMapper.delete(buildTypeModel);
	}

	@Override
	public List<BuildingTypeModel> getBuildTypeListByAll() throws Exception {
		
		return buildTypeMapper.selectBuildTypeListByAll();
	}

	@Override
	public BuildingTypeModel getBuildTypeByNo(int no) throws Exception {
		
		return buildTypeMapper.selectBuildTypeByNo(no);
	}

}
