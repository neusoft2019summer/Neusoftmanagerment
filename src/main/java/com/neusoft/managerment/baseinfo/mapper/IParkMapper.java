package com.neusoft.managerment.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.managerment.baseinfo.model.ParkModel;


/**
 *  模块：基础信息   表：车位 Park
 * 车位的DAO层MyBatis Mapper接口
 * @Author: 吕淑兰
 */

@Mapper
public interface IParkMapper {
	//增加车位
	public void create(ParkModel parkModel) throws Exception;
	//修改车位
	public void update(ParkModel parkModel) throws Exception;
	//删除车位
	public void delete(ParkModel parkModel) throws Exception;
	//取得所有车位列表
	public List<ParkModel> selectListByAll() throws Exception;
	//取得所有车位列表,关联ParkType
	public List<ParkModel> selectListByAllWithParkType() throws Exception;
	//取得所有车位列表,关联Building
	public List<ParkModel> selectListByAllWithBuilding() throws Exception;
	//取得所有车位列表,关联ParkType和Building
	public List<ParkModel> selectListByAllWithParkTypeAndBuilding() throws Exception;
	//取得指定车位类型的车位列表,参数:parkTypeNo 
	public List<ParkModel> selectListByParkType(int ParkTypeNo) throws Exception;
	//取得指定楼宇的车位列表,参数:buildingNo 
	public List<ParkModel> selectListByBuilding(int buildingNo) throws Exception;
	//取得指定车位的信息
	public ParkModel selectByNo(int no) throws Exception;
	//取得所有车位列表,分页模式
	public List<ParkModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得车位的个数
	public int selectCountByAll() throws Exception;

}
