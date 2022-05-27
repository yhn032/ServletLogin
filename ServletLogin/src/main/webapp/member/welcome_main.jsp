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
<c:if test="${ !empty user }">
	<script>
		alert('${user.nickname }님 환영합니다!');
	</script>
</c:if>


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
        <li><a href="#">Home</a></li>
        <li><a href="#">코스만들기</a></li>
        <li><a href="#">코스추천</a></li>
        <li><a href="#">후기</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${!empty user }">
	      	<li><a href=""><input type="hidden">${user.nickname }님 환영합니다.</a></li>
      	</c:if>
        <li><a href="logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li  data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li  data-target="#myCarousel" data-slide-to="1" ></li>
      <li  data-target="#myCarousel" data-slide-to="2" ></li>
    </ol>
     <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
         <img src="../image/이색.png" alt="Image" width="100%">
        <div class="carousel-caption">
          <h3>멋진 데이트를 원하시나요?</h3>
          <p></p>
        </div>      
      </div>
    
   
      <div class="item">
       <img src="../image/레스토랑.png" alt="Image" width="100%">
        <div class="carousel-caption">
          <h3>그런데 데이트 코스를 짜기가 어렵다고요?</h3>
          <p></p>
        </div>      
      </div>
    
   
      <div class="item">
       <img src="../image/그림.jpg" alt="Image" width="100%">
        <div class="carousel-caption">
          <h3>아주 잘 찾아오셨습니다 바로 가시죠</h3>
          <p></p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

  
<div class="container text-center">    
  <h2>성공한 데이트 코스 후기</h2><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="../image/팬.png" class="img-responsive" style="width:100%" alt="Image">
      <p>조용한 실내데이트</p>
    </div>
    <div class="col-sm-4"> 
      <img src="../image/팬.png" class="img-responsive" style="width:100%" alt="Image">
      <p>익스트림 야외데이트</p>    
    </div>
     <div class="col-sm-4"> 
      <img src="../image/팬.png" class="img-responsive" style="width:100%" alt="Image">
      <p>적당적당한 데이트</p>    
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center" >
  <p>언제나 그대의 원활한 데이트를 기원하며...adios</p>
</footer>
</div>
</body>
</html>
