package com.neusoft.managerment.feeinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.neusoft.managerment.baseinfo.model.MaintainProviderModel;
import com.neusoft.managerment.baseinfo.model.RoomModel;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的小区Model 
 */
@Alias("MaintainRecord")
@Data
public class MaintainRecordModel implements Serializable {
	private int recordno = 0;
	//外键
	private M_typeModel mtypeno = null;
	//外键
	private RoomModel roomno = null;
	private String contactname = null;
	private String mobile = null;
	private String tel = null;
	private Date mdate = null;
	private String mdesc = null;
	//外键
	private WempidModel wempid = null;
	private Date wdate = null;
	private String wtask = null;
	private String wresult = null;
	private int wfee = 0;
	//外键
	private MaintainProviderModel prociderno = null;
	private String clientfeeback = null;

}
