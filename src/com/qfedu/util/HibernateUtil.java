package com.qfedu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	private HibernateUtil() {
		throw new AssertionError();
	}
	
	public static Session getSession() {
		return factory.getCurrentSession();
	}
}
