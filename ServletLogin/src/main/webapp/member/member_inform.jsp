<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>

.container{
	width: 600px;
	height: 500px;
}

img{
  float:left;
  margin-left:120px
}

.head{
	margin-top:10px;
}



</style>


</head>

<body>

<div class="container">
 
    <a href="main.do">
	<img src="../image/연애대작전.png" alt="Image" style="hover">
    </a>
  <!--  <div class="container" > -->
    <h2>회원정보수정</h2>

    
  <div class="panel panel-default" style="margin-top: 50px;">	
    <div class="panel-body">  이름   ${ user.name } </div>
    <div class="panel-body"> 이메일  ${ user.email } </div>
    <div class="panel-body"> 비밀번호 ${ user.pwd }</div>
    <div class="panel-body">닉네임 ${ user.nickname }</div>
   <div class="panel-body"> 전화번호 ${ user.tel }</div>
    <div class="panel-body">생년월일 ${ user.birth }</div>
  </div>
</div>   
    
  <div class="container">
  <ul class="pager">
    <li><a href="#" onclick="modify()">수정</a></li>
    <li><a href="#">회원탈퇴</a></li>
  </ul>
  </div>
 
<!-- </div> -->

</body>
</html>