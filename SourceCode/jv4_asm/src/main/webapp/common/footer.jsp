<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="bg-dark pt-5 pb-3 tm-text-dark tm-footer">
	<div class="container-fluid tm-container-small">
		<div class="row">
			<div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
				<h3 class="tm-text-primary mb-4 tm-footer-title">PolyTube</h3>
				<p class="text-white">Trang web PolyTube cho phép người dùng tải lên, xem, chia sẻ
					về video, đăng ký người dùng khác và hiển thị nhiều video đa phương
					tiện do người dùng tạo ra. Nội dung có sẵn bao gồm video clip, đoạn
					chương trình truyền hình, video âm nhạc, phim tài liệu ngắn và tài
					liệu, bản ghi âm, đoạn giới thiệu phim và các nội dung khác như
					viết blog bằng video, video sáng tạo ngắn và video giáo dục.</p>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
				<h3 class="tm-text-primary mb-4 tm-footer-title">Liên kết</h3>
				<ul class="tm-footer-links pl-0">
					<li><a href="#">Giới thiệu</a></li>
					<li><a href="#">Liên hệ</a></li>
					<li><a href="#">Góp ý</a></li>
					<li><a href="#">Hỏi đáp</a></li>
				</ul>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
				<ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
					<li class="mb-2"><a href="https://facebook.com"><i
							class="fab fa-facebook"></i></a></li>
					<li class="mb-2"><a href="https://twitter.com"><i
							class="fab fa-twitter"></i></a></li>
					<li class="mb-2"><a href="https://instagram.com"><i
							class="fab fa-instagram"></i></a></li>
					<li class="mb-2">
					<a href="https://pinterest.com">
					<i class="fab fa-pinterest"></i>
					</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</footer>

<script src="<c:url value='/templates/user/js/plugins.js'/>"></script>
<script>
	$(window).on("load", function() {
		$('body').addClass('loaded');
	});
</script>