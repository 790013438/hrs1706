package com.qfedu.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbResourceManager;

/**
 * 部门数据访问对象实现类
 * @author 骆昊
 *
 */
public class DeptDaoImpl implements DeptDao {

	private static final String SELECT_ALL_DEPT_SQL = "select dno, dname, dloc from tb_dept";
	private static final String INSERT_DEPT_SQL = "insert into tb_dept values (?,?,?)";
	private static final String DELETE_DEPT_SQL = "delete from tb_dept where dno=?";
	private static final String UPDATE_DEPT_SQL = "update tb_dept set dname=?, dloc=? where dno=?";
	private static final String COUNT_EMP_SQL = "select count(eno) from tb_emp where dno=?";
	
	@Override
	public boolean save(Dept dept) {
		Connection connection = DbResourceManager.openConnection();
		try {
			return DbResourceManager.executeUpdate(connection, INSERT_DEPT_SQL, 
					dept.getNo(), dept.getName(), dept.getLocation()) == 1;
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public boolean deleteByNo(Integer no) {
		Connection connection = DbResourceManager.openConnection();
		try {
			return DbResourceManager.executeUpdate(connection, DELETE_DEPT_SQL, no) == 1;
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public boolean update(Dept dept) {
		Connection connection = DbResourceManager.openConnection();
		try {
			return DbResourceManager.executeUpdate(connection, UPDATE_DEPT_SQL, 
					dept.getName(), dept.getLocation(), dept.getNo()) == 1;
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, SELECT_ALL_DEPT_SQL);
		try {
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
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public int countEmpByNo(Integer no) {
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, COUNT_EMP_SQL, no);
		try {
			return rs.next() ? rs.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

}
