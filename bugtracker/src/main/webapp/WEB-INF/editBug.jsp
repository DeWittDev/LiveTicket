<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Report</title>
</head>
<body>
	<div class="dash">
		<h1><c:out value="${currentUser.name}"/></h1>
		<div>
			<a href="/logout">Log Out</a><br>
			<a href="/dash">Home</a>
		</div>
	</div>
	<h2>Create Bug Report</h2>
	<div class="view">
		
		<div>
			<form:form action="/edit/${bug.id}" method="PUT" modelAttribute="bug">
				<div>
					<form:label path="title" placeholder="${bug.title}">Title:</form:label><br>
					<form:input path="title" />
					<form:errors path="title"/>
				</div>
				<div>
					<form:label path="description" placeholder="${bug.description}">Description:</form:label><br>
					<form:textarea path="description" rows="3"/>
					<form:errors path="description"/>
				</div>
				<div>
					<form:input type="hidden" path="users" value="${bug.users.id}" />
				</div>
				<button>Submit</button>
			</form:form><br>
			<form:form action="/delete/${id}" method="DELETE" methodAttribute="bug">
				<button>Remove Report</button>
			</form:form>
			
		</div>
		
	</div>
</body>
</html>