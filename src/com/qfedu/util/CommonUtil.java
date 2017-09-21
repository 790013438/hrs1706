package com.qfedu.util;

import java.util.Date;
import java.util.UUID;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ���ù�����
 * @author ���
 *
 */
// a- ab-
// normal abnormal
// use abuse
// in- im-
// import include
// ex-
// export exclude
// patri
// expatriate
// mal-
// treat maltreat
// test - contest
// text - context
public final class CommonUtil {

	private CommonUtil() {
		throw new AssertionError();
	}
	
	/**
	 * ���ȫ��Ψһ���ļ���
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * ��ȡ�ļ����еĺ�׺��
	 * @param filename �ļ���
	 * @return ��׺��
	 */
	public static String getFilenameSuffix(String filename) {
		// assert filename != null;
		int index = filename.lastIndexOf(".");
		return index > 0 && index < filename.length() - 1 ? 
			filename.substring(index) : "";
	}
	
	/**
	 * ��ʱ�����ڸ�ʽ�����ַ���
	 * @param pattern ��ʽ
	 * @param date ʱ�����ڶ���
	 * @return ��ʽ�����ʱ�������ַ���
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * ���ַ���������ʱ������
	 * @param pattern ��ʽ
	 * @param str ʱ�������ַ���
	 * @return ʱ�����ڶ���
	 */
	public static Date stringToDate(String pattern, String str) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
