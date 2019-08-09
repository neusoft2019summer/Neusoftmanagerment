package com.neusoft.managerment.feeinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;



import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的小区Model
 */
@Alias("MaintainRecord")
@Data
public class MaintainRecordModel {
	private int recordno = 0;
	private int mytypeno = 0;
	private int roomno = 0;
	private String contactname = null;
	private String mobile = null;
	private String tel = null;
	private Date mdate = null;
	private String mdesc = null;
	private String wempid = null;
	private Date wdate = null;
	private String wtask = null;
	private String wresult = null;
	private int wfee = 0;
	private int prociderno = 0;
	private String clientfeeback = null;

}
