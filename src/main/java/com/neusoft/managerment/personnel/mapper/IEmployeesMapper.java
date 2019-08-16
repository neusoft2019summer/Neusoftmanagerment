package com.neusoft.managerment.personnel.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.personnel.model.EmployeesModel;

/**
 *    author : 丘嘉茹
 *    version: 1.0
 *    人事管理信息模块的员工档案管理信息
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
	public List<EmployeesModel> selectEmpListByAll() throws Exception;
	//分页
	public List<EmployeesModel> selectEmpListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//返回指定员工的信息
	public EmployeesModel selectEmpByID(int id) throws Exception;
	//检索
	public List<EmployeesModel> selectListByConditionWithDepartments(@Param("departmentNo") int departmentNo,@Param("sex") String sex,@Param("startJoinDate") Date startJoinDate,@Param("endJoinDate") Date endJoinDate, @Param("start") int start,@Param("rows") int rows) throws Exception;
	//检索的个数
	public int selectCountByCondition(@Param("departmentNo") int departmentNo,@Param("sex") String sex,@Param("startJoinDate") Date startJoinDate,@Param("endJoinDate") Date endJoinDate) throws Exception;
}
