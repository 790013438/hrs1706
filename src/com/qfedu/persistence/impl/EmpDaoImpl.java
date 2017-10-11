package com.qfedu.persistence.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.persistence.EmpDao;
import com.qfedu.util.HibernateUtil;
import com.qfedu.util.PageBean;

public class EmpDaoImpl 
		extends BaseDaoAdapter<Emp, Integer>
		implements EmpDao {

	@Override
	public PageBean<Emp> findEmpsByDept(Dept dept, int page, int size) {
		List<Emp> empList = HibernateUtil.getSession()
				.createQuery("from Emp as e where e.dept=:dept", Emp.class)
				.setParameter("dept", dept)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int empCount = HibernateUtil.getSession()
				.createQuery("select count(e) from Emp as e where e.dept=:dept", Long.class)
				.setParameter("dept", dept)
				.getSingleResult().intValue();
		int totalPage = (empCount - 1) / size + 1;
		return new PageBean<>(empList, totalPage, page, size);
	}
}
