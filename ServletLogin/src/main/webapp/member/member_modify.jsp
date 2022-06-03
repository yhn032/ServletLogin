<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap" rel="stylesheet">

<style type="text/css">

.container{
	width: 700px;
	height: 1000px;
	font-family: 'Hi Melody', cursive;
	font-size: 18px;
}

#question{
  margin-top: 20px;
  margin-bottom: 20px;
}

.btn {cursor:pointer;}

#title{
/* float: left; */
font-size: 40px;
text-align: center;
margin-top: 20px;
margin-bottom: 20px;
}

img{
  float:left;
  margin:0 auto;
}

control-label col-sm-2{/*라벨*/
  display: inline-block;
} 
.form-group{ /*아우터div*/
  
   text-align:center; 
   display: flex;
}
.col-sm-10{  /*이너div*/
    width:300px;
    margin-bottom: 20px;
     margin: auto;
}


body{
  background-color: #fae3e3;
}

</style>

<script>

	function modify(f){
		
		if(confirm("수정하시겠습니까?")==false){
			return;
		}
	
	    f.action = "modify.do";
		f.submit();
	}
	
</script>	


</head>

<body>



<form>

<div class="container">

<a href="main.do">
<img src="../image/연애대작전.png" alt="Image" >
</a>
  
<div id="title">회원정보수정</div>

    <div id="form" class="form-group" >
      <label class="control-label col-sm-2" >이메일</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="email" value="${ user.email }" readonly>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" >비밀번호</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="pwd" value="${ user.pwd }" >
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" >이름</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="name"  value="${ user.name }" >
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" >닉네임</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="nickname" value="${ user.nickname }"  >
      </div>
      
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" >생년월일</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="birth" value="${ user.birth }" >
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" >전화번호</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="tel" value="${ user.tel }"  >
      </div>
    </div>
    
    <div id="question">
    <label class="control-label col-sm-2" >질문</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="question" value="${ user.question }" readonly>
      </div>
	 </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" >답변</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="answer" value="${ user.answer }"  >
     </div>
    </div>
    
    <div style="margin-top:30px; text-align:center;">
  	<button type="button" class="btn btn-default" onclick='modify(this.form); return false'>수정하기</button>
    </div>
    
 </div>   
</form>

  
  
 
 

</body>
</html>