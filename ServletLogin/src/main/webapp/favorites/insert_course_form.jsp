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
<!-- CKEditor -->
<script src="//cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>
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
        width: 800px;
        background-color: #FFF0F5;
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
        margin-top:30px;
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
	var toolbar = {
            toolbarGroups : [
            	{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
    			{ name: 'editing', groups: [ 'selection', 'find', 'spellchecker', 'editing' ] },
    			{ name: 'links', groups: [ 'links' ] },
    			{ name: 'insert', groups: [ 'insert' ] },
    			{ name: 'forms', groups: [ 'forms' ] },
    			{ name: 'tools', groups: [ 'tools' ] },
    			{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
    			{ name: 'others', groups: [ 'others' ] },
    			{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
    			'/',
    			{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
    			{ name: 'styles', groups: [ 'styles' ] },
    			{ name: 'colors', groups: [ 'TextColor', 'BGColor'] },
    			{ name: 'about', groups: [ 'about' ] }
            ],

            removeButtons : 'Underline,PasteFromWord,PasteText,Unlink,Anchor,Image,Source,RemoveFormat,Blockquote,About',
        };

</script>

<script type="text/javascript">
	function send(f){
		var coTitle = f.coTitle.value.trim();
		//var coText  = f.coText.value.trim();
		var coText  = CKEDITOR.instances.coText.getData();
		var photo1 = f.coPhoto1.value;
		var photo2 = f.coPhoto2.value;
		var photo3 = f.coPhoto3.value;
		
		if(coTitle==''){
			alert('제목을 입력하세요.');
			f.coTitle.value='';
			f.coTitle.focus();
			return;
		}
		if(photo1=='' && photo2=='' && photo3==''){
			alert("업로드할 사진을 최소 1장 선택하세요.");
			return;
		}
		
		if(coText==''){
			alert('내용을 입력하세요.');
			f.coText.value='';
			f.coText.focus();
			return;
		}
		
		f.action="insert_course.do";
		
		f.submit();
		
	}

</script>
</head>

<body>
	<form method="POST" enctype="multipart/form-data">
		<div class="card align" id="mainBox">
			<div class="card-title">        
				<h2 class="card-title" style="color:#ffc0cb;"><img src="../image/연애대작전.png" onclick="location.href='../member/main.do'"> 연 애 대 작 전</h2>
			</div>    
			<div class="card-body">
				<input type="hidden" name="coId" value="${user.nickname }">
				<table>	
					<tr>
						
					</tr>
				</table>
				<h4 style="color:#ffc0cb;"> 코 스 제 목 </h4>
				<input type="text" name="coTitle" id="coTitle" class="form-control" required autofocus><br>
				
				
				<h4 style="color:#ffc0cb;"> 코 스 내 용 </h4>
		        <textarea rows="7" cols="50" name="coText" id="coText" class="form-control" placeholder="내용"></textarea>
		        <script>
		        	CKEDITOR.replace('coText', toolbar);
		        </script>
		        
		        <br><br><h4 style="color:#ffc0cb;"> 대 표 사 진(최대 3장) </h4>
		        <input name="coPhoto1" type="file">
		        <input name="coPhoto2" type="file">
		        <input name="coPhoto3" type="file">
			</div>
			
			<input id="btn-Yes" class="btn btn-lg w-btn w-btn-pink" type="button" onclick="send(this.form);" value="코스 등록하기">
			    
		</div>
	</form>
</body>

</html>
