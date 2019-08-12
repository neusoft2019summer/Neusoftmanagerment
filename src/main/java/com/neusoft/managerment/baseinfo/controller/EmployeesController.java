package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.neusoft.managerment.baseinfo.model.EmployeesModel;
import com.neusoft.managerment.baseinfo.service.IEmployeesService;
import com.neusoft.managerment.message.ResultMessage;

@RestController
@RequestMapping("employees")
public class EmployeesController {
	@Autowired
	private IEmployeesService employeesService=null;
	//增加
	@PostMapping("/add")
	public ResultMessage<EmployeesModel> add(EmployeesModel employees) throws Exception {
		employeesService.add(employees);
		return new ResultMessage<EmployeesModel>("OK","增加员工信息成功");
	}
	//修改
	@PostMapping("/modify")
	public ResultMessage<EmployeesModel> modify(EmployeesModel employees) throws Exception {
		employeesService.modify(employees);
		return new ResultMessage<EmployeesModel>("OK","修改员工信息成功");
	}
	//删除
	@PostMapping("/delete")
	public ResultMessage<EmployeesModel> delete(EmployeesModel employees) throws Exception {
		employeesService.delete(employees);
		return new ResultMessage<EmployeesModel>("OK","删除员工信息成功");
	}
	//取得指定的员工信息
	@GetMapping("/get")
	public EmployeesModel getEmpByID(int id) throws Exception{
		return employeesService.getEmpByID(id);
	}
	//取得所有客户列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<EmployeesModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<EmployeesModel> result=new ResultMessage<EmployeesModel>("OK","取得客户列表分页模式成功");
		//result.setCount(EmployeesModel.getCountByAll());
		//result.setPageCount(EmployeesModel.getPageCountByAll(rows));
		result.setList(employeesService.getEmpListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有客户列表，无分页
	@GetMapping(value="/list/all")
	public List<EmployeesModel> getListByAll() throws Exception{
		return employeesService.getListByAll();
	}
}
