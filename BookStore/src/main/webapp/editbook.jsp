<%@page import="com.entity.Books"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.BooksDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<%@include file="component/allcss.jsp"%>

</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Please Login..");
		response.sendRedirect("login.jsp");
	}
	%>

	<div class="container-fluid">
		<div class="row py-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Update Book Page</h4>

						<%
						String success = (String) session.getAttribute("successAdd");
						String error = (String) session.getAttribute("errorAdd");

						if (success != null) {
						%>
						<h4 class="text-center text-primary"><%=success%></h4>
						<%
						session.removeAttribute("successAdd");
						}
						if (error != null) {
						%>
						<h4 class="text-center text-danger"><%=error%></h4>
						<%
						session.removeAttribute("errorAdd");
						}
						%>

						<form action="updatebook" method="post">

							<%
							int bid = Integer.parseInt(request.getParameter("bid"));
							BooksDAO booksDAO = new BooksDAO(DBConnect.getConn());
							Books book = booksDAO.getBooktById(bid);
							%>
							<input type="hidden" value="<%=bid%>" name="bid">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Author Name</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="aname" value="<%=book.getAuthorNAme()%>">
								<div id="emailHelp" class="form-text"></div>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter Book Name
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="bname" value="<%=book.getBookName()%>">
								<div id="emailHelp" class="form-text"></div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter Book Price
									</label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="bprice"
									value="<%= book.getBookPrice()%>">
							</div>
							
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter Book Rating
									</label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="brating"
									value="<%= book.getBookRating()%>">
							</div>
							
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter Published Date
									</label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="bdate"
									value="<%= book.getPublishedDate()%>">
							</div>

						
							<div class="text-center">
								<button type="submit" class="btn btn-primary text-center">Update
									Contact</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>