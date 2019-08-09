package com.neusoft.managerment.feeinfo.model;



import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的收费项目Model
 */
@Alias("FeeItem")
@Data
public class FeeItemModel {
	private int itemno = 0;
	private String itemcode = null;
	private String itemname = null;
	private String itemunit = null;
	private int feetypeno = 0;
	private String feecycle = null;
	private String itemstatus = null;
	private String itemdesc = null;

}
