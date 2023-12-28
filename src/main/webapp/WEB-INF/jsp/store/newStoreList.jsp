<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 리스트</title>
<!-- bootstrap CDN link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- 내가 만든 외부 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/css/store/style.css">
</head>
<body>
	<div id="wrap">		
			<header class="bg-info">배탈의 민족</header>
			<h1>가게 - 리뷰</h1>	
			<c:forEach var="review" items="${reviewList}">
				<div class="store form-control">
							<div class="d-flex">
								<h2>이름</h2>
								<div>${review.point}</div>
							</div>	
							<h5>${review.createdAt}</h5>
							<h5>${review.review}</h5>
							<div>${review.menu}</div>
				</div>
			</c:forEach>		
			<hr>
			<footer>
				<h3>(주)우와한형제</h3>
				고객센터: 1500-1500
			</footer>	

	</div>
</body>
</html>