package com.qfedu.util;

/**
 * 创建数据库会话的工厂
 * @author 骆昊
 *
 */
public final class DbSessionFactory {
	private static ThreadLocal<DbSession> threadLocal = new ThreadLocal<>();
	
	private DbSessionFactory() {
		throw new AssertionError();
	}
	
	/**
	 * 获得跟当前线程绑定的数据库会话对象
	 */
	public static DbSession getCurrentDbSession() {
		DbSession session = threadLocal.get();
		if (session == null) {
			session = new DbSession();
			threadLocal.set(session);
		}
		session.open();
		return session;
	}
	
	/**
	 * 关闭和当前线程绑定的数据库会话
	 */
	public static void closeCurrentDbSession() {
		DbSession session = threadLocal.get();
		if (session != null) {
			threadLocal.remove();
			session.close();
		}
	}
}
