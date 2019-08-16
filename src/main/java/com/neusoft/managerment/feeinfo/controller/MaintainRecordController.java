package com.neusoft.managerment.feeinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.managerment.baseinfo.model.MaintainProviderModel;
import com.neusoft.managerment.baseinfo.service.IMaintainproviderService;
import com.neusoft.managerment.feeinfo.model.MaintainRecordModel;
import com.neusoft.managerment.feeinfo.service.IMaintainRecordService;
import com.neusoft.managerment.message.ResultMessage;

/**
 *  模块：物业日常业务管理  
 *  维修保单控制层Controller
 * @Author:张梓琪
 */

@RestController
@RequestMapping(value="/maintainrecord")
public class MaintainRecordController {

	@Autowired
	public IMaintainRecordService imrr = null;
	//增加
	@RequestMapping(value="/add")
	public ResultMessage<MaintainRecordModel> add(MaintainRecordModel maintainmodel)throws Exception{
		imrr.add(maintainmodel);
		return new ResultMessage<MaintainRecordModel>("ok","增加成功");
		
		
	}
	//修改
	@RequestMapping(value="/modify")
	public ResultMessage<MaintainRecordModel> modify(MaintainRecordModel maintainmodel)throws Exception{
		imrr.modify(maintainmodel);
		return new ResultMessage<MaintainRecordModel>("ok","修改成功");

		}
	//删除
	@RequestMapping(value="/delete")
	public ResultMessage<MaintainRecordModel> delete(MaintainRecordModel maintainmodel)throws Exception{
		imrr.delete(maintainmodel);
		return new ResultMessage<MaintainRecordModel>("ok","删除成功");

		}
	//查询所有维修保单 分页
	@RequestMapping(value="/list/all/page")
	public ResultMessage<MaintainRecordModel> list(@RequestParam(required = false,defaultValue ="4") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<MaintainRecordModel> result = new ResultMessage<MaintainRecordModel>("ok","分页查询成功");
		result.setList(imrr.getListByAllWithPage(rows, page));
		result.setCount(imrr.getcountbyall());
		result.setPageCount(imrr.getPageCountByAll(rows));
		result.setPage(page);
		result.setRows(rows);
		return result;		

		}
	
		
}
