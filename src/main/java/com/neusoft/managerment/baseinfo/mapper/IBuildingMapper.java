package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.BuildingModel;

/**
 * 模块：基础信息  表：楼宇  Building
 * 楼宇的DAO层MyBatis Mapper接口
 * @Author: 吕淑兰
 */

@Mapper
public interface IBuildingMapper {
	//增加
	public void create(BuildingModel buildModel) throws Exception;
	//修改
	public void update(BuildingModel buildModel) throws Exception;
	//删除
	public void delete(BuildingModel buildModel) throws Exception;
	//查询楼宇的信息
	public List<BuildingModel> selectBuildListByAll() throws Exception;
	//查询楼宇的信息,关联Area
	public List<BuildingModel> selectBuildListByAllWithArea() throws Exception;
	//查询楼宇的信息,关联BuildingType
	public List<BuildingModel> selectBuildListByAllWithBuildType() throws Exception;
	//查询楼宇的信息,关联Area和BuildingType
	public List<BuildingModel> selectBuildListByAllWithAreaAndBuildType() throws Exception;
	//取得指定小区的楼宇列表,参数:areaNo 
	public List<BuildingModel> selectBuildListByArea(int areaNo) throws Exception;
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<BuildingModel> selectBuildListByBuildType(int buildTypeNo) throws Exception;
	//取得指定楼宇的信息
	public BuildingModel selectBuildByNo(int no) throws Exception;
	//取得所有部门列表,分页模式
	public List<BuildingModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得部门的个数
	public int selectCountByAll() throws Exception;

}
