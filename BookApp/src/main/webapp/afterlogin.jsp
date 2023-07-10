<%@page import="javax.sound.sampled.Port"%>
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
	crossorigin="anonymous" />
<title>Profile page</title>
<style>
@import
	url("https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap")
	;

* {
	font-family: 'Montserrat', sans-serif;
}

.ps:hover {
	box-shadow: 10px 15px 10px black;
	color: black
}

.ps1:hover {
	box-shadow: 10px 15px 10px yellow;
	color: blue;
}

.ps2:hover {
	box-shadow: 10px 15px 10px blue;
	color: yellow;
}

.ps3:hover {
	box-shadow: 10px 15px 10px red;
	color: white;
}

.col {
	color: white;
}

.row0 .demo {
	margin-top: 30px;
	display: flex;
	justify-content: space-around;
	color: grey;
	margin-left: 224px;
}

.row1 .demo1 {
	display: flex;
	justify-content: space-around;
	color: grey;
	margin-left: 224px;
	padding-right: 123px;
}

.row2 .demo2 {
	display: flex;
	justify-content: space-around;
	color: grey;
	margin-bottom: 40px;
	margin-left: 224px;
	padding-right: 123px;
}

.logout {
	display: flex;
	justify-content: center;
	margin-top: 20px;
	margin-bottom: 10px;
}

#profile {
	display: flex;
	justify-content: space-between;
	opacity: 0.8;
	background-color: #001E3C;
}

h2 {
	color: purple;
}

h1 {
	font-weight: bold;
	color: white;
	margin-top: 10px;
	text-shadow: 2px 2px black;
}

#pro {
	color: grey;
	margin-left: 20px;
}

.main {
	opacity: 0.6;
	transition: 0.5s;
	box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px,
		rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;
	padding-bottom: 10px;
	margin-bottom: 80px;
}

.main:hover {
	opacity: 0.8;
	transition: 0.5s;
}

.pk {
	margin-top: 14px;
	margin-bottom: 17px;
	margin-right: 7px;
}

.pk1 {
	margin-left: 646px;
}
.sk
{
  margin-left: 340px;;
}
</style>
</head>
<body>
	<%!%>

	<%
	int id = (int) session.getAttribute("id");

	String name = (String) session.getAttribute("name");

	long contact = (long) session.getAttribute("contact");

	String address = (String) session.getAttribute("address");

	String email = (String) session.getAttribute("email");

	String gender = (String) session.getAttribute("gender");

	String password = (String) session.getAttribute("password");

	session.setAttribute("userid", id);
	session.setAttribute("username", name);
	session.setAttribute("password", password);
	%>

	<div id="profile">
		<h1 class="pk1">Book Store</h1>
		<a href="deleteaccount.html" class="btn pk sk btn-warning"> DELETE ACCOUNT</a>
		<a href="logoutlink" class="btn pk btn-danger"> LOGOUT</a>

	</div>

	<div class="main">
		<div class="row0 ">
			<h2 id="pro">Profile :</h2>
			<div class="demo">

				<h2>
					USERID :
					<%=id%></h2>
				<hr>
				<h2>
					USERNAME :
					<%=name%></h2>
				<hr>

			</div>
		</div>

		<div class="row1 demo1">
			<div class="demo1">


				<h2>
					CONTACT NO : <i><%=contact%></i>
				</h2>
				<hr>
				<h2>
					ADDRESS :
					<%=address%></h2>
				<hr>

			</div>
		</div>
		<div class="row2 demo2">
			<div class="demo2">

				<h2>
					EMAIL ID :
					<%=email%></h2>
				<hr>
				<h2>
					GENDER :
					<%=gender%></h2>
				<hr>
			</div>
		</div>

		<div class="logout">

			<a href="updateprofile.html" class="btn btn-success">UPDATE
				PROFILE</a>
		</div>
	</div>



	<div class="row mt-5">
		<div class="col">
			<div class="card bg-primary">
				<div class="card-body ps">
					<h2 class="card-title">ADD BOOK</h2>
					<a href="addbook.html" class="btn btn-warning">CLICK HERE</a>
				</div>
			</div>
		</div>


		<div class="col">
			<div class="card bg-danger">
				<div class="card-body ps1">
					<h2 class="card-title">UPDATE BOOK</h2>
					<a href="updatebook.html" class="btn btn-dark">CLICK HERE</a>
				</div>
			</div>
		</div>


		<div class="col">
			<div class="card bg-secondary">
				<div class="card-body ps2">
					<h2 class="card-title">DELETE BOOK</h2>
					<a href="deletebook.html" class="btn btn-danger">CLICK HERE</a>
				</div>
			</div>
		</div>


		<div class="col">
			<div class="card bg-info">
				<div class="card-body ps3">
					<h2 class="card-title">DISPLAY BOOKS</h2>
					<a href="paginationlink?page=1" class="btn btn-primary">CLICK
						HERE</a>
				</div>
			</div>
		</div>




	</div>
	 
</body>
</html>
