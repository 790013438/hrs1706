package com.qfedu.service.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.persistence.impl.DeptDaoImpl;
import com.qfedu.service.DeptService;

/**
 * 部门相关业务实现类
 * @author 骆昊
 *
 */
public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public List<Dept> listAllDepts() {
		return deptDao.findAll();
	}

	@Override
	public boolean removeDeptByNo(Integer no) {
		if (deptDao.countEmpByNo(no) == 0) {
			return deptDao.deleteByNo(no);
		}
		return false;
	}

}
