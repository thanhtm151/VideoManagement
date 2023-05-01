<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="<c:url value='/templates/login/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/templates/login/css/my-style.css'/>">
    
    <link href="//cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>

    <style type="text/css">
        body {
            background-image: url(<c:url value='/templates/user/img/bg1.jpg'/>);
            background-repeat: no-repeat;
            background-size: 100%;
        }

        .heading-section {
            font-size: 40px;
        }
    </style>
</head>

<body class="img js-fullheight">
    <div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Login</h2>
                </div>
            </div>
            <!-- Form Login -->
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <div class="login-wrap p-0">
                        <form action="/ASM_Java4/login" class="signin-form" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" name="username" placeholder="Username" required>
                                 <h6 class="text-danger ml-2">${message_username}</h6>
                            </div>
                            <div class="form-group">
                                <input id="password-field" type="password" name="password" class="form-control" placeholder="Password"
                                    required> <span toggle="#password-field"
                                    class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                    <h6 class="text-danger ml-2">${message_pass}</h6>
                            </div>
                            <!-- modal thong bao -->
                            
                            
                             <!-- modal thong bao -->
                            <div class="form-group">
                                <button type="submit"
									class="form-control btn submit px-3 dtn-btn" formaction="/ASM_Java4/login">Đăng nhập</button>
                                <!-- <a href="#"
                                    class="form-control btn submit pt-3 dtn-btn" onclick="alertLoginPass()">Đăng nhập</a> -->
                            </div>
                            <div class="form-group d-md-flex">
                                <div class="w-50">
                                    <label class="checkbox-wrap checkbox-primary text-white2">Remember
                                        Me <input type="checkbox" class="bg-white"> <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="dtn-a">
                                    <a href="/ASM_Java4/forgotPassword" class="text-white2">Quên mật khẩu
                                        ?</a>
                                </div>

                            </div>
                        </form>
                        <p class="w-100 text-center">
                            &mdash; Bạn chưa có tài khoản ? &mdash; <a href="/ASM_Java4/register"
                                class="dtn-a text-white2">Đăng
                                ký ngay</a>
                        </p>

                    </div>
                </div>
            </div>
             <!-- Form Login -->
        </div>
    </section>

    <script src="<c:url value='/templates/login/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/templates/login/js/popper.js'/>"></script>
    <script src="<c:url value='/templates/login/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/templates/login/js/main.js'/>" /></script>
    <script src="<c:url value='/templates/user/js/plugins.js'/>"></script>
    <script>
        $(window).on("load", function () {
            $('body').addClass('loaded');
        });
    </script>

</body>

</html>