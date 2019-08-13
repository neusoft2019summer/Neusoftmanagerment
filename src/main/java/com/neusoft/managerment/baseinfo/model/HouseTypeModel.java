package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("housetype")
@Data
public class HouseTypeModel implements Serializable {
	private int typeno = 0;
	private String typename = null;
	
}
