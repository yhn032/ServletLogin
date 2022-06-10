<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 로그인 성공시 보여지는 화면 -->
<!DOCTYPE html>
<html lang="en">
<head>
<title>연애작전</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet" href="../css/main.css">

<!-- BootStrap3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap" rel="stylesheet">

</head>
<body>
<c:if test="${empty user }">
나의 리스트 기능은 로그인시에만 사용가능합니다.
</c:if>

<c:if test="${!empty user }">
	<div id="mainbox" style="font-family: 'Hi Melody', cursive;">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <div>
		      	<img src="../image/연애대작전.png" alt="Image">
		      </div>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar" >
		      <ul class="nav navbar-nav">
		        <li><a href="../member/main.do">Home</a></li>
		        <li><a href="insert_course_form.do">코스만들기</a></li>
		        <li><a href="course.do">코스추천</a></li>
		        <li><a href="mylist.do">찜한코스</a></li>
		        <li><a href="../member/member_inform.jsp">회원정보수정</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      	<c:if test="${!empty user }">
			      	<li><a href=""><input type="hidden">${user.nickname }님 환영합니다.</a></li>
		      	</c:if>
		        <li><a href="../member/logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	
	<div class="panel panel-success" id="mylist_title" style="font-family: 'Hi Melody', cursive;"> 
		<div class="panel-heading" style="text-align: center;">
			${user.nickname }님이 찜한 데이트 코스 리스트
			<input class="btn btn-warning" type="button" value="찜하러 가기" onclick="location.href='course.do'">
		</div>
	</div>
	
	<div id="favContent" style="font-family: 'Hi Melody', cursive;">
		<table id="c_table" class="table table-condensed">
			
			<!-- 제목 행 -->
			<tr class="danger">
				<th width="10%">번호</th>
				<th width="50%">코스제목</th>
				<th width="30%">작성자ID</th>
				<th width="10%">조회수</th>
			</tr>
			
			<!-- 데이터 행 -->
			<!-- 만약 데이터가 없다면 -->
			<c:if test="${empty list }">
				<td colspan="5" style="color: red; text-align: center">데이터가 없습니다.</td>
			</c:if>
			
			<!-- 데이터가 있다면 -->
			<c:if test="${!empty list }">
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.idx }</td>
						<td>${vo.coTitle}</td>
						<td>${vo.coId }</td>
						<td>${vo.coView }</td>
					</tr>
					<tr>
						<td colspan="4">${vo.coText }</td>
					</tr>
					
				</c:forEach>
			</c:if>
				
		</table>
	</div>

</c:if>

</body>
</html>


