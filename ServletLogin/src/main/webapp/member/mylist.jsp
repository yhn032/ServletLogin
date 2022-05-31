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
<c:if test="${empty user }">
나의 리스트 기능은 로그인시에만 사용가능합니다.
</c:if>

<c:if test="${!empty user }">
${user.nickname }님의 데이트 코스 리스트

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
			<td colspan="5" style="color: red; text-align: center">아직 저장한 데이트 코스가 없습니다.</td>
		</c:if>
		
		<!-- 데이터가 있다면 -->
		<c:if test="${!empty list }">
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.idx }</td>
					<td><input style="background-color: white; border: none;" type="button" onclick="location.href='detail.do?idx=${vo.idx}'" value="${vo.coTitle }"></td>
					<td>${vo.coId }</td>
					<td>${vo.coView }</td>
				</tr>
				
			</c:forEach>
		</c:if>
	</table>
</c:if>

<input type="button" value="뒤로가기" onclick="location.href='course.do'">
</body>
</html>