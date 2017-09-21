package com.qfedu.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qfedu.domain.Emp;
import com.qfedu.persistence.EmpDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbResourceManager;

public class EmpDaoImpl implements EmpDao {
	
	private static final String SELECT_EMP_BY_DEPT_SQL = 
			"select eno, ename, esex, ejob, estatus, etel from tb_emp where dno=?";
	private static final String INSERT_EMP_SQL =
			"insert into tb_emp values (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public List<Emp> findEmpsByDeptNo(Integer no) {
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, SELECT_EMP_BY_DEPT_SQL, no);
		List<Emp> empList = new ArrayList<>();
		try {
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setNo(rs.getInt("eno"));
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getBoolean("esex"));
				emp.setJob(rs.getString("ejob"));
				emp.setStatus(rs.getBoolean("estatus"));
				emp.setTel(rs.getString("etel"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
		return empList.size() > 0 ? empList : Collections.emptyList();
	}

	@Override
	public boolean save(Emp emp) {
		Connection connection = DbResourceManager.openConnection();
		try {
			return DbResourceManager.executeUpdate(connection, INSERT_EMP_SQL, 
					emp.getNo(), emp.getName(), emp.getSex(),
					emp.getJob(), emp.getMgr().getNo(), emp.getSalary(), 
					emp.getHireDate(), emp.getStatus(), emp.getPhoto(), 
					emp.getTel(), emp.getDept().getNo()) == 1;
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public boolean deleteByNo(Integer no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findByNo(Integer no) {
		// TODO Auto-generated method stub
		return null;
	}

}
