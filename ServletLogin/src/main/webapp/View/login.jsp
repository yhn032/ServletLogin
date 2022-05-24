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
	min-height: 600px;
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

.form-control{
	width: 70%;
	border-radius: 50px solid black;
	margin: 0 auto;
	margin-top: 10px;
}

i {
	position: absolute;
	left: 60%;
	top: 250px;
	color: orange;
}
</style>

<script>
$(document).ready(function(){
    $('.main i').on('click',function(){
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
		<h2>한국ICT인재교육원</h2><br>
		<h4>로그인</h4>
	</div>
	
	<div id="content">
		<form>
			<div class="main">
			    <input type="email" class="form-control" placeholder="Email" id="email" name="email">
				<input type="password" class="form-control" placeholder="Password" id="pwd" name="pwd">
				<i class="fa fa-eye fa-lg"></i>
			</div>
		</form>
	</div>
	
	<div id="social">
		<input id="login" type="button" value="로그인"><br>
		<input id="naver" type="button" value="네이버로 계속"><br>
		<input id="google" type="button" value="구글로 계속"><br>
	</div>

	<div id="footer">
		<p>서아진, 최규범, 김병국</p>
	</div>	
</div>
</body>
</html>