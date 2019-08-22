package com.neusoft.managerment.feeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.feeinfo.model.FeeItemYearPriceModel;
import com.neusoft.managerment.feeinfo.service.IFeeItemYearPriceService;
import com.neusoft.managerment.message.ResultMessage;

/**
 *  模块：feeinfo 收费 
 *  收费项目年度价格  FeeItemYearPrice控制层Controller
 * @Author: 吕淑兰
 */

@RestController
@RequestMapping(value="/feeItemYearPrice")
public class FeeItemYearPriceController {

	@Autowired
	private IFeeItemYearPriceService feeItemYearPriceService=null;
	
	//增加收费项目年度价格
	@PostMapping(value="/add")
	public ResultMessage<FeeItemYearPriceModel> add(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception{
		feeItemYearPriceService.add(feeItemYearPriceModel);
		return new ResultMessage<FeeItemYearPriceModel>("OK","增加收费项目年度价格成功");
	}
	//修改收费项目年度价格
	@PostMapping(value="/modify")
	public ResultMessage<FeeItemYearPriceModel> modify(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception{
		feeItemYearPriceService.modify(feeItemYearPriceModel);
		return new ResultMessage<FeeItemYearPriceModel>("OK","修改收费项目年度价格成功");
	}
	//删除收费项目年度价格
	@PostMapping(value="/delete")
	public ResultMessage<FeeItemYearPriceModel> delete(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception{
		feeItemYearPriceService.delete(feeItemYearPriceModel);
		return new ResultMessage<FeeItemYearPriceModel>("OK","删除收费项目年度价格成功");
	}
	
	//取得收费项目年度价格表，关联收费项目
	@GetMapping("/list/all")
	public List<FeeItemYearPriceModel> getListByAllWithFeeItem() throws Exception{
		return feeItemYearPriceService.getListByAllWithFeeItem();
	}
	//取得指定收费项目年度价格的信息，关联收费项
	@GetMapping("/get")
	public FeeItemYearPriceModel getByFeeYearWithFeeItem(String feeyear) throws Exception{
		return feeItemYearPriceService.getByFeeYearWithFeeItem(feeyear);
	};
}
