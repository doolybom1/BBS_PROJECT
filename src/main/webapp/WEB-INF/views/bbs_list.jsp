<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
tr>th, tr>td{
	text-align: center;
}
.dt{
	width:250px;
}
.no,.wr{
	width:100px;
}
</style>

<script>
	$(function() {
		$(".btn-writer").click(function() {
			document.location.href="${rootPath}/bbs/insert"
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	
	<section class="container-fluid">
		<article>
			<table class="table table-striped table-hover table-bordered">
				<tr>
					<th class="no">NO</th>				
					<th class="wr">작성자</th>				
					<th class="dt">일시</th>				
					<th>제목</th>				
				</tr>
				<co:choose>
					<co:when test="${empty BBS_LIST}">	
						<tr>
							<td colspan="4">데이터가 없습니다</td>
						</tr>
					</co:when>
					<co:otherwise>
						<co:forEach items="${BBS_LIST}" var="BBS" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${BBS.b_writer}</td>
								<td>${BBS.b_date_time}</td>
								<td><a href="${rootPath}/bbs/detail?b_id=${BBS.b_id}">${BBS.b_subject}</a></td>
							</tr>			
						</co:forEach>
					</co:otherwise>
				</co:choose>	
			</table>
		</article>
	</section>
	<article class="d-flex mt-1 justify-content-end">
		<button class="btn btn-primary btn-writer">글쓰기</button>
	</article>
	
</body>
</html>