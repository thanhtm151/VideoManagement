<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Video-Detail</title>
<link rel="stylesheet" href="<c:url value='/templates/user/css/bootstrap.min.css'/>">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value='/templates/user/fontawesome/css/all.min.css'/>">
<link rel="stylesheet" href="<c:url value='/templates/user/css/templatemo-style.css' />">
<link rel="stylesheet" href="<c:url value='/templates/user/css/dtn-style.css' />">
<!--icon  -->
<link rel="icon" type="image/png" sizes="64x64" href="<c:url value='/templates/user/icon/logo-icon.png'/>">

 <style type="text/css">
    	.dtn-video{
    	box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    	 height: 400px;
    	}
    	.dtn-video2{
    	box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    	height: 400px;
    	}
    	footer{
    		 background-image: url(<c:url value='/templates/user/img/bg78.gif'/>);
            background-size: cover;
    	}
</style>
</head>
<body onload="getVideos('${videos.title}')">
	<div id="loader-wrapper">
		<div id="loader"></div>

		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>

	</div>
	<nav class="navbar navbar-expand-lg nav-dtn">
		<div class="container-fluid">
			<a class="navbar-brand logo-color"
				href="/ASM_Java4/index"> <i
				class="fas fad fa-photo-video"></i> PolyTube
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mb-2 mb-lg-0 navbar-color">
					<li class="nav-item"><a class="nav-link nav-link-1"
						aria-current="page" href="/ASM_Java4/index">Trang
							chủ</a></li>
					<li class="nav-item"><a class="nav-link nav-link-1"
						href="/ASM_Java4/videos">Video</a></li>
					<li class="nav-item"><a class="nav-link nav-link-1"
						href="/ASM_Java4/about">Giới thiệu</a></li>
					<li class="nav-item"><a class="nav-link nav-link-1"
						href="/ASM_Java4/contact">Liên hệ - Góp ý</a></li>
					<li class="nav-item dropdown">
			          <a class="nav-link nav-link-1 dropdown-toggle" href="#" id="taiKhoan" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            ${account}
			          </a>
			          <ul class="dropdown-menu dmenu-design" aria-labelledby="taiKhoan">
			            <li><a class="dropdown-item" href="/ASM_Java4/login" ${login_pass}>Đăng nhập</a></li>			           
			            <li><a class="dropdown-item" href="/ASM_Java4/register"${login_pass}>Đăng ký</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/logout"${login_no}>Đăng xuất</a></li>
			            <li><hr class="dropdown-divider"${login_no}></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/changePassword"${login_no}>Đổi mật khẩu</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/forgotPassword"${login_pass}>Quên mật khẩu</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/editAccount"${login_no}>Sửa tài khoản</a></li>
			            <li><hr class="dropdown-divider"${login_admin}></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/admin/index"${login_admin}>Giao diện Admin</a></li>
			          </ul>
        		</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="tm-hero d-flex justify-content-center align-items-center"
		data-parallax="scroll"
		data-image-src="<c:url value='/templates/user/img/anh1.png'/>">
		<form class="d-flex tm-search-form">
			<input class="form-control tm-search-input" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-primary tm-search-btn" type="submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</div>
	<%@ include file="/common/video-detail/content.jsp"%>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>