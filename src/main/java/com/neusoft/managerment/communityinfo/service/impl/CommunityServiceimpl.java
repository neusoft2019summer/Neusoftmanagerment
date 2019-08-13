package com.neusoft.managerment.communityinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.managerment.communityinfo.mapper.ICommunityMapper;
import com.neusoft.managerment.communityinfo.model.CommunityActiveModel;
import com.neusoft.managerment.communityinfo.service.ICommunityService;
/*
 * 模块：社区模块
 * 社区活动业务实现类
 * @Author: 张梓琪
 */
@Service("actservice")
public class CommunityServiceimpl implements ICommunityService {
	@Autowired
	private ICommunityMapper communityMapper = null;
	
	

	@Override
	public void add(CommunityActiveModel com) throws Exception {
		communityMapper.insert(com);
		
	}

	@Override
	public void modify(CommunityActiveModel com) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CommunityActiveModel com) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<CommunityActiveModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityActiveModel> getListByType(String type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
