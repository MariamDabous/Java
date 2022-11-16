<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${book.title}</h1>
<a href="/books">back to the shelves</a>
<p> ${book.user.userName } read ${book.title} by ${book.author}. </p>
<p>Here are ${book.user.userName }'s thoughts:</p><br>

<p> ${book.thoughts}</p>




</body>
</html>