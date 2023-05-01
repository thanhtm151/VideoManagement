package com.poly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.FavoriteDAO;
import com.poly.dao.UserDAO;
import com.poly.entity.FAVORITE;
import com.poly.entity.USERS;
import com.poly.util.JpaUtils;

@WebServlet({ "/login", "/logout", "/register", "/forgotPassword", "/changePassword", "/editAccount", "/verifi-code" })
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/login": {
			this.doGetLogin(request, response);
			break;
		}
		case "/logout": {
			this.doGetLogout(request, response);
			break;
		}
		case "/register": {
			this.doGetRegister(request, response);
			break;
		}
		case "/forgotPassword": {
			this.doGetForgotPass(request, response);
			break;
		}
		case "/changePassword": {
			this.doGetChangePass(request, response);
			break;
		}
		case "/editAccount": {
			this.doGetEditAccount(request, response);
			break;
		}
		case "/verifi-code": {
			this.doGetVerifiCode(request, response);
			break;
		}

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRequestURI();
		String method = request.getMethod();

		if (path.contains("login")) {
			if (method.equalsIgnoreCase("POST")) {
				login(request, response);
			}
		} else if (path.contains("editAccount")) {
			editAccount(request, response);
		} else if (path.contains("register")) {
			if (method.equalsIgnoreCase("POST")) {
				register(request, response);
			}
		} else if (path.contains("changePassword")) {
			changePassword(request, response);
		} else if (path.contains("forgotPassword")) {
			forgotPass(request, response);
		}

	}

	// Sua doi tai khoan edit account
	private void doGetEditAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		editAccount(request, response);
	}

	private void editAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		int count = 0;
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				UserDAO dao = new UserDAO();
				dao.update(user);
				request.setAttribute("message", "Cập nhật tài khoản thành công!");
				count = 1;
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi cập nhật tài khoản!");
			}
		}
		request.getRequestDispatcher("/views/user/editAccount.jsp").forward(request, response);
	}
	// Sua doi tai khoan edit account

	// Đổi mật khẩu - Change Password
	private void doGetChangePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		changePassword(request, response);
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		USERS user = (USERS) request.getSession().getAttribute("user");
		String pass_old = request.getParameter("old_pass");
		String new_pass = request.getParameter("password");
		String confirmPass = request.getParameter("pass_confirm");
		int count = 0;
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			if (user != null && !user.getPassword().equals(pass_old)) {
				System.out.println("Mat khau cu sai");
				request.setAttribute("messsage1", "Mật khẩu cũ ko trùng khớp!");
			}else if (new_pass.length() < 6) {
				request.setAttribute("messsage2", "Mật khẩu phải có tối thỉu 6 ký tự !");
			}  else if (!new_pass.equals(confirmPass)) {
				System.out.println("Mat khau ko trung khop");
				request.setAttribute("messsage3", "Mật khẩu không trùng khớp !");
			} else {
				try {
					BeanUtils.populate(user, request.getParameterMap());
					UserDAO dao = new UserDAO();
					dao.update(user);
					request.setAttribute("message", "Đổi mật khẩu thành công!");
					count = 1;
				} catch (Exception e) {
					request.setAttribute("message", "Lỗi!");
				}
			}
		}
		if (count == 0) {
			request.getRequestDispatcher("/views/user/changePassword.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}

	}

	// Đổi mật khẩu - Change Password

	// Quên mật khẩu - ForgotPassword
	private void doGetForgotPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
	}

	private void forgotPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkForm(request, response) == true) {
			sendMail(request, response);
		} else {
			doGetForgotPass(request, response);
		}
	}

	private boolean checkForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);

		String dinhdangGmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String dinhdangFpt = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "fpt+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String username = request.getParameter("id");
		UserDAO dao = new UserDAO();
		USERS user = dao.findById(username);
		int count = 0;
		if (user == null) {
			request.setAttribute("message1", "*Username không tồn tại !!");
			count = 1;
		}else if (!email.matches(dinhdangGmail) && !email.matches(dinhdangFpt)){
			request.setAttribute("message2", "*Định dạng email không hợp lệ !!");
			count = 1;
		}
		else {
			request.setAttribute("message2", "*Vui lòng nhập email !!");
			count = 2;
		}
		System.out.println(count);
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Gui email
	private void sendMail(HttpServletRequest request, HttpServletResponse response)
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
			String username = request.getParameter("id");
			UserDAO dao = new UserDAO();
			USERS user = dao.findById(username);

			String subject = "PolyTube - Lấy lại mật khẩu ";
			String maXacNhan = randomMa(6);
			String body = "Mật khẩu của tài khoản " + user.getId() + ": " + user.getPassword();// "Mã xác nhận của bạn
																								// là : " + maXacNhan+

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
				request.setAttribute("message", "Lấy lại mật khẩu thành công !!!");
//				count = 1;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "Lấy lại mật khẩu thất bại !");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "Lấy lại mật khẩu thất bại !!");
			}
		}
		if (count == 0) {
			request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	// Random code
	private static final String digits = "0123456789"; // 0-9
	private static final String ALPHA_NUMERIC = digits;
	private static Random generator = new Random();

	public String randomMa(int soKyTu) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < soKyTu; i++) {
			int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
			char ch = ALPHA_NUMERIC.charAt(number);
			sb.append(ch);
		}
		return sb.toString();
	}

	public static int randomNumber(int min, int max) {
		return generator.nextInt((max - min) + 1) + min;
	}

	// Quên mật khẩu - ForgotPassword
	// VerifiCode
	private void doGetVerifiCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/verifi-code.jsp").forward(request, response);
	}

	// Đăng ký - Register page
	private void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		int count = 0;
		if (checkRegister(request, response)) {
			try {
				USERS entity = new USERS();
				BeanUtils.populate(entity, request.getParameterMap());
				dao.create(entity);
				request.setAttribute("message", "Đăng ký thành công!");
				count = 1;
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi đăng ký!");
			}
		}
		if (count == 0) {
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}

	}

	private boolean checkRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pass = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPass");
		String username = request.getParameter("id");
		String email = request.getParameter("email");
		System.out.println(email);

		String dinhdangGmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String dinhdangFpt = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "fpt+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

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
		if(pass.length() < 6) {
			request.setAttribute("message4", "Vui lòng nhập mật khẩu ít nhất 6 kí tự!");
			return false;
		}

		if (!confirmPass.equals(pass)) {
			request.setAttribute("message1", "Mật khẩu không trùng khớp!");
			return false;
		}
		if (!email.matches(dinhdangGmail) && !email.matches(dinhdangFpt)) {// || !email.matches(dinhdangFpt)
			request.setAttribute("message3", "Định dạng email không hợp lệ!");
			return false;
		}
		return true;

	}
	// Đăng ký - Register page

	// Login
	private void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");
		String pass = request.getParameter("password");
		int count = 0;
		try {
			// User entity & User Dao
			UserDAO dao = new UserDAO();
			USERS user = dao.findById(id);

			if (id.isEmpty() || pass.isEmpty()) {
				request.getSession().setAttribute("user", null);
			}
			if (!user.getPassword().equals(pass)) {
				request.setAttribute("message_pass", "Sai mật khẩu!");
			} else {
//				request.setAttribute("message", "Đăng nhập thành công!");
				request.setAttribute("message_username", "Đăng nhập thành công!");
				request.getSession().setAttribute("user", user);

				count = 1;
			}
		} catch (Exception e) {
			request.setAttribute("message_username", "Sai tên đăng nhập!");
		}
		if (count == 1) {
			response.sendRedirect("index");
		} else {
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		}
	}
	// Login

	// Logout đăng xuất
	private void doGetLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("like");

		response.sendRedirect("index");
	}
	// Logout đăng xuất
}
