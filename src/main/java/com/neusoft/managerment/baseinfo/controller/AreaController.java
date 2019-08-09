package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.AreaModel;
import com.neusoft.managerment.baseinfo.service.IAreaService;

/**
 *    模块：基础信息   表：小区 Area
 *    author : 吕淑兰
 *    version: 1.0
 */
//小区的控制类
@RestController
@RequestMapping("/area")
public class AreaController {
	@Autowired
	private IAreaService areas=null;
	
	@RequestMapping("/list")
	public List<AreaModel> getAreaListByAll() throws Exception{
		return areas.getAreaListByAll();
	}
	
	@RequestMapping(path="/get/{areano}",method= {RequestMethod.POST,RequestMethod.GET})	
	public AreaModel getArea(@PathVariable int areano) throws Exception{
		return areas.getAreaByNo(areano);
	}
	
	@PostMapping(value="/add")
	public String add(AreaModel areaModel) throws Exception {
		areas.add(areaModel);
		System.out.println("add");
		return "OK";
	}
	
	@PostMapping(value="/delete")
	public String delete(AreaModel areaModel) throws Exception {
		areas.delete(areaModel);
		System.out.println("delete");
		return "OK";
	}
	@PostMapping(value="/update")
	public String update(AreaModel areaModel) throws Exception {
		areas.modify(areaModel);
		System.out.println("dupdate");
		return "OK";
	}
}
