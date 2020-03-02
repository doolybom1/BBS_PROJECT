<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script>
$(function(){
	$(document).on("click","button",function(){
		let txt = $(this).text()
		if(txt == '수정'){
			document.location.href = "${rootPath}/bbs/update?b_id=${BBS.b_id}"
		}
	})
})

</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

	<section class="container-fluid">
		<h2 class="p-3">${BBS.b_subject}</h2>
		<div class="">
			<small class="m-3"><b>작성자 :</b> ${BBS.b_writer}</small>
			<small class="m-3"><b>작성날짜/시간 :</b> ${BBS.b_date_time}</small>
			<hr/>
			<div class="p-3">${BBS.b_content}</div>
		</div>
	</section>
	<div class="form-group d-flex justify-content-end mt-1">
		<button class="btn btn-outline-primary mr-2 p-2">수정</button>
		<button class="btn btn-outline-danger mr-2 p-2">삭제</button>
		<button class="btn btn-outline-success mr-2 p-2">답글</button>
		<button class="btn btn-outline-dark p-2">목록으로</button>
	</div>
	<section class="container-fluid p-3">
		<div class="p-3">댓글을 남겨주세요</div>
		<form method="POST" class="main">
			<div class="row p-3 bg-light">
				<input type="hidden"/>
				<input type="hidden"/>
				<div class="col-2">
					<input name="c_writer" id="c_writer" class="form-control" placeholder="작성자"/>
				</div>
				<div class="col-8">
					<input name="c_subject" id="c_subject" class="form-control" placeholder="댓글을 입력하세요"/>
				</div>
				<div class="col-2 d-flex justify-content-center">
					<button type="button" class="btn btn-outline-primary">댓글 저장</button>
				</div>
			</div>
		</form>	
		<div class="p-3">댓글 리스트</div>
	</section>	
</body>
</html>