<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Result page</title>

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

String status=(String)session.getAttribute("delete");

PrintWriter pw=response.getWriter();

%>

<%if(status.equals("yes")){%> 
        
       <h1 style='color:purple'>BOOK DELETED SUCCESSFULLY !!</h1>
   <%}else{%>
  <h1  style='color:red'>INVALID BOOK ID !!</h1>
    <%}%>

<div class="btn1">
    <button id="home"><a href="displaybook.jsp">BACK</a></button> 
</div>    
</body>
</html>