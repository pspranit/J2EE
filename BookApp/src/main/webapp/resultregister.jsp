<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
<title>User Add Page</title>


   <style>
    h1{
	color:purple;
	}
   .btn1{

            display: flex;
            /* border: 2px solid red; */
            justify-content: center;
            margin-right: 10px;
            margin-top:20px
        }
        #home{
            height: 40px;
            width: 80px;
            padding: 8px 8px;
            
            border-radius: 10px;
        }
        a{
            text-decoration: none;
            color: rebeccapurple;
            font-weight: bold;
            color: black;
        }
        .btn1 :hover{
            background-color: black;
            color: white;
            box-shadow: 10px 10px 20px blue;
        }
</style>
</head>
<body>
<%
String update=(String)session.getAttribute("register");
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
if(update.equals("true"))
{
	pw.print("<<h1>ACCOUNT CREATED SUCCESSFULLY</h1>");
}
else{
	pw.print("<h1>PLZZ ENTER VALID INFORMATION</h1>");
}
%>


<div class="btn1">
    <button id="home"><a href="index.html">HOME</a></button> 
</div>    
</body>
</html>