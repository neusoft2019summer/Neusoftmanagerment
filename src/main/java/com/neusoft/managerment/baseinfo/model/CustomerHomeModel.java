package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

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
	private int customerno = 0;
	private int roomno = 0;
	private int livingtypeno = 0;
	private Date receivedate = null;
	private Date livedate = null;
	private int hunmancount = 0;
	
}
