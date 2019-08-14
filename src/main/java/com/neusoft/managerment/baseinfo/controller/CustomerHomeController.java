package com.neusoft.managerment.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	//取得指定的客户房间
	@GetMapping("/get")
	public CustomerHomeModel getByCHNO(int chno) throws Exception{
		return customerHomeService.getByCHNO(chno);
	}
	//取得所有客户房间列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<CustomerHomeModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerHomeModel> result=new ResultMessage<CustomerHomeModel>("OK","取得客户房间列表分页模式成功");
		result.setList(customerHomeService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有客户房间列表，无分页
	@GetMapping(value="/list/all")
	public List<CustomerHomeModel> getListByAll() throws Exception{
		return customerHomeService.getListByAll();
	}
	

}
