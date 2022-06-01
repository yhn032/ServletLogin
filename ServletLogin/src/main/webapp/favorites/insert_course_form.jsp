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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>코스 만들기</title>
<style>
    @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: auto;
	    margin-top: 100px;
	    
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
	function send(f){
		var coTitle = f.coTitle.value.trim();
		var coText  = f.coText.value.trim();
		
		f.action="insert_course.do";
		
		f.submit();
		
	}

</script>
</head>

<body>
	<form>
		<div class="card align" style="width:500px; background-color: #FFF0F5;">
			<div class="card-title" style="margin-top:30px;">        
				<h2 class="card-title" style="color:#ffc0cb;"><img src="../image/연애대작전.png"> 연 애 대 작 전</h2>
			</div>    
			<div class="card-body">
				<input type="hidden" name="coId" value="${user.nickname }">
				<input type="text" name="coTitle" id="coTitle" class="form-control" placeholder="코스 제목" required autofocus><br>
		        <textarea rows="7" cols="50" name="coText" id="coText" class="form-control" placeholder="내용"></textarea>
			</div>
			
			<input id="btn-Yes" class="btn btn-lg w-btn w-btn-pink" type="button" onclick="send(this.form);" value="코스 등록하기">
			    
		</div>
	</form>
</body>

</html>
