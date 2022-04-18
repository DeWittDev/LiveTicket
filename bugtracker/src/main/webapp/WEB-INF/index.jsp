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
	<div>
		<div class="dash" id="heading">
			<h1>Bug Tracker</h1>
		</div>
		<div class="login">
			<%-- Registration --%>
			<div class="form" id="frontpage">
				<h2>Register</h2>
				<br>
			    <form:form action="/register" method="post" modelAttribute="newUser">
			        <div class="form-group">
			            <label>Name:</label><br>
			            <form:input id="inputText" path="name"/><br>
			            <form:errors class="text-warning" path="name"/>
			        </div>
			        <div>
			            <label>Email:</label><br>
			            <form:input id="inputText" path="email"/><br>
			            <form:errors class="text-warning" path="email"/>
			        </div>
			        <div>
			            <label>Password:</label><br>
			            <form:password id="inputText" path="password"/><br>
			            <form:errors class="text-warning" path="password"/>
			        </div>
			        <div>
			            <label>Confirm Password:</label><br>
			            <form:password id="inputText" path="confirm"/><br>
			            <form:errors class="text-warning" path="confirm"/>
			        </div>
			        <div>
			        	<form:input type="hidden" path="position" value="Developer" />
			        </div><br>
			        <button>Submit</button>
			    </form:form>    
			</div>
			
			<%-- Login --%>
			<div class="form">
				<h2>Login</h2>
			    <form:form action="/login" method="post" modelAttribute="newLogin">
			        <div class="form-group">
			        
			            <form:errors class="text-warning" path="userPassword"/>
			            <form:errors class="text-warning" path="userEmail"/>
			            <br>
			            <label>Email:</label><br>
			            <form:input id="inputText" path="userEmail"/>
			        </div>
			        <div class="form-group">
			            <label>Password:</label><br>
			            <form:password id="inputText" path="userPassword"/>
			        </div><br>
			        <button>Login</button>
			    </form:form>
			</div>
		</div>
	</div>
</body>
</html>