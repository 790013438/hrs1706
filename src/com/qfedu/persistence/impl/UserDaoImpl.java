package com.qfedu.persistence.impl;

import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;

/**
 * 用户数据访问对象的实现类
 * @author 骆昊
 *
 */
public class UserDaoImpl 
		extends BaseDaoAdapter<User, String>
		implements UserDao {
}
