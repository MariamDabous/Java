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
	<h1>All Books</h1>
	<table style="width:70%;" class="table table-striped table-bordered ">
	<thead>
		<tr>
			<th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
		</tr>
    </thead>
    <tbody>
		<c:forEach var="book" items="">
 			<tr>
	 			<td><c:out value=""/></td>
				<td><a href="/books/"><c:out value=""></c:out></a></td>
				<td><c:out value=""/></td>
				<td><c:out value=""/></td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
</body>
</html>