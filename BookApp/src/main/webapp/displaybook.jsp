<%@page import="Model.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
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
<title>Book Table</title>
<style>
.contain {
	display: flex;
	justify-content: center;
	margin-top: 22px;
}

.btn1 {
	display: flex;
	/* border: 2px solid red; */
	justify-content: center;
	margin-right: 10px;
	margin-top: 20px
}

#home {
	height: 40px;
	width: 80px;
	padding: 8px 8px;
	border-radius: 10px;
}

a {
	text-decoration: none;
	color: rebeccapurple;
	font-weight: bold;
	color: black;
}

.btn1 :hover {
	background-color: black;
	color: white;
	box-shadow: 10px 10px 20px blue;
}

.page {
	display: flex;
	justify-content: space-evenly;
	margin-left: 200px;
	margin-right: 200px
}

.a1 {
	margin-left: 10px;
	height: 23px;
	width: 22px;
	color: black;
}

.a1:hover {
	box-shadow: 0px 0px 5px purple;
	border-radius: 80px;
	color: black;
	transition: 0.4s;
}

.a1 span {
	margin-left: 5px;
	padding-bottom: 10px;
}

.next {
	margin-left: 5px;
}

.field {
	color: white;
}

.pk:hover {
	color: blue;
}
</style>
</head>
<body>

	<%
	List<Book> books = (List) session.getAttribute("bookList");

	String pageNo = (String) session.getAttribute("pageNo");
	%>
	<center>

		<h1>BOOK MANAGEMENT</h1>
		<h3>
			CURRENT PAGE NO :
			<%=pageNo%></h3>

	</center>

	<div class="contain">
		<div class="ps">

			<table class="table">
				<thead>
					<tr class="field" bgcolor="grey">
						<th>BOOK_ID</th>
						<th>AUTHOR_NAME</th>
						<th>BOOK_NAME</th>
						<th>BOOK_PRICE</th>
						<th>RATING</th>
						<th>DATE</th>
						<th>USERID</th>
						<th bgcolor="green">UPDATE</th>
						<th bgcolor="red">DELETE</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Book b1 : books) {
					%>
					<tr>
						<td><%=b1.getBookid()%></td>
						<td><%=b1.getAuthorName()%></td>
						<td><%=b1.getBookName()%></td>
						<td><%=b1.getBookPrice()%></td>
						<td><%=b1.getBookRating()%></td>
						<td><%=b1.getPublishedDate()%></td>
						<td><%=b1.getUserId()%></td>
						<td><a href="updatebook.html"><button
									class="btn btn-primary">UPDATE</button></a></td>
						<td><a class="btn btn-danger"
							href="deletelink?id=<%=b1.getBookid()%>">DELETE</a></td>

					</tr>
					<%
					}
					%>
				
				<tbody>
			</table>
		</div>


	</div>

	<%
	int next = Integer.parseInt(pageNo);
	next = next + 1;
	String nextStr = Integer.toString(next);

	int ps = Integer.parseInt(pageNo);

	if (ps > 1) {
		ps = ps - 1;
	} else {
		ps = 1;
	}

	String previous = Integer.toString(ps);
	%>

	<div class="page">
		<a class="pk" href='paginationlink?page=<%=previous%>'><span>Previous</span></a>
		<a class="a1" href='paginationlink?page=1'><span>1</span></a> <a
			class="a1" href='paginationlink?page=2'><span>2</span></a> <a
			class="a1" href='paginationlink?page=3'><span>3</span></a> <a
			class="pk" href='paginationlink?page=<%=nextStr%>'><span>Next</span></a>

	</div>

	<div class="btn1">
		<button id="home">
			<a href="afterlogin.jsp">BACK</a>
		</button>
	</div>

</body>
</html>