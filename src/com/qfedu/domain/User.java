package com.qfedu.domain;

import java.io.Serializable;

/**
 * 用户类
 * @author 骆昊
 *
 */
public class User implements Serializable {
    private String username;		// 用户名
    private String password;			// 密码
    private String email;				// 邮箱

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
