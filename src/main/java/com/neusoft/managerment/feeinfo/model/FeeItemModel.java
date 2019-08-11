package com.neusoft.managerment.feeinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    模块：收费   表：收费项目  FeeItem
 *    收费项目的Model类
 * @Author: 吕淑兰
 */
@Alias("FeeItem")
@Data
public class FeeItemModel implements Serializable {
	private int itemno = 0;
	private String itemcode = null;
	private String itemname = null;
	private String itemunit = null;
	private int feetypeno = 0;
	private String feecycle = null;
	private String itemstatus = null;
	private String itemdesc = null;

}
