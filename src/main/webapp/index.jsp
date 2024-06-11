<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>This is HTML Code</h1>
	<%
       int a=7;
       System.out.println(a+" is a Number");
     %>

	<%! int b=8; %>

	<% System.out.print(a); %>

	<h1><%= b %></h1>

	<h3 style="color: blue"><%= LocalDate.now() %></h3>

	<%@include file="insert.html"%>

    <%= this %>

</body>
</html>