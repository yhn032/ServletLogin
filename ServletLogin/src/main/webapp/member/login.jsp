<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
#main-login{ 
	border: 1px solid black;
	margin: 0 auto;
	margin-top: 30px;
	border-radius: 10px;
	width: 35%;
	height: 550px;
	align-content: center;
}

#content { 
	margin: 0 auto;
	align-content: center;
}

#header { 
	text-align: center;
	margin-top: 30px;
	margin-bottom: 30px;
}


i {
	color: orange;
}

.form_list_input input {
	border: 0;
	height: 45px;
	width: 70%;
	border-radius: 30px;
	margin-left: 70px;
	margin-top: 15px;
}
.form_list_input input:focus {
	outline: none;
	box-shadow: 0 0 0 3px #9be3f2;
}
.form_list_input input::placeholder {
	font-weight: 500;
	color: #000000;
}

div input{
	border: 0;
	height: 45px;
	width: 70%;
	border-radius: 30px;
	margin-left: 70px;
	margin-top: 15px;
}

#social #naver{
	background-color: #19ce60;
	color: white;
	font-weight: bold;
}
#social #naver:hover{
	outline: none;
	box-shadow: 0 0 0 3px #1d914a;
}

#social #google{
	background-color: #476dea;
	color: white;
	font-weight: bold;
}
#social #google:hover{
	outline: none;
	box-shadow: 0 0 0 3px #1c43c2;
}

#login input{
	background-color: #ef4f4f;
	color: white;
	font-weight: bold;
}

#login input:hover{
	outline: none;
	box-shadow: 0 0 0 3px #af1111;
}

#footer {
	font-size: 8px;
	margin-top: 20px;
	float: right;
}
</style>

<script>
$(document).ready(function(){
    $('.form_list_input i').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).prop('class',"fa fa-eye-slash fa-lg")
            .prev('input').prop('type',"text");
        }else{
            $(this).prop('class',"fa fa-eye fa-lg")
            .prev('input').prop('type','password');
        }
    });
});
</script>
</head>
<body>
<!-- 로그인 화면 구성 -->
<div id="main-login">
	<div id="header">
		<h2>연애대작전</h2><br>
		<h4>로그인</h4>
	</div>
	
	<div id="content">
 		<form>
		    <div class="form_list_input">
				<input type="email" placeholder="Email" id="email" name="email">
				<input type="password" placeholder="Password" id="pwd" name="pwd">
				<i class="fa fa-eye fa-lg"></i>
		    </div>
 		</form>
	</div>
	
	<div id="login">
		<input id="login" type="button" value="로그인"><br>
	</div>
	
	<div style="text-align: center; margin-top: 15px;">또는</div>
	
	<div id="social">
		<input id="naver" type="button" value="네이버로 계속"><br>
		<input id="google" type="button" value="구글로 계속"><br>
	</div>
	
	<div id="footer">
		한국ICT인재교육원: 서아진, 최규범, 김병국
	</div>
</div>
</body>
</html>