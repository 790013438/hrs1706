package com.qfedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns = "/dept", loadOnStartup = 1)
public class ShowDeptServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("dept");
		Map<Integer, Dept> map = (Map<Integer, Dept>) req.getServletContext().getAttribute("cache");
		req.setAttribute("deptList", new ArrayList<>(map.values()));
		req.getRequestDispatcher("dept.jsp").forward(req, resp);
	}
}
