package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.CustomerModel;
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
	//查询部门信息
	public List<DepartmentsModel> selectListByAll() throws Exception;
	public List<DepartmentsModel> selectDeptListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//返回指定部门的信息
	public DepartmentsModel selectDeptByNo(int no) throws Exception;
	//取得个数
	public int selectCountByAll() throws Exception;
	//取得页数
	public int selectPageCountByAll(int rows) throws Exception;
}
