package com.neusoft.managerment.baseinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 丘嘉茹
 *    version: 1.0
 *    人事管理信息模块的部门管理信息Model
 */
@Alias("Departments")
@Data
public class DepartmentsModel {
	private int deptno = 0;
	private String deptname = null;
	private String ddesc = null;

}
