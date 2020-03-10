<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
$(function() {
	var toolbar = [
		['style',['bold','italic','underline'] ],
		['fontsize',['fontsize']],
		['font Style',['fontname']],
		['color',['color']],
		['para',['ul','ol','paragraph']],
		['height',['height']],
		['table',['table']],
		['insert',['link','hr','picture']],
		['view',['fullscreen','codeview']]
		
	]
	
	$("#b_content").summernote({
		lang:'ko-KR',
		placeholder:'본문을 입력하세요',
		width:'100%',
		toolbar:toolbar,
		height:'200px',
		disableDragAndDrop : false,
	}) // end summernote
	
	// 이미지 업로드 부분 아직 안함
	
	$(document).on("click","button",function(){
			let txt = $(this).text()
			if(txt ==  '삭제'){
				if(confirm("삭제하시겠습니까?")){
					document.location.href = "${rootPath}/delete?b_id=${BBS.b_id}"				
				}
			}
		})

})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="container-fluid">
		<fieldset>
			<form method="POST">
				<div class="form-group">
					<input name="b_writer" class="form-control" placeholder="작성자" value="${BBS.b_writer}" />
				</div>			
				<div class="form-group">
					<input name="b_subject" class="form-control" placeholder="제목" value="${BBS.b_subject}" />
				</div>			
				<div class="form-group">
					<textarea name="b_content" id="b_content" rows="5" cols="30">${BBS.b_content}</textarea>
				</div>			
				<div class="form-group d-flex justify-content-end">
					<c:choose>
						<c:when test="${INSERT == 'INSERT'}">
							<button class="btn btn-outline-success mr-1">저장</button>
							<a href="${rootPath}/list"><button type="button" class="btn btn-outline-dark">목록으로</button></a>
						</c:when>
						<c:otherwise>
							<button class="btn btn-outline-success mr-1">저장</button>
							<button type="button" class="btn btn-outline-danger mr-1">삭제</button>
							<a href="${rootPath}/list"><button type="button" class="btn btn-outline-dark">목록으로</button></a>
						</c:otherwise>
					</c:choose>
				</div>
			</form>		
		</fieldset>
	</section>
</body>
</html>