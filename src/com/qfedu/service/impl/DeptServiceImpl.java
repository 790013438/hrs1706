package com.qfedu.service.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.persistence.impl.DeptDaoImpl;
import com.qfedu.service.DeptService;

/**
 * �������ҵ��ʵ����
 * @author ���
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
