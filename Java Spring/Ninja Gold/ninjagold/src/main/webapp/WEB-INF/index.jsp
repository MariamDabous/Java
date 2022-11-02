<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
    <label><h2>Your Gold:</h2></label>
    <div>${gold}</div>
    </header>
    <main>
    <form action="/process_farm"method="post">
        <h3>Farm</h3>
        <p>(earns 10-20 gold)</p>
        <button>Find Gold!</button>
    </form>

    <form action="/process_cave"method="post">
        <h3>Cave</h3>
        <p>(earns 10-20 gold)</p>
        <button>Find Gold!</button>
    </form>

    <form action="/process_house"method="post">
        <h3>House</h3>
        <p>(earns 10-20 gold)</p>
        <button>Find Gold!</button>
    </form>

    <form action="/process_quest"method="post">
        <h3>Quest</h3>
        <p>(earns/takes 0-50 gold)</p>
        <button>Find Gold!</button>
    </form>
    </main>
    <footer>
        <label><h2>Activities:</h2></label><br>
        <textarea cols="100" rows="8" name="activities">
           <c:forEach var="onecomment" items="${comm}">
                <c:out value="${onecomment}"></c:out>  <%= new Date() %> 
        </c:forEach>
        </textarea>
    </footer>

</body>
</html>