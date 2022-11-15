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
	
	<h1>Add a Book to Your Shelf!</h1>
	<a href="/logout">logout</a>
	<form:form action="/createproject" method="post" modelAttribute="project">
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
	</form:form>

</body>
</html>