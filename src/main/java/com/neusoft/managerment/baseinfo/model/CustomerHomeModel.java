package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
   *    系统基础信息模块的客户房间Model
 */
@Alias("customerhome")
@Data
public class CustomerHomeModel implements Serializable {

	private int chno = 0;
	private CustomerModel customer = null;
	private RoomModel room = null;
	private LivingTypeModel livingtype = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date livedate = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date receivedate = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date feestartdate = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date feeenddate = null;
	private int humancount = 0;	
}
