<%@page import="com.entity.Books"%>
<%@page import="com.dao.BooksDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
<style>
.ps:hover {
	transition:1s;
	background-color: #e8e6e6;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<%
	if (user == null) {
			session.setAttribute("invalidMsg", "Please Login..");
			response.sendRedirect("login.jsp");
		}
	%>

	<%
	String success = (String) session.getAttribute("successAdd");

		if (success != null) {
	%>
	<div class="alert alert-success" role="alert"><%=success%></div>
	<%
	session.removeAttribute("successAdd");
		}
	%>
	<div class="container">
		<div class="row p-3">



			<%
			if (user != null) {
					BooksDAO booksDAO = new BooksDAO(DBConnect.getConn());
					List<Books> bookList = booksDAO.getBooks(user.getuId());
					for (Books c : bookList) {
			%>

			<div class="col-md-3 mt-3">
				<div class="card ps">
					<div class="card-body">
						<h5>
							Author Name :
							<%=c.getAuthorNAme()%></h5>
						<p>
							Book Name :
							<%=c.getBookName()%>
						<p><p>
							Book Price :
							<%=c.getBookPrice()%></p>
						<p>
							Book Rating :
							<%=c.getBookRating()%></p>
							<p>
							Published Date :
							<%=c.getPublishedDate()%></p>
						<div class="text-center">
							<a href="editbook.jsp?bid=<%=c.getBookId()%>"
								class="btn btn-primary btn-sm text-white mr-2">Edit</a>
								 
							<a href="deletecontact?bid=<%=c.getBookId()%>"
								class="btn btn-danger btn-sm text-white mr-2">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>



		</div>
	</div>

</body>
</html>
