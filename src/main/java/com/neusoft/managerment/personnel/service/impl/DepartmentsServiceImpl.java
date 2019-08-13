package com.neusoft.managerment.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.neusoft.managerment.personnel.mapper.IDepartmentsMapper;
import com.neusoft.managerment.personnel.mapper.IEmployeesMapper;
import com.neusoft.managerment.personnel.model.DepartmentsModel;
import com.neusoft.managerment.personnel.service.IDepartmentsService;
@Service
@Transactional(rollbackFor=Exception.class)
public class DepartmentsServiceImpl implements IDepartmentsService {

	@Autowired
	private IDepartmentsMapper departmentsMapper=null;
	@Autowired
	private IEmployeesMapper employeesMapper=null;
	@Override
	public void add(DepartmentsModel departments) throws Exception {
		// TODO Auto-generated method stub
		departmentsMapper.create(departments);
	}

	@Override
	public void modify(DepartmentsModel departments) throws Exception {
		// TODO Auto-generated method stub
		departmentsMapper.update(departments);
	}

	@Override
	public void delete(DepartmentsModel departments) throws Exception {
		// TODO Auto-generated method stub
		departmentsMapper.delete(departments);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartmentsModel> getDeptListByAll() throws Exception {
		// TODO Auto-generated method stub
		return departmentsMapper.selectDeptListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartmentsModel> getDeptListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return departmentsMapper.selectDeptListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public DepartmentsModel getDeptByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return departmentsMapper.selectDeptByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return departmentsMapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public boolean checkCanDelete(int no) throws Exception {
		// TODO Auto-generated method stub
		boolean result=true;
		if(employeesMapper.selectCountByCondition(no,"", null, null)>0) {
			result=false;
		}
		
		return result;
	}

}
