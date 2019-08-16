package com.neusoft.managerment.feeinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.managerment.feeinfo.mapper.IM_typeMapper;
import com.neusoft.managerment.feeinfo.model.M_typeModel;
import com.neusoft.managerment.feeinfo.service.IM_typeService;
@Service
public class M_typeServiceImpl implements IM_typeService{

	@Autowired IM_typeMapper typemapper = null;
	@Override
	public void add(M_typeModel mtype) throws Exception {
		typemapper.create(mtype);
		
	}

	@Override
	public void modify(M_typeModel mtype) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(M_typeModel mtype) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
