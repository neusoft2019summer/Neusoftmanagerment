package com.neusoft.managerment.feeinfo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息模块的收费类型Model
 */
@Alias("FeeType")
@Data
public class FeeTypeModel {

	private int typeno = 0;
	private String typename = null;
}
