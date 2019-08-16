package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.managerment.baseinfo.model.CustomerHomeModel;


/**
 *    模块：基础信息   表：客户房间 CustomerHome
 *    author : 陈思颖
 *    version: 1.0
 */
//客户房间的Mapper接口
@Mapper
public interface ICustomerHomeMapper {
	//增加
	public void create(CustomerHomeModel customerHomeModel) throws Exception;
	//修改
	public void update(CustomerHomeModel customerHomeModel) throws Exception;
	//删除
	public void delete(CustomerHomeModel customerHomeModel) throws Exception;
	//取得客户房间的信息
	public List<CustomerHomeModel> selectListByAll() throws Exception;
	//取得单条客户房间的信息
	public CustomerHomeModel selectByCHNO(int chno) throws Exception;
	//取得客户房间列表,有分页
	public List<CustomerHomeModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;

}
