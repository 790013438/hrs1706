package com.qfedu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门类
 * @author 骆昊
 *
 */
@Entity
@Table(name = "tb_dept")
public class Dept implements Serializable {
	@Id
	@Column(name = "dno")
	private Integer no;				// 编号
	@Column(name = "dname")
	private String name;		// 名称
	@Column(name = "dloc")
	private String location;	// 所在地

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
