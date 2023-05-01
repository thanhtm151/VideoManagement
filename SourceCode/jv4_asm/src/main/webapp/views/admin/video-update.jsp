<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>PolyTube | CẬP NHẬT VIDEO</title>
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

        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
            <i class="fas fa-bars"></i>
        </button>

        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
                    aria-describedby="btnNavbarSearch" />
                <button class="btn btn-primary" id="btnNavbarSearch" type="button">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>

        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                    data-bs-toggle="dropdown" aria-expanded="false">Welcome
                    ${account}<i class="fas fa-user fa-fw"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="/ASM_Java4/login" ${login_pass}>Đăng nhập</a></li>
                    <li><a class="dropdown-item" href="/ASM_Java4/register" ${login_pass}>Đăng ký</a></li>
                    <li><a class="dropdown-item" href="/ASM_Java4/logout" ${login_no}>Đăng xuất</a></li>
                    <li>
                        <hr class="dropdown-divider" ${login_no}>
                    </li>
                    <li><a class="dropdown-item" href="/ASM_Java4/changePassword" ${login_no}>Đổi
                            mật khẩu</a></li>
                    <li><a class="dropdown-item" href="/ASM_Java4/forgotPassword" ${login_pass}>Quên
                            mật khẩu</a></li>
                    <li><a class="dropdown-item" href="/ASM_Java4/editAccount" ${login_no}>Sửa tài
                            khoản</a></li>
                    <li>
                        <hr class="dropdown-divider" ${login_admin}>
                    </li>
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
                            <div class="sb-nav-link-icon">
                                <i class="fas fa-tachometer-alt"></i>
                            </div> Báo cáo - Thống kê
                        </a>


                        <div class="sb-sidenav-menu-heading">Trang quản lý</div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseUserCtr" aria-expanded="false" aria-controls="collapseUserCtr">
                            <div class="sb-nav-link-icon">
                                <i class="fas fad fa-user"></i>
                            </div> Quản lý người dùng
                            <div class="sb-sidenav-collapse-arrow">
                                <i class="fas fa-angle-down"></i>
                            </div>
                        </a>
                        <div class="collapse" id="collapseUserCtr" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/ASM_Java4/admin/user-ctr">Danh sách
                                    người dùng</a> <a class="nav-link"
                                    href="/ASM_Java4/admin/user-update">Cập nhật
                                    người dùng</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseVideoCtr" aria-expanded="false" aria-controls="collapseVideoCtr">
                            <div class="sb-nav-link-icon">
                                <i class="fas fad fa-video"></i>
                            </div> Quản lý Video
                            <div class="sb-sidenav-collapse-arrow">
                                <i class="fas fa-angle-down"></i>
                            </div>
                        </a>
                        <div class="collapse" id="collapseVideoCtr" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/ASM_Java4/admin/video-ctr">Danh sách
                                    Video</a> <a class="nav-link" href="/ASM_Java4/admin/video-update">Cập
                                    nhật
                                    Video</a>
                            </nav>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">CẬP NHẬT VIDEO</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/ASM_Java4/admin/index">Trang chủ</a></li>
                        <li class="breadcrumb-item active">Cập nhật video</li>
                    </ol>
                    <div class="card mb-4">
                        <form ${hidden} class="mt-3 ms-3 me-3 mb-3 row" action="/ASM_Java4/admin/video-update"
                            method="post" enctype="multipart/form-data">
                            <div class="col-6">
                                <div class="mb-3">
                                    <label for="youtubeID" class="form-label">Video ID*</label>
                                    <input name="id" type="text" class="form-control" id="youtubeID"
                                        aria-describedby="youtubeIDHelp" value="${video.id}" ${videoid} ${videoid2} placeholder="Nhập Video Id của bạn?" required="required">
                                </div>
                                <h6 class="ms-3 text-primary">${message2}</h6>
                                <div class="mb-3">
                                    <label for="youtubeID" class="form-label">Tiêu đề
                                        video*</label> <input name="title" type="text" class="form-control"
                                        id="youtubeID" aria-describedby="youtubeIDHelp" value="${video.title}" placeholder="Nhập title của video?" required="required">
                                </div>
                                <div class="mb-3" hidden>
                                    <label for="youtubeID" class="form-label">Tổng lượt xem*</label>
                                    <input type="text" class="form-control" id="youtubeID"
                                        aria-describedby="youtubeIDHelp" value="${video.views}" name="views">
                            </div>
                            <%-- <div class="mb-3">
                                <label for="posterDTN" class="form-label">Poster*</label> <input name="poster"
                                    type="text" class="form-control" id="posterDTN" aria-describedby="posterDTNHelp"
                                    value="${video.poster}" ${log_poster}>
                                <input type="text" class="form-control" id="posterDTN"
                                    aria-describedby="posterDTNHelp" value="${videoposter2}" ${log_poster2}>
                            </div> --%>
                            <div class="mb-3">
                                <label for="videoDTN" class="form-label">Video Href*</label> <input name="href"
                                    type="text" class="form-control" id="videoDTN" aria-describedby="videoDTNHelp"
                                    value="${video.href}" placeholder="Nhập VideoId Youtube bạn muốn đăng?" required="required">
                            </div>
                            <h6 class="ms-3 text-primary">${message3}</h6>
                            <div class="mb-3">
                                <label for="moTa" class="form-label">Mô Tả*</label>
                                <textarea name="discriptions" class="form-control" id="moTa"
                                    rows="3" placeholder="Nhập mô tả?" required="required">${video.discriptions}</textarea>
                            </div>
                            <div class="mb-3">
                            	 <label for="moTa" class="form-label">Trạng thái: </label>
                            <div class="form-check form-check-inline">
								  <input ${video.active?'checked':''}  class="form-check-input" type="radio" name="active" id="inlineRadio2" value="true">
								  <label class="form-check-label" for="inlineRadio2">ACTIVE</label>
								</div>
                                <div class="form-check form-check-inline">
								  <input ${video.active?'':'checked'} class="form-check-input" type="radio" name="active" id="inlineRadio1" value="false" required="required">
								  <label class="form-check-label" for="inlineRadio1">INACTIVE</label>
								</div>
                            </div>
                    </div>
                    <div class="col-6">
                        <div class="card mt-4">
                           
                            <div class="mt-2 mb-2 p-2">
                                <%-- <img src="<c:url value='${img.poster}'/>" class="card-img-top img-fluid"
                                    width="300px" height="150px" alt="Poster video" ${logimg}> --%>
								 <img src="<c:url value='${img.poster}'/>" class="card-img-top img-fluid"
							                                width="300px" height="100px" alt="Poster video" ${log2img}>
                                <input accept="image/*" class="mt-2 form-control form-control-sm"
											id="formFileSm" type="file" name="photo_file">
											<!-- <button type="submit" class="mt-2 btn btn-outline-primary float-end">Load Ảnh</button> -->
                        </div>
                    </div>
                </div>

                <div class="text-end"  ${buttonnolog}>
                    <button type="submit" class="btn btn-primary" formaction="/ASM_Java4/admin/video-update/create" ${log_btnThem}>Thêm</button>
                    <button type="submit" class="btn btn-success" formaction="/ASM_Java4/admin/video-update/update" ${log_btn}>Sửa</button>
                    <button type="submit" class="btn btn-danger" ${log_btn}${buttonxoa} formaction="/ASM_Java4/admin/video-update/delete">Xóa</button>
                    <a  class="btn btn-dark" href="/ASM_Java4/video-detail/id/${video.id}" ${log_btn}>Xem Video</a>
                </div>
                </form>
                <h6 class="ms-3 text-primary">${message}</h6>
        </div>
    </div>
    </main>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/js/scripts.js'/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/assets/demo/chart-area-demo.js'/>"></script>
    <script src="<c:url value='/templates/admin/assets/demo/chart-bar-demo.js'/>"></script>
    <script src="<c:url value='/templates/admin/assets/demo/chart-pie-demo.js'/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="<c:url value='/templates/admin/js/datatables-simple-demo.js'/>"></script>
    <script src="<c:url value='/templates/user/js/plugins.js'/>"></script>
    <script>
        $(window).on("load", function () {
            $('body').addClass('loaded');
        });
    </script>
</body>

</html>