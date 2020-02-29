<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
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
			<table class="table table-striped table-hover">
				<tr>
					<th>NO</th>				
					<th>작성자</th>				
					<th>일시</th>				
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
								<td>${BBS.b_subject}</td>
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