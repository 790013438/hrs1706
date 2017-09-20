package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dept", loadOnStartup = 1)
public class ShowDeptServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", getDeptService().listAllDepts());
		req.getRequestDispatcher("dept.jsp").forward(req, resp);
	}
}
