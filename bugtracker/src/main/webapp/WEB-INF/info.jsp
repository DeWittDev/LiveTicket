<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page isErrorPage="true"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<title>Report Info</title>
</head>
<body>
	<div>
		<div class="dash">
			<h1>Welcome <c:out value="${currentUser.name}"/></h1>
			<div>
				<a href="/logout">Log Out</a><br>
				<a href="/dash">Home</a><br>
				<a href="/bug/report">Report Bug</a>
			</div>
		</div>
		<div class="view">
		<h2>${bug.title}</h2>
			<div>
				<p id="font2">-<c:out value="${bug.description}" /></p>
				<label id="font2">Submitted by: <c:out value="${bug.users.name}" /></label>
			</div>
			<c:if test="${currentUser.id == bug.users.id}">
				<a href="/delete/${bug.id}">delete</a>
				<a href="">Edit</a>
			</c:if>
		</div>
	</div>
</body>
</html>