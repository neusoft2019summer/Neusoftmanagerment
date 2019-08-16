package com.neusoft.managerment.feeinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	


}
