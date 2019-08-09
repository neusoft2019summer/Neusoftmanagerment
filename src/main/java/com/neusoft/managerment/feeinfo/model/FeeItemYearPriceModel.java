package com.neusoft.managerment.feeinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
   *   系统基础信息模块的收费项目年度价格Model
 */
@Alias("FeeItemYearPrice")
@Data
public class FeeItemYearPriceModel {
	
	private String feeyear = null;
	private int itemno = 0;
	private int unitprice = 0;
	private Date startdate = null;
	private Date enddate = null;
	private String pricedesc = null;
	
	
	

}
