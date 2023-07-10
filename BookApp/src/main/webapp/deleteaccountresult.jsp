<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update R Profile Page</title>

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
String deleteAccount=(String)session.getAttribute("deleteaccount");
PrintWriter pw=response.getWriter();
if(deleteAccount.equals("true"))
{
	pw.print("<h1>ACCOUNT DELETED SUCCESSFULLY</h1>");
}
else{
	pw.print("<h1>PLZZ ENTER VALID USERNAME AND PASSWORD</h1>");
}
%>

<div class="btn1">
    <button id="home"><a href="index.html">HOME</a></button> 
</div>    
</body>
</html>