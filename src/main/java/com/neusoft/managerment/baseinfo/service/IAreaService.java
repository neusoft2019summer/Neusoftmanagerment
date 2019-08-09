package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import com.neusoft.managerment.baseinfo.model.AreaModel;

/**
 *    模块：基础信息   表：小区 Area
 *    author : 吕淑兰
 *    version: 1.0
 */
//小区的业务接口
public interface IAreaService {
	//添加
	public void add(AreaModel areaModel) throws Exception;
	//修改
	public void modify(AreaModel areaModel) throws Exception;
	//修改
	public void delete(AreaModel areaModel) throws Exception;
	//查询小区的信息
	public List<AreaModel> getAreaListByAll() throws Exception;
	//根据指定小区的信息
	public AreaModel getAreaByNo(int no) throws Exception;
}
