package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的房间Model
 */
@Alias("room")
@Data
public class RoomModel implements Serializable {

	private int roomno = 0;
	private AreaModel area = null;
	private BuildingTypeModel buildingtype = null;
	private HouseTypeModel housetype = null;
	private BuildingModel building = null;
	private String departmentcode = null;
	private String floor = null;
	private String roomcode = null;
	private BigDecimal buildingarea = null;
	private BigDecimal feearea = null;
	private String roomstatus = null;
	private String roomtype = null;
	
}
