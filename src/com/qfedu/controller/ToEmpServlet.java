package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns = "/toEmp", loadOnStartup = 1)
public class ToEmpServlet extends BaseServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dept dept = (Dept) req.getSession().getAttribute("dept");
		String noString = req.getParameter("no");
		int no = Integer.parseInt(noString);
		if (dept == null || no != dept.getNo()) {
			dept = getDeptService().getDeptByNo(no);
			req.getSession().setAttribute("dept", dept);
		}
		req.getRequestDispatcher("emp.jsp").forward(req, resp);
	}
}
