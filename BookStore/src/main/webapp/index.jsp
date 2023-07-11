<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore</title>
<%@include file="component/allcss.jsp"%>
<style>
.back-img {
	background-image: url("images/img.jpg");
	width: 100%;
	height: 92vh;
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	text-shadow: 2px 2px black;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid back-img text-center text-light">
		<h1>Welcome to BookStore App</h1>
	</div>

</body>
</html>