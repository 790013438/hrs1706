package com.qfedu.persistence;

import com.qfedu.domain.User;

/**
 * 用户数据访问对象
 * @author 骆昊
 *
 */
public interface UserDao {

	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @return 用户对象或null
	 */
	User findByUsername(String username);
	
	/**
	 * 保存用户
	 * @param user 用户对象
	 * @return 保存成功返回true否则返回false
	 */
	boolean save(User user);
}
