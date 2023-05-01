package com.poly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.VideoDAO;
import com.poly.entity.USERS;
import com.poly.entity.VIDEO;

@WebServlet({ "/index", "/photo-detail", "/about", "/contact" })
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		setAcountHeader(req, resp);
		switch (path) {
		case "/index": {
			this.doGetIndex(req, resp);
			break;
		}
		case "/photo-detail": {
			this.doGetPhotoDetail(req, resp);
			break;
		}
		case "/about": {
			this.doGetAbout(req, resp);
			break;
		}
		case "/contact": {
			this.doGetContact(req, resp);
			break;
		}

		}
	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		USERS user = (USERS) req.getSession().getAttribute("user");

		VideoDAO dao = new VideoDAO();
		List<VIDEO> video2 = dao.findVideoTop5();
		List<VIDEO> video1 = dao.findVideoTop();

		if (user != null) {
			req.setAttribute("hidden", "");
			List<VIDEO> video3 = dao.findVideoLike(user.getId());
			List<VIDEO> video4 = dao.findVideoShare(user.getId());
			
			if(!video3.isEmpty()) {
				req.setAttribute("video3", video3);
			}
			if(!video4.isEmpty()) {
				req.setAttribute("video4", video4);
			}
		} else {
			req.setAttribute("hidden", "hidden");
		}
		if (!video2.isEmpty()) {
			req.setAttribute("video2", video2);
		}
		if (!video1.isEmpty()) {
			req.setAttribute("video1", video1);
		}

		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}

	private void doGetPhotoDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/photo-detail.jsp").forward(req, resp);
	}

	private void doGetAbout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/about.jsp").forward(req, resp);
	}

	private void doGetContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/contact.jsp").forward(req, resp);
	}

	// Set Page Header Account
	private void setAcountHeader(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		USERS username = (USERS) req.getSession().getAttribute("user");
		if (username != null) {
			req.setAttribute("account", username.getId());
			req.setAttribute("login_pass", "hidden");
			req.setAttribute("login_no", "");
			if (username.getAdmin()) {
				req.setAttribute("login_admin", "");
			} else {
				req.setAttribute("login_admin", "hidden");
			}
		} else {
			req.setAttribute("account", "Tài khoản");
			req.setAttribute("login_pass", "");
			req.setAttribute("login_no", "hidden");
			req.setAttribute("login_admin", "hidden");
		}
	}
}
