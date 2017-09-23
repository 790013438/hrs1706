package com.qfedu.service.impl;

import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.persistence.EmpDao;
import com.qfedu.persistence.impl.EmpDaoImpl;
import com.qfedu.service.EmpService;
import com.qfedu.util.PageBean;

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
	public PageBean<EmpDto> listAllEmpsByDeptNo(Integer no, int page, int size) {
		return empDao.findEmpsByDeptNo(no, page, size);
	}

}
