package com.qfedu.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbResourceManager;

/**
 * 用户数据访问对象的实现类
 * @author 骆昊
 *
 */
public class UserDaoImpl implements UserDao {

	private static final String SELECT_USER_SQL = "select password, email from tb_user where username=?";
	private static final String INSERT_USER_SQL = "insert into tb_user values (?,?,?)";

	@Override
	public User findByUsername(String username) {
		Connection connection = DbResourceManager.openConnection();
		ResultSet rs = DbResourceManager.executeQuery(connection, SELECT_USER_SQL, username);
		try {
				User user = null;
				if (rs.next()) {
					user = new User();
					user.setUsername(username);
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
				}
				return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("解析结果集时出现异常", e);
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

	@Override
	public boolean save(User user) {
		Connection connection = DbResourceManager.openConnection();
		try {
			return DbResourceManager.executeUpdate(connection, INSERT_USER_SQL, 
					user.getUsername(), user.getPassword(), user.getEmail()) == 1;
		} finally {
			DbResourceManager.closeConnection(connection);
		}
	}

}
