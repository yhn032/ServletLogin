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

#question{
	text-align-last: center;
	text-align: center;
	vertical-align: middle;
}

i {
	position: absolute;
	left: 60%;
	top: 250px;
	color: orange;
}

#combobox{
   margin-left: 95px;
}
</style>

</head>
<body>
<!-- 회원가입 폼 생성 -->
<div id="main-login">
	<div id="header">
		<h2>한국ICT인재교육원</h2><br>
		<h4>회원가입</h4>
	</div>
	
	<div id="content">
		<form>
			<div class="main">
			    <input type="id" class="form-control" placeholder="아이디" id="id" name="id">
				<input type="password" class="form-control" placeholder="비밀번호" id="pwd" name="pwd">
			    <input type="text" class="form-control" placeholder="이름" id="name" name="name">
			    <input type="text" class="form-control" placeholder="닉네임" id="nickname" name="nickname">
			    <input type="text" class="form-control" placeholder="생일(yyyy-mm-dd)" id="birth" name="birth">
			    <input type="text" class="form-control" placeholder="전화번호(000-000-0000)" id="tel" name="tel">
			    <input type="text" class="form-control" placeholder="이메일" id="email" name="email">
			    <br>
			    <div id="combobox">
			    질문<select id="question" name = "질문">
        	    <option value = "a" selected>고향은 어디입니까?</option>
	            <option value = "b">좋아하는 연예인은 누구입니까?</option>
	            <option value = "c">좋아하는 색깔은 무엇입니까?</option>
        	    <option value = "d" selected>어머니의 이름은 무엇입니까?</option>
	            <option value = "f">아버지의 이름은 무엇입니까?</option>
	            <option value = "g">출신 초등학교의 이름은 무엇입니까?</option>
	            </select>
	            </div>
	            <input type="text" class="form-control" placeholder="답변" id="answer" name="answer">
	        	
			</div>
		</form>
	</div>
	
	<div id="social">
		<input id="login" type="button" value="회원가입"><br>
	</div>

	<div id="footer">
		<p>서아진, 최규범, 김병국</p>
	</div>	
</div>
</body>
</html>