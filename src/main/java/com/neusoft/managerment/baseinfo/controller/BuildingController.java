package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.BuildingModel;
import com.neusoft.managerment.baseinfo.service.IAreaService;
import com.neusoft.managerment.baseinfo.service.IBuildingService;
import com.neusoft.managerment.baseinfo.service.IBuildingTypeService;
/**
 *    模块：基础信息  表：楼宇  Building
 *    author : 吕淑兰
 *    version: 1.0
 */
//楼宇的控制类
@RestController
@RequestMapping("/build")
public class BuildingController {
	@Autowired
	private IBuildingService bs=null;
	
	//查询楼宇的信息
	@RequestMapping("/list")
	public List<BuildingModel> getBuildListByAll() throws Exception{
		return bs.getBuildListByAll();
	}
	
	//查询楼宇的信息,关联Area
	@RequestMapping(path="/list2",method= {RequestMethod.POST,RequestMethod.GET})
	public List<BuildingModel> getBuildListByAllWithArea() throws Exception {
		return bs.getBuildListByAllWithArea();
	}
	
	//查询楼宇的信息,关联BuildingType
	@RequestMapping(path="/list3",method= {RequestMethod.POST,RequestMethod.GET})
	public List<BuildingModel> getBuildListByAllWithBuildType() throws Exception{
		return bs.getBuildListByAllWithBuildType();
	}
	
	//查询楼宇的信息,关联Area和BuildingType
	@RequestMapping(path="/list4",method= {RequestMethod.POST,RequestMethod.GET})
	public List<BuildingModel> getBuildListByAllWithAreaAndBuildType() throws Exception {
		return bs.getBuildListByAllWithAreaAndBuildType();
	}
	
	//取得指定小区的楼宇列表,参数:areaNo 
	@RequestMapping(path="/list5",method= {RequestMethod.POST,RequestMethod.GET})
	public List<BuildingModel> getBuildListByArea(int areaNo) throws Exception {
		return bs.getBuildListByArea(areaNo);
	}
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	@RequestMapping(path="/list6",method= {RequestMethod.POST,RequestMethod.GET})
	public List<BuildingModel> getBuildListByBuildType(int buildTypeNo) throws Exception {
		return bs.getBuildListByBuildType(buildTypeNo);
	}
	
	//取得指定楼宇的信息
	@RequestMapping(path="/get/{bno}",method= {RequestMethod.POST,RequestMethod.GET})	
	public BuildingModel getBuildByNo(@PathVariable int bno) throws Exception{
		return bs.getBuildByNo(bno);
	}
	
	//取得指定楼宇的信息
	@RequestMapping(path="/get1",method= {RequestMethod.POST,RequestMethod.GET})	
	public BuildingModel getBuildByNo1(int bno) throws Exception{
		return bs.getBuildByNo(bno);
	}
	
	
	@PostMapping(value="/add")
	public String add(BuildingModel buildModel) throws Exception {
		bs.add(buildModel);
		System.out.println("add");
		return "OK";
	}
	
	@PostMapping(value="/delete")
	public String delete(BuildingModel buildModel) throws Exception {
		bs.delete(buildModel);
		System.out.println("delete");
		return "OK";
	}
	@PostMapping(value="/update")
	public String update(BuildingModel buildModel) throws Exception {
		bs.modify(buildModel);
		System.out.println("update");
		return "OK";
	}
}

