<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<!-- header,nav -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header,nav -->


		<div id="container" class="clearfix">
			<!-- aside 없음 -->
			<div id="full-content">

				<!-- content-head 없음 -->
				<div id="index">

					<img id="profile-img" src="${pageContext.request.contextPath}/assets/image/profile.jpg">

					<div id="greetings">
						<p class="text-xlarge">
							<span class="bold">안녕하세요♡<br> 이정화의 MySite에 오신 것을 환영합니다<br> <br> 이 사이트는 Web programming 실습 과제 예제 사이트입니다.<br>
							</span> <br> 사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며,<br> spring framework 기반으로 제작되었습니다.<br> <br> java + database + 웹 프로그래밍 <br>수업에서 배운 내용들을 토대로 만들었습니다.<br> <br> <br>
							<br> <a class="" href="${pageContext.request.contextPath}/api/guestbook/addList">[방명록에 글 남기기]</a>
						</p>
					</div>
					<!-- //greetings -->

					<div class="clear"></div>

				</div>
				<!-- //index -->

			</div>
			<!-- //full-content -->


		</div>
		<!-- //container -->


		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap ////-->

</body>

</html>