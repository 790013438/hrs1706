package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delDept", loadOnStartup = 1)
public class DelDeptServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			String responseText = 
					getDeptService().removeDeptByNo(no) ? "success" : "failed";
			PrintWriter pw = resp.getWriter();
			pw.write(responseText);
			pw.close();
		}
	}

	
}
