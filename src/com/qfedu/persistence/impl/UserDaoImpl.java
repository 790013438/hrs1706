package com.qfedu.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;

/**
 * 用户数据访问对象的实现类
 * @author 骆昊
 *
 */
public class UserDaoImpl implements UserDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql:///hrs", "root", "123456")) {
            PreparedStatement stmt = connection.prepareStatement(
                    "select password, email from tb_user where username=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql:///hrs", "root", "123456")) {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into tb_user values (?,?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
