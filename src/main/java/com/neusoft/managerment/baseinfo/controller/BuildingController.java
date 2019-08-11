package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.AreaModel;
import com.neusoft.managerment.baseinfo.model.BuildingModel;
import com.neusoft.managerment.baseinfo.service.IAreaService;
import com.neusoft.managerment.baseinfo.service.IBuildingService;
import com.neusoft.managerment.baseinfo.service.IBuildingTypeService;
import com.neusoft.managerment.message.ResultMessage;
/**
 *   模块：baseinfo 基础信息
 *   楼宇控制层Controller
 * @Author: 吕淑兰
 */

@RestController
@RequestMapping(value="/build")
public class BuildingController {
	@Autowired
	private IBuildingService bs=null;
	
	//增加楼宇
	@PostMapping(value="/add")
	public ResultMessage<BuildingModel> add(BuildingModel buildModel) throws Exception {
		bs.add(buildModel);
		return new ResultMessage<BuildingModel>("OK","增加楼宇成功");
	}
	//修改楼宇
	@PostMapping(value="/modify")
	public ResultMessage<BuildingModel> update(BuildingModel buildModel) throws Exception {
		bs.modify(buildModel);
		return new ResultMessage<BuildingModel>("OK","修改楼宇成功");
	}
	//删除楼宇
	@PostMapping(value="/delete")
	public ResultMessage<BuildingModel> delete(BuildingModel buildModel) throws Exception {
		bs.delete(buildModel);
		return new ResultMessage<BuildingModel>("OK","删除楼宇成功");
	}
	
	//取得所有楼宇列表
	@GetMapping(value="/list/all")
	public List<BuildingModel> getBuildListByAll() throws Exception{
		return bs.getBuildListByAll();
	}
	//取得所有楼宇列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<BuildingModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="2") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<BuildingModel> result=new ResultMessage<BuildingModel>("OK","取得楼宇列表分页模式成功");
		result.setCount(bs.getCountByAll());
		result.setPageCount(bs.getPagaCountByAll(rows));
		result.setList(bs.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	//查询楼宇的信息,关联Area
	@GetMapping(value="/list/all/witharea")
	public List<BuildingModel> getBuildListByAllWithArea() throws Exception {
		return bs.getBuildListByAllWithArea();
	}
	
	//查询楼宇的信息,关联BuildingType
	@GetMapping(value="/list/all/withbuildtype")
	public List<BuildingModel> getBuildListByAllWithBuildType() throws Exception{
		return bs.getBuildListByAllWithBuildType();
	}
	
	//查询楼宇的信息,关联Area和BuildingType
	@GetMapping(value="/list/all/withareaandbuildtype")
	public List<BuildingModel> getBuildListByAllWithAreaAndBuildType() throws Exception {
		return bs.getBuildListByAllWithAreaAndBuildType();
	}
	
	//取得指定小区的楼宇列表,参数:areaNo 
	@GetMapping(value="/list/area")
	public List<BuildingModel> getBuildListByArea(int areaNo) throws Exception {
		return bs.getBuildListByArea(areaNo);
	}
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	@GetMapping(value="/list/buildtype")
	public List<BuildingModel> getBuildListByBuildType(int buildTypeNo) throws Exception {
		return bs.getBuildListByBuildType(buildTypeNo);
	}
		
	//取得指定楼宇的信息
	@GetMapping("/get")
	public BuildingModel getBuildByNo1(int bno) throws Exception{
		return bs.getBuildByNo(bno);
	}

}

