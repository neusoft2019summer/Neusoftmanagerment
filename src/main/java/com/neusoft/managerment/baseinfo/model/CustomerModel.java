package com.neusoft.managerment.baseinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的客户Model
 */
@Alias("Customer")
@Data
public class CustomerModel {

	private int customerno = 0;
	private int typeno = 0;
	private String ccode = null;
	private String cname = null;
	private String contact = null;
	private String carcode = null;
	private String mobile = null;
	private String tel = null;
	private String fax = null;
	private String qq = null;
	private String weixin = null;
	private Date feestartdate = null;
	private Date feeenddate = null;
	private String cstatus = null;
	
}
