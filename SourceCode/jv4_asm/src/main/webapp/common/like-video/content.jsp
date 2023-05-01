<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid tm-container-content tm-mt-60">
	<div class="row mb-4">
		<div class="col-12 d-flex justify-content-end align-items-center ">
			<form action="" class="tm-text-primary">
				Page <input type="text" value="1" size="1"
					class="tm-input-paging tm-text-primary"> of 50
			</form>
		</div>
		<h2 class="mt-2 col-12 tm-text-primary text-dark">
			<i class="fas far fa-thumbs-up"></i> Video đã thích
		</h2>
	</div>
	<div class="row tm-mb-90 tm-gallery">
		<c:forEach var="item" items="${videos}">
			<!-- Video Items -->
			<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
				<div class="dtn-video bg-white">
					<figure class="effect-ming tm-video-item">
						<img src="<c:url value='${item.poster}'/>" alt="Image"
							class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>Play Video</h2>
							<a href="/ASM_Java4/video-detail/id/${item.id}">View
								more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between pl-2">
						<h3 class="fs-6" style="font-size: 100%;">
							<a href="/ASM_Java4/video-detail/id/${item.id}"
								class="text-dark"> <span>${item.title}</span>
							</a>
						</h3>
					</div>
					<div class="d-flex justify-content-between text-gray pl-2">
						<span>${item.discriptions}</span>
					</div>
					<div
						class="mt-5 d-flex justify-content-between tm-text-gray pl-2 pb-2">
				</div>
			</div>
			<!-- Video Items -->
		</c:forEach>
	</div>
	<!-- row -->

	<div class="row tm-mb-90">
		<div
			class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
			<a href="javascript:void(0);"
				class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
			<div class="tm-paging d-flex">
				<a href="javascript:void(0);" class="active tm-paging-link">1</a> <a
					href="javascript:void(0);" class="tm-paging-link">2</a> <a
					href="javascript:void(0);" class="tm-paging-link">3</a> <a
					href="javascript:void(0);" class="tm-paging-link">4</a>
			</div>
			<a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next
				Page</a>
		</div>
	</div>
</div>
<!-- container-fluid, tm-container-content -->