package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的车位Model
 */
@Alias("park")
@Data
public class ParkModel implements Serializable {

	private int parkno = 0;
	private int typeno = 0;
	private String parkcode = null;
	private int buildingno = 0;
	private String location = null;
	private int area = 0;
	private String parkstatus = null;
	private int rentprice = 0;
	private String rentunit = null;
	private String feestatus = null;
}
