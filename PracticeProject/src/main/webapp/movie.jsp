<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	double totalBill=(double)request.getAttribute("count");

	
%>

<% if(totalBill!=0){%>
<h1>TOTAL BILL:<%=totalBill %> </h1>

<%}else { %>

<h1>SHOW HOUSEFULL</h1>
<%} %>

</body>
</html>