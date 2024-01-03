<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					
				<c:forEach var="bookmark" items="${bookmarkList}">
					<tr>
						<td>${bookmark.id}</td>
						<td>${bookmark.name}</td>
						<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
						<td>
							<%-- 1) value로 값 넣기 --%>
							<%--<button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button></td> --%>
							<%-- data로 값 꺼내기--%>
						<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button></td>
					</tr>
				</c:forEach>
				</tr>
			</tbody>			
		</table>	
	</div>
<script>
	$(document).ready(function(){
		// 삭제 버튼 클릭
		$('.del-btn').on('click', function(e){
			// alert("클릭");
			// let id = $(this).val();
			// let id = $(this).attr("value");
			// let id = e.target.value;
			
			// 2) data를 이용해 값 가져오기
			// 태그영역: data-bookmark-id
			// 스크립트 영역: .data('data-bookmark-id')
			let id = $(this).data('bookmark-id');		
			//alert(id);
			
			$.ajax({
				//request
				type:"delete"
				, url:"/lesson06/delete-bookmark"
				, data:{"id":id}
			
				//response
				, success:function(data){
					if(data.code == 200){
						// 성공
						location.reload();
					} else if(data.code == 500){
						// 실패
						alert(data.error_message);
					}
				}
				, error:function(request, status, error){
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			})
			
		});
	});
</script>	
</body>
</html>