package com.qfedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String servletPath = request.getServletPath();
		if (servletPath.equals("/dept") || servletPath.equals("/delDept") ||
				servletPath.equals("/addDept")) {
			if (request.getSession().getAttribute("username") != null) {
				chain.doFilter(req, resp);
			} else {
				request.setAttribute("hint", "ÇëÏÈµÇÂ¼!!!");
				request.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException { }

	@Override
	public void destroy() {	}
}
