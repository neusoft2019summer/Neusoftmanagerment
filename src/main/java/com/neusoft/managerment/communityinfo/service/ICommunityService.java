package com.neusoft.managerment.communityinfo.service;

import com.neusoft.managerment.communityinfo.model.CommunityActiveModel;

/*
  * 社区业务层接口
 * @Author: 张梓琪
 */
public interface ICommunityService {
	
	//增加
	public void add(CommunityActiveModel com) throws Exception;
	//修改
	public void modify(CommunityActiveModel com) throws Exception;
	//删除
	public void delete(CommunityActiveModel com) throws Exception;
	//取得活动的单个对象
	//

}
