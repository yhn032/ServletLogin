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
  <link rel="stylesheet" href="../css/main.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>


<div id="mainbox">
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


<div id="favContent">
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
			<tr>
				<td>${list.idx }</td>
				<td>${list.coTitle}</td>
				<td>${list.coId }</td>
				<td>${list.coView }</td>
			</tr>
		</c:if>
			
	</table>
</div>

<div id="detail_course">
	<div class="panel panel-danger">
      <div class="panel-heading" style="text-align: center;">${list.coTitle }</div>
      <div class="panel-body">${list.coText }</div>
    </div>
</div>
</body>
</html>
