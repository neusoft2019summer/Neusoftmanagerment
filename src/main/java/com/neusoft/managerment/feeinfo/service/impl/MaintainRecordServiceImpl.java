package com.neusoft.managerment.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.feeinfo.mapper.IMaintainRecordMapper;
import com.neusoft.managerment.feeinfo.model.MaintainRecordModel;
import com.neusoft.managerment.feeinfo.service.IMaintainRecordService;
/*
 * 
 * 维护维修业务层接口的实现类
 * @Author: 张梓琪
 */
@Service

public class MaintainRecordServiceImpl implements IMaintainRecordService{


	@Autowired
	private IMaintainRecordMapper maintainrecordmapper = null;

	@Override
	public void add(MaintainRecordModel maintainrecord) throws Exception {
		maintainrecordmapper.insert(maintainrecord);
		
	}

	@Override
	public void modify(MaintainRecordModel maintainrecord) throws Exception {
		maintainrecordmapper.update(maintainrecord);
		
	}

	@Override
	public void delete(MaintainRecordModel maintainrecord) throws Exception {
		maintainrecordmapper.delete(maintainrecord);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<MaintainRecordModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return maintainrecordmapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getcountbyall() throws Exception {
		
		return maintainrecordmapper.selectcountbyall();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		int pageCount=0;
		int count=this.getcountbyall();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	}
	



