package com.neusoft.managerment.personnel.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.personnel.model.DepartmentsModel;

/**
 *    author : 丘嘉茹
 *    version: 1.0
 *    人事管理信息模块的部门管理信息
 */


public interface IDepartmentsService {
	//增加
	public void add(DepartmentsModel departments) throws Exception;
	//修改
	public void modify(DepartmentsModel departments) throws Exception;
	//删除
	public void delete(DepartmentsModel departments) throws Exception;
	//查询部门信息
	public List<DepartmentsModel> getDeptListByAll() throws Exception;
	public List<DepartmentsModel> getDeptListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//返回指定部门的信息
	public DepartmentsModel getDeptByNo(int deptno) throws Exception;
	//取得个数
	public int getCountByAll() throws Exception;

	//检查部门能否被删
	public boolean checkCanDelete(int no)throws Exception;
	//取得部门页数
	public int getPageCountByAll(int rows) throws Exception;
}
