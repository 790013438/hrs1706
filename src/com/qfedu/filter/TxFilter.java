package com.qfedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.qfedu.util.DbException;
import com.qfedu.util.DbSession;
import com.qfedu.util.DbSessionFactory;

// @WebFilter("/*")
public class TxFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, 
			FilterChain chain) throws IOException, ServletException {
		DbSession session = DbSessionFactory.getCurrentDbSession();
		try {
			session.beginTx();
			chain.doFilter(req, resp);
			session.commitTx();
		} catch (DbException e) {
			session.rollbackTx();
		} finally {
			DbSessionFactory.closeCurrentDbSession();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException { }

	@Override
	public void destroy() { }
}
