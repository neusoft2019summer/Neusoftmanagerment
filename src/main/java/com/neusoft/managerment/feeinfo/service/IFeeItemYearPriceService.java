package com.neusoft.managerment.feeinfo.service;

import java.util.List;

import com.neusoft.managerment.feeinfo.model.FeeItemYearPriceModel;

/**
 *   模块：收费   表：收费项目年度价格  FeeItemYearPrice
 *  收费项目年度价格业务层接口
 * @Author:吕淑兰
 */
public interface IFeeItemYearPriceService {
	//增加收费项目年度价格
	public void add(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//修改收费项目年度价格
	public void modify(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//删除收费项目年度价格
	public void delete(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//取得收费项目年度价格表，关联收费项目
	public List<FeeItemYearPriceModel> getListByAllWithFeeItem() throws Exception;
	//取得指定收费项目年度价格的信息，关联收费项
	public FeeItemYearPriceModel getByFeeYearWithFeeItem(String feeyear) throws Exception;
	
}
