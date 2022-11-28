<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kickball League</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<h1 class="welcome" >Welcome!</h1>
	<div class="main">
		<div class="register">
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<table border="1">
				    <tr>
				        <td><form:label path="userName">User Name:</form:label>
				        <form:errors path="userName"/></td>
				        <td><form:input path="userName"/></td>
				    </tr>
				    <tr>
				        <td><form:label path="email">Email:</form:label>
				        <form:errors path="email"/></td>
				        <td><form:input path="email"/></td>
				    </tr>
				    <tr>
				        <td><form:label path="password">Password</form:label>
				        <form:errors path="password"/></td>
				        <td><form:input type="password" path="password"/></td>
				    </tr>
				    <tr>
				        <td><form:label path="confirm">Confirm PW:</form:label>
				        <form:errors path="confirm"/></td>
				        <td><form:input type="password" path="confirm"/></td>
				    </tr>
				</table>
				<input type="submit" value="Register" class="input"/>
			</form:form> 
		</div>
		<div class="login">
		<h1>Log In</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
		    <table border="1">
		    	<tr>
			        <td><form:label path="email">Email:</form:label>
			        <form:errors path="email"/></td>
			        <td><form:input path="email"/></td>
		    	</tr>
		    	<tr>
			        <td><form:label path="password">Password:</form:label>
			        <form:errors path="password"/></td>
			        <td><form:input type="password" path="password"/></td>
		    	</tr>
		    </table>
		    <input type="submit" value="Log in" class="input"/>
		</form:form>  
		</div>  
	</div>
</body>
</html>