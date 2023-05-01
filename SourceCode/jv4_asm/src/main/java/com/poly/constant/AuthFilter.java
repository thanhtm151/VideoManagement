package com.poly.constant;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.USERS;

@WebFilter({"/admin/index","/admin/user-ctr", "/admin/video-ctr", "/admin/user-update", "/admin/video-update/*", 
	"/admin/video-update/edit/*","/admin/user-update/edit/*","/admin/index/*","/video-share","/video-share/*"
	, "/like-video","/video-detail/like/*"//"/index"
})
public class AuthFilter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		USERS user = (USERS)req.getSession().getAttribute("user");
		
		String uri = req.getRequestURI();
		String error = "";
		if (user == null) {//|| uri.contains("/index")
			error = resp.encodeURL("Vui lòng đăng nhập !");
			//System.out.println("Vui lòng đăng nhập !");
		} else if (!user.getAdmin() && uri.contains("/admin/")) {
			error = resp.encodeURL("Vui lòng đăng nhập với vai trò admin !");
			//System.out.println("Vui lòng đăng nhập với vai trò admin !");
		}
		if (!error.isEmpty()) {
			req.getSession().setAttribute("seuri", uri);
			resp.sendRedirect("/ASM_Java4/login?error=" + resp.encodeURL(error));
		} else {
			chain.doFilter(req, resp);
		}
		
	}
	
}
