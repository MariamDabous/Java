<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 class="welcome">Hello ,<c:out value="${currentUser.userName}"/> Welcome to..</h2>
<h1>The Book Broker!</h1>
<p>Available Books to Borrow</p>
<a href="/logout">logout</a>
<a href="/book/new">+ Add a to my shelf!</a>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Owner</th>
		<th>Actions</th>
	</tr>
		<c:forEach var="book" items="${books}">
		<c:choose>
		<c:when test="${book.borrower.id eq null or book.user.id eq currentUser.id}">
		<tr>
			<td> ${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.author}</td>
			<td>${book.user.userName} </td>
			<td>
			<c:choose>
	    <c:when test="${book.user.id eq currentUser.id }">
	        <a href="/book/edit/${book.id}">edit</a>  <a href="delete/${book.id}">delete</a> 
	        <br />
	    </c:when>    
	    <c:otherwise>
	        <a href="/borrow/${book.id }">Borrow</a>
	        <br />
	    </c:otherwise>
	</c:choose>
	</td>
		</tr>
		</c:when> 
		</c:choose>
		</c:forEach>
		
</table>
<br>
<p>Books I'm Borrowing..</p>
<br>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Owner</th>
		<th>Actions</th>
	</tr>
	<c:forEach var="book" items="${currentUser.borrowedBooks}">
	<tr>
		<td>${book.id}</td>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.user.userName}</td>
		<td><a href="/return/${book.id }"> return</a> </td>
	
	</tr>
	</c:forEach>
</table>

</body>
</html>