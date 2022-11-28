<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Details</title>
</head>
<body>
	<h1>${teams.name}</h1><br>
	<a href="/home">dashboard</a><br>
	<h2>Team Name: ${teams.name} </h2>
	<h2>Skill Level: ${teams.level}</h2>
	<h2>Game Day: ${teams.gameday}</h2>
	<h2>Players:</h2>
	<c:forEach var="user" items="${teams.users}">
		<ul>
			<li>${user.userName }</li>
		</ul>
	</c:forEach><br>
	<h3>Add Player:</h3><br>
	<form:form action="/addplayer/${teams.id}" method="post" modelAttribute="product">
		<table border="1">
			<tr>
				<td>Player Name:</td>
				<td>
					<select name="players">
			        	<c:forEach var="one" items="${players}">
			        		<option value="${one.id}"><c:out value="${one.userName}"></c:out></option>
			        	</c:forEach>
		        	</select>
	        	</td>
			</tr>
		</table>
		<input type="submit" value="Add"/>
	</form:form><br><br>
	<a href="/teams/${team.id}/edit">edit</a><br>
	<a href="/delete/${team.id}">delete</a>
	
	
</body>
</html>