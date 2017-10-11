package com.qfedu.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns = "/addDept", loadOnStartup = 1)
public class AddDeptServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		String name = req.getParameter("name");
		String location = req.getParameter("location");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			Dept dept = new Dept();
			dept.setNo(no);
			dept.setName(name);
			dept.setLocation(location);
			if (getDeptService().addNewDept(dept)) {
				// �����Ӳ��ųɹ�����ˢ�»����������ض��򵽲鿴����ҳ��
				Map<Integer, Dept> map = (Map<Integer, Dept>) 
						req.getServletContext().getAttribute("cache");
				map.put(dept.getNo(), dept);
				resp.sendRedirect("dept");
			} else {
				req.setAttribute("hint", "��Ӳ���ʧ��!");
				req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("hint", "�����������Ĳ�����Ϣ");
			req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
		}
	}
}
