package com.qfedu.util;

/**
 * ���ݿ�����쳣(����ʱ�쳣)
 * @author ���
 *
 */
public class DbException extends RuntimeException {
	public static final String RS_EX = "���������ʱ�����쳣";
	public static final String EXEC_EX = "ִ��SQL���ʱ�����쳣";
	public static final String CONN_EX = "�޷��������ݿ�����";
	public static final String DIS_EX = "�޷��ر����ݿ�����";
	
	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
