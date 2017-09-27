package com.qfedu.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.qfedu.util.DbException;
import com.qfedu.util.DbSession;
import com.qfedu.util.DbSessionFactory;

/**
 * ҵ�������
 * @author ���
 *
 */
public class ServiceProxy implements InvocationHandler {
	private Object target;		// �������ҵ�����
	
	public ServiceProxy(Object target) {
		this.target = target;
	}
	
	/**
	 * �����������
	 * @param target ���������
	 * @return �������
	 */
	public static <T> T createProxy(Object target) {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new ServiceProxy(target));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		DbSession session = DbSessionFactory.getCurrentDbSession();
		String methodName = method.getName();
		boolean isTxNeeded = !methodName.startsWith("get") &&
				!methodName.startsWith("list");
		try {
			if (isTxNeeded) session.beginTx();
			Object retVal = method.invoke(target, args);
			if (isTxNeeded) session.commitTx();
			return retVal;
		} catch (DbException e) {
			if (isTxNeeded) session.rollbackTx();
			throw e;
		} finally {
			DbSessionFactory.closeCurrentDbSession();
		}
	}

}
