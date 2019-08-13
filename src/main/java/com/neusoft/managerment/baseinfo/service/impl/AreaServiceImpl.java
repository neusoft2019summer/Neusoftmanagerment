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
 * 小区业务层接口的实现类
 * @Author: 吕淑兰
 */

@Service
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
	@Transactional(readOnly = true)
	public List<AreaModel> getAreaListByAll() throws Exception {
		
		return areaMapper.selectAreaListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public AreaModel getAreaByNo(int no) throws Exception {
		
		return areaMapper.selectAreaByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaModel> getListByAllWithPage(int rows, int page) throws Exception {
		return areaMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return areaMapper.selectCountByAll();
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

	@Override
	public boolean checkCanDelete(int no) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
