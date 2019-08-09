package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import com.neusoft.managerment.baseinfo.model.BuildingModel;


/**
 *    模块：基础信息  表：楼宇  Building
 *    author : 吕淑兰
 *    version: 1.0
 */
//楼宇的业务接口
public interface IBuildingService {
	//增加
	public void add(BuildingModel buildModel) throws Exception;
	//修改
	public void modify(BuildingModel buildModel) throws Exception;
	//删除
	public void delete(BuildingModel buildModel) throws Exception;
	//查询楼宇的信息
	public List<BuildingModel> getBuildListByAll() throws Exception;
	//查询楼宇的信息,关联Area
	public List<BuildingModel> getBuildListByAllWithArea() throws Exception;
	//查询楼宇的信息,关联BuildingType
	public List<BuildingModel> getBuildListByAllWithBuildType() throws Exception;
	//查询楼宇的信息,关联Area和BuildingType
	public List<BuildingModel> getBuildListByAllWithAreaAndBuildType() throws Exception;
	//取得指定小区的楼宇列表,参数:areaNo 
	public List<BuildingModel> getBuildListByArea(int areaNo) throws Exception;
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<BuildingModel> getBuildListByBuildType(int buildTypeNo) throws Exception;
	//取得指定楼宇的信息
	public BuildingModel getBuildByNo(int no) throws Exception;
}
