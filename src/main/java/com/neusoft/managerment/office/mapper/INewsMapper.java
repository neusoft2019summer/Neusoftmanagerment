package com.neusoft.managerment.office.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.managerment.office.model.NewsModel;

//新闻的Mapper层接口
@Mapper
public interface INewsMapper {
	//c  增添方法
	public void create(NewsModel newsmodel) throws Exception;
	//u  修改方法
	public void update(NewsModel newsmodel) throws Exception;
	//d  删除方法
	public void delete(NewsModel newsmodel) throws Exception;
	//r  查找
	public void select(NewsModel newsmodel) throws Exception;

}
