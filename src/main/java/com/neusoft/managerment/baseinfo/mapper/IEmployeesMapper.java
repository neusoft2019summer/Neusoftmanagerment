package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.DepartmentsModel;
import com.neusoft.managerment.baseinfo.model.EmployeesModel;




/**
 *    author : 丘嘉茹
 *    version: 1.0
 *    人事管理信息模块的员工档案管理信息dao
 */
//员工档案管理的Mapper接口
@Mapper
public interface IEmployeesMapper {
	//增加
	public void create(EmployeesModel empModel) throws Exception;
	//修改
	public void update(EmployeesModel empModel) throws Exception;
	//删除
	public void delete(EmployeesModel empModel) throws Exception;
	//查询员工档案信息
	public List<EmployeesModel> selectListByAll() throws Exception;
	public List<EmployeesModel> selectEmpListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//返回指定员工的信息
	public EmployeesModel selectEmpByID(int id) throws Exception;
	//取得个数
	public int selectCountByAll() throws Exception;
	//取得页数
	public int selectPageCountByAll(int rows) throws Exception;
}
