<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Demo JSP</title>
    </head>
<body>
    <h1>Hiiiiiiiiiiiiiiiii</h1>
    <h1>Two plus two is: <h1>
	<h2><c:out value="${2+2}"/></h2>
    
</body>
</html>