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
	
	<h1>Edit project</h1>
	<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project">
	<input type="hidden" name="_method" value="put">
    	<p>
        	<form:label path="title">Title:</form:label>
        	<form:errors path="title"/>
        	<form:input path="title"/>
    	</p>
    	<p>
        	<form:label path="description">Description:</form:label>
        	<form:errors path="description"/>
        	<form:input path="description"/>
    	</p>
    	<p>
        	<form:label path="date">Due date:</form:label>
        	<form:errors path="date"/>
        	<form:input type="date" path="date"/>
    	</p>
        <input type="submit" value="Create"/>
	</form:form><br>
	<form:form action="/dashboard" method="get" modelAttribute="project">
		<input type="submit" value="Cancel"/>
	</form:form>
</body>
</html>