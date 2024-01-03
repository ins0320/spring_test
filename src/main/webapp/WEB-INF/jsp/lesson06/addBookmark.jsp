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
			<label>제목</label>
			<input type="text"  id="name" class="form-control col-5">
			
			<label for="url">주소</label>
			<div class="d-flex">
				<input type="text"  id="url" class="form-control col-5">
				<button type="button" id="duplicationBtn" class="btn-info ml-3">중복확인</button>
			</div>
			<small class="text-danger mt-3 d-none" id="duplicationText">중복된 url 입니다.</small>
			<small class="text-success" id="availableText d-none">사용가능한 url 입니다.</small><br>
			<button type="button" id="addBtn" class="btn-success col-6 mt-3">추가</button>
	</div>
	<script>
	$(document).ready(function(){
		$("#addBtn").on("click", function(){
			let name = $("#name").val();
			let url = $("#url").val();
			
			// validation 
			if(!name){
				alert("제목을 입력하세요");
				return;
			}
			if(url.length < 1){
				alert("주소를 입력하세요");
				return;
			}

			// http 또는 https => ok
			if(url.startsWith("http://") == false
					&& url.startsWith("https://") == false){
				alert("주소 형식이 잘못 되었습니다.");
				return;
			}
			
			$.ajax({ // -- AJAX				
				// request
				type:"post"
				, url:"/lesson06/add-bookmark"
				, data:{"name":name, "url":url} //json 형태
			
				//response - call back 함수
				, success:function(data){ // data: JSON String => parsing(jquery ajax 함수) => dictionary
					//alert(code);
					if(data.code == 200){ // return : "code":200 
						location.href="/lesson06/after-add-bookmark-view"; // get 방식
					}
				}	
				, error:function(request, status, error){
					alert("추가하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			}); // -- AJAX
		
		}); // -- addBtn
		
		$("#duplicationBtn").on("click", function(){
			// alert("중복확인");
			let url = $("#url").val().trim();
			if(!url){
				alert("url을 입력하세요.");
				return;
			}
			
			// AJAX 통신 - DB 중복확인
			$.ajax({
				// request
				type:"POST"
				, url:"/lesson06/is-duplication-url"
				, data:{"url":url}
				
				// response
				, success:function(data){ // data: JSON String => dictionary
					// {"code":200, "is_duplication":true} => 중복
					if(data.is_duplication){
						// 중복이다.
						$("#duplicationText").removeClass("d-none");
						$("#availableText").addClass("d-none");
					}else{
						// 중복 x => 사용가능
						$("#duplicationText").addClass("d-none");
						$("#availableText").removeClass("d-none");
					}
				}
				, error:function(request, status, error){
					alert("중복확인에 실패했습니다.");
				}
			});			
		});
});	// -ready
	</script>
</body>
</html>