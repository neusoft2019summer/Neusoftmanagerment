package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.BuildingTypeModel;
import com.neusoft.managerment.baseinfo.model.CustomerModel;

/**
 *    模块：基础信息   表：客户 Customer
 *    author : 陈思颖
 *    version: 1.0
 */
//客户的Mapper接口
@Mapper
public interface ICustomerMapper {
	//增加
	public void create(CustomerModel customerModel) throws Exception;
	//修改
	public void update(CustomerModel customerModel) throws Exception;
	//删除
	public void delete(CustomerModel customerModel) throws Exception;
	//取得客户的信息
	public List<CustomerModel> selectListByAll() throws Exception;
	//取得单个客户的信息
	public CustomerModel selectByCustomerNo(int customerno) throws Exception;
	//取得客户列表,有分页
	public List<CustomerModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得客户的个数
	public int selectCountByAll() throws Exception;
	//取得客户页数
	public int selectPageCountByAll(int rows) throws Exception;
}
