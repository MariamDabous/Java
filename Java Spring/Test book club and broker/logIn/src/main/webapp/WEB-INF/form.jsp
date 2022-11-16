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
	<h2 class="welcome">Welcome ,<c:out value="${currentUser.userName}"/></h2>
	<h1>Add a Book to Your Shelf!</h1>
	<a href="/logout">logout</a>
	<form:form action="/createbook" method="post" modelAttribute="book">
	<form:input type="hidden" path="user" value="${currentUser.id}"/>
    	<p>
        	<form:label path="title">Title:</form:label>
        	<form:errors path="title"/>
        	<form:input path="title"/>
    	</p>
    	<p>
        	<form:label path="author">Author:</form:label>
        	<form:errors path="author"/>
        	<form:input path="author"/>
    	</p>
    	<p>
        	<form:label path="thoughts">My thoughts:</form:label>
        	<form:errors path="thoughts"/>
        	<form:input path="thoughts"/>
    	</p>
        <input type="submit" value="Create"/>
	</form:form>

</body>
</html>