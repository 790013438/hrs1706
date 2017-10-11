package com.qfedu.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �û���
 * @author ���
 *
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	@Id
	private String username;		// �û���
	private String password;			// ����
	private String email;				// ����

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
