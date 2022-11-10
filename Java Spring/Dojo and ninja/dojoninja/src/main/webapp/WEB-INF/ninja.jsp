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
		<form:label path="dojo">Dojo:</form:label>
    	<form:select path="dojo">
        	<c:forEach var="one" items="${dojos}">
        		<form:option value="${one.id}"><c:out value="${one.name}"></c:out></form:option>
        	</c:forEach>
        </form:select>
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