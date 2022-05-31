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
</head>
</head>
<body>

<div class="container">
  <div style="font-size: 40px; text-align: center; margin-top: 10px; margin-bottom: 30px;">회원정보수정</div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">이메일:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control"  placeholder="Enter email" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">비밀번호:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" placeholder="Enter password">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">이름:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">닉네임:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  placeholder="Enter password" >
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">생년월일:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">전화번호:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  placeholder="Enter password" >
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">비밀번호찾기</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" placeholder="Enter password" >
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <input type="button" class="btn btn-default" value="수정" onclick=""/>
      </div>
    </div>
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <input type="button" class="btn btn-default" value="회원탈퇴" onclick=""/>
      </div>
    </div>
 
</div>

</body>
</html>