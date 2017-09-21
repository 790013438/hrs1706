package com.qfedu.util;

import java.util.Date;
import java.util.UUID;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 常用工具类
 * @author 骆昊
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
	 * 获得全局唯一的文件名
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取文件名中的后缀名
	 * @param filename 文件名
	 * @return 后缀名
	 */
	public static String getFilenameSuffix(String filename) {
		// assert filename != null;
		int index = filename.lastIndexOf(".");
		return index > 0 && index < filename.length() - 1 ? 
			filename.substring(index) : "";
	}
	
	/**
	 * 将时间日期格式化成字符串
	 * @param pattern 样式
	 * @param date 时间日期对象
	 * @return 格式化后的时间日期字符串
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * 将字符串解析成时间日期
	 * @param pattern 样式
	 * @param str 时间日期字符串
	 * @return 时间日期对象
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
