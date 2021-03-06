<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/rboard.css" rel="stylesheet" type="text/css">


</head>


<body>
	<div id="wrap">

		<!-- header,nav -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header,nav -->



		<div id="container" class="clearfix">
			<!-- aside-->
			<c:import url="/WEB-INF/views/includes/boardAside.jsp"></c:import>

			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">댓글게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="rboard">
					<div id="read">
						<form action="rboard" method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자</span> <span class="form-value">${rboardVo.name}</span>
							</div>

							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span> <span class="form-value">${rboardVo.hit}</span>
							</div>

							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span> <span class="form-value">${rboardVo.regDate}</span>
							</div>

							<!-- 제목 -->
							<div class="form-group">
								<span class="form-text">제 목</span> <span class="form-value">${rboardVo.title}</span>
							</div>

							<!-- 내용 -->
							<div id="txt-content">
								<span class="form-value">${rboardVo.content}</span>
							</div>

							<!-- 댓글 -->
							<c:if test="${authUser != null}">
								<a id="btn_modify" href="${pageContext.request.contextPath }/rboard/commentForm?no=${rboardVo.no}">댓글달기</a>
							</c:if>

							<a id="btn_modify" href="${pageContext.request.contextPath }/rboard/modifyForm?no=${rboardVo.no}">수정</a> 
							<a id="btn_modify" href="list">목록</a>

						</form>
						<!-- //form -->
					</div>
					<!-- //read -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->



		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
