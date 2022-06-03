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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap" rel="stylesheet">
<script>


function leave(f){
	Swal.fire({
	  title: '정말 탈퇴하시겠습니까?',
	  text: "탈퇴시 계정을 다시 복구시킬 수 없습니다.",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: '탈퇴',
	  cancelButtonText: '취소'
	}).then((result) => {
	  if (result.value) {
       //"탈퇴" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. 
       f.action='leave.do';
       f.submit();
	  }
	})
}

</script>
<style>

.container{
    font-family: 'Hi Melody', cursive;
    font-size: 20px;
	width: 600px;
	height: 600px;
	
}

img{
  float:left;
  margin-left:180px;
}


#title{
float: left;
font-size: 40px;
text-align: center;
margin-top: 20px;
margin-bottom: 20px;
}

.panel-body{  
  margin-bottom: 15px;
}

body{
  background-color: #fae3e3;
}

</style>
</head>

<body>

<form>
<div class="container">
 
    <a href="main.do">
	<img src="../image/연애대작전.png" alt="Image" style="margin-right:10px;">
    </a>
    
    
   <div id="title">회원 정보</div>

    
  <div class="panel panel-default" style="clear:both;">	
    <div class="panel-body">  이름 ㅣ ${ user.name } </div>
    <div class="panel-body"> 이메일 ㅣ ${ user.email } </div>
    <div class="panel-body"> 비밀번호 ㅣ ${ user.pwd }</div>
    <div class="panel-body">닉네임 ㅣ${ user.nickname }</div>
    <div class="panel-body"> 전화번호  ㅣ${ user.tel }</div>
    <div class="panel-body">생년월일 ㅣ${ user.birth }</div>
    <div class="panel-body">질문 ㅣ${ user.question }</div>
    <div class="panel-body">답변  ㅣ${ user.answer }</div>
  </div>
  
    
  <div id="button" style=" margin-top: 15px; text-align:center;">
    <button type="button" class="btn btn-default" onclick="location.href='inform_form.do'">회원정보수정</button>
    <button type="button" class="btn btn-default" onclick='leave(this.form); '>회원탈퇴</button>
  </div>
  </div> 
</form>


</body>
</html>