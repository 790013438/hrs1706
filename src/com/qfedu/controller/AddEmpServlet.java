package com.qfedu.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.CommonUtil;

@WebServlet(urlPatterns = "/addEmp", loadOnStartup = 1)
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class AddEmpServlet extends BaseServlet {	
	private static final int DEFAULT_IMAGE_WIDTH = 200;
	private static final int DEFAULT_IMAGE_HEIGHT = 150;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		boolean sex = req.getParameter("sex").equals("1");
		String job = req.getParameter("job");
		double salary = Double.parseDouble(req.getParameter("salary"));
		String hireDateStr = req.getParameter("hiredate");
		System.out.println(hireDateStr);
		Date hireDate = CommonUtil.stringToDate("yyyy-MM-dd", hireDateStr);
		String tel = req.getParameter("tel");
		Emp emp = new Emp();
		emp.setNo(no);
		emp.setName(name);
		emp.setJob(job);
		emp.setSex(sex);
		emp.setSalary(salary);
		emp.setStatus(true);
		emp.setHireDate(hireDate);
		emp.setTel(tel);
		Emp mgr = new Emp();
		emp.setMgr(mgr);
		Part part = req.getPart("photo");
		if (part.getSize() > 0) {
			String newFilename = CommonUtil.getUniqueFilename() + ".png";
			String path = req.getServletContext().getRealPath("/images");
			File file = new File(path + "/" + newFilename);
			CommonUtil.compressImage(part.getInputStream(), file, 
					DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
			emp.setPhoto(newFilename);
		}
		int deptNo = Integer.parseInt(req.getParameter("dno"));
		Dept dept = new Dept();
		dept.setNo(deptNo);
		emp.setDept(dept);
		if (getEmpService().addNewEmp(emp)) {
			resp.sendRedirect("toEmp?no=" + deptNo);
		} else {
			req.setAttribute("hint", "ÃÌº”‘±π§ ß∞‹!!!");
			req.getRequestDispatcher("add_emp.jsp").forward(req, resp);
		}
	}

}
