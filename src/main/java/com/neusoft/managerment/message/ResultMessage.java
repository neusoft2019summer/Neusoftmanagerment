package com.neusoft.managerment.message;

import java.io.Serializable;
import java.util.List;

import com.neusoft.managerment.baseinfo.model.CustomerModel;
import com.neusoft.managerment.personnel.model.EmployeesModel;

import lombok.Data;
/*
 * 模块：公共基础工具类，
 * 公共的控制层结果返回类
 * @Author: 陈思颖
 */
@Data
public class ResultMessage<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T model=null; //业务对象
	private List<T> list=null; //业务对象的列表
	private String status=null;
	private String message=null;
	private int rows=0; //每屏显示的行数
	private int page=0; //第几页
	private int count=0; //信息T的个数
	private int pageCount=0; //页数
	
	public ResultMessage() {
		
	}
	public ResultMessage(String status,String message) {
		this.status=status;
		this.message=message;
	}
}
