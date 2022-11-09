<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Expense Details</h1>
<a href="/expenses">Go Back</a>
<h2>Expense Name: ${oneExp.name}</h2>
<h2>Expense description: ${oneExp.description }</h2>
<h2>Vendor: ${oneExp.vendor }</h2>
<h2>Amount Spent: ${oneExp.amount}</h2>

</body>
</html>