package com.neusoft.managerment.office.model;


import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;



import lombok.Data;

/**
 *    author : 张梓琪
 *    version: 1.0
 *    系统基础信息的新闻的Model
 */
@Alias("NewsModel")
@Data
public class NewsModel implements Serializable {
	
	private String newstype = null;
	private Date newstime = null;
	private String newscontent = null;
	

}
