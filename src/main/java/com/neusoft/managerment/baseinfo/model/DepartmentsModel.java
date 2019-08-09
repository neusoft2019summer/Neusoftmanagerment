package com.neusoft.managerment.baseinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的部门信息Model
 */
@Alias("Departments")
@Data
public class DepartmentsModel {
	private int deptno = 0;
	private String deptname = null;
	private String ddesc = null;

}
