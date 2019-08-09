package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.baseinfo.model.AreaModel;


/**
 *    模块：基础信息   表：小区 Area
 *    author : 吕淑兰
 *    version: 1.0
 */
//小区的Mapper接口
@Mapper
public interface IAreaMapper {
	//增加
	public void create(AreaModel areaModel) throws Exception;
	//修改
	public void update(AreaModel areaModel) throws Exception;
	//删除
	public void delete(AreaModel areaModel) throws Exception;
	//查询小区的信息
	public List<AreaModel> selectAreaListByAll() throws Exception;
	//根据指定小区的信息
	public AreaModel selectAreaByNo(int no) throws Exception;
}
