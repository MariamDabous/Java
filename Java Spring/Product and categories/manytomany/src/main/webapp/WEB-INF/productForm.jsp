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
	<h1>New Product</h1>
	<form:form action="/createproduct" method="post" modelAttribute="product">
    	<p>
        	<form:label path="name"> name:</form:label>
        	<form:errors path="name"/>
        	<form:input path="name"/>
    	</p>
    	<p>
        	<form:label path="description">description:</form:label>
        	<form:errors path="description"/>
        	<form:input path="description"/>
    	</p>
    	<p>
        	<form:label path="price">price:</form:label>
        	<form:errors path="price"/>
        	<form:input type="number" path="price"/>
    	</p>
        <input type="submit" value="Create"/>
	</form:form>

</body>
</html>