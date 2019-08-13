package com.neusoft.managerment.communityinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.communityinfo.model.CommunityActiveModel;

/*
 * 社区活动的DAO层Mapper接口
 * @Author: 张梓琪
 */
@Mapper
public interface ICommunityMapper {
	//增加
	public void insert(CommunityActiveModel con) throws Exception;
	//修改
	public void update(CommunityActiveModel con) throws Exception;
	//删除
	public void delete(CommunityActiveModel con) throws Exception;
	//查  取得所有活动
	public List<CommunityActiveModel> selectListByAll()throws Exception;
	//取得指定地方的活动
	public List<CommunityActiveModel> selectListByPlace()throws Exception;
	//取得指定时间的活动
	public List<CommunityActiveModel> selectListByTime()throws Exception;
	
	
	

}
