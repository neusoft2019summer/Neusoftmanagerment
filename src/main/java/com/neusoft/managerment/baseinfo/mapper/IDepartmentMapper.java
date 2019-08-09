package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.baseinfo.model.DepartmentsModel;

/**
 *    author : 丘嘉茹
 *    version: 1.0
 *    人事管理信息模块的部门管理信息dao
 */
//部门管理的mapper接口
@Mapper
public interface IDepartmentMapper {
	//增加
	public void create(DepartmentsModel deptModel) throws Exception;
	//修改
	public void update(DepartmentsModel deptModel) throws Exception;
	//删除
	public void delete(DepartmentsModel deptModel) throws Exception;
	//查询员工档案信息
	public List<DepartmentsModel> selectDeptListByAll() throws Exception;
	//返回指定员工的信息
	public DepartmentsModel selectDeptByNo(int no) throws Exception;

}
