package com.neusoft.managerment.baseinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    模块：基础信息   表：小区 Area
 *    author : 吕淑兰
 *    version: 1.0
 */
@Alias("area")
@Data
public class AreaModel implements Serializable {
	private int no=0;
	private String name=null;
	private String address=null;
	private String developer=null;
	private BigDecimal buildingarea=null;
	private BigDecimal usearea=null;
	private BigDecimal packarea=null;
	private int home=0;
	private int house=0;
	private int pack=0;
}
