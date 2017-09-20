package com.qfedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ���Դ��������
 * @author ���
 *
 */
public final class DbResourceManager {
	private static final String DRV = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///hrs";
	private static final String UID = "root";
	private static final String PWD = "123456";
	
	static {
		try {
			Class.forName(DRV);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DbResourceManager() {
		throw new AssertionError();
	}
	
	/**
	 * �����ݿ�����
	 * @return ���ݿ����Ӷ���
	 */
	public static Connection openConnection() {
		try {
			return DriverManager.getConnection(URL, UID, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.CONN_EX, e);
		}
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.DIS_EX, e);
		}
	}
	
	/**
	 * ִ����ɾ�Ĳ���
	 * @param con ���Ӷ���
	 * @param sql SQL���
	 * @param params �滻SQL�����ռλ���Ĳ���
	 * @return ��Ӱ�������
	 */
	public static int executeUpdate(Connection con, String sql, Object... params) {
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
	public static ResultSet executeQuery(Connection con, String sql, Object... params) {
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
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








