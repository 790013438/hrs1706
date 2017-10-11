package com.qfedu.dto;

import java.io.Serializable;

import com.qfedu.domain.Emp;

/**
 * 员工数据传输对象 (Data Transfer Object / Value Object)
 * @author 骆昊
 *
 */
public class EmpDto implements Serializable {
	private Integer no;
	private String name;
	private String sex;
	private String status;
	private String job;
	private String tel;
	private String deptName;
	
	public EmpDto(Emp emp) {
		this.setNo(emp.getNo());
		this.setName(emp.getName());
		this.setSex(emp.getSex() ? "男" : "女");
		this.setJob(emp.getJob());
		this.setStatus(emp.getStatus() ? "在职" : "离职");
		this.setTel(emp.getTel());
		this.setDeptName(emp.getDept().getName());
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
