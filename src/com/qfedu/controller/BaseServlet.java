package com.qfedu.controller;

import javax.servlet.http.HttpServlet;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.ServiceFactory;

/**
 * 所有自定义Servlet的父类
 * @author 骆昊
 *
 */
public abstract class BaseServlet extends HttpServlet {

	/**
	 * 获取用户业务对象
	 */
	protected UserService getUserService() {
		return ServiceFactory.create(UserService.class);
	}
	
	/**
	 * 获取部门业务对象
	 */
	protected DeptService getDeptService() {
		return ServiceFactory.create(DeptService.class);
	}
	
	/**
	 * 获取员工业务对象 
	 */
	protected EmpService getEmpService() {
		return ServiceFactory.create(EmpService.class);
	}
}
