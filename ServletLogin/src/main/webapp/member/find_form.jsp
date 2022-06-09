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

    a{ 
    	color: #cccccc; text-decoration: none; 
    }+
    .text2{
    	color : blue;
    }
    img{
    	margin-right:15px;
    }
    #question{
    	margin-top:15px;
   		margin-bottom: 15px;
    }
   
</style>

<script type="text/javascript">

$(document).ready(function(){
	setTimeout(showMessage, 100);
});

function showMessage(){
	if("${param.reason eq 'fail_email'}" == "true"){
		alert("이메일이 틀렸거나 존재하지 않습니다.");
		return;
	}
	
	if("${param.reason eq 'fail_question'}" == "true"){
		alert("질문이 올바르지 않습니다. 회원가입시 설정한 질문을 선택해주세요.");
		return;
	}
	
	if("${param.reason eq 'fail_answer'}" == "true"){
		alert("질문에 대한 답이 올바르지 않습니다.");
		return;
	}
}


function check(f){

	var name = f.name.value;
	var email = f.email.value;
	var answer = f.answer.value;
	
	if(email==''){
		alert('이메일이 올바로 입력되지 않았습니다.');
		f.email.value='';
		f.email.focus();
		return;
	}
	
	if(name==''){
		alert('이름이 올바로 입력되지 않았습니다.');
		f.name.value='';
		f.name.focus();
		return;
	}
	
	if(answer==''){
		alert('답변이 입력되지 않았습니다.');
		f.answer.value='';
		f.answer.focus();
		return;
	}
	f.action='find.do';
	f.submit();

}
	
</script>
</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	<form>
		<div class="card align" style="width:500px; background-color: #FFF0F5;">
			<div class="card-title" style="margin-top:30px;">        
				<h2 class="card-title" style="color:#ffc0cb;"><img src="../image/연애대작전.png"> 연 애 대 작 전</h2>
			</div>    
			<div class="card-body">
				<input type="email" name="email" id="email" class="form-control" placeholder="이메일" required autofocus value="${param.email }"><br>
				<input type="text" name="name" id="name" class="form-control" placeholder="이름" required value="${param.name }"><br>
				<h4 class="card-title" style="color:#ffc0cb;">비밀번호 찾기 질문</h4>
				    <select id="question" name = "question">
		        	    <option value = "고향은 어디입니까?" selected>고향은 어디입니까?</option>
			            <option value = "좋아하는 연예인은 누구입니까?">좋아하는 연예인은 누구입니까?</option>
			            <option value = "좋아하는 색깔은 무엇입니까?">좋아하는 색깔은 무엇입니까?</option>
		        	    <option value = "어머니의 이름은 무엇입니까?">어머니의 이름은 무엇입니까?</option>
			            <option value = "아버지의 이름은 무엇입니까?">아버지의 이름은 무엇입니까?</option>
			            <option value = "출신 초등학교의 이름은 무엇입니까?">출신 초등학교의 이름은 무엇입니까?</option>
		             </select>
		          
				<input type="text" name="answer" id="answer" class="form-control" placeholder="답변" required>
			</div>
			
			<input id="btn-Yes" class="btn btn-lg w-btn w-btn-pink" type="button" onclick="check(this.form);" value="비 밀 번 호 찾 기">
			    
			<div class="links">
				<a href="login_form.do">로그인</a> | <a href="enroll_form.do">회원가입</a>
			</div>
		</div>
	</form>
</body>

</html>
