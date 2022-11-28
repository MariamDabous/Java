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
<h1>Edit Team</h1><br>
<a href="/home">dashboard</a><br>
<form:form action="/teams/edit/${team.id}" method="post" modelAttribute="team">
	<input type="hidden" name="_method" value="put">
	<form:input type="hidden" path="creator" value="${currentUser.id}"/>
	<table border="1">
		<tr>
			<td><form:label path="name">Team Name:</form:label>
        	<form:errors path="name"/></td>
        	<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="level"> Skill Level(1-5):</form:label>
        	<form:errors path="level"/></td>
        	<td><form:input type="number" min="1" max="5" path="level"/></td>
		</tr>
		<tr>
			<td><form:label path="gameday"> Game Day:</form:label>
        	<form:errors path="gameday"/></td>
        	<td><form:input path="gameday"/></td>
		</tr>
	
	
	</table>
	<input type="submit" value="Submit"/>
	</form:form><br><br>
	<a href="/delete/${team.id}">delete</a>
	

</body>
</html>