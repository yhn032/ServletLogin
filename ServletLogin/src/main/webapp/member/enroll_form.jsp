<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/enroll.css">


<script>

	regular_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	regular_pwd = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	regular_tel = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	
	function enroll(f){
		
		let email = f.email.value;
		let pwd = f.pwd.value;
		let tel = f.tel.value;
		let name = f.name.value;
		let nickname = f.nickname.value;
		let birth = f.birth.value;
		
	
		if(email=='' || pwd=='' || tel=='' || name=='' || nickname=='' || birth==''){
			
			alert('입력되지 않은 항목이 있습니다.')
			return;
		}
		
		if(regular_email.test(email)==false){
			
			alert("유효한 이메일 형식이 아닙니다.")
			f.email.value='';
			f.email.focus();
			return;
		}
		
		if(regular_pwd.test(pwd)==false){
			
			alert("유효한 비밀번호 형식이 아닙니다.")
			f.pwd.value='';
			f.pwd.focus();
			return;
		}
		
		if(regular_tel.test(tel)==false){
			
			alert("유효한 전화번호 형식이 아닙니다.")
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		f.action = "insert.do";
		f.submit();
	}


</script>	

</head>
<body>
<!-- 회원가입 폼 생성 -->
<div id="main-login">
	<div id="header">
		<h2>연애대작전</h2><br>
		<h4>회원가입</h4>
	</div>
	
	
		<form>
			<div id="content">
			  <div class="main">
			    
			    <input type="text" class="form-control" placeholder="이메일" id="email" name="email">
			    <div class="help-tip"><p>최소 8 자, 최소 하나의 문자 및 하나의 숫자를 입력하세요</p></div>
				<input class="form-control" placeholder="비밀번호" id="pwd" name="pwd">
			    <input type="text" class="form-control" placeholder="이름" id="name" name="name">
			    <input type="text" class="form-control" placeholder="닉네임" id="nickname" name="nickname">
			    <input type="text" class="form-control" placeholder="생일(yyyy-mm-dd)" id="birth" name="birth">
			    <input type="text" class="form-control" placeholder="전화번호(xxx-xxxx-xxxx)" id="tel" name="tel">
			    <hr>
			    <div id="combobox">
			   <h6 style="text-align:center;">비밀번호 찾기 질문</h6> <br>
			    <select id="question" name = "question">
        	    <option value = "a" selected>고향은 어디입니까?</option>
	            <option value = "b">좋아하는 연예인은 누구입니까?</option>
	            <option value = "c">좋아하는 색깔은 무엇입니까?</option>
        	    <option value = "d">어머니의 이름은 무엇입니까?</option>
	            <option value = "f">아버지의 이름은 무엇입니까?</option>
	            <option value = "g">출신 초등학교의 이름은 무엇입니까?</option>
	            </select>
	            </div>
	            <input type="text" class="form-control" placeholder="답변" id="answer" name="answer">
	        	<hr>
			</div>
	     </div>
	<br><br>
	
	<div id="social">
		<input id="login" type="button" value="회원가입" onclick="enroll(this.form);">
	</div>
</form>
    <hr>
	<div id="footer">
		<p>서아진, 최규범, 김병국</p>
	</div>	
</div>
</body>
</html>