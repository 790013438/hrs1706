package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empDetail", loadOnStartup = 1)
public class ShowEmpDetailServlet extends BaseServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		int no = Integer.parseInt(noString);
		req.setAttribute("emp", getEmpService().getEmpByNo(no));
		req.getRequestDispatcher("emp_detail.jsp").forward(req, resp);
	}
}
