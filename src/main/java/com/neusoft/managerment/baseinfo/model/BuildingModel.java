package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    模块：基础信息  表：楼宇  Building
 *    author : 吕淑兰
 *    version: 1.0
 */
@Alias("building")
@Data
public class BuildingModel implements Serializable {
	private int no=0;
	private AreaModel area=null;
	private String code=null;
	private String address=null;
	private BuildingTypeModel buildType=null;
	private String direction=null;
	private int home=0;
	private int house=0;

}
