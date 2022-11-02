<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/submit" method="POST">
		<label>Pick any number from 5 to 25</label><br>
		<input type="number" name="num" min="5" max="25"><br><br>
		
		<label>Enter the name of any city</label><br>
		<input type="text" name="city"><br><br>
		
		<label>Enter the name of any real person</label><br>
		<input type="text" name="person"><br><br>
		
		<label>Enter professional endeavor or hoppy:</label><br>
		<input type="text" name="hoppy"><br><br>
		
		<label>Enter any type of living thing</label><br>
		<input type="text" name="living"><br><br>
		
		<label>Say something nice to someone</label><br>
		<input type="text" name="nice"><br><br>
		
		<label>Send and show a friend</label><br>
		<input type="submit">
		

	</form>
</body>
</html>