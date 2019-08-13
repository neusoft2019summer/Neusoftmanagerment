package com.neusoft.managerment.baseinfo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.managerment.baseinfo.model.CustomerModel;
import com.neusoft.managerment.baseinfo.service.ICustomerService;
import com.neusoft.managerment.message.ResultMessage;

/**
 *    模块：基础信息  表：客户 Customer
 *    author : 陈思颖
 *    version: 1.0
 */
//客户的控制类
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService=null;
	
	//增加客户
	@PostMapping("/add")
	public ResultMessage<CustomerModel> add(CustomerModel customer) throws Exception {
		customerService.add(customer);
		return new ResultMessage<CustomerModel>("OK","增加客户成功");
	}
	//修改客户
	@PostMapping("/modify")
	public ResultMessage<CustomerModel> modify(CustomerModel customer) throws Exception {
		customerService.modify(customer);
		return new ResultMessage<CustomerModel>("OK","修改客户成功");
	}
	//删除客户
	@PostMapping("/delete")
	public ResultMessage<CustomerModel> delete(CustomerModel customer) throws Exception {
		customerService.delete(customer);
		return new ResultMessage<CustomerModel>("OK","删除客户成功");
	}
	//取得指定的客户
	@GetMapping("/get")
	public CustomerModel getByCustomerNo(int customerno) throws Exception{
		return customerService.getByCustomerNo(customerno);
	}
	//取得所有客户列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<CustomerModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerModel> result=new ResultMessage<CustomerModel>("OK","取得客户列表分页模式成功");
		result.setCount(customerService.getCountByAll());
		result.setPageCount(customerService.getPageCountByAll(rows));
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
	
	@GetMapping(value="/list/all/customertype")
	public ResultMessage<CustomerModel> getListByAllWithCustomerType(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerModel> result=new ResultMessage<CustomerModel>("OK","取得客户列表分页模式成功");
		result.setCount(customerService.getCountByAll());
		result.setPageCount(customerService.getPageCountByAll(rows));
		result.setList(customerService.getListByAllWithCustomerType(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;	
	}

	/*
	//检查此客户能否被删除
	@GetMapping(value="/checkDelete")
	public ResultMessage<CustomerModel> checkForDelete(int no) throws Exception{
		ResultMessage<CustomerModel> result=new ResultMessage<CustomerModel>("OK","此部门可以删除");
		if(!customerService.checkCanDelete(no)) {
			result.setStatus("NO");
			result.setMessage("此客户不能删除");
		}
		return result;
	}*/
}
