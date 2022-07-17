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
		var coTitle = $("#coTitle").val().trim();
		//var coText  = f.coText.value.trim();
		var coText  = CKEDITOR.instances.coText.getData();
		
		if(coTitle==''){
			alert('제목을 입력하세요.');
			f.coTitle.value='';
			f.coTitle.focus();
			return;
		}
		
		if(coText==''){
			alert('내용을 입력하세요.');
			f.coText.value='';
			f.coText.focus();
			return;
		}
		
		f.action="modify_course.do";
		
		f.submit();
		
	}

</script>
<script type="text/javascript">

	//Ajax파일 업로드 코드... 
	function ajaxFileUpload1() {
		// 업로드 버튼이 클릭되면 파일 찾기 창을 띄운다.
		// == 사진 수정 버튼을 클릭하면 -> 숨겨놓은 버튼이 클릭되도록 설정한다.
		$("#ajaxFile1").click();
	}
	//Ajax파일 업로드 코드... 
	function ajaxFileUpload2() {
		// 업로드 버튼이 클릭되면 파일 찾기 창을 띄운다.
		// == 사진 수정 버튼을 클릭하면 -> 숨겨놓은 버튼이 클릭되도록 설정한다.
		$("#ajaxFile2").click();
	}
	//Ajax파일 업로드 코드... 
	function ajaxFileUpload3() {
		// 업로드 버튼이 클릭되면 파일 찾기 창을 띄운다.
		// == 사진 수정 버튼을 클릭하면 -> 숨겨놓은 버튼이 클릭되도록 설정한다.
		$("#ajaxFile3").click();
	}

	function ajaxFileChange(c) {
		// 파일이 선택되면 업로드를 진행한다.
		photo_upload(c);
	}

	function photo_upload(c) {
		
		//alert($("#ajaxFile"+c));
		
		/* //파일선택->취소시
		if ($("#ajaxFile"+c).files == undefined)
			return; */

		var form = $("#ajaxForm")[0];
		var formData = new FormData(form);
		formData.append("photo_num", c);
		formData.append("f_idx", "${param.f_idx}");
		formData.append("coPhoto", $("#ajaxFile"+c)[0].files[0]);	//photo_upload.do?p_idx=55&photo=a.jpg

		
		$.ajax({
			url : "photo_upload.do", //PhotoUploadAction
			type : "POST",
			data : formData,
			processData : false,
			contentType : false,
			dataType : 'json',
			success : function(result_data) {
				//result_data = {"p_filename":"aaa.jpb"}

				//location.href=''; //자신의 페이지를 리로드(refresh)

				$("#"+c).attr("src",
						"${pageContext.request.contextPath }/upload/" + result_data.filename);

			},
			error : function(err) {
				alert(err.responseText);
			}
		});

	}
</script>
</head>

<body>
	<!--화일업로드용 폼  -->
	<!-- 실제 파일 업로드는 이 form이 담당하게 되고, display를 none으로 한다. 
	 우리가 만들어 놓은 버튼을 누르면 이 버튼이 눌리는 것처럼 동작되도록 구현한다. -->
	<form enctype="multipart/form-data" id="ajaxForm" method="post">
		<input type="file" id="ajaxFile1" style="display: none;" onChange="ajaxFileChange(1);">
		<input type="file" id="ajaxFile2" style="display: none;" onChange="ajaxFileChange(2);">
		<input type="file" id="ajaxFile3" style="display: none;" onChange="ajaxFileChange(3);">
	</form>
	<form>
		<div class="card align" id="mainBox">
			<div class="card-title">        
				<h2 class="card-title" style="color:#ffc0cb;"><img src="../image/연애대작전.png" onclick="location.href='../member/main.do'"> 연 애 대 작 전</h2>
			</div>    
			<div class="card-body">
				<input type="hidden" name="coId" value="${user.nickname }">
				<input type="hidden" name="f_idx" value="${list.f_idx }">
				<table>	
					<tr>
						
					</tr>
				</table>
				<h4 style="color:#ffc0cb;"> 코 스 제 목 </h4>
				<input type="text" name="coTitle" id="coTitle" class="form-control" required autofocus value="${list.coTitle }"><br>
				
				
				<h4 style="color:#ffc0cb;"> 코 스 내 용 </h4>
		        <textarea rows="7" cols="50" name="coText" id="coText" class="form-control">${list.coText }</textarea>
		        <script>
		        	CKEDITOR.replace('coText', toolbar);
		        </script>
		        
		        <br><br><h4 style="color:#ffc0cb;"> 대 표 사 진(최대 3장) </h4>
		        <c:if test="${list.coPhoto1 ne 'no_file'}">
			      	<img id="1" src="${pageContext.request.contextPath }/upload/${list.coPhoto1}" width="350px;" height="300px" onclick="ajaxFileUpload1();">
		      	</c:if>
		      	<c:if test="${list.coPhoto1 eq 'no_file'}">
			      	<img id="1" src="${pageContext.request.contextPath }/image/이미지추가버튼.png" width="350px;" height="300px" onclick="ajaxFileUpload1();">
		      	</c:if>
		      	
		      	<c:if test="${list.coPhoto2 ne 'no_file'}">
			      	<img id="2" src="${pageContext.request.contextPath }/upload/${list.coPhoto2}" width="350px;" height="300px" onclick="ajaxFileUpload2();">
		      	</c:if>
		      	<c:if test="${list.coPhoto2 eq 'no_file'}">
			      	<img id="2" src="${pageContext.request.contextPath }/image/이미지추가버튼.png" width="350px;" height="300px" onclick="ajaxFileUpload2();">
		      	</c:if>
		      	
		      	<c:if test="${list.coPhoto3 ne 'no_file'}">
			      	<img id="3" src="${pageContext.request.contextPath }/upload/${list.coPhoto3}" width="350px;" height="300px" style="margin-top: 20px;" onclick="ajaxFileUpload3();">
		      	</c:if>
		      	<c:if test="${list.coPhoto3 eq 'no_file'}">
			      	<img id="3" src="${pageContext.request.contextPath }/image/이미지추가버튼.png" width="350px;" height="300px" style="margin-top: 20px;" onclick="ajaxFileUpload3();">
		      	</c:if>
			</div>
			
			<input id="btn-Yes" class="btn btn-lg w-btn w-btn-pink" type="button" onclick="send(this.form);" value="코스 수정하기">
			    
		</div>
	</form>
</body>

</html>
