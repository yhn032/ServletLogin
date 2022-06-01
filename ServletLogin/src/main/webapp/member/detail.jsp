<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 선택된 게시글의 디테일 페이지입니다.
<div id="favContent">
	
	<table border="1" id="c_table">
		
		<!-- 제목 행 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">코스제목</th>
			<th width="30%">작성자ID</th>
			<th width="10%">조회수</th>
		</tr>
		
		<!-- 데이터 행 -->
		<!-- 만약 데이터가 없다면 -->
		<c:if test="${empty list }">
			<td colspan="5" style="color: red; text-align: center">데이터가 없습니다.</td>
		</c:if>
		
		<!-- 데이터가 있다면 -->
		<tr>
			<td>${list.idx }</td>
			<td>${list.coTitle}</td>
			<td>${list.coId }</td>
			<td>${list.coView }</td>
		</tr>
			
		<tr><td><input type="button" value="뒤로가기" onclick="location.href='course.do'"></td></tr>
	</table>
</div>
</body>
</html>