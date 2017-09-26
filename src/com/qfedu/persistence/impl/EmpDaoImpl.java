package com.qfedu.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.persistence.EmpDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbResourceManager;
import com.qfedu.util.PageBean;

public class EmpDaoImpl implements EmpDao {
	
	private static final String SELECT_EMP_BY_DEPT_SQL = 
			"select eno, ename, esex, ejob, estatus, etel from tb_emp where dno=? limit ?,?";
	private static final String SELECT_EMP_COUNT_SQL = 
			"select count(eno) from tb_emp where dno=?";
	private static final String INSERT_EMP_SQL =
			"insert into tb_emp values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_EMP_SQL = 
			"select ephoto from tb_emp where eno=?";

	@Override
	public PageBean<EmpDto> findEmpsByDeptNo(Integer no, int page, int size) {
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, 
				SELECT_EMP_BY_DEPT_SQL, no, (page - 1) * size, size);
		ResultSet rs2 = DbResourceManager.executeQuery(connection, 
				SELECT_EMP_COUNT_SQL, no);
		List<EmpDto> empList = new ArrayList<>();
		try {
			while (rs.next()) {
				EmpDto emp = new EmpDto();
				emp.setNo(rs.getInt("eno"));
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getBoolean("esex") ? "男" : "女");
				emp.setJob(rs.getString("ejob"));
				emp.setStatus(rs.getBoolean("estatus") ? "在职" : "离职");
				emp.setTel(rs.getString("etel"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
		int total = 0;
		try {
			total = rs2.next() ? rs2.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		} finally {
			DbResourceManager.closeConnection(connection);
		}
		int totalPage = (total - 1) / size + 1;
		empList = empList.size() > 0 ? empList : Collections.emptyList();
		return new PageBean<>(empList, totalPage, page, size);
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
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		return false;
	}

	@Override
	public Emp findByNo(Integer no) {
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, SELECT_EMP_SQL, no);
		try {
			Emp emp = null;
			if (rs.next()) {
				emp = new Emp();
				emp.setPhoto(rs.getString("ephoto"));
			}
			return emp;
		} catch (SQLException e) {
			throw new DbException(DbException.RS_EX, e);
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

}
