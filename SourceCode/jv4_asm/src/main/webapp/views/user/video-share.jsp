<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <title>Chia sẻ video cho bạn bè</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="<c:url value='/templates/login/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/templates/login/css/my-style.css'/>">
    <style type="text/css">
        body {
            background-image: url(<c:url value='/templates/user/img/bg1.jpg'/>);
            background-repeat: no-repeat;
            background-size: 100%;
        }

        .signin-form {
            margin-top: 90px;
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
                <div class="col-md-6 col-lg-4 mt-5">
                    <div class="login-wrap p-0">
                        <form action="/ASM_Java4/video-share/share" class="signin-form" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Friend Your's Email" name="email" required>
                            </div>
                            <div class="form-group">
                                <button type="submit"
									class="form-control btn submit px-3 dtn-btn" formaction="/ASM_Java4/video-share/share">Chia sẻ ngay</button>
                            </div>
                            </form>
                            <h6 class="text-white">${message}</h6>
                    </div>
                </div>
            </div>
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