<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1><br><br>
<a href="/products/new">New Product</a><br><br>
<a href="/categories/new">New Category</a><br><br>
<table border="1">
	<tr>
		<th>Products</th>
		<th>Categories</th>
	</tr>
	<tr>
		<td>
			<ul>
				<c:forEach var="pro" items="${products}">
					<li>${pro.name}</li>
				
				 </c:forEach>
			</ul>
		</td>
		<td>
			<ul>
				<c:forEach var="cat" items="${categories}">
					<li>${cat.name}</li>
				
				 </c:forEach>
			</ul>
		</td>
	</tr>
</table>
	
</body>
</html>