package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.baseinfo.model.BuildingTypeModel;

/**
 *    模块：基础信息  表：建筑类型 BuildingType
 *    author : 吕淑兰
 *    version: 1.0
 */
//建筑类型的Mapper接口
@Mapper
public interface IBuildingTypeMapper {
	//增加
	public void create(BuildingTypeModel buildTypeModel) throws Exception;
	//修改
	public void update(BuildingTypeModel buildTypeModel) throws Exception;
	//删除
	public void delete(BuildingTypeModel buildTypeModel) throws Exception;
	//查询建筑类型的信息
	public List<BuildingTypeModel> selectBuildTypeListByAll() throws Exception;
	//根据指定建筑类型的信息
	public BuildingTypeModel selectBuildTypeByNo(int no) throws Exception;
}
