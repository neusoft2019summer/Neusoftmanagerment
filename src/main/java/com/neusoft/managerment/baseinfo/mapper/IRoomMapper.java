package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.managerment.baseinfo.model.RoomModel;


/**
 *    模块：基础信息   表：房间 Room
 *    author : 陈思颖
 *    version: 1.0
 */
//房间的Mapper接口
@Mapper
public interface IRoomMapper {
	//增加
	public void create(RoomModel roomModel) throws Exception;
	//修改
	public void update(RoomModel roomModel) throws Exception;
	//删除
	public void delete(RoomModel roomModel) throws Exception;
	//取得房间的信息
	public List<RoomModel> selectListByAll() throws Exception;
	
	public List<RoomModel> selectListByAllwithFK() throws Exception;
	
	//取得单个房间的信息
	public RoomModel selectByRoomNo(int roomno) throws Exception;
	//取得房间列表,有分页
	public List<RoomModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得房间的个数
	public int selectCountByAll() throws Exception;
	//取得房间页数
	public int selectPageCountByAll(int rows) throws Exception;
	//取得所有房间列表,关联AreaNo
	public List<RoomModel> selectListByAllWithAreaNo() throws Exception;
	//取得所有房间列表,关联BuildingTypeNo
	public List<RoomModel> selectListByAllWithBuildingTypeNo() throws Exception;
	//取得所有房间列表,关联HouseTypeNo
	public List<RoomModel> selectListByAllWithHouseTypeNo() throws Exception;
	//取得所有房间列表,关联BuildingNo
	public List<RoomModel> selectListByAllWithBuildingNo() throws Exception;
	//取得所有房间列表,关联TypeNo和BuildingNo
	//public List<RoomModel> selectListByAllWithTypeNoAndBuildingNo() throws Exception;
	//根据类型编号取得此户型的房间
	public RoomModel selectListByHouseTypeNo(int housetypeno) throws Exception;
	//根据楼宇序号取得此序号的房间
	public RoomModel selectListByBuildingNo(int buildingno) throws Exception;

	
}
