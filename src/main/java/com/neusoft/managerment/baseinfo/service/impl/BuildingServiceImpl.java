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
 * 楼宇业务层接口的实现类
 * @Author: 吕淑兰
 */

@Service
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
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByAll() throws Exception {
		
		return buildMapper.selectBuildListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByAllWithArea() throws Exception {
		
		return buildMapper.selectBuildListByAllWithArea();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByAllWithBuildType() throws Exception {
		
		return buildMapper.selectBuildListByAllWithBuildType();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByAllWithAreaAndBuildType() throws Exception {
		
		return buildMapper.selectBuildListByAllWithAreaAndBuildType();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByArea(int areaNo) throws Exception {
		
		return buildMapper.selectBuildListByArea(areaNo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getBuildListByBuildType(int buildTypeNo) throws Exception {
		
		return buildMapper.selectBuildListByBuildType(buildTypeNo);
	}

	@Override
	@Transactional(readOnly = true)
	public BuildingModel getBuildByNo(int no) throws Exception {
		
		return buildMapper.selectBuildByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingModel> getListByAllWithPage(int rows, int page) throws Exception {
		return buildMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return buildMapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int getPagaCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
