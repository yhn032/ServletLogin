
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	height: 610px;
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

.form_list_input input:hover {
	outline: none;
	box-shadow: 0 0 0 3px #9dd3f2;
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


.login-enroll{
	margin-top: 10px;
	margin-left: 70px;
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

var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

function send(f){
	var email = f.email.value;
	var pwd   = f.pwd.value;
	
	
	if(email==''){
		alert('이메일을 입력하세요.');
		f.email.focus();
		return;		
	}
	if(pwd==''){
		alert('비밀번호를 입력하세요.');
		f.pwd.focus();
		return;
	}
	
	
	if(regEmail.test(email)==false){
		alert('이메일의 형식이 올바르지 않습니다. 다시 입력해주세요.');
		f.email.value='';
		f.pwd.value='';
		f.email.focus();
		return;
	}
	
	
	f.action="login.do";
	f.submit();
};


</script>
</head>
<body>
<c:if test="${result==-1 || result == 0 }">
	<script>
		alert("아이디 혹은 비밀번호가 틀렸습니다.");
	</script>
</c:if>

<!-- 로그인 화면 구성 -->
<div id="main-login">
	<div id="header">
		<h2>연애대작전</h2><br>
		<h4>로그인</h4>
	</div>
	
	<form>
		<div id="content">
			    <div class="form_list_input">
					<input type="email" placeholder="Email" id="email" name="email">
					<input type="password" placeholder="Password" id="pwd" name="pwd">
					<i class="fa fa-eye fa-lg"></i>
			    </div>
		</div>
		
		<div class="login-enroll"><a href="#">이메일과 비밀번호를 잊으셨나요?</a></div>
		<div id="login">
			<input id="login" type="button" value="로그인" onclick="send(this.form);"><br>
		</div>
	</form>
	
	<div style="text-align: center; margin-top: 15px;">또는</div>
	
	<div id="social">
		<input id="naver" type="button" value="네이버로 계속" onclick="location.href='https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com'"><br>
		<input id="google" type="button" value="구글로 계속" onclick="location.href='https://www.google.com/'"><br>
	</div>
	
	
	<div class="login-enroll"><a href="insert_form.do">아직 아이디가 없으신가요?</a></div>
	<div id="footer">
		한국ICT인재교육원: 서아진, 최규범, 김병국
	</div>
</div>
</body>
</html>