package com.neusoft.managerment.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.ICustomerHomeMapper;
import com.neusoft.managerment.baseinfo.model.CustomerHomeModel;
import com.neusoft.managerment.baseinfo.service.ICustomerHomeService;
/**
 *    模块：基础信息   表：客户房间 CustomerHome
 *    author : 陈思颖
 *    version: 1.0
 */

//客户房间的业务实现类
@Service("customerHomeService")
@Transactional(rollbackFor=Exception.class)
public class CustomerHomeServiceImpl implements ICustomerHomeService {

	@Autowired
	private ICustomerHomeMapper customerHomeMapper=null;
	
	@Override
	public void add(CustomerHomeModel customerhome) throws Exception {
		
		customerHomeMapper.create(customerhome);
	}

	@Override
	public void modify(CustomerHomeModel customerhome) throws Exception {
		
		customerHomeMapper.update(customerhome);
	}

	@Override
	public void delete(CustomerHomeModel customerhome) throws Exception {
		
		customerHomeMapper.delete(customerhome);
	}

	@Override
	public List<CustomerHomeModel> getListByAll() throws Exception {
		
		return customerHomeMapper.selectListByAll();
	}

	@Override
	public CustomerHomeModel getByCHNO(int chno) throws Exception {
		
		return customerHomeMapper.selectByCHNO(chno);
	}

	@Override
	public List<CustomerHomeModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return customerHomeMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

}
