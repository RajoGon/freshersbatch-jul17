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
    <form action='controller?forward=historybooks' method='post' >
    	<input type='checkbox' name='cbooks' value='C'> C<br>
    	<input type='checkbox' name='cbooks' value='C++' > C++<br>
    	<input type='checkbox' name='cbooks' value='Java' > Java<br>
    	<input type='submit' value='Submit'>
    </form>
</body>
</html>