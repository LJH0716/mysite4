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
					<div id="modifyForm">
						<form action="${pageContext.request.contextPath }/rboard/modify" method="get">
							<input type="hidden" name="no" value="${rboardVo.no}">
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
								<label class="form-text" for="txt-title">제목</label> <input type="text" id="txt-title" name="title" value="${rboardVo.title}">
							</div>



							<!-- 내용 -->
							<div class="form-group">
								<textarea id="txt-content" name="content">${rboardVo.content}</textarea>
							</div>


							<a id="btn_cancel" href="list">취소</a>
							<button id="btn_modify" type="submit">수정</button>

						</form>
						<!-- //form -->
					</div>
					<!-- //modifyForm -->
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