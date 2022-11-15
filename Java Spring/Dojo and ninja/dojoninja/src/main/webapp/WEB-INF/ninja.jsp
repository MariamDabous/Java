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
	<h1>New Ninja</h1>
	<form:form action="/createninja" method="post" modelAttribute="ninja">
		<label >Dojo:</label>
    	<select name="dojo">
        	<c:forEach var="one" items="${dojos}">
        		<option value="${one.id}"><c:out value="${one.name}"></c:out></option>
        	</c:forEach>
        </select>
    	<p>
        	<form:label path="firstName">First name:</form:label>
        	<form:errors path="firstName"/>
        	<form:input path="firstName"/>
    	</p>
    	<p>
        	<form:label path="lastName">Last name:</form:label>
        	<form:errors path="lastName"/>
        	<form:input path="lastName"/>
    	</p>
    	<p>
        	<form:label path="age">Age:</form:label>
        	<form:errors path="age"/>
        	<form:input path="age"/>
    	</p>
        <input type="submit" value="Create"/>
	</form:form>
</body>
</html>