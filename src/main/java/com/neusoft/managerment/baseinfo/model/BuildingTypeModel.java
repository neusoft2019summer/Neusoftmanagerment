package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;
/**
 *    模块：基础信息  表：建筑类型 BuildingType
 *    author : 吕淑兰
 *    version: 1.0
 */

@Alias("buildingtype")
@Data
public class BuildingTypeModel implements Serializable {

	private int no=0;
	private String name=null;
	
	
}
