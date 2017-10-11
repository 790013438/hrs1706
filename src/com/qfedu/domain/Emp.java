package com.qfedu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 员工类
 * @author 骆昊
 *
 */
@Entity
@Table(name = "tb_emp")
public class Emp implements Serializable {
	@Id
	@Column(name = "eno")
	private Integer no;				// 编号
	@Column(name = "ename")
	private String name;		// 姓名
	@Column(name = "esex")
	private Boolean sex;			// 性别
	@Column(name = "ejob")
	private String job;				// 职位
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emgr")
	private Emp mgr;				// 主管
	@Column(name = "esal")
	private Double salary;		// 月薪
	@Column(name = "ehiredate")
	private Date hireDate;		// 入职日期
	@Column(name = "estatus")
	private Boolean status;	// 是否在职
	@Column(name = "ephoto")
	private String photo;		// 照片(路径)
	@Column(name = "etel")
	private String tel;				// 电话号码
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dno")
	private Dept dept;				// 所在部门

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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Emp getMgr() {
		return mgr;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
