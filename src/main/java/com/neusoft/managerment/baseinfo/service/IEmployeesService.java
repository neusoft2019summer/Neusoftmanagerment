package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.CustomerModel;
import com.neusoft.managerment.baseinfo.model.EmployeesModel;



public interface IEmployeesService {
	//增加
	public void add(EmployeesModel employees) throws Exception;
	//修改
	public void modify(EmployeesModel employees) throws Exception;
	//删除
	public void delete(EmployeesModel employees) throws Exception;
	//查询部门信息
	public List<EmployeesModel> getListByAll() throws Exception;
	public List<EmployeesModel> getEmpListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//返回指定部门的信息
	public EmployeesModel getEmpByID(int id) throws Exception;
	//取得个数
	public int getCountByAll() throws Exception;
	//取得页数
	public int getPageCountByAll(int rows) throws Exception;
}
