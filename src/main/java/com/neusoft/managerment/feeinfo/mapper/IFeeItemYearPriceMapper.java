package com.neusoft.managerment.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.feeinfo.model.FeeItemYearPriceModel;


/**
 *  模块：基础信息   表：收费项目年度价格  FeeItemYearPrice
 *收费项目年度价格的DAO层MyBatis Mapper接口
 * @Author: 吕淑兰
 */

@Mapper
public interface IFeeItemYearPriceMapper {
	//增加收费项目
	public void create(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//修改收费项目
	public void update(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//删除收费项目
	public void delete(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception;
	//取得收费项目年度价格表，关联收费项目
	public List<FeeItemYearPriceModel> selectListByAllWithFeeItem() throws Exception;
	//取得指定收费项目年度价格的信息，关联收费项目
	public FeeItemYearPriceModel selectByFeeYearWithFeeItem(String feeyear) throws Exception;
	
}
