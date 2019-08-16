package com.neusoft.managerment.feeinfo.service;

import com.neusoft.managerment.feeinfo.model.M_typeModel;


public interface IM_typeService {
	    //增加
		public void add(M_typeModel mtype) throws Exception;
		//修改
		public void modify(M_typeModel mtype) throws Exception;
		//删除
		public void delete(M_typeModel mtype) throws Exception;
		
}
