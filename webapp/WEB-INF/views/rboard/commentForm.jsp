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
					<h3>댓글쓰기</h3>
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
					<div id="writeForm">
						<form action="${pageContext.request.contextPath}/rboard/commentwrite" method="get">

							<!-- hidden으로 값 저장 -->

							<input type="hidden" name="user_no" value="${authUser.no}"> 
							<input type="hidden" name="group_no" value="${rboardVo.groupNo}"> 
							<input type="hidden" name="order_no" value="${rboardVo.orderNo}"> 
							<input type="hidden" name="depth" value="${rboardVo.depth}">

							<!-- 글번호 -->
							<div class="form-group">
								<span class="form-text">no</span> <span class="form-value">${rboardVo.no}</span>
							</div>


							<!-- 제목 -->
							<div class="form-group">
								<label class="form-text" for="txt-title">title</label> <input type="text" id="txt-title" name="title" value="${rboardVo.title}">
							</div>

							<!-- 내용 -->
							<div class="form-group">
								<textarea id="txt-content" name="content"></textarea>
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