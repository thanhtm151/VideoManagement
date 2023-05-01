<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid tm-mt-60">
	<div class="row tm-mb-50">
		<div class="col-lg-4 col-12 mb-5">
			<h2 class="tm-text-primary mb-5">GÓP Ý</h2>
			<form id="contact-form" action="" method="POST"
				class="tm-contact-form mx-auto">
				<div class="form-group">
					<input type="text" name="name" class="form-control rounded-0"
						placeholder="Name" required />
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control rounded-0"
						placeholder="Email" required />
				</div>
				<div class="form-group">
					<textarea rows="8" name="message" class="form-control rounded-0"
						placeholder="Message" required=></textarea>
				</div>

				<div class="form-group tm-text-right">
					<button type="submit" class="btn btn-primary">Send</button>
				</div>
			</form>
		</div>
		<div class="col-lg-4 col-12 mb-5">
			<div class="tm-address-col">
				<h2 class="tm-text-primary mb-5">Liên hệ</h2>
				<p class="tm-mb-50">Mọi thông tin yêu cầu và đóng góp ý kiến xin
					vui lòng liên hệ:</p>
				<address class="tm-text-gray tm-mb-50">Văn Phòng: Tòa T, FPT Polytechnic, TP. Hồ Chí Minh</address>
				<ul class="tm-contacts">
					<li><a href="#" class="tm-text-gray"> <i
							class="fas fa-envelope"></i> Email: kietltps25037@fpt.edu.vn
					</a></li>
					<li><a href="#" class="tm-text-gray"> <i
							class="fas fa-phone"></i> Tel: 0602-8895-2178
					</a></li>
				</ul>
			</div>
		</div>
		<div class="col-lg-4 col-12">
			<h2 class="tm-text-primary mb-5">Địa chỉ</h2>
			<!-- Map -->
			<div class="mapouter mb-4">
				<div class="gmap-canvas">
					<iframe width="100%" height="520" id="gmap-canvas"
						src=https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.444049584406!2d106.62387491471914!3d10.853791492269051!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752a20d8555e69:0x743b1e9558fb89e0!2sQTSC%209%20Building!5e0!3m2!1svi!2s!4v1681296041616!5m2!1svi!2s&gidzl=QjNjNElwkmHkp-HVv-Mu2s3Eu5V_vBi9VicsLAlZlWWec-LJ_BQpNNgKv0VokRDISPA_3ZYn6svjwVwp1G
						frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="row tm-mb-74 tm-people-row">
	<h2 class="tm-text-primary mb-5"><i class="fab fa-teamspeak"></i> NHÓM POLY</h2>
		<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5 text-center">
			<img src="<c:url value='templates/user/img/poly.jpg'/>"
				alt="Image" class="mb-4 w-50 img-fluid">
			<h2 class="tm-text-primary text-dtn mb-4">Lại Tuấn Kiệt</h2>
			<h3 class="tm-text-secondary h5 mb-4">Trưởng Nhóm</h3>
			<ul class="tm-social pl-0 mb-0 justify-content-center ">
				<li><a href="https://facebook.com"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
				<li><a href="https://linkedin.com"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5 text-center">
			<img src="<c:url value='templates/user/img/poly.jpg'/>"
				alt="Image" class="mb-4 w-50 img-fluid">
			<h2 class="tm-text-primary text-dtn mb-4">Biện Thái Bảo</h2>
			<h3 class="tm-text-secondary h5 mb-4 ">Thành viên</h3>
			<ul class="tm-social pl-0 mb-0 justify-content-center">
				<li><a href="https://facebook.com"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
				<li><a href="https://linkedin.com"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5 text-center">
			<img src="<c:url value='templates/user/img/poly.jpg'/>"
				alt="Image" class="mb-4 w-50 img-fluid">
			<h2 class="tm-text-primary text-dtn mb-4">Trần Mạnh Thành</h2>
			<h3 class="tm-text-secondary h5 mb-4 ">Thành viên</h3>
			<ul class="tm-social pl-0 mb-0 justify-content-center">
				<li><a href="https://facebook.com"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
				<li><a href="https://linkedin.com"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5 text-center">
			<img src="<c:url value='templates/user/img/poly.jpg'/>"
				alt="Image" class="mb-4 w-50 img-fluid">
			<h2 class="tm-text-primary text-dtn mb-4">Nguyễn Trung Đạo</h2>
			<h3 class="tm-text-secondary h5 mb-4">Thành viên</h3>
			<ul class="tm-social pl-0 mb-0 justify-content-center">
				<li><a href="https://facebook.com"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
				<li><a href="https://linkedin.com"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5 text-center">
			<img src="<c:url value='templates/user/img/poly.jpg'/>"
				alt="Image" class="mb-4 w-50 img-fluid">
			<h2 class="tm-text-primary text-dtn mb-4">Võ Thanh Trường</h2>
			<h3 class="tm-text-secondary h5 mb-4 ">Thành viên</h3>
			<ul class="tm-social pl-0 mb-0 justify-content-center">
				<li><a href="https://facebook.com"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
				<li><a href="https://linkedin.com"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
		</div>
	</div>
</div>
