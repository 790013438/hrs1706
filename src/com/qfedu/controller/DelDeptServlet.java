package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns = "/delDept", loadOnStartup = 1)
public class DelDeptServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("no");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			boolean flag = getDeptService().removeDeptByNo(no);
			if (flag) {
				// 如果删除部门成功则先刷新缓存数据
				Map<Integer, Dept> map = (Map<Integer, Dept>) 
						req.getServletContext().getAttribute("cache");
				map.remove(no);
			}
			String responseText = flag ? "success" : "failed";
			PrintWriter pw = resp.getWriter();
			pw.write(responseText);
			pw.close();
		}
	}

	
}
