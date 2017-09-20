package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.service.DeptService;
import com.qfedu.service.impl.DeptServiceImpl;

@WebServlet(urlPatterns = "/delDept", loadOnStartup = 1)
public class DelDeptServlet extends HttpServlet {
	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			deptService.removeDeptByNo(no);
		}
		resp.sendRedirect("dept");
	}
}
