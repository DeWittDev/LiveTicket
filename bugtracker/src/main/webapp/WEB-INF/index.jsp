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

	<%-- Registration --%>
	<div class="form">
		<h2>Register</h2>
	    <form:form action="/register" method="post" modelAttribute="newUser">
	        <div class="form-group">
	            <label>Name:</label>
	            <form:input path="name"/>
	            <form:errors path="name"/>
	        </div>
	        <div>
	            <label>Email:</label>
	            <form:input path="email"/>
	            <form:errors path="email"/>
	        </div>
	        <div>
	            <label>Password:</label>
	            <form:password path="password"/>
	            <form:errors path="password"/>
	        </div>
	        <div>
	            <label>Confirm Password:</label>
	            <form:password path="confirm"/>
	            <form:errors path="confirm"/>
	        </div>
	        <div>
	        	<form:input type="hidden" path="position" value="Developer" />
	        </div>
	        <input type="submit" value="Sumbit"/>
	    </form:form>    
	</div>
	<br>
	
	<%-- Login --%>
	<div class="form">
		<h2>Login</h2>
	    <form:form action="/login" method="post" modelAttribute="newLogin">
	        <div class="form-group">
	            <label>Email:</label>
	            <form:input path="email"/>
	            <form:errors path="email"/>
	        </div>
	        <div class="form-group">
	            <label>Password:</label>
	            <form:password path="password"/>
	            <form:errors path="password"/>
	        </div>
	        <input type="submit" value="Login"/>
	    </form:form>
	</div>
</body>
</html>