package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/emp", loadOnStartup = 1)
public class ShowEmpServlet extends BaseServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		String name = req.getParameter("name");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			req.setAttribute("deptNo", no);
			req.setAttribute("deptName", name);
			req.setAttribute("empList", getEmpService().listAllEmpsByDeptNo(no));
			req.getRequestDispatcher("emp.jsp").forward(req, resp);
		}
	}
}
