package com.poly.constant;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpFilter extends Filter{
	@Override
	default public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	default public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		this.doFilter((HttpServletRequest)req, (HttpServletResponse)resp, chain);
	}
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;
	
	@Override
	default public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
