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
<h2>${onelang.name}</h2>
<h2>${onelang.creator}</h2>
<h2>${onelang.currentVersion}</h2>
<p><a href="/delete/languages/${onelang.id}">delete</a> </p>
<p><a href="/languages/edit/${onelang.id}">edit</a></p>
</body>
</html>