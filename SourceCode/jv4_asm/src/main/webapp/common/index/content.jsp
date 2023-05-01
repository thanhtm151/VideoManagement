<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="container-fluid tm-container-content mt-3 ps-3">
	<!-- Video new -->
	<div class="row mb-1">
		<!-- <div class="col-12 d-flex justify-content-end align-items-center ">
			<form action="" class="tm-text-primary">
				Page <input type="text" value="1" size="1"
					class="tm-input-paging tm-text-primary"> of 200
			</form>
		</div> -->
		<h2 class="mt-1 col-12 tm-text-primary text-dark">
			<i class="fas fad fa-video"></i> Video mới nhất
		</h2>
	</div>
	<!-- row -->
	<div class="row"><!--tm-mb-90 tm-gallery-->
		<c:forEach var="item" items="${video1}">
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
	<!-- row -->
	<!-- Video yêu thích -->
	<div class="row mb-4" ${hidden}>
		<h2 class="col-6 text-dark">
			<a href="/ASM_Java4/like-video" class="tm-dtn1"> <i
				class="fas far fa-thumbs-up"></i> Video đã thích
			</a>
		</h2>
	</div>
	<div class="row tm-mb-90 tm-gallery" ${hidden}>
		<c:forEach var="item" items="${video3}">
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
			<a class="btn btn-primary bg-danger" href="/ASM_Java4/like-video">Xem Thêm</a>
		</div>
	</div>
	<!-- row -->
	<!-- Video được xem nhiều -->
	<div class="row mb-4">
		<h2 class="col-6 text-dark">
			<i class="fas fad fa-chart-line"></i> Video nhiều lượt xem nhất
		</h2>
	</div>
	<div class="row tm-mb-90 tm-gallery">
		<c:forEach var="item" items="${video2}">
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
	<!-- row -->
	<!-- Video đã chia sẻ -->
	<div class="row mb-4" ${hidden}>
		<h2 class="col-6 text-dark">
			<i class="fas fad fa-share-square"></i> Video đã chia sẻ
		</h2>

	</div>
	<div class="row tm-mb-90 tm-gallery" ${hidden}>
		<c:forEach var="item" items="${video4}">
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
	</div>
	<!-- row -->
</div>