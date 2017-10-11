package com.qfedu.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.qfedu.util.HibernateUtil;

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
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Object retVal = method.invoke(target, args);
			session.getTransaction().commit();
			return retVal;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
