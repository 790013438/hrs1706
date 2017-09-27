package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;

/**
 * ����ҵ�����Ĺ�����
 * 
 * @author ���
 *
 */
public final class ServiceFactory {
	private static Map<Class<?>, Object> map = new HashMap<>();

	static {
		map.put(UserService.class, ServiceProxy.createProxy(new UserServiceImpl()));
		map.put(DeptService.class, ServiceProxy.createProxy(new DeptServiceImpl()));
		map.put(EmpService.class, ServiceProxy.createProxy(new EmpServiceImpl()));
	}

	private ServiceFactory() {
		throw new AssertionError();
	}

	/**
	 * ����ҵ�����Ĺ�������
	 * @param type ҵ����������
	 * @return ҵ�����
	 */
	public static <T> T create(Class<?> type) {
		return (T) map.get(type);
	}
}