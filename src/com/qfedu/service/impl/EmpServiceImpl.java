package com.qfedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qfedu.domain.Dept;
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
		return empDao.save(emp) != null;
	}
	
	@Override
	public PageBean<EmpDto> listAllEmpsByDept(Dept dept, int page, int size) {
		PageBean<Emp> pageBean = empDao.findEmpsByDept(dept, page, size);
		List<Emp> empList = pageBean.getDataModel();
		List<EmpDto> empDtoList = new ArrayList<>();
		for (Emp emp : empList) {
			empDtoList.add(new EmpDto(emp));
		}
		return new PageBean<>(empDtoList, pageBean.getTotalPage(), pageBean.getCurrentPage(), pageBean.getPageSize());
	}

	@Override
	public Emp getEmpByNo(int no) {
		return empDao.findById(no);
	}

}
