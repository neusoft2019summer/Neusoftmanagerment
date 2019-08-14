package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import com.neusoft.managerment.baseinfo.model.CustomerHomeModel;


/**
 *    模块：基础信息   表：客户房间 CustomerHome
 *    author : 陈思颖
 *    version: 1.0
 */
public interface ICustomerHomeService {
	//增加
	public void add(CustomerHomeModel customerhome) throws Exception;
	//修改
	public void modify(CustomerHomeModel customerhome) throws Exception;
	//删除
	public void delete(CustomerHomeModel customerhome) throws Exception;
	//取得所有客户房间列表
	public List<CustomerHomeModel> getListByAll() throws Exception;
	//取得单个客户房间对象，
	public CustomerHomeModel getByCHNO(int chno) throws Exception;
	//取得所有客户房间列表,分页模式
	public List<CustomerHomeModel> getListByAllWithPage(int rows,int page) throws Exception;

}
