<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/node1.js"></script>
	<meta charset="ISO-8859-1">
	<title>Time</title>
</head>
<body>
  <div class=time>
  <p><c:out value="${formatedtime}"/></p>
  </div>
</body>
</html>