<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Project Details</h1><br>
<a href="/dashboard" >Back to dashboard</a>
<h2>Project: ${project.title}</h2>
<h2>Description: ${project.description}</h2>
<h2>Project: ${project.date}</h2>
<form:form action="/delete/${project.id}" method="post">
     <input type="submit" value="Delete"/>
</form:form>
</body>
</html>