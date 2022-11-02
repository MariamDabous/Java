<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fruit</title>
</head>
<body>
<h1>Fruit Store</h1>
<table border=1>
	<tr>
		<th>name</th>
		<th>price</th>
	</tr>
	<c:forEach var="one" items="${fruits1}">
	<tr>
		<td><c:out value="${one.name}"/></td>
		<td><c:out value="${one.price}"/></td>
	</tr>
	</c:forEach>

</table>
	
    

</body>
</html>