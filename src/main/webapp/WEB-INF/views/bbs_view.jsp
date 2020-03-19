<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="co"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			document.location.href = "${rootPath}/update?b_id=${BBS.b_id}"
		}else if(txt ==  '삭제'){
			if(confirm("삭제하시겠습니까?")){
				document.location.href = "${rootPath}/delete?b_id=${BBS.b_id}"
			}
		}else if(txt == '댓글 저장'){
			var data = {
					c_writer : $("#c_writer").val(),
					c_subject : $("#c_subject").val()
			}
			
			var formData = $(".main").serialize()
			$.ajax({
				url : "${rootPath}/comment/insert",
				data : formData,
				type : "POST",
				success : function(result){
					alert(result)
					$(".cmt_list").html(result)
				},
				error:function(){
					alert("서버통신오류")
				}
			})
			return false
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
		<a href="${rootPath}/list"><button class="btn btn-outline-dark p-2">목록으로</button></a>
	</div>
	<section class="container-fluid p-3">
		<div class="p-3 h3">댓글을 남겨주세요</div>
		<form class="main">
			<div class="row p-3 bg-light">
				<input type="hidden" name="c_id" id="c_id" value="0">
				<input type="hidden" name="c_b_id" value="${BBS.b_id}">
				<div class="col-2">
					<input name="c_writer" id="c_writer" class="form-control" placeholder="작성자"/>
				</div>
				<div class="col-8">
					<input name="c_subject" id="c_subject" class="form-control" placeholder="댓글을 입력하세요"/>
				</div>
				<div class="col-2 d-flex justify-content-center">
					<button type="button" class="btn btn-outline-primary re_save">댓글 저장</button>
				</div>
			</div>
		</form>	
		<div class="p-3 h3">댓글 리스트</div>
		<div class="row pl-4">
			<label class="col-2"><b>작성자</b></label>
			<label class="col-8"><b>댓글</b></label>
		</div>
		<div class="p-3 cmt_list">
			<%@ include file="/WEB-INF/views/comment_list.jsp" %>
		</div>
		
	</section>	
</body>
</html>