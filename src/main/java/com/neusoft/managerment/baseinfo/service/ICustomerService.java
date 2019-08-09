package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.CustomerModel;


/**
 *    模块：基础信息   表：客户 Customer
 *    author : 陈思颖
 *    version: 1.0
 */
public interface ICustomerService {
	//增加
	public void add(CustomerModel customer) throws Exception;
	//修改
	public void modify(CustomerModel customer) throws Exception;
	//删除
	public void delete(CustomerModel customer) throws Exception;
	//取得所有客户列表
	public List<CustomerModel> getListByAll() throws Exception;
	//取得客户单个对象，
	public CustomerModel getByCustomerNo(int customerno) throws Exception;
	//取得所有客户列表,分页模式
	public List<CustomerModel> getListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得客户的个数
	public int getCountByAll() throws Exception;
	//取得客户页数
	public int getPageCountByAll(int rows) throws Exception;
}
