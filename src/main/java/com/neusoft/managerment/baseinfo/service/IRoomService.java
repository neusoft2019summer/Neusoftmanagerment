package com.neusoft.managerment.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.RoomModel;
/**
 *    模块：基础信息   表：房间 Room
 *    author : 陈思颖
 *    version: 1.0
 */
public interface IRoomService {
	//增加
	public void add(RoomModel room) throws Exception;
	//修改
	public void modify(RoomModel room) throws Exception;
	//删除
	public void delete(RoomModel room) throws Exception;
	//取得所有客户列表
	public List<RoomModel> getListByAll() throws Exception;
	//取得客户单个对象，
	public RoomModel getByRoomNo(int roomno) throws Exception;
	//取得所有客户列表,分页模式
	public List<RoomModel> getListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得客户的个数
	public int getCountByAll() throws Exception;
	//取得客户页数
	public int getPagaCountByAll(int rows) throws Exception;
}
