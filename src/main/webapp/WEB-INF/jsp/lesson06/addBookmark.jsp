<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 추가하기</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
 <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>	
	<div class="container">
		<h1>즐겨찾기추가하기</h1>
		<form method="post" action="/lesson06/quiz01/add-bookmark">
			<label for="name">제목</label>
			<input type="text" name="name" id="name" class="form-control col-5">
			<label for="url">주소</label>
			<input type="text" name="url" id="url" class="form-control col-5">
			
			<input type="button" value="추가" id="addBtn" class="btn-success col-5 mt-2">
		</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#addBtn").on('click', function(){
			let name = $("#name").val();
			let url = $("#url").val();
			
			// validation 
			if(name.length < 1){
				alert("제목을 입력하세요");
				return;
			}
			if(url.length < 1){
				alert("주소를 입력하세요");
				return;
			}

		
		$.ajax({ // -- AJAX
			// request
			type:"post"
			, url:"/lesson06/quiz01/add-bookmark"
			, data:{"name":name, "url":url}
			, success:function(data){
				alert(data); // 성공
				if(data = "성공"){
					location.href="/lesson06/quiz01/after-add-bookmark-view";
				}
			}	
			, error:function(request, status, error){
				alert(request);
				alert(status);
				alert(error);
			}
		}); // -- AJAX
	}); // -ready
});	
	</script>
</body>
</html>