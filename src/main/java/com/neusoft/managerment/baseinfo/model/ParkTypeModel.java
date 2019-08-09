package com.neusoft.managerment.baseinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的车位类型Model
 */
@Alias("parktype")
@Data
public class ParkTypeModel {

	private int typeno = 0;
	private String typename = null;
	private int unitprice = 0;
	private String unit = null;
}
