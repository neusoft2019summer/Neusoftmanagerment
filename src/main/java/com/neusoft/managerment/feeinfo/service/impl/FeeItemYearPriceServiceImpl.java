package com.neusoft.managerment.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.feeinfo.mapper.IFeeItemYearPriceMapper;
import com.neusoft.managerment.feeinfo.model.FeeItemYearPriceModel;
import com.neusoft.managerment.feeinfo.service.IFeeItemYearPriceService;
/**
 *    模块：收费   表：收费项目年度价格  FeeItemYearPrice
 * 收费项目年度价格业务层接口的实现类
 * @Author: 吕淑兰
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FeeItemYearPriceServiceImpl implements IFeeItemYearPriceService {

	@Autowired
	private IFeeItemYearPriceMapper feeItemYearPriceMapper=null;
	@Override
	public void add(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception {
		feeItemYearPriceMapper.create(feeItemYearPriceModel);

	}

	@Override
	public void modify(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception {
		feeItemYearPriceMapper.update(feeItemYearPriceModel);

	}

	@Override
	public void delete(FeeItemYearPriceModel feeItemYearPriceModel) throws Exception {
		feeItemYearPriceMapper.delete(feeItemYearPriceModel);

	}

	@Override
	public List<FeeItemYearPriceModel> getListByAllWithFeeItem() throws Exception {
		
		return feeItemYearPriceMapper.selectListByAllWithFeeItem();
	}

	@Override
	public FeeItemYearPriceModel getByFeeYearWithFeeItem(String feeyear) throws Exception {
		
		return feeItemYearPriceMapper.selectByFeeYearWithFeeItem(feeyear);
	}

}
