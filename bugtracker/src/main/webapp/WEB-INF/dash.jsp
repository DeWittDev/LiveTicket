<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page isErrorPage="true"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Login and Register</title>
</head>
<body>
	<div class="dash">
		<h1>Welcome <c:out value="${currentUser.name}"/></h1>
		<div>
			<a href="/logout">Log Out</a><br>
			<a href="/bug/report">Report Bug</a>
		</div>
	</div>
	 	
	 	<div>
			<h3>Pile of Ideas</h3>
			<table>
				<tr>
					<th>Title</th>
					<th>Added By</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${bug}" var="bug">
				<tr>
					<td><a href="/bug/${bug.id}"><c:out value="${bug.title}"/></a></td>
					<td><c:out value="${bug.users.name}"/></td>
					<td><a href="">edit</a><br><a href="/delete/${bug.id}">delete</a></td>
				</tr>
				</c:forEach>		
			</table>
			<br>
		</div>
</body>
</html>