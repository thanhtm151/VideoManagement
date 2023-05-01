<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>PolyTube | TRANG CHỦ</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <div id="loader-wrapper">
        <div id="loader"></div>
        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>
    </div>
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
       
        <a class="navbar-brand ps-3" href="/ASM_Java4/admin/index">PolyTube</a>
        
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                class="fas fa-bars"></i></button>
        
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
                    aria-describedby="btnNavbarSearch" />
                <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i
                        class="fas fa-search"></i></button>
            </div>
        </form>
        
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                    aria-expanded="false">Welcome ${account}<i class="fas fa-user fa-fw"></i></a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    	<li><a class="dropdown-item" href="/ASM_Java4/login" ${login_pass}>Đăng nhập</a></li>			           
			            <li><a class="dropdown-item" href="/ASM_Java4/register"${login_pass}>Đăng ký</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/logout"${login_no}>Đăng xuất</a></li>
			            <li><hr class="dropdown-divider"${login_no}></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/changePassword"${login_no}>Đổi mật khẩu</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/forgotPassword"${login_pass}>Quên mật khẩu</a></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/editAccount"${login_no}>Sửa tài khoản</a></li>
			            <li><hr class="dropdown-divider"${login_admin}></li>
			            <li><a class="dropdown-item" href="/ASM_Java4/index">Giao diện User</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Trang tổng quan</div>
                        <a class="nav-link" href="/ASM_Java4/admin/index">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Báo cáo - Thống kê
                        </a>


                        <div class="sb-sidenav-menu-heading">Trang quản lý</div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUserCtr" aria-expanded="false" aria-controls="collapseUserCtr">
                            <div class="sb-nav-link-icon"><i class="fas fad fa-user"></i></div>
                            Quản lý người dùng
                             <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                         <div class="collapse" id="collapseUserCtr" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/ASM_Java4/admin/user-ctr">Danh sách người dùng</a>
                                    <a class="nav-link" href="/ASM_Java4/admin/user-update">Cập nhật người dùng</a>
                                </nav>
                            </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVideoCtr" aria-expanded="false" aria-controls="collapseVideoCtr">
                            <div class="sb-nav-link-icon"><i class="fas fad fa-video"></i></div>
                           Quản lý Video
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                         <div class="collapse" id="collapseVideoCtr" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/ASM_Java4/admin/video-ctr">Danh sách Video</a>
                                    <a class="nav-link" href="/ASM_Java4/admin/video-update">Cập nhật Video</a>
                                </nav>
                            </div>
                        
                    </div>
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
        <form action="/ASM_Java4/admin/index" method="post">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">BÁO CÁO - THỐNG KÊ</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Báo cáo - Thống kê</li>
                    </ol>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-primary text-white mb-4">
                                <div class="card-body">Tổng số người dùng</div>
                                <h2 class="ms-3">${countUser}<i class="fas fad fa-user float-end me-2"></i></h2>                              
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-warning text-white mb-4">
                                <div class="card-body">Tổng số Video</div>
                                <h2 class="ms-3">${countVideo}<i class="fas fad fa-video float-end me-2"></i></h2> 
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-success text-white mb-4">
                                <div class="card-body">Tổng lượt xem</div>
                                <h2 class="ms-3">${countViews}<i class="fas fad fa-eye float-end me-2"></i></h2> 
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-danger text-white mb-4">
                                <div class="card-body">Tổng lượt thích</div>
                                <h2 class="ms-3">${countLike}<i class="fas fad fa-heart float-end me-2"></i></h2> 
                            </div>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
						  <li class="nav-item" role="presentation">
						    <button class="nav-link ${ms1}" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">FAVORITES</button>
						  </li>
						  <li class="nav-item" role="presentation">
						    <button class="nav-link ${ms2}" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">FAVORITES USERS</button>
						  </li>
						  <li class="nav-item" role="presentation">
						    <button class="nav-link ${ms3}" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">SHARE FRIENDS</button>
						  </li>
						</ul>
						<div class="tab-content" id="myTabContent">
						<!--Favorites-->
						  <div class="tab-pane fade ${message} mt-2 p-3" id="home" role="tabpanel" aria-labelledby="home-tab">
						  	<table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>Video Title</th>
                                        <th>Favorite Count</th>
                                        <th>Latest Date</th>
                                        <th>Oldest Date</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                         <th>Video Title</th>
                                        <th>Favorite Count</th>
                                        <th>Latest Date</th>
                                        <th>Oldest Date</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                	<c:forEach var="item" items="${videos}">
										<tr>
											<td>${item.group}</td>
											<td>${item.likes}</td>
											<td>
											<fmt:formatDate value="${item.newest}" pattern="dd-MM-yyyy"/>
											</td>
											<td>
											<fmt:formatDate value="${item.oldest}" pattern="dd-MM-yyyy" />
											</td>
										</tr>
									</c:forEach>
                                </tbody>
                            </table>
						  </div>
						 <!--Favorites-->
						 <!--Favorites User-->
						  <div class="tab-pane fade ${message1} mt-2 p-3" id="profile" role="tabpanel" aria-labelledby="profile-tab">
						  	<div class="row">
						  		<h4 class="col-2">Video Title?</h4>
						  		<select name="title1" class="col-8 form-select pe-2" aria-label="Default select example" style="width: 70%;">
								  <option selected></option>
								<c:forEach var="sel1" items="${sel1}">
									  <option value="${sel1}">${sel1}</option>
								</c:forEach>
								</select>
								<button type="submit" class="ms-1 col-2 btn btn-primary" formaction="/ASM_Java4/admin/index/report1"style="width: 80px;">Tìm</button>
						  	</div>
						  	<table class="table mt-2 table-bordered">
                                <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                        <th>Favorite Date</th>
                                        <th>Video Like</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="user" items="${user}">
	                                	<tr>
	                                        <td>${user.user.id}</td>
	                                        <td>${user.user.fullname}</td>
	                                        <td>${user.user.email}</td>
	                                        <td>${user.likeDate}</td>
	                                        <td>${user.video.id}</td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
						  </div>
						  <!--Favorites User-->
						  <!--Share Friends-->
						  <div class="tab-pane fade ${message2} mt-2 p-3" id="contact" role="tabpanel" aria-labelledby="contact-tab">
						  	<div class="row">
						  		<h4 class="col-2">Video Title?</h4>
						  		<select name="title2" class="col-8 form-select pe-2" aria-label="Default select example" style="width: 70%;">
								  <option selected></option>
									<c:forEach var="sel1" items="${sel1}">
										  <option value="${sel1}">${sel1}</option>
									</c:forEach>
								</select>
								<button type="submit" class="ms-1 col-2 btn btn-primary" formaction="/ASM_Java4/admin/index/report2"style="width: 80px;">Tìm</button>
						  	</div>
						  	<table class="table mt-2 table-bordered">
                                <thead>
                                    <tr>
                                        <th>Sender Name</th>
                                        <th>Sender Email</th>
                                        <th>Receiver Email</th>
                                        <th>Sent Date</th>
                                        <th>Video Share</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="sha" items="${share}">
                                		<tr>
	                                        <td>${sha.user.fullname}</td>
	                                       	<td>${sha.user.email}</td>
	                                        <td>${sha.email}</td>
	                                       	<td>
	                                       		<fmt:formatDate value="${sha.shareDate}" pattern="dd-MM-yyyy"/>
	                                       	</td>
	                                       	<td>${sha.video.id}</td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
						  </div>
						  <!--Share Friends-->
						</div>
                    </div>
                </div>
            </main>
            </form>
        </div>
    </div>
    <script src="<c:url value='/templates/user/js/plugins.js'/>"></script>
    <script>
        $(window).on("load", function () {
            $('body').addClass('loaded');
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/js/scripts.js'/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/assets/demo/chart-area-demo.js'/>"></script>
    <script src="<c:url value='/templates/admin/assets/demo/chart-bar-demo.js'/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/js/datatables-simple-demo.js'/>"></script>
</body>

</html>
