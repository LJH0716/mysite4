<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

</head>

<body>
	<div id="wrap">

		<!-- 해더 네비 -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //해더 네비 -->

		<div id="container" class="clearfix">
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/includes/galleryAside.jsp"></c:import>
			<!-- //게시판 aside -->

			<div id="content">

				<div id="content-head">
					<h3>갤러리</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">갤러리</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="gallery">

					<div id="list">
						<c:if test="${authUser != null}">
							<button id="btnImgUpload">이미지올리기</button>
						</c:if>
					</div>

				</div>
				<!-- //gallery -->


			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<!-- 푸터 -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //푸터 -->
	</div>
	<!-- //wrap -->
	
	
	<!-- ********* 이미지 등록 모달창 **********-->
	
	<div id="uploadModal" class="modal fade">
		<div class="modal-dialog">
		
			<div class="modal-content">
			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지 등록</h4>
				</div>
				
				<div class="modal-body">

					<div id="content">
					글작성<input type="text" name="content" value="">
					<br> 
					</div>
					
					<div id="file">
					<form action="${pageContext.request.contextPath}/gallery/upload" method="post" enctype="multipart/form-data">
					이미지 선택<input type="file" name="file" value="">
					</form>
					</div>
					
				</div>
				
				<div class="modal-footer">
					<button type="submit" class="btn" id="btnUpload">등록</button>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- /////////////////////////////////////////////////////////////// -->
	

</body>

<script type="text/javascript">
	/* 준비 */
	$(document).ready(function() {
		

	});

	/* 이미지 등록 버튼 */
	//jquery 요청(json)
	$("#btnImgUpload").on("click", function() {
		console.log("저장버튼 클릭");

		//모달창 띄우기
		$("#uploadModal").modal("show");


	});
</script>

</html>