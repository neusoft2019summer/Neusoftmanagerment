package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import com.neusoft.managerment.baseinfo.model.AreaModel;

/**
 *   模块：基础信息   表：小区 Area
 *  小区业务层接口
 * @Author:吕淑兰
 */

public interface IAreaService {
	//添加
	public void add(AreaModel areaModel) throws Exception;
	//修改
	public void modify(AreaModel areaModel) throws Exception;
	//修改
	public void delete(AreaModel areaModel) throws Exception;
	//查询小区的信息
	public List<AreaModel> getAreaListByAll() throws Exception;
	//取得指定小区的信息
	public AreaModel getAreaByNo(int no) throws Exception;
	
	//取得所有小区列表,分页模式
	public List<AreaModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得小区的个数
	public int getCountByAll() throws Exception;
	//取得小区页数
	public int getPagaCountByAll(int rows) throws Exception;
}
