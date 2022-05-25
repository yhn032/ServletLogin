<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
 @media (max-width: 600px) {
 	.mainbox{
 	 min-width: 600px;
 	 margin: auto;
 	}
    .carousel-caption {
      display: none; 
    }
    navbar-default {
      margin-bottom: 1;
      border-radius: 1;
      background-color: #fdc4f3;
      text-align: center;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #fdc4f3;
      padding: 25px;
    }
    #myNavbar li {
    	margin-top: 30px;
    }
    
   }
  </style>
</head>
<body>
<div id="mainbox">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle"  data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <div>
      	<img src="image/연애대작전.png" alt="Image">
      </div>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" >
      <ul class="nav navbar-nav">
        <li id="gg"><a href="#">Home</a></li>
        <li><a href="#">코스만들기</a></li>
        <li><a href="#">코스추천</a></li>
        <li><a href="#">후기</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>



    <!-- Wrapper for slides -->
    <div class="carousel-inner" >
      <div class="item active">
        <img src="image/덕배.png" alt="Image" style="weight:100%" align="middle">
        <div class="carousel-caption">
          <h3></h3>
          <p>Money Money.</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    
</div>
  
<div class="container text-center">    
  <h3>What We Do</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="image/덕배.png" class="img-responsive" style="width:100%" alt="Image">
      <p>Current Project</p>
    </div>
    <div class="col-sm-4"> 
      <img src="image/팬.png" class="img-responsive" style="width:100%" alt="Image">
      <p>Project 2</p>    
    </div>
    <div class="col-sm-4">
      <div class="well">
       <p>Some text..</p>
      </div>
      <div class="well">
       <p>Some text..</p>
      </div>
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center" >
  <p>그대의 원활한 데이트를 기원하며...adios</p>
</footer>
</div>
</body>
</html>
