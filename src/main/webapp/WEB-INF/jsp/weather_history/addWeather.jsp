<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
 <link rel="stylesheet" href="/css/weather_history/style.css" type="text/css">
<!-- bootstrap CDN link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!--datepicker-->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<%-- 내가 만든 외부 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/css/weather_history/style.css">
</head>
<body>
	<div id="wrap">
		<div class="contents d-flex">
			<%-- 메뉴 영역 --%>
			<nav class="col-2">
				<%-- 상단 로고 --%>
				<div class="logo d-flex justify-content-center mt-3">
					<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" width="25">
					<span class="text-white font-weight-bold ml-2">기상청</span>
				</div>

				<%-- 메뉴 --%>
				<%-- flex-column: 세로 메뉴 --%>
				<ul class="nav flex-column mt-4">
					<li class="nav-item">
						<a href="/weather-history/weather-list-view" class="nav-link menu-font">날씨</a>
					</li>
					<li class="nav-item">
						<a href="/weather-history/add-weather-view" class="nav-link menu-font">날씨입력</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link menu-font">테마날씨</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link menu-font">관측 기후</a>
					</li>
				</ul>
			</nav>

			<%-- 날씨 추가 --%>
			<section class="col-10 mt-3 ml-5">
				<h3>날씨 입력</h3>
				<form method="post" action="/weather-history/add-weather">
					<div class="d-flex justify-content-between mt-5">
						<div class="d-flex align-items-center">
							<div class="input-label">날짜</div>
							<input type="text" class="form-control" id="date" name="date">
						</div>
						<div class="d-flex align-items-center">
							<div class="input-label">날씨</div>
							<select class="form-control" name="weather">
								<option>맑음</option>
								<option>구름조금</option>
								<option>흐림</option>
								<option>비</option>
							</select>
						</div>

						<div class="d-flex align-items-center">
							<div class="input-label">미세먼지</div>
							<select class="form-control" name="microDust">
								<option>좋음</option>
								<option>보통</option>
								<option>나쁨</option>
								<option>최악</option>
							</select>
						</div>
					</div>

					<div class="d-flex justify-content-between mt-5">
						<div class="d-flex align-items-center">
							<div class="input-label">기온</div>
							<div class="input-group">
								<input type="text" class="form-control" name="temperatures">
								<div class="input-group-append">
									<span class="input-group-text">℃</span>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center">
							<div class="input-label">강수량</div>
							<div class="input-group">
								<input type="text" class="form-control" name="precipitation">
								<div class="input-group-append">
									<span class="input-group-text">mm</span>
								</div>
							</div>
						</div>

						<div class="d-flex align-items-center">
							<div class="input-label">풍속</div>
							<div class="input-group">
								<input type="text" class="form-control" name="windSpeed">
								<div class="input-group-append">
									<span class="input-group-text">km/h</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="text-right mt-4 mb-5">
						<input type="submit" class="btn btn-success" value="저장">
					</div>
				</form>
			</section>
		</div>
		<footer class="d-flex align-items-center">
			<div class="footer-logo ml-4">
				<img class="foot-logo-image" src="https://www.weather.go.kr/w/resources/image/foot_logo.png" width="120">
			</div>
			<div class="copyright ml-4">
				<small class="text-secondary"> 
					(07062) 서울시 동작구 여의대방로16길 61 <br>
					Copyright@2023 KMA. All Rights RESERVED.
				</small>
			</div>
		</footer>
	</div>
	<script>
		// 날짜 선택
		$(document).ready(function(){
			//날짜 선택
			$("#date").datepicker({
				dateFormat: "yy-mm-dd"				
			});
		});
	</script>
</body>
</html>