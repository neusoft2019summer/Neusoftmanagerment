package com.neusoft.managerment.personnel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.managerment.personnel.mapper.IEmployeesMapper;
import com.neusoft.managerment.personnel.model.EmployeesModel;
import com.neusoft.managerment.personnel.service.IEmployeesService;


@Service("employeesService")
@Transactional(rollbackFor=Exception.class)
public class EmployeesServiceImpl implements IEmployeesService {
	@Autowired
	private IEmployeesMapper employeesMapper=null;
	
	@Override
	public void add(EmployeesModel employees) throws Exception {
		// TODO Auto-generated method stub
		employeesMapper.create(employees);
	}

	@Override
	public void modify(EmployeesModel employees) throws Exception {
		// TODO Auto-generated method stub
		employeesMapper.update(employees);
	}

	@Override
	public void delete(EmployeesModel employees) throws Exception {
		// TODO Auto-generated method stub
		employeesMapper.delete(employees);
	}

	@Override
	public List<EmployeesModel> getEmpListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return employeesMapper.selectEmpListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public EmployeesModel getEmpByID(int id) throws Exception {
		// TODO Auto-generated method stub
		return employeesMapper.selectEmpByID(id);
	}



	@Override
	public List<EmployeesModel> getEmpListByAll() throws Exception {
		// TODO Auto-generated method stub
		return employeesMapper.selectEmpListByAll();
	}

	@Override
	public List<EmployeesModel> getListByConditionWithDepartments(int departmentNo, String sex, Date startJoinDate,
			Date endJoinDate, int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return employeesMapper.selectListByConditionWithDepartments(departmentNo, sex, startJoinDate, endJoinDate, rows*(page-1), rows);
	}

	@Override
	public int getCountByConditionWithDepartments(int departmentNo, String sex, Date startJoinDate, Date endJoinDate)
			throws Exception {
		// TODO Auto-generated method stub
		return employeesMapper.selectCountByCondition(departmentNo, sex, startJoinDate, endJoinDate);
	}

	@Override
	public int getPageCountByConditionWithDepartments(int departmentNo, String sex, Date startJoinDate,
			Date endJoinDate, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByConditionWithDepartments(departmentNo, sex, startJoinDate, endJoinDate);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	}

