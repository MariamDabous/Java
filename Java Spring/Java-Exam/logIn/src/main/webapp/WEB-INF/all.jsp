<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body style="margin: 24px">
	<h2 class="welcome">Welcome, <c:out value="${currentUser.userName}"/>!</h2><br>
	<a href="/logout">logout</a><br><br><br>
	<table style="width:70%;" class="table table-striped table-bordered ">
	<thead>
		<tr>
			<th>Team Name</th>
            <th>Skill Level (1-5)</th>
            <th>Game Day</th>
		</tr>
    </thead>
    <tbody>
		<c:forEach var="team" items="${teams}">
 			<tr>
	 			<td><a href="teams/${team.id }">${team.name}</a></td>
				<td>${team.level}</td>
				<td>${team.gameday}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
    <form:form action="/teams/new" method="get">
    	<input type="submit" value="Create New Team"/>
	</form:form>
</body>
</html>