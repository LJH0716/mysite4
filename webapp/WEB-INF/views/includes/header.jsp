<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="header" class="clearfix">
		<h1>
			<a href="${pageContext.request.contextPath}/main">MySite</a>
		</h1>

		<c:choose>
			<c:when test="${sessionScope.authUser!=null}">
				<ul>
					<li>${authUser.name}님안녕하세요♡</li>
					<li><a href="${pageContext.request.contextPath}/logout" class="btn_s">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/modifyForm?no=${authUser.no}" class="btn_s">회원정보수정</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
					<li><a href="${pageContext.request.contextPath}/loginForm" class="btn_s">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/join" class="btn_s">회원가입</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="${pageContext.request.contextPath}/board/list3">게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/gallery/list">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}/api/guestbook/addList">방명록</a></li>
			</ul>
		</div>

	</div>

</body>
</html>