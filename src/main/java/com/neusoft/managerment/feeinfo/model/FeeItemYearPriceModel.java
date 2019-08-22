package com.neusoft.managerment.feeinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *    模块：收费   表：收费项目年度价格  FeeItemYearPrice
 *    收费项目年度价格的Model类
 * @Author: 吕淑兰
 */
@Alias("FeeItemYearPrice")
@Data
public class FeeItemYearPriceModel implements Serializable {
	
	private String feeyear = null; // 收费年度
	private List<FeeItemModel> item = null; // 收费项目
	private BigDecimal unitprice = null; // 单价
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate = null; // 开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate = null; // 结束日期
	private String pricedesc = null; // 价格描述
	
}
