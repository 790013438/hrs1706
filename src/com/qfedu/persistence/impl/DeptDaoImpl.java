package com.qfedu.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbSessionFactory;

/**
 * 部门数据访问对象实现类
 * @author 骆昊
 *
 */
public class DeptDaoImpl implements DeptDao {

	private static final String SELECT_DEPT_SQL = "select dname, dloc from tb_dept where dno=?";
	private static final String SELECT_ALL_DEPT_SQL = "select dno, dname, dloc from tb_dept";
	private static final String INSERT_DEPT_SQL = "insert into tb_dept values (?,?,?)";
	private static final String DELETE_DEPT_SQL = "delete from tb_dept where dno=?";
	private static final String UPDATE_DEPT_SQL = "update tb_dept set dname=?, dloc=? where dno=?";
	private static final String COUNT_EMP_SQL = "select count(eno) from tb_emp where dno=?";
	
	@Override
	public boolean save(Dept dept) {
		return DbSessionFactory.getCurrentDbSession().executeUpdate(
				INSERT_DEPT_SQL, 
				dept.getNo(), dept.getName(), dept.getLocation()) == 1;
	}

	@Override
	public boolean deleteByNo(Integer no) {
		return DbSessionFactory.getCurrentDbSession().executeUpdate(
				DELETE_DEPT_SQL, no) == 1;
	}

	@Override
	public boolean update(Dept dept) {
		return DbSessionFactory.getCurrentDbSession().executeUpdate(
				UPDATE_DEPT_SQL, 
				dept.getName(), dept.getLocation(), dept.getNo()) == 1;
	}

	@Override
	public List<Dept> findAll() {
		ResultSet rs = DbSessionFactory.getCurrentDbSession().executeQuery(
				SELECT_ALL_DEPT_SQL);
		try {
			List<Dept> deptList = new ArrayList<>();
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setNo(rs.getInt("dno"));
				dept.setName(rs.getString("dname"));
				dept.setLocation(rs.getString("dloc"));
				deptList.add(dept);
			}
			return deptList.size() > 0 ? deptList : Collections.emptyList();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
	}

	@Override
	public int countEmpByNo(Integer no) {
		ResultSet rs = DbSessionFactory.getCurrentDbSession().executeQuery(
				COUNT_EMP_SQL, no);
		try {
			return rs.next() ? rs.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
	}

	@Override
	public Dept findById(Integer no) {
		ResultSet rs = DbSessionFactory.getCurrentDbSession().executeQuery(
				SELECT_DEPT_SQL, no);
		try {
			Dept dept = null;
			if (rs.next()) {
				dept = new Dept();
				dept.setNo(no);
				dept.setName(rs.getString("dname"));
				dept.setLocation(rs.getString("dloc"));
			}
			return dept;
		} catch (SQLException e) {
			throw new DbException(DbException.RS_EX, e);
		}
	}
}
