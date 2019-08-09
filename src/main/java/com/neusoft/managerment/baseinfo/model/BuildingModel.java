package com.neusoft.managerment.baseinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 */
@Alias("building")
@Data
public class BuildingModel {
	private int buildingno = 0;
	private int areano = 0;
	private String bcode = null;
	private String baddress = null;
	private int buildingtypeno = 0;
	private String direction = null;
	private int totalhome = 0;
	private int totalhouse = 0;

}
