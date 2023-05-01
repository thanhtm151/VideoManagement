package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.*;
import com.poly.entity.*;
import com.poly.util.UploadUtils;

@MultipartConfig
@WebServlet({ "/admin/index", "/admin/index/report1", "/admin/index/report2", "/admin/user-ctr", "/admin/video-ctr",
		"/admin/user-update", "/admin/video-update/*", "/admin/video-update/edit/*", "/admin/user-update/edit/*",
		"/admin/user-update/create", "/admin/user-update/update", "/admin/user-update/delete",
		"/admin/video-update/create", "/admin/video-update/update/*", "/admin/video-update/delete" })
public class AdminServlet extends HttpServlet {

	String id;
	String VideoId;
	int countUpdate = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		setPageItemHeader(request, response);
		switch (path) {
		case "/admin/index": {
			request.setAttribute("message", "show active");
			request.setAttribute("ms1", "active");
			this.doGetIndex(request, response);
			break;
		}
		case "/admin/user-ctr": {
			this.doGetUserCtr(request, response);
			break;
		}
		case "/admin/video-ctr": {
			this.doGetVideoCtr(request, response);
			break;
		}
		case "/admin/user-update": {
			this.doGetUserUpdate(request, response);
			break;
		}
		case "/admin/video-update": {

			request.setAttribute("videoid", " ");
			request.setAttribute("videoid2", " ");

//			request.setAttribute("log_poster2","");
//			request.setAttribute("log_poster","hidden");
//			request.setAttribute("log2img","hidden");
			request.setAttribute("log_btn", "hidden");

			VIDEO video = new VIDEO();
			video.setPoster("/templates/user/img2/video_icon.jpg");
			request.setAttribute("img", video);

			this.doGetVideoUpdate(request, response);
			break;
		}
		case "/admin/user-update/edit": {
			doGetUserUpdateEdit(request, response);
			break;
		}
		case "/admin/user-update/create": {
			insertUser(request, response);
			break;
		}
		case "/admin/user-update/update": {
			doGetUserUpdateEdit(request, response);
			break;
		}
		case "/admin/user-update/delete": {

		}
		case "/admin/video-update/edit": {
			VideoDAO dao = new VideoDAO();
			VIDEO video = new VIDEO();
			String uri = request.getRequestURI();

			String idVideo = uri.substring(uri.lastIndexOf("/") + 1);
			VideoId = idVideo;
			video = dao.findById(idVideo);
			FavoriteDAO favdao = new FavoriteDAO();
			List<VIDEO> fav = favdao.findByVideo(idVideo);

			ShareDAO sdao = new ShareDAO();
			List<VIDEO> share = sdao.findShareVideo(idVideo);

			if (!fav.isEmpty() || !share.isEmpty()) {
				request.setAttribute("buttonxoa", "hidden");
			}

			request.setAttribute("videoid", "disabled=\"disabled\"");
			request.setAttribute("videoid2", "readonly=\"readonly\"");

			// request.setAttribute("logimg","hidden");
			// request.setAttribute("log_poster2","hidden");
			request.setAttribute("log_btn", "");
			request.setAttribute("log_btnThem", "hidden");
			request.setAttribute("img", video);
			request.setAttribute("video", video);
			
			if(countUpdate != 0) {
				request.setAttribute("message", "Cập nhật thành công!");
			}
			doGetVideoUpdate(request, response);
			break;
		}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		setPageItemHeader(req, resp);
		switch (path) {
		case "/admin/user-update/create": {
			insertUser(req, resp);
			break;
		}
		case "/admin/user-update/update": {
			updateUser(req, resp);
			break;
		}
		case "/admin/user-update/delete": {
			removeUser(req, resp);
			break;
		}
		case "/admin/video-update": {
			req.setAttribute("videoid", " ");
			req.setAttribute("videoid2", " ");

//			req.setAttribute("log_poster2","");
//			req.setAttribute("log_poster","hidden");
//			req.setAttribute("log2img","hidden");
			req.setAttribute("log_btn", "hidden");
			getPosterVideo(req, resp);
			break;
		}
		case "/admin/video-update/create": {
			insertVideo(req, resp);
			break;
		}
		case "/admin/video-update/update": {
			updateVideo(req, resp);
			break;
		}
		case "/admin/video-update/delete": {
			deleteVideo(req, resp);
			break;
		}
		case "/admin/index": {
			req.setAttribute("message", "show active");
			req.setAttribute("ms1", "active");
			doGetIndex(req, resp);
			break;
		}
		case "/admin/index/report1": {
			req.setAttribute("message1", "show active");
			req.setAttribute("ms2", "active");
			doGetIndex(req, resp);
			break;
		}
		case "/admin/index/report2": {
			req.setAttribute("message2", "show active");
			req.setAttribute("ms3", "active");
			doGetIndex(req, resp);
			break;
		}
		}
	}

	// Video Page
	private void doGetVideoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		;

		request.getRequestDispatcher("/views/admin/video-update.jsp").forward(request, response);
	}

	private void doGetVideoCtr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		List<VIDEO> list = dao.findAll();

		request.setAttribute("videos", list);

		request.getRequestDispatcher("/views/admin/video-ctr.jsp").forward(request, response);
	}

	// Video Update Edit
	private void getPosterVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File dir = new File(request.getServletContext().getRealPath("/files"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		Part photo = request.getPart("photo_file");
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());

		if (photo.getSize() > 0) {
			request.setAttribute("logimg", "");
			request.setAttribute("log_poster2", "");
			request.setAttribute("log_poster", "hidden");
			request.setAttribute("log2img", "hidden");
			request.setAttribute("img", photoFile);
			doGetVideoUpdate(request, response);
		}
	}

	// video-update create
	private void insertVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VIDEO entity = new VIDEO();
		int count = 0;
		if (checkVideoUpdate(request, response)) {
			try {
				BeanUtils.populate(entity, request.getParameterMap());
				entity.setPoster("/templates/user/img2/" + UploadUtils.processUploadFiled("photo_file", request,
						"/templates/user/img2/", entity.getId()));

				VideoDAO dao = new VideoDAO();
				dao.create(entity);

				request.setAttribute("img", entity);
				request.setAttribute("message", "Thêm video " + entity.getId() + " thành công!");
				request.setAttribute("buttonnolog", "hidden");
				request.setAttribute("hidden", "hidden");
//				count = 1;
			} catch (Exception e) {
				System.out.println(e);
				request.setAttribute("message", "Lỗi Thêm!");
			}
		} else {
			request.setAttribute("log_btn", "hidden");
			request.setAttribute("log_btnThem", "");
		}
		if (count == 0) {
			doGetVideoUpdate(request, response);
		} else {
			response.sendRedirect("/admin/video-update/edit/" + VideoId);
		}

	}

	// Check Video
	private boolean checkVideoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoId = request.getParameter("id");
		String hrefVideo = request.getParameter("href");

		String dinhdangIdVideo = "/^[A-Za-z0-9_\\.]{11}$/";

		VideoDAO dao = new VideoDAO();
		VIDEO video = dao.findById(videoId);

		if (video != null) {
			request.setAttribute("message2", "Video đã tồn tại!");
			return false;
		}
		if (videoId.contains(" ") && videoId.length() < 10) {
			request.setAttribute("message2",
					"Video id phải có độ tài từ 6 đến 10 ký tự, không có khoảng trắng và không dấu!");
			return false;
		}
//		if (!hrefVideo.matches(dinhdangIdVideo)) {// || !email.matches(dinhdangFpt)
//			request.setAttribute("message3", "Định dạng IDVideo không hợp lệ!");
//			return false;
//		}
		return true;

	}

	// video-update update
	private void updateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		VIDEO video = dao.findById(VideoId);
		VIDEO video2 = dao.findById(VideoId);

		int count = 0;
		try {
			BeanUtils.populate(video2, request.getParameterMap());

			if (request.getPart("photo_file").getSize() == 0) {
				video2.setPoster(video.getPoster());
			} else {
				video2.setPoster("/templates/user/img2/" + UploadUtils.processUploadFiled("photo_file", request,
						"/templates/user/img2/", video.getId()));
			}
			dao.update(video2);
			request.setAttribute("img", video2);
			request.setAttribute("video", video2);

			request.setAttribute("buttonxoa", "hidden");
			request.setAttribute("message", "Cập nhật thành công!");
			count = 1;
			countUpdate = 1;
		} catch (Exception e) {
			request.setAttribute("message", "Lỗi cập nhật!");
		}

		request.setAttribute("videoid", "disabled=\"disabled\"");
		request.setAttribute("videoid2", "readonly=\"readonly\"");

		// request.setAttribute("logimg","hidden");
		// request.setAttribute("log_poster2","hidden");
		request.setAttribute("log_btn", "");
		request.setAttribute("log_btnThem", "hidden");

		if (count == 0) {
			doGetVideoUpdate(request, response);
		} else {
			
			response.sendRedirect("edit/"+VideoId);
		}

	}

	// video-update delete
	private void deleteVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		if (VideoId != null) {
			try {
				dao.remove(VideoId);
				request.setAttribute("message", "Xóa thành công!");
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi xóa!");
			}
		}
		request.setAttribute("buttonnolog", "hidden");
		request.setAttribute("hidden", "hidden");
		doGetVideoUpdate(request, response);

	}
	// Video Page

	// User Page
	private void doGetUserUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("buttonlog", "hidden");
		request.setAttribute("buttonlog1", "hidden");
		request.setAttribute("loguser", "");
		request.setAttribute("admin", "false");

		request.getRequestDispatcher("/views/admin/user-update.jsp").forward(request, response);
	}

	// CheckUser
	private boolean checkUserUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pass = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPass");
		String username = request.getParameter("id");
		String email = request.getParameter("email");
		System.out.println(email);

		String dinhdangGmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String dinhdangFpt = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "fpt+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		UserDAO dao = new UserDAO();
		USERS u = dao.findById(username);

		if (u != null) {
			request.setAttribute("message2", "Tên tài khoản đã tồn tại!");
			return false;
		}
		if (username.contains(" ") && username.length() < 10) {
			request.setAttribute("message2",
					"Username có độ tài từ 6 đến 10 ký tự, không có khoảng trắng và không dấu!");
			return false;
		}
		if (pass.length() < 6) {
			request.setAttribute("message4", "Vui lòng nhập mật khẩu ít nhất 6 kí tự!");
			return false;
		}

		if (!confirmPass.equals(pass)) {
			request.setAttribute("message1", "Mật khẩu không trùng khớp!");
			return false;
		}
		if (!email.matches(dinhdangGmail) || !email.matches(dinhdangFpt)) {// || !email.matches(dinhdangFpt)
			request.setAttribute("message3", "Định dạng email không hợp lệ!");
			return false;
		}
		return true;

	}

	private void doGetUserUpdateEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		USERS user = new USERS();

		String uri = request.getRequestURI();

		id = uri.substring(uri.lastIndexOf("/") + 1);

		user = dao.findById(id);

		FavoriteDAO favdao = new FavoriteDAO();
		List<VIDEO> fav = favdao.findLikeVideo(id);

		ShareDAO sdao = new ShareDAO();
		List<VIDEO> share = sdao.findShareUser(id);

		if (!fav.isEmpty() || !share.isEmpty()) {
			request.setAttribute("buttonxoa", "hidden");
		}

		request.setAttribute("u", user);
		request.setAttribute("loguser", "disabled=\"disabled\"");
		request.setAttribute("buttonnolog", "hidden");
		request.setAttribute("buttonlog", "");
		if (user.getAdmin()) {
			request.setAttribute("buttonlog1", "hidden");
		} else {
			request.setAttribute("buttonlog1", "");
		}
		request.setAttribute("admin", user.getAdmin());
		request.getRequestDispatcher("/views/admin/user-update.jsp").forward(request, response);

	}

	private void doGetUserCtr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		List<USERS> user = dao.findAll();

		request.setAttribute("users", user);

		request.getRequestDispatcher("/views/admin/user-ctr.jsp").forward(request, response);
	}

	// Thêm User
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pass = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPass");

		int count = 0;
		if (checkUserUpdate(request, response)) {
			try {
				USERS entity = new USERS();
				BeanUtils.populate(entity, request.getParameterMap());
				UserDAO dao = new UserDAO();
				dao.create(entity);
				request.setAttribute("message", "Thêm thành công!");
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi Thêm!");
			}
		}
		if (count == 0) {
			doGetUserUpdate(request, response);
		}

	}

	// Cập nhật User
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		USERS user = dao.findById(id);
		try {
			BeanUtils.populate(user, request.getParameterMap());
			dao.update(user);
			request.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			request.setAttribute("message", "Lỗi cập nhật!");
		}

		request.setAttribute("u", user);
		request.setAttribute("loguser", "disabled=\"disabled\"");
		request.setAttribute("buttonnolog", "hidden");
		request.setAttribute("buttonlog", "");
		if (user.getAdmin()) {
			request.setAttribute("buttonlog1", "hidden");
		} else {
			request.setAttribute("buttonlog1", "");
		}
		request.setAttribute("admin", user.getAdmin());
		request.getRequestDispatcher("/views/admin/user-update.jsp").forward(request, response);
		System.out.println(id);
	}

	// Xóa User
	private void removeUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		if (id != null) {
			try {
				dao.remove(id);
				request.setAttribute("message", "Xóa thành công!");
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi xóa!");
			}
		}
		request.setAttribute("buttonnolog", "hidden");
		request.setAttribute("hidden", "hidden");
		request.getRequestDispatcher("/views/admin/user-update.jsp").forward(request, response);
		System.out.println(id);

	}
	// User Page

	// Admin Index - Trang chu Index
	private void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		favoriteReport(request, response);
		getTitleVideo(request, response);
		favoriteUserReport(request, response);
		shareReport(request, response);
		request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
	}

	private void favoriteReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReportDAO dao = new ReportDAO();
		List<REPORT> list = dao.favoriteReport();

		List<Long> countUser = dao.getCountUser();
		List<Long> countVideo = dao.getCountVideo();
		List<Long> countViews = dao.getCountViews();
		List<Long> countLike = dao.getLikeCount();

		String demUser = countUser.toString();
		String demVideo = countVideo.toString();
		String demViews = countViews.toString();
		String demLike = countLike.toString();

		if (list != null) {
			request.setAttribute("countUser", demUser.substring(demUser.indexOf("[") + 1, demUser.indexOf("]")));
			request.setAttribute("countVideo", demVideo.substring(demVideo.indexOf("[") + 1, demVideo.indexOf("]")));
			request.setAttribute("countViews", demViews.substring(demViews.indexOf("[") + 1, demViews.indexOf("]")));
			request.setAttribute("countLike", demLike.substring(demLike.indexOf("[") + 1, demLike.indexOf("]")));

			request.setAttribute("videos", list);
		}
	}

	private void getTitleVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDAO dao = new FavoriteDAO();
		List<String> fav = dao.findAllLike();
		if (fav != null) {
			request.setAttribute("sel1", fav);
		}
	}

	private void favoriteUserReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReportDAO dao = new ReportDAO();
		List<FAVORITE> list = dao.favoritesUserReport(request);
		if (list != null) {
			request.setAttribute("user", list);
		}
	}

	private void shareReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReportDAO dao = new ReportDAO();
		List<SHARES> list = dao.shareReport(request);
		if (list != null) {
			request.setAttribute("share", list);
		}
	}

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
}
