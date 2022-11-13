<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
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
<table border="1">
	<tr>
		<th>Name</th>
		<th>Creator</th>
		<th>Version</th>
		<th>Action</th>
	</tr>
	<c:forEach var="lang" items="${languages}">
	<tr>
		<td><a href="/languages/${lang.id}"> ${lang.name}</a></td>
		<td>${lang.creator}</td>
		<td>${lang.currentVersion}</td>
		<td><a href="/delete/languages/${lang.id}">delete</a> <a href="/languages/edit/${lang.id}">edit</a> </td>
	</tr>
	</c:forEach>
</table>
<form:form action="/createlang" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator:</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>    
    <p>
        <form:label path="currentVersion">Version:</form:label>
        <form:errors path="currentVersion"/>
        <form:textarea path="currentVersion"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>