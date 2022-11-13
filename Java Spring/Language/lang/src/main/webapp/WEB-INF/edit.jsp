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
<h3><a href="/languages" >Dashboard</a></h3>
<form:form action="/editlanguages/${language.id}" method="post" modelAttribute="language">
<input type="hidden" name="_method" value="put">
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