<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Verti by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" media="screen"
	href="https://d3nn82uaxijpm6.cloudfront.net/assets/strava-app-icons-4d3576a8aed320ae76fadffd73580ab4d7762ca7752ffdf98c307dd858bec00d.css">
<link rel="stylesheet" media="screen"
	href="https://d3nn82uaxijpm6.cloudfront.net/assets/strava-orion-1731779462880907f17d94f747e55679c032d636af442da84ea95916c083e7ee.css">
<link rel="stylesheet" media="screen"
	href="https://d3nn82uaxijpm6.cloudfront.net/assets/onboarding/show-3aec61dd498f638e1df2096bd95f6da5a7a77c24f340ca2c4ec2e1d1968b9d3b.css">
<link rel="stylesheet" media="screen"
	href="https://d3nn82uaxijpm6.cloudfront.net/packs/css/application-6b1ae9e9.chunk.css">
<style type="text/css">
.spinner, .spinner .status {
	position: relative;
}

.spinner {
	margin-top: 1em;
	margin-bottom: 1em;
}

.spinner .status {
	top: 2px;
	margin-left: 0.5em;
}

.spinner .status:empty {
	display: none;
}

.spinner.lg .graphic {
	border-width: 3px;
	height: 32px;
	width: 32px;
}

.spinner.tiny {
	height: 10px;
	width: 10px;
}

.spinner.centered, .spinner.vcentered {
	box-sizing: border-box;
	width: 100%;
}

.spinner.vcentered {
	left: 0;
	margin-top: -12px;
	position: absolute;
	right: 0;
	text-align: center;
	top: 50%;
}

.spinner .graphic, .ajax-loading-image {
	animation: spin 1.2s infinite linear;
	box-sizing: border-box;
	border-color: #eee;
	border-radius: 50%;
	border-style: solid;
	border-top-color: #666;
	border-top-style: solid;
	border-width: 2px;
	content: "";
	display: inline-block;
	height: 20px;
	position: relative;
	vertical-align: middle;
	width: 20px;
}

@
keyframes spin {from { transform:rotate(0deg);
	
}

to {
	transform: rotate(359deg);
}
}
</style>
</head>
<body class="is-preload left-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="index.jsp">blkin</a>
					</h1>
				</div>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="index.html">Welcome</a></li>
						<li><a href="#">Dropdown</a>
							<ul>
								<li><a href="#">Lorem ipsum dolor</a></li>
								<li><a href="#">Magna phasellus</a></li>
								<li><a href="#">Phasellus consequat</a>
									<ul>
										<li><a href="#">Lorem ipsum dolor</a></li>
										<li><a href="#">Phasellus consequat</a></li>
										<li><a href="#">Magna phasellus</a></li>
										<li><a href="#">Etiam dolore nisl</a></li>
									</ul></li>
								<li><a href="#">Veroeros feugiat</a></li>
							</ul></li>
						<li class="current"><a href="left-sidebar.html">대시 보드</a></li>
						<li><a href="right-sidebar.html">Right Sidebar</a></li>
						<li><a href="no-sidebar.html">No Sidebar</a></li>
					</ul>
				</nav>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div class="row gtr-200">
					<div class="col-4 col-12-medium">
						<div id="sidebar">

							<!-- Sidebar -->
							<section>
								<div class="athlete-profile" id="athlete-profile">
									<div class="card-body text-center">
										<a href="/athletes/59788260"><div
												class="avatar avatar-athlete avatar-lg">
												<div class="avatar-content">
													<div class="avatar-img-wrapper">
														<div class="avatar-badge">
															<span class="app-icon-wrapper  "><span
																class="app-icon icon-badge-"></span></span>
														</div>
														<img alt="승훈 백" class="avatar-img"
															src="https://d3nn82uaxijpm6.cloudfront.net/assets/avatar/athlete/medium-bee27e393b8559be0995b6573bcfde897d6af934dac8f392a6229295290e16dd.png">
													</div>
												</div>
											</div>

											<h2 class="text-title2 mt-sm mb-md">
												<div class="#">백승훈</div>
											</h2> </a>
										<ul class="list-stats text-center">
											<li><a class="stat" href="#"><div
														class="stat-subtext">팔로잉</div> <b class="stat-text">0</b>
											</a></li>
											<li><a class="stat" href="#"><div
														class="stat-subtext">팔로워</div> <b class="stat-text">0</b>
											</a></li>
											<li><a class="stat" href="#"><div
														class="stat-subtext">활동</div> <b class="stat-text">0</b> </a></li>
										</ul>
									</div>
									<div class="card-footer">
										<div class="card-section">
											<div class="text-label text-small">최근 활동</div>
											<a class="text-small" href="#"> <strong>오후 달리기</strong> •
												<time class="timestamp" datetime="2020-06-11 07:30:00 UTC">
													어제 </time>

											</a>
										</div>
										<div class="card-section">
											<a class="btn-card-link media media-middle"
												href="/athletes/59788260/training/log">
												<div class="media-body">내 트레이닝 로그</div>
												<div class="media-right">
													<span class="app-icon-wrapper  "><span
														class="app-icon icon-caret-right icon-dark icon-lg"></span></span>
												</div>
											</a>
										</div>
									</div>
								</div>

								<footer>
									<a href="#" class="button icon solid fa-info-circle">Find
										out more</a>
								</footer>
							</section>

							<section>
								<h3>Subheading</h3>
								<ul class="style2">
									<li><a href="#">Amet turpis, feugiat et sit amet</a></li>
									<li><a href="#">Ornare in hendrerit in lectus</a></li>
									<li><a href="#">Semper mod quis eget mi dolore</a></li>
									<li><a href="#">Quam turpis feugiat sit dolor</a></li>
									<li><a href="#">Amet ornare in hendrerit in lectus</a></li>
									<li><a href="#">Semper mod quisturpis nisi</a></li>
								</ul>
							</section>

						</div>
					</div>
					<div class="col-8 col-12-medium imp-medium">
						<div id="content">



	<!-- Footer -->
	<div id="footer-wrapper">
		<footer id="footer" class="container">
			<div class="row">
				<div class="col-3 col-6-medium col-12-small">

					<!-- Links -->
					<section class="widget links">
						<h3>Random Stuff</h3>
						<ul class="style2">
							<li><a href="#">Etiam feugiat condimentum</a></li>
							<li><a href="#">Aliquam imperdiet suscipit odio</a></li>
							<li><a href="#">Sed porttitor cras in erat nec</a></li>
							<li><a href="#">Felis varius pellentesque potenti</a></li>
							<li><a href="#">Nullam scelerisque blandit leo</a></li>
						</ul>
					</section>

				</div>
				<div class="col-3 col-6-medium col-12-small">

					<!-- Links -->
					<section class="widget links">
						<h3>Random Stuff</h3>
						<ul class="style2">
							<li><a href="#">Etiam feugiat condimentum</a></li>
							<li><a href="#">Aliquam imperdiet suscipit odio</a></li>
							<li><a href="#">Sed porttitor cras in erat nec</a></li>
							<li><a href="#">Felis varius pellentesque potenti</a></li>
							<li><a href="#">Nullam scelerisque blandit leo</a></li>
						</ul>
					</section>

				</div>
				<div class="col-3 col-6-medium col-12-small">

					<!-- Links -->
					<section class="widget links">
						<h3>Random Stuff</h3>
						<ul class="style2">
							<li><a href="#">Etiam feugiat condimentum</a></li>
							<li><a href="#">Aliquam imperdiet suscipit odio</a></li>
							<li><a href="#">Sed porttitor cras in erat nec</a></li>
							<li><a href="#">Felis varius pellentesque potenti</a></li>
							<li><a href="#">Nullam scelerisque blandit leo</a></li>
						</ul>
					</section>

				</div>
				<div class="col-3 col-6-medium col-12-small">

					<!-- Contact -->
					<section class="widget contact">
						<h3>Contact Us</h3>
						<ul>
							<li><a href="#" class="icon brands fa-twitter"><span
									class="label">Twitter</span></a></li>
							<li><a href="#" class="icon brands fa-facebook-f"><span
									class="label">Facebook</span></a></li>
							<li><a href="#" class="icon brands fa-instagram"><span
									class="label">Instagram</span></a></li>
							<li><a href="#" class="icon brands fa-dribbble"><span
									class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon brands fa-pinterest"><span
									class="label">Pinterest</span></a></li>
						</ul>
						<p>
							1234 Fictional Road<br /> Nashville, TN 00000<br /> (800)
							555-0000
						</p>
					</section>

				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div id="copyright">
						<ul class="menu">
							<li>&copy; Untitled. All rights reserved</li>
							<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>
				</div>
			</div>
		</footer>
	</div>

	</div>

	<!-- Scripts -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>







<div>
	<div>내 정보</div>
	<div>기록 정보</div>
</div>

</body>
</html>