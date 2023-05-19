<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.container{
display: flex;
justify-content: center;
margin-top: 100px;
}
.table1{
	margin-right:20px;
}
</style>
</head>
<body>

<%

ArrayList<Integer> even=new ArrayList<>();
ArrayList<Integer> odd=new ArrayList<>();

String start=request.getParameter("start");
String end=request.getParameter("end");

int startpoint=Integer.parseInt(start);
int endpoint=Integer.parseInt(end);


for(int i=startpoint;i<=endpoint;i++)
{
	if(i%2==0)
	{
			even.add(i);
			
	}
	else{	
			odd.add(i);
	}
}
%>
<div class="container">
<div class="table1">

  <table border="4px" cellpadding="10px">
    <tr>
      <th bgcolor="red">EVEN</th>   
    </tr>
    
    <%
    for(int e:even)
    {%>
    <tr><td><%=e%></td></tr>
     <%}%> 			  
    
  </table>
  </div>
  
  <div class="table1">
  
    <table border="4px" cellpadding="10px">
    <tr>
      <th bgcolor="yellow">ODD</th>
    </tr>
    <%
    for(int o:odd)
    {%>
    <tr><td><%=o%></td></tr>
     <%}%> 	
  </table>
  </div>
  </div>
</body>
</html>