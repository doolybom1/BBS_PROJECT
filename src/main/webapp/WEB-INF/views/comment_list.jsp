<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:forEach items="${CMT_LIST}" var="CMT">
	<div class="row p-3 bg-light">	
		<div class="col-2">${CMT.c_writer}</div>
		<div class="col-8">${CMT.c_subject}</div>
		<div class="col-1">&times;</div>
		<div class="col-1"><i class="fas fa-reply"></i></div>
	</div>
</c:forEach>
