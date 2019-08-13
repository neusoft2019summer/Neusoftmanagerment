package com.neusoft.managerment.communityinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/*
 * 模块：Community 人力资源
 * model层：Model类
 * @Author: 张梓琪
 */
@Alias("Active")
@Data
public class CommunityActiveModel implements Serializable {
	private String communityno = null;
	private String place = null;
	private String communitycontent = null;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date = null;

}
