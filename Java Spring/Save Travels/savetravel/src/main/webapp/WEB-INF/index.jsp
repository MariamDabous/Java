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

<h1>Save Travel</h1>
<table border=1>
	<tr>
	<th>Expense</th>
	<th>Vendor</th>
	<th>Amount</th>
	</tr>
	<c:forEach var="exp" items="${expenses}">
	<tr>
		<td><c:out value="${exp.name}"></c:out></td>
		<td>${exp.vendor}</td>
		<td>${exp.amount}</td>
	</tr>
	 </c:forEach>
	
</table>
<h1>Add Expense:</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p>    
    <p>
        <form:label path="description">Language</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>