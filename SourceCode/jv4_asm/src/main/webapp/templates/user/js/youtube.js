let nextPageToken = ""

function getVideos(search) {
    fetch("https://youtube.googleapis.com/youtube/v3/search?key=AIzaSyBbL8D5SQ6XpoDs-8LPYug7VZNaxUjemPE&type=video&part=snippet&oder=date&maxResults=8&q="+search)
        .then((result) => {
            return result.json()
        }).then((data) => {
            console.log(data)
            let videos = data.items
            nextPageToken = data.nextPageToken
            let youtube = document.querySelector(".youtube")
            // var id = document.getElementById("videoID").src ="https://www.youtube.com/embed/cCkXz3zA3JY";
            for (video of videos) {
                youtube.innerHTML +=
                    `
                    <!-- Video Items -->
			<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
				<div class="mt-2 dtn-video2 bg-white">
					<figure class="effect-ming tm-video-item text-center">
						<img src="https://i.ytimg.com/vi/${video.id.videoId}/maxresdefault.jpg"
							alt="Image" class="img-fluid" width="100%" height="50%">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>Play Youtube</h2>
							<a href="https://www.youtube.com/watch?v=${video.id.videoId}">View more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between pl-2">
						<h3 class="fs-6" style="font-size: 100%;">
							<a href="https://www.youtube.com/watch?v=${video.id.videoId}" class="text-dark">
								<span>${video.snippet.title}</span>
							</a>
						</h3>
					</div>
					<div class="mt-5 d-flex justify-content-between tm-text-gray pl-2 pb-2">
						<span class="tm-text-gray-light">19/02/2020</span> 
						<span> ???? views.</span>
					</div>
				</div>
			</div>
			<!-- Video Items -->
            `
            }
        })
}
 // <img src="${video.snippet.thumbnails.high.url}">
//  <iframe width="688" height="387" src="https://www.youtube.com/embed/${video.id.videoId}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>