<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<html>
    <head>
        <meta charset="utf-8">
        <title>통나무 펜션</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>

<%-- 내가 만든 외부 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
        <div id="wrap" >
            <header class="mt-4">
                <div class="text-center display-4">통나무 팬션</div>
                <nav class="mt-4">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약안내</a></li>
                        <li class="nav-item"><a class="nav-link" href="/booking/booking-list-view">예약목록</a></li>
                    </ul>
                </nav>
            </header>
            <h1 class="text-center mt-3">예약 목록 보기</h1>
            <table class="table text-center mt-3">
            <thead>
            	<tr>
            		<th>이름</th>
            		<th>예약날짜</th>
            		<th>숙박일수</th>
            		<th>숙박인원</th>
            		<th>전화번호</th>
            		<th>예약상태</th>
            	</tr>
            </thead>
            <tbody>
            	<c:forEach var="booking" items="${ bookingList}">
            	<tr>
            		<td>${booking.name}</td>
            		<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 dd일"/></td>
            		<td>${booking.day}</td>
            		<td>${booking.headcount}</td>
            		<td>${booking.phoneNumber}</td>
            		<td>${booking.state}</td>
            		<td><button type="button" class="deleteBtn btn btn-danger" data-booking-id="${booking.id}">삭제</button></td>
            	</tr>
            	</c:forEach>
            </tbody>           
            </table>
   </div>     
<script>
	$(document).ready(function(){
		
		//삭제 버튼
		$(".deleteBtn").on('click',function(e){
			// alert("삭제");
			// 2) data를 이용해 값 가져오기
			// 태그영역: data-booking-id
			// 스크립트 영역: .data('booking-id')
			let id = $(this).data('booking-id');
			//alert(id);
			$.ajax({
				// request
				type:"delete"
				, url:"/booking/delete-booking"
				, data:{"id":id}
				
				// response
				, success:function(data){
					//성공
					if(data.code == 200){
						location.reload(true);
					} else if(data.code == 500)
						// 실패
						alert(data.error_message);
				}
				, error:function(reqeuest, status, error){
					alert("삭제하는데 실패했습니다. 관리자에게 문의하세요.");
				}
			}); // --ajax
		}); // -- deletebtn
	});

</script>    
</body>
</html>