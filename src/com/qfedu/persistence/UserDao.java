package com.qfedu.persistence;

import com.qfedu.domain.User;

/**
 * �û����ݷ��ʶ���
 * @author ���
 *
 */
public interface UserDao {

	/**
	 * �����û��������û�
	 * @param username �û���
	 * @return �û������null
	 */
	User findByUsername(String username);
	
	/**
	 * �����û�
	 * @param user �û�����
	 * @return ����ɹ�����true���򷵻�false
	 */
	boolean save(User user);
}
