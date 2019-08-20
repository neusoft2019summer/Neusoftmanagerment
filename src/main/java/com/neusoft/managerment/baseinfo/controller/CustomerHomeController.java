package com.neusoft.managerment.baseinfo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.CustomerHomeModel;
import com.neusoft.managerment.baseinfo.service.ICustomerHomeService;
import com.neusoft.managerment.message.ResultMessage;

/**
 *    模块：基础信息   表：客户房间 CustomerHome
 *    author : 陈思颖
 *    version: 1.0
 */

//客户房间的控制类
@RestController
@RequestMapping("/customerhome")
public class CustomerHomeController {
	@Autowired
	private ICustomerHomeService customerHomeService=null;
	
	//增加客户房间
	@PostMapping("/add")
	public ResultMessage<CustomerHomeModel> add(CustomerHomeModel customerhome) throws Exception {
		customerHomeService.add(customerhome);
		return new ResultMessage<CustomerHomeModel>("OK","增加客户房间成功");
	}
	
	//修改客户房间
	@PostMapping("/modify")
	public ResultMessage<CustomerHomeModel> modify(CustomerHomeModel customerhome) throws Exception {
		customerHomeService.modify(customerhome);
		return new ResultMessage<CustomerHomeModel>("OK","修改客户房间成功");
	}
	
	//删除客户房间
	@PostMapping("/delete")
	public ResultMessage<CustomerHomeModel> delete(CustomerHomeModel customerhome) throws Exception {
		customerHomeService.delete(customerhome);
		return new ResultMessage<CustomerHomeModel>("OK","删除客户房间成功");
	}

	//1 取得所有客户列表,无关联客户类型
	@GetMapping(value="/list/all")
	public List<CustomerHomeModel> getListByAll() throws Exception{
		return customerHomeService.getListByAll();
	}
	
	//2 取得所有客户列表,关联客户类型,分页模式
	@GetMapping(value="/list/all/page")
	public ResultMessage<CustomerHomeModel> getListByAllWithFKWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerHomeModel> result=new ResultMessage<CustomerHomeModel>("OK","取得客户列表分页模式成功");
		result.setCount(customerHomeService.getCountByAll());
		result.setPageCount(customerHomeService.getPageCountByAll(rows));
		result.setList(customerHomeService.getListByAllWithFKWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//3 取得指定客户对象
	@GetMapping("/get")
	public CustomerHomeModel getByCustomerNo(int chno) throws Exception{
		return customerHomeService.getByCHNO(chno);
	}
	
	//4 取得客户的个数
	

	//5 根据综合检索条件取得客户列表
	@GetMapping(value="/list/condition/page")
	public ResultMessage<CustomerHomeModel> getListByConditionWithPage(
		@RequestParam(required = false,defaultValue ="0") int customerno,
		@RequestParam(required = false,defaultValue ="20") int rows,
		@RequestParam(required = false,defaultValue = "1") int page) 
				throws Exception{
	ResultMessage<CustomerHomeModel> result=new ResultMessage<CustomerHomeModel>("OK","检索取得员工列表分页成功");
	result.setCount(customerHomeService.getCountByCondition(customerno));
	result.setPageCount(customerHomeService.getPageCountByConditionWithPage(customerno,  rows));
	result.setList(customerHomeService.getListByConditionWithPage(customerno, rows, page));
	result.setPage(page);
	result.setRows(rows);
	
	return result;
	}
	
	//6 根据综合检索条件取得客户个数 

}
