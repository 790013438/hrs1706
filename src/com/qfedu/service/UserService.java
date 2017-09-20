package com.qfedu.service;

import com.qfedu.domain.User;

/**
 * 用户相关业务接口
 * @author 骆昊
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回true否则返回false
	 */
	boolean login(String username, String password);
	
	/**
	 * 注册
	 * @param user 用户对象
	 * @return 注册成功返回true否则返回false
	 */
	boolean register(User user);
}
