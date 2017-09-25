package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

@WebServlet(urlPatterns = "/emp", loadOnStartup = 1)
public class ShowEmpServlet extends BaseServlet {
	private static final int DEFAULT_PAGE = 1;
	private static final int DEFAULT_SIZE = 5;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dept dept = (Dept) req.getSession().getAttribute("dept");
		String noString = req.getParameter("no");
		int no = Integer.parseInt(noString);
		if (dept == null || no != dept.getNo()) {
			dept = getDeptService().getDeptByNo(no);
			req.getSession().setAttribute("dept", dept);
		}
		if (dept != null) {
			int page = DEFAULT_PAGE;
			String pageStr = req.getParameter("page");
			if (pageStr != null) {
				try {
					page = Integer.parseInt(pageStr);
					page = page <= 0 ? DEFAULT_PAGE : page;
				} catch (NumberFormatException e) {
				}
			}
			int size = DEFAULT_SIZE;
			PageBean<EmpDto> pageBean = getEmpService().listAllEmpsByDeptNo(dept.getNo(), page, size);
//			req.setAttribute("empList", pageBean.getDataModel());
//			req.setAttribute("totalPage", pageBean.getTotalPage());
//			req.setAttribute("currentPage", pageBean.getCurrentPage());
//			req.getRequestDispatcher("emp.jsp").forward(req, resp);
			// 1. 将对象转换成JSON格式的字符串返回给浏览器
			// { 'empList': [{'no': 1122, 'name': '骆昊',  ...}, {}, ...], 'totalPage': 4, 'currentPage': 2, 'pageSize': 5 }
			// Gson / Fastjson
			String jsonStr = "";
			// 2. 把JSON字符串输出到浏览器通过MIME类型告诉浏览器这里是JSON格式
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.write(jsonStr);
			pw.close();
		}
	}
}
