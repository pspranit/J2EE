<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arithmatic Operations</title>
<style>
body{
background-color: grey;
}
.container{
display: flex;
margin:0px;
justify-content: center;
align-content: center;
}
.main{
background-color: aqua;
padding-left: 20px;
padding-right: 20px;
border-radius: 20px;


}
h1{
display: flex;
justify-content: center;
margin-top: 150px;
color:red;
text-decoration: underline;
text-shadow: 2px 2px yellow;
}
h2{
color:purple;
}
</style>
</head>
<body>


<%

int finalAdd=(int)request.getAttribute("addResult");
int finalSub=(int)request.getAttribute("subResult");
int finalMulti=(int)request.getAttribute("multiResult");
double finalDiv=(double)request.getAttribute("divResult");

%>
<h1><b>CALCULATOR</b></h1> 

<div class="container">
<div class="main">
<h2>ADDITION IS :<%=finalAdd %></h2>
<h2>SUBSTRACTION IS :<%=finalSub %></h2>
<h2>MULTIPLICATION IS :<%=finalMulti %></h2>
<h2>DIVISION IS :<%=finalDiv %></h2>
</div>
</div>




</body>
</html>