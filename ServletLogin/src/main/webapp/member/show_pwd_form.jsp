<%@ page language="java" contentType="text/html; charset=UTF-8"    
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>아이디 찾기</title>
<style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 200px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}

    #btn-Yes{
    	display:block;
    	margin:auto;
        background-color: #ffc0cb;
        border: none;
        margin-bottom: 15px;
        
    }
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
    .card-title{
        margin: auto;
        padding-right: 10px;
    }
	 .links{
        text-align: center;
        margin-bottom: 10px;
    }

    .card-pwd { 
    	background-color:#ffc0cb;
    	font-size:xx-large;
    	color: #ffffff;
    	text-align: center;
    	margin-bottom: 10px;
  	}
    img{
    	margin-right:15px;
    }
    #question{
    	margin-top:15px;
   		margin-bottom: 15px;
    }
   
</style>

</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	<form>
		<div class="card align" style="width:500px; background-color: #FFF0F5;">
			<div class="card-title" style="margin-top:30px; ">        
				<h2 class="card-title" style="color:#ffc0cb;"><img src="../image/연애대작전.png"> 연 애 대 작 전</h2>
			</div>    
			<div class="card-body">
				<table style="margin: auto;">
					<tr>
						<td>
							<h4 class="card-title" style="color:#ffc0cb;">${vo.name}님의 비밀번호는</h4><br>
							<div class="card-pwd">${vo.pwd}</div>
						</td>
					</tr>
				</table>    
			
				<input id="btn-Yes" class="btn btn-lg w-btn w-btn-pink" type="button" onclick="alert('그냥 죽기살기로 기억하세요^^');" value="혹시 잊을 것 같으면 눌러주세요">
				    
				<div class="links">
					<a href="login_form.do">로그인</a> | <a href="main.do">메인페이지</a>
				</div>
			</div>
		</div>	
	</form>
</body>

</html>
