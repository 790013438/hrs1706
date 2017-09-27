package com.qfedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ�Ự
 * @author ���
 *
 */
public class DbSession {
	private Connection connection;
	
	/**
	 * �������ݿ�Ự
	 */
	public void open() {
		if (connection == null) {
			connection = DbResourceManager.openConnection();
		}
	}
	
	/**
	 * �ر����ݿ�Ự
	 */
	public void close() {
		DbResourceManager.closeConnection(connection);
	}
	
	/**
	 * ��������
	 */
	public void beginTx() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	
	/**
	 * �ύ����
	 */
	public void commitTx() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	
	/**
	 * �ع�����
	 */
	public void rollbackTx() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	
	/**
	 * ִ����ɾ�Ĳ���
	 * @param con ���Ӷ���
	 * @param sql SQL���
	 * @param params �滻SQL�����ռλ���Ĳ���
	 * @return ��Ӱ�������
	 */
	public int executeUpdate(String sql, Object... params) {
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for (int i = 0; i < params.length; ++i) {
				stmt.setObject(i + 1, params[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.EXEC_EX, e);
		}
	}
	
	/**
	 * ִ�в�ѯ����
	 * @param con ���ݿ����Ӷ���
	 * @param sql SQL���
	 * @param params �滻SQL�����ռλ���Ĳ���
	 * @return ��������� (�α�)
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; ++i) {
				stmt.setObject(i + 1, params[i]);
			}
			return stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.EXEC_EX, e);
		}
	}
}
