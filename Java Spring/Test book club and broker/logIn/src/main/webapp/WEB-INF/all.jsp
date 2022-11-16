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
<title>Insert title here</title>
</head>
<body style="margin: 24px">
	<h2 class="welcome">Welcome ,<c:out value="${currentUser.userName}"/></h2>
	<a href="/logout">logout</a>
	<h1>All Books</h1>
	<table style="width:70%;" class="table table-striped table-bordered ">
	<thead>
		<tr>
			<th>ID</th>
            <th>Title</th>
            <th>author</th>
            <th>posted by</th>
		</tr>
    </thead>
    <tbody>
		<c:forEach var="book" items="${books}">
 			<tr>
	 			<td>${book.id}</td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"/></td>
				<td><c:out value="${book.user.userName}"/></td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
</body>
</html>