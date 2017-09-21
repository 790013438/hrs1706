package com.qfedu.service.impl;

import java.util.List;

import com.qfedu.domain.Emp;
import com.qfedu.persistence.EmpDao;
import com.qfedu.persistence.impl.EmpDaoImpl;
import com.qfedu.service.EmpService;

/**
 * 员工相关业务实现类
 * @author 骆昊
 *
 */
public class EmpServiceImpl implements EmpService {
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public boolean addNewEmp(Emp emp) {
		return empDao.save(emp);
	}
	
	@Override
	public List<Emp> listAllEmpsByDeptNo(Integer no) {
		return empDao.findEmpsByDeptNo(no);
	}

}
