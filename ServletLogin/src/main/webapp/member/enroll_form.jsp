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
<link rel="stylesheet" href="../css/enroll.css"><link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap" rel="stylesheet">


<script>

	regular_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	regular_pwd = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	regular_tel = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	
	 function send(f){
			
			let email = f.email.value;
			let pwd = f.pwd.value;
			let tel = f.tel.value;
			let name = f.name.value;
			let nickname = f.nickname.value;
			let birth = f.birth.value;
		
			
			if(regular_pwd.test(pwd)==false){
				
				alert("유효한 비밀번호 형식이 아닙니다.")
				$( "#enroll").attr('disabled',true);
				f.pwd.value='';
				f.pwd.focus();
				return;
			}
			
			if(regular_tel.test(tel)==false){
				
				alert("유효한 전화번호 형식이 아닙니다.")
				$( "#enroll").attr('disabled',true);
				f.tel.value='';
				f.tel.focus();
				return;
			}
			
			f.action = "insert.do";
			f.submit();
		}
	
	//문서 내의 element 배치가 완료되면,
  $(document).ready(function(){
	  
	  //아이디 입력창에서 키가 입력되면, << 콜백함수
	  $("#email").keyup(function(e){
		  
		  var email = $( this ).val();
		  
		  if(regular_email.test(email)==false){
			  $("#email_msg").html("올바른 이메일 형식이 아닙니다.")
			     .css("color","red");
			  
			  //서버 안갔다왔을때(클라쪽). 여기 비활성화 안주면 안됨
			  $("#enroll").attr("disabled",true);
			  return;
		  }
			//서버에 사용 가능 여부 확인
			
		  $.ajax({
			  url:'email_check.do',  
		      data:{"email":email}, 
		      dataType:'json',
		      success:function(res){
		    	  //res = {"result":true}
		    	  //res = {"result":false}
		    	  if(res.result){//사용가능할때
		    		  $("#email_msg").html("사용 가능한 이메일입니다.")
		 		     .css("color","blue");
		    	  
		    	     //(서버 갔다오고 나서)가입버튼 활성화
		    	     $("#enroll").attr("disabled",false);
		    	     
		    	  }else{//사용중일때
		    		  $("#email_msg").html("이미 사용중인 이메일입니다.")
			 		 .css("color","red");
		    	  
		    	  	  //아이디 다시 안되는걸로 바꿨을때(서버 갔다오고 나서)비활성화
		    		 $("#enroll").attr("disabled",true);
		    	  }
		      },
		      error:function(err){
		    	  alert(err.responseText);
		      }
		  });
	  });
  });

</script>	

</head>
<body>
<!-- 회원가입 폼 생성 -->
<div id="main">
	<div id="header">
		<h2>♥연애대작전</h2><br>
		<h4>회원가입</h4>
	</div>
	
	
		<form>
			<div id="content">
			
			 <table class="table table-striped">    
			    <tr>
			      <th>이름</th>	
			      <td>  <input type="text" class="form-control" id="name" name="name"></td>
			    </tr>
			    
			    <tr>
			      <th>이메일</th>
			      <td>
			       <input type="text" class="form-control"  id="email" name="email">
			       <span id="email_msg"></span>
			      </td>	
			    </tr>
			  
			    <tr>
			      <th>비밀번호</th>
			      <td>	
			      <input type="password" class="form-control"  id="pwd" name="pwd">
			      </td>
			    </tr>
			    
			     <tr>
			      <th>닉네임</th>
			      <td><input type="text" class="form-control"  id="nickname" name="nickname"></td>
			    </tr>
			   
			     <tr>
			       <th>생일</th>
			       <td> <input type="text" class="form-control" placeholder="yyyy-mm-dd" id="birth" name="birth"></td>
			     </tr>
			
			     <tr>
			       <th>전화번호</th>
			       <td> <input type="text" class="form-control" placeholder="xxx-xxxx-xxxx" id="tel" name="tel"></td>
			     </tr>
			    
				   <tr >
				    <th>비밀번호 찾기 질문</th>
				    <td>
				    <select id="question" name = "question">
	        	    <option value = "고향은 어디입니까?" selected>고향은 어디입니까?</option>
		            <option value = "좋아하는 연예인은 누구입니까?">좋아하는 연예인은 누구입니까?</option>
		            <option value = "좋아하는 색깔은 무엇입니까?">좋아하는 색깔은 무엇입니까?</option>
	        	    <option value = "어머니의 이름은 무엇입니까?">어머니의 이름은 무엇입니까?</option>
		            <option value = "아버지의 이름은 무엇입니까?">아버지의 이름은 무엇입니까?</option>
		            <option value = "출신 초등학교의 이름은 무엇입니까?">출신 초등학교의 이름은 무엇입니까?</option>
		            </select>
		            <input type="text" class="form-control" placeholder="답변" id="answer" name="answer">
		            </td>
		           </tr>
		           
				    <tr>	 
					<td><input id="enroll" type="button" value="회원가입" onclick="send(this.form);" disabled="disabled"></td>
				    </tr>
	    </table>
	  </div>
</form>
 
	<div id="footer">
		<p>서아진, 최규범, 김병국</p>
	</div>	
</div>
</body>
</html>