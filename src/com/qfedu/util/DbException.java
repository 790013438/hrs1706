package com.qfedu.util;

/**
 * 数据库操作异常(运行时异常)
 * @author 骆昊
 *
 */
public class DbException extends RuntimeException {
	public static final String RS_EX = "解析结果集时发生异常";
	public static final String EXEC_EX = "执行SQL语句时发生异常";
	public static final String CONN_EX = "无法建立数据库连接";
	public static final String DIS_EX = "无法关闭数据库连接";
	
	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
