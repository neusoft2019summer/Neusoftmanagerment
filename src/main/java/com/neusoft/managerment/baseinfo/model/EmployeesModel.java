package com.neusoft.managerment.baseinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的员工信息Model
 */
@Alias("Employees")
@Data
public class EmployeesModel {

	private String empid = null;
	private int deptno = 0;
	private String empname = null;
	private String sex = null;
	private int age = 0;
	private Date joindate = null;
	private String job = null;
	private String mobile = null;
	private String tel = null;
	private String qq = null;
	private String weixin = null;
}
