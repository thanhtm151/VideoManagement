package com.poly.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.FavoriteDAO;
import com.poly.dao.ShareDAO;
import com.poly.dao.UserDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.FAVORITE;
import com.poly.entity.SHARES;
import com.poly.entity.USERS;
import com.poly.entity.VIDEO;

@WebServlet({ "/videos", "/video-detail/id/*", "/like-video", "/video-detail/like/*", "/video-share",
		"/video-share/share" })
public class VideoServlet extends HttpServlet {
	// doGet
	private String id = "", urlVideo = "";
	private int count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		setPageItemHeader(request, response);
		switch (path) {
		case "/videos": {
			this.doGetVideos(request, response);
			break;
		}
		case "/video-detail/id": {
			doGetVideoDetail(request, response);
			break;
		}
		case "/like-video": {
			this.doGetLikeVideo(request, response);
			break;
		}
		case "/video-share": {
			this.doGetVideoShare(request, response);
			break;
		}
		}

	}

	// doGet
	// doPost
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		count = 0;
		USERS user = (USERS) request.getSession().getAttribute("user");
		setPageItemHeader(request, response);
		switch (path) {
		case "/video-detail/like": {
			FavoriteDAO fav = new FavoriteDAO();
			if (user != null) {
				List<FAVORITE> list = fav.findLike(id, user.getId());
				if (list != null && !list.isEmpty()) {
					unLike(request, response);
				} else {
					likeVideo(request, response);
				}
			} else {
				response.sendRedirect("/ASM_Java4/login");
			}
			count=1;
			break;
		}
		case "/video-share/share": {
			if (user != null) {
				// request.setAttribute("urlVideo", urlVideo);
				if (checkForm(request, response) == true) {
					VideoDAO dao = new VideoDAO();
					VIDEO vid = dao.findById(id);
					
					sendMail(request, response, user.getFullname(),vid.getTitle(), urlVideo);
					insertShares(request, response);
					doGetVideoShare(request, response);
				} else {
					doGetVideoShare(request, response);
				}
			} else {
				response.sendRedirect("/ASM_Java4/login");
			}
			count=1;
			break;
		}
		}
	}
	// doPost

	// Video Page
	private void doGetVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		List<VIDEO> video = dao.findAll();
		if (video != null) {
			req.setAttribute("videos", video);
		}

		req.getRequestDispatcher("/views/user/videos.jsp").forward(req, resp);
	}

	// VideoDetail
	private void doGetVideoDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		VIDEO video = new VIDEO();
		List<VIDEO> video2 = dao.findVideoTop5();
		USERS user = (USERS) request.getSession().getAttribute("user");

		FavoriteDAO fav = new FavoriteDAO();
		
		String uri = request.getRequestURI();

		id = uri.substring(uri.lastIndexOf("/") + 1);
		
		List<Long> like = fav.getLike(id);
		if(!like.isEmpty()) {
			String likel = like.toString();
			String like2 = likel.substring(likel.indexOf("[") + 1, likel.indexOf("]"));
			System.out.println(like2);
			request.setAttribute("like",like2);
		}
		
		if (user != null) {
			List<FAVORITE> list = fav.findLike(id, user.getId());
			if (list != null && !list.isEmpty()) {
				request.setAttribute("likelog", "Unlike");
				request.setAttribute("btnlike","bg-dark");
				System.out.println(list.toString());
			} else {
				request.setAttribute("likelog", "Like");
				request.setAttribute("btnlike","bg-danger");
			}
		} else {
			request.setAttribute("likelog", "Like");
			request.setAttribute("btnlike","bg-danger");
		}

		video = dao.findById(id);
		if (count == 0) {
			int views = video.getViews();
			video.setViews(views + 1);
			dao.update(video);
		}else {
			count = 0;
		}
		urlVideo = request.getRequestURL().toString();

		request.setAttribute("videos", video);
		request.setAttribute("video", video2);
		request.getRequestDispatcher("/views/user/video-detail.jsp").forward(request, response);
	}

	// LikeVideo
	private void doGetLikeVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		if (user != null) {
			FavoriteDAO dao = new FavoriteDAO();
			List<VIDEO> list = dao.findLikeVideo(user.getId());
			request.setAttribute("videos", list);
		}

		request.getRequestDispatcher("/views/user/like-video.jsp").forward(request, response);
	}

	private void likeVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		VideoDAO daoVideo = new VideoDAO();
		VIDEO video = daoVideo.findById(id);
		if (user != null) {
			FavoriteDAO dao = new FavoriteDAO();
			FAVORITE fav = new FAVORITE();
			VIDEO vi = new VIDEO();
			vi.setId(id);
			fav.setVideo(vi);

			USERS u = new USERS();
			u.setId(user.getId());
			fav.setUser(u);
			fav.setLikeDate(new Date());

			dao.create(fav);
			request.getSession().setAttribute("like", fav);
			List<FAVORITE> list = dao.findLike(id, user.getId());
			if (list != null && !list.isEmpty()) {
				request.setAttribute("likelog", "Unlike");
				System.out.println(list.toString());
			} else {
				request.setAttribute("likelog", "Like");
			}

			request.setAttribute("videos", video);

			response.sendRedirect("/ASM_Java4/video-detail/id/" + id);
		}
		count = 1;
	}

	private void unLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		VideoDAO daoVideo = new VideoDAO();
		VIDEO video = daoVideo.findById(id);
		if (user != null) {
			FavoriteDAO dao = new FavoriteDAO();
			List<FAVORITE> list = dao.findLike(id, user.getId());
			dao.remove(list.get(0).getId());

			if (list != null && !list.isEmpty()) {
				request.setAttribute("likelog", "Like");
			} else {
				request.setAttribute("likelog", "Unlike");
			}

			request.setAttribute("videos", video);

			response.sendRedirect("/ASM_Java4/video-detail/id/" + id);
		} else {
			response.sendRedirect("/ASM_Java4/login");
		}
		count = 1;
	}
	// doGet
	// Admin Index - Trang chu Index

	private void setPageItemHeader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS username = (USERS) request.getSession().getAttribute("user");
		if (username != null) {
			request.setAttribute("account", username.getId());
			request.setAttribute("login_pass", "hidden");
			request.setAttribute("login_no", "");
			if (username.getAdmin()) {
				request.setAttribute("login_admin", "");
			} else {
				request.setAttribute("login_admin", "hidden");
			}
		} else {
			request.setAttribute("account", "Tài khoản");
			request.setAttribute("login_pass", "");
			request.setAttribute("login_no", "hidden");
			request.setAttribute("login_admin", "hidden");
		}
	}

	// Share video
	private void doGetVideoShare(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/video-share.jsp").forward(request, response);
	}

	// Share Insert
	private void insertShares(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		VideoDAO daoVideo = new VideoDAO();

		String email = request.getParameter("email");

		ShareDAO dao = new ShareDAO();
		SHARES share = new SHARES();

		USERS u = new USERS();
		u.setId(user.getId());
		share.setUser(u);

		VIDEO vid = daoVideo.findById(id);
		vid.setId(id);
		share.setVideo(vid);

		share.setEmail(email);
		share.setShareDate(new Date());

		dao.create(share);
		System.out.println("*Chia sẻ thành công!");

	}

	// checkShare
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String method = request.getMethod();
		String dinhdangGmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String dinhdangFpt = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@fpt+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		int count = 0;
		if (method.equalsIgnoreCase("POST")) {
			if (email != null) {
				if (!email.matches(dinhdangGmail) && !email.matches(dinhdangFpt)) {
					System.out.println(email);
					request.setAttribute("message", "*Định dạng email không hợp lệ!");
					count = 2;
				}else {
					count = 0;
				}
			}else {
				count = 2;
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Gui email
	private void sendMail(HttpServletRequest request, HttpServletResponse response, String username,String video, String url)
			throws ServletException, IOException {
		String method = request.getMethod();
		int count = 0;
		if (method.equalsIgnoreCase("POST")) {
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			props.setProperty("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					String username = "thanhtmps25076@fpt.edu.vn";
					String password = "moorwwlvplwfxzpy";
					return new PasswordAuthentication(username, password);
				}
			});
			String subject = "PolyTube - " + username + " chia sẻ video tới bạn";
			String body = "Xem video: "+video+"  " + url;

			MimeMessage mime = new MimeMessage(session);
			try {
				Multipart mailmultipart = new MimeMultipart();
				// Nội dung text của mail
				MimeBodyPart bodytext = new MimeBodyPart();
				bodytext.setText(body, "utf-8", "html");

				// Thêm body vào part
				mailmultipart.addBodyPart(bodytext);
				mime.setFrom(new InternetAddress("thanhtmps25076@fpt.edu.vn"));
				mime.setRecipients(Message.RecipientType.TO, request.getParameter("email"));
				mime.setSubject(subject, "utf-8");
				mime.setReplyTo(mime.getFrom());
				mime.setContent(mailmultipart);

				Transport.send(mime);
				request.setAttribute("message", "*Chia sẻ thành công !!!");
//					count = 1;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "*Chia sẻ thất bại !!!");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "*Chia sẻ thất bại !!!");
			}
		}
		request.getRequestDispatcher("/views/user/video-share.jsp").forward(request, response);
	}
}