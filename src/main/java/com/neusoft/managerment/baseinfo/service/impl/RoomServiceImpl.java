package com.neusoft.managerment.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.baseinfo.mapper.IRoomMapper;
import com.neusoft.managerment.baseinfo.model.RoomModel;
import com.neusoft.managerment.baseinfo.service.IRoomService;
/**
 *    模块：基础信息   表：房间 Room
 *    author : 陈思颖
 *    version: 1.0
 */

//房间的业务实现类
@Service("roomService")
@Transactional(rollbackFor=Exception.class)
public class RoomServiceImpl implements IRoomService {
	@Autowired
	private IRoomMapper roomMapper=null;
	
	@Override
	public void add(RoomModel room) throws Exception {
		roomMapper.create(room);

	}

	@Override
	public void modify(RoomModel room) throws Exception {
		roomMapper.update(room);

	}

	@Override
	public void delete(RoomModel room) throws Exception {
		roomMapper.delete(room);

	}

	@Override
	public List<RoomModel> getListByAll() throws Exception {
		
		return roomMapper.selectListByAll();
	}
	
	@Override
	public List<RoomModel> getListByAllWithFK() throws Exception {
		
		return roomMapper.selectListByAllwithFK();
	}

	@Override
	public RoomModel getByRoomNo(int roomno) throws Exception {
		
		return roomMapper.selectByRoomNo(roomno);
	}

	@Override
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return roomMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return roomMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<RoomModel> getListByAllWithAreaNo() throws Exception {
		
		return roomMapper.selectListByAllWithAreaNo();
	}

	@Override
	public List<RoomModel> getListByAllWithBuildingTypeNo() throws Exception {
		
		return roomMapper.selectListByAllWithBuildingTypeNo();
	}
	
	@Override
	public List<RoomModel> getListByAllWithHouseTypeNo() throws Exception {
		
		return roomMapper.selectListByAllWithHouseTypeNo();
	}

	@Override
	public List<RoomModel> getListByAllWithBuildingNo() throws Exception {
		
		return roomMapper.selectListByAllWithBuildingNo();
	}
	
	/*
	@Override
	public List<RoomModel> getListByAllWithTypeNoAndBuildingNo() throws Exception {
		
		return roomMapper.selectListByAllWithTypeNoAndBuildingNo();
	}
	*/

	
	@Override
	public RoomModel getListByHouseTypeNo(int housetypeno) throws Exception {
		
		return roomMapper.selectListByHouseTypeNo(housetypeno);
	}

	@Override
	public RoomModel getListByBuildingNo(int buildingno) throws Exception {
		
		return roomMapper.selectListByBuildingNo(buildingno);
	}



}
