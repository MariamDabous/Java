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
<h1>${categories.name}</h1>
<h2>Categories:</h2>
<ul>
	<c:forEach var="x" items="${categories.products}">
	<li>${x.name }</li>
	</c:forEach>
</ul>
<form:form action="/addproduct/${categories.id}" method="post" modelAttribute="category">
    	<p>
        	<p>Add Product:</p>
        	<select name="products">
        	<c:forEach var="one" items="${products}">
        		<option value="${one.id}"><c:out value="${one.name}"></c:out></option>
        	</c:forEach>
        </select>
    	</p>
        <input type="submit" value="Add"/>
	</form:form>


</body>
</html>