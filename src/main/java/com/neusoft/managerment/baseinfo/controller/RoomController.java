package com.neusoft.managerment.baseinfo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.managerment.baseinfo.model.RoomModel;
import com.neusoft.managerment.baseinfo.service.IRoomService;
import com.neusoft.managerment.message.ResultMessage;

/**
 *    模块：基础信息  表：房间 Room
 *    author : 陈思颖
 *    version: 1.0
 */
//房间的控制类
@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private IRoomService roomService=null;
	
	//增加房间
	@PostMapping("/add")
	public ResultMessage<RoomModel> add(RoomModel room) throws Exception {
		roomService.add(room);
		return new ResultMessage<RoomModel>("OK","增加房间成功");
	}
	//修改房间
	@PostMapping("/modify")
	public ResultMessage<RoomModel> modify(RoomModel room) throws Exception {
		roomService.modify(room);
		return new ResultMessage<RoomModel>("OK","修改房间成功");
	}
	//删除房间
	@PostMapping("/delete")
	public ResultMessage<RoomModel> delete(RoomModel room) throws Exception {
		roomService.delete(room);
		return new ResultMessage<RoomModel>("OK","删除房间成功");
	}
	//取得指定的房间
	@GetMapping("/get")
	public RoomModel getByCustomerNo(int roomno) throws Exception{
		return roomService.getByRoomNo(roomno);
	}
	//取得所有房间列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<RoomModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<RoomModel> result=new ResultMessage<RoomModel>("OK","取得房间列表分页模式成功");
		result.setCount(roomService.getCountByAll());
		result.setPageCount(roomService.getPageCountByAll(rows));
		result.setList(roomService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有房间列表，无分页
	@GetMapping(value="/list/all")
	public List<RoomModel> getListByAll() throws Exception{
		return roomService.getListByAll();
	}
}

