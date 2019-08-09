package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.BuildingTypeModel;
import com.neusoft.managerment.baseinfo.service.IAreaService;
import com.neusoft.managerment.baseinfo.service.IBuildingTypeService;
/**
 *    模块：基础信息  表：建筑类型 BuildingType
 *    author : 吕淑兰
 *    version: 1.0
 */
//建筑类型的控制类
@RestController
@RequestMapping("/buildType")
public class BuildingTypeController {
	@Autowired
	private IBuildingTypeService bts=null;
	
	@RequestMapping("/list")
	public List<BuildingTypeModel> getBuildTypeListByAll() throws Exception{
		return bts.getBuildTypeListByAll();
	}
	
	@RequestMapping(path="/get/{btNo}",method= {RequestMethod.POST,RequestMethod.GET})	
	public BuildingTypeModel getBuildTypeByNo(@PathVariable int btNo) throws Exception{
		return bts.getBuildTypeByNo(btNo);
	}
	@RequestMapping(path="/get1",method= {RequestMethod.POST,RequestMethod.GET})	
	public BuildingTypeModel getBuildTypeByNo1(int btNo) throws Exception{
		return bts.getBuildTypeByNo(btNo);
	}
	
	@PostMapping(value="/add")
	public String add(BuildingTypeModel buildTypeModel) throws Exception {
		bts.add(buildTypeModel);
		System.out.println("add");
		return "OK";
	}
	
	@PostMapping(value="/delete")
	public String delete(BuildingTypeModel buildTypeModel) throws Exception {
		bts.delete(buildTypeModel);
		System.out.println("delete");
		return "OK";
	}
	@PostMapping(value="/update")
	public String update(BuildingTypeModel buildTypeModel) throws Exception {
		bts.modify(buildTypeModel);
		System.out.println("update");
		return "OK";
	}
}
