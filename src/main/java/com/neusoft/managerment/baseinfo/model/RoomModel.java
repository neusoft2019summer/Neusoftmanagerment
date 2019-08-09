package com.neusoft.managerment.baseinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的房间Model
 */
@Alias("room")
@Data
public class RoomModel {

	private int roomno = 0;
	private int housetypeno = 0;
	private int buildingno = 0;
	private String departmentcode = null;
	private String floor = null;
	private String roomcode = null;
	private int buildingarea = 0;
	private int feearea = 0;
	private String roomstatus = null;
	private String roomtype = null;
	
}
