<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">


<script type="text/javascript">
/* 전역변수 */
idx = 0;
function send(i){
	idx = i; 
}
$(document).ready(function (){
	$(".star").click(function(){
		if($(this).val() == '☆'){
			$(this).val('★');
			$.ajax({
				type:'GET',
				url :'update_mylist.do',
				data:{'nickname':'${user.nickname}', 'idx':idx},
				success:function(res){
					console.log(1);
				}
			});
			alert('즐겨찾기에 추가되었습니다.');
		}else{
			$(this).val('☆');
			$.ajax({
				type:'GET',
				url :'delete_mylist.do',
				data:{'idx':idx},
				success:function(res){
					console.log(1);
				}
			});
			alert('즐겨찾기에서 삭제되었습니다.');
		}
	});
});

</script>
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
		<c:if test="${!empty user }">
			<li><a href="../member/main.do">Home</a></li>
			<li><a href="insert_course_form.do">코스만들기</a></li>
			<li><a href="course.do">코스추천</a></li>
			<li><a href="mylist.do">찜한 코스</a></li>
			<li><a href="../member/inform_form.do">회원정보수정</a></li>
		</c:if>
		<c:if test="${empty user }">
			<li><a href="../member/main.do">Home</a></li>
        	<li><a href="course.do">코스추천</a></li>
      	</c:if>
	</ul>
    
      
      
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${empty user }">
	      	<li><a href=""><input type="hidden">Guest님 환영합니다.</a></li>
	      	<li><a href="../member/login_form.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        	<li><a href="../member/enroll_form.do"><span class="glyphicon glyphicon-baby-formula"></span> 회원가입</a></li>
      	</c:if>
      	<c:if test="${!empty user }">
	      	<li><a href=""><input type="hidden">${user.nickname }님 환영합니다.</a></li>
	      	<li><a href="../member/logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      	</c:if>
      </ul>
    </div>
  </div>
</nav>

<!-- 나의 리스트로 이동 -->
<c:if test="${!empty user }">
<input class="btn btn-warning" style="text-align: right;" type="button" value="즐겨찾기" onclick="location.href='mylist.do'">

</c:if>

</div>

<div id="favContent">
	
	<table class="table table-condensed" id="c_table">
		
		<!-- 제목 행 -->
		<tr class="danger">
			<th width="10%">번호</th>
			<th width="40%">코스제목</th>
			<th width="30%">작성자ID</th>
			<th width="10%">조회수</th>
			<th width="10%">나의 리스트</th>
		</tr>
		
		<!-- 데이터 행 -->
		<!-- 만약 데이터가 없다면 -->
		<c:if test="${empty list }">
			<td colspan="5" style="color: red; text-align: center">데이터가 없습니다.</td>
		</c:if>
		
		<!-- 데이터가 있다면 -->
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.idx }</td>
				<td><input style="background-color: white; border: none;" type="button" onclick="location.href='../favorites/detail.do?idx=${vo.idx}'" value="${vo.coTitle }"></td>
				<td>${vo.coId }</td>
				<td>${vo.coView }</td>
				<c:if test="${empty user }">
					<td>로그인시 사용가능</td>
      			</c:if>
		      	<c:if test="${!empty user }">
					<td><input type="button" class="star" value="☆" onclick="send(${vo.idx})"></td>
		      	</c:if>
			</tr>
			
		</c:forEach>
	</table>
</div>
</body>
</html>
