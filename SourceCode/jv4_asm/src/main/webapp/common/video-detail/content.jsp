<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp"%>
<div class="container-fluid tm-container-content tm-mt-60">
	<!-- <div class="row mb-4">
		<h2 class="col-12 text-dark">Có Chàng Trai Viết Lên Cây - Phan
			Mạnh Quỳnh | MẮT BIẾC OST</h2>
	</div> -->
	<!--Video content  -->
			<form action="/ASM_Java4/video-detail" method="post">
	<div class="row tm-mb-90">
		<div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
			<iframe width="100%" height="500"
				src="https://www.youtube.com/embed/${videos.href}"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
			<%-- <video loop controls id="tm-video">
                <source src="<c:url value='templates/user/video/hero1.mp4'/>" type="video/mp4">
                </video> --%>
			<div class="d-flex justify-content-between">
				<h3 class="fs-6" style="font-size: 140%;">
						<span class="text-dark">${videos.title}</span>
				</h3>
			</div>
			<div class="mt-2 d-flex justify-content-between tm-text-gray">
				<span class="tm-text-gray-light">Ngày đăng: 12/04/2023</span> <span>${videos.views}
					lượt xem.</span>
			</div>
		</div>
		<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
			<div class="tm-bg-gray tm-video-details">
				<p class="mb-4">
				<h4 class="tm-text-gray-dark mb-3">Tiêu đề:</h4>
				${videos.title}<br>
				</p>
				<p class="mb-4">
				<h4 class="tm-text-gray-dark mb-3">Lượt xem:</h4>
				${videos.views}<br>
				</p>
				<p class="mb-4">
				<h4 class="tm-text-gray-dark mb-3">Mô tả:</h4>
				${videos.discriptions}
				</p>
				<div class="d-flex justify-content-between btn-dtn2">
					<button formaction="/ASM_Java4/video-detail/like" class="btn btn-primary ${btnlike} w-100"><i
						class="fas fa-thumbs-up"></i> ${like} ${likelog}
					</button> <button formaction="/ASM_Java4/video-share/share" class="btn btn-primary w-100"> <i
						class="fas fad fa-share"> </i>Share</button>
						
				</div>
			
			</div>
		</div>
	</div>
	</form>
	<div class="row mb-4">
		<h2 class="col-12 tm-text-primary">Đề xuất</h2>
	</div>
	<div class="row tm-mb-90 tm-gallery">
		<c:forEach var="item" items="${video}">
			<!-- Video Items -->
			<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
				<div class="dtn-video bg-white">
					<figure class="effect-ming tm-video-item">
						<img src="<c:url value='${item.poster}'/>"
							alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>Play Video</h2>
							<a href="/ASM_Java4/video-detail/id/${item.id}">View more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between pl-2">
						<h3 class="fs-6" style="font-size: 100%;">
							<a href="/ASM_Java4/video-detail/id/${item.id}" class="text-dark">
								<span>${item.title}</span>
							</a>
						</h3>
					</div>
					<div class="d-flex justify-content-between text-gray pl-2">
						<span>${item.discriptions}</span>
					</div>
					<div class="mt-5 d-flex justify-content-between tm-text-gray pl-2 pb-2">
						<span class="tm-text-gray-light">12/04/2023</span> 
						<span>${item.views} lượt xem.</span>
					</div>
				</div>
			</div>
			<!-- Video Items -->
		</c:forEach>
		<div class="text-center">
			<a class="btn btn-primary" href="/ASM_Java4/videos">Xem Thêm</a>
		</div>
	</div>
</div>
