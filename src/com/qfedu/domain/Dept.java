package com.qfedu.domain;

import java.io.Serializable;

/**
 * ������
 * @author ���
 *
 */
public class Dept implements Serializable {
	private Integer no;				// ���
	private String name;		// ����
	private String location;	// ���ڵ�

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
//	public String getNameUrl() {
//		try {
//			return URLEncoder.encode(name, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			throw new RuntimeException(e);
//		}
//	}

}