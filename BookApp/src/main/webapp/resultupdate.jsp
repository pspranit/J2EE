<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Update Result</title>

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
String update=(String)session.getAttribute("update");
%>

<h1><%=update%></h1>


<div class="btn1">
    <button id="home"><a href="displaybook.jsp">BACK</a></button> 
</div>    
</body>
</html>