<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Computer Books</title>
</head>
<body>
<%@ page import="java.util.*" %>
<% 
	String uname = (String)session.getAttribute("uname"); 
%>
<h1>Welcome <%= uname %> </h1>
    <form action='controller?forward=cartpage' method='post' >
    	<input type='checkbox' name='hbooks' value='Indian History'>Indian History<br>
    	<input type='checkbox' name='hbooks' value='Roman History' >Roman History<br>
    	<input type='checkbox' name='hbooks' value='Greek History' >Greek History<br>
    	<input type='submit' value='Submit'>
    </form>
</body>
</html>