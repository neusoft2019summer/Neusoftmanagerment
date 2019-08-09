package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import com.neusoft.managerment.baseinfo.model.BuildingTypeModel;

/**
 *    模块：基础信息  表：建筑类型 BuildingType
 *    author : 吕淑兰
 *    version: 1.0
 */
//建筑类型的业务接口
public interface IBuildingTypeService {
	//增加
	public void add(BuildingTypeModel buildTypeModel) throws Exception;
	//修改
	public void modify(BuildingTypeModel buildTypeModel) throws Exception;
	//删除
	public void delete(BuildingTypeModel buildTypeModel) throws Exception;
	//查询建筑类型的信息
	public List<BuildingTypeModel> getBuildTypeListByAll() throws Exception;
	//根据指定建筑类型的信息
	public BuildingTypeModel getBuildTypeByNo(int no) throws Exception;
}
