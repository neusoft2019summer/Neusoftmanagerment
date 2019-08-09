package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neusoft.managerment.baseinfo.model.CustomerModel;
import com.neusoft.managerment.baseinfo.service.ICustomerService;
import com.neusoft.managerment.message.ResultMessage;

/*
 * 模块：客户管理
 * Controller层：客户控制器Controller类
 * @Author: 陈思颖
 */
public class CustomerController {
	@Autowired
	private ICustomerService customerService=null;
	
	//增加客户
	@PostMapping("/add")
	public ResultMessage<CustomerModel> add(CustomerModel customer) throws Exception {
		customerService.add(customer);
		return new ResultMessage<CustomerModel>("OK","增加部门成功");
	}
	//修改客户
	@PostMapping("/modify")
	public ResultMessage<CustomerModel> modify(CustomerModel customer) throws Exception {
		customerService.modify(customer);
		return new ResultMessage<CustomerModel>("OK","修改部门成功");
	}
	//删除客户
	@PostMapping("/delete")
	public ResultMessage<CustomerModel> delete(CustomerModel customer) throws Exception {
		customerService.delete(customer);
		return new ResultMessage<CustomerModel>("OK","删除部门成功");
	}
	//取得指定的客户
	@GetMapping("/get")
	public CustomerModel getByCustomerNo(int customerNo) throws Exception{
		return customerService.getByCustomerNo(customerNo);
	}
	//取得所有客户列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<CustomerModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerModel> result=new ResultMessage<CustomerModel>("OK","取得部门列表分页模式成功");
		result.setCount(customerService.getCountByAll());
		result.setPageCount(customerService.getPagaCountByAll(rows));
		result.setList(customerService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有客户列表，无分页
	@GetMapping(value="/list/all")
	public List<CustomerModel> getListByAll() throws Exception{
		return customerService.getListByAll();
	}
}
