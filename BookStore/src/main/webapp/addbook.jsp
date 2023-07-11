<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
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
						<h4 class="text-center text-success">Add Book Page</h4>

						<%
						String success = (String) session.getAttribute("successAdd");
						String error = (String) session.getAttribute("errorAdd");

						if (success != null) {
						%>
						<h4 class="text-center text-primary" ><%=success%></h4>
						<%
						session.removeAttribute("successAdd");
						}
						if (error != null) {
						%>
						<h4 class="text-center text-danger" ><%=error%></h4>
						<%
						session.removeAttribute("errorAdd");
						}
						%>			

						<form action="addbook" method="post">

							<%
							if (user != null) {
							%>
							<input type="hidden" value="<%=user.getuId()%>" name="userId">
							<%
							}
							%>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Author Name</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="aname">
								<div id="emailHelp" class="form-text"></div>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter Book Name
									</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="bname">
								<div id="emailHelp" class="form-text"></div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Book Price</label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="bprice">
							</div>
							
								<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Book Rating</label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="brating">
							</div>
							
								<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Published Date</label> <input type="date" class="form-control"
									id="exampleInputPassword1" name="bdate">
							</div>

							
							<div class="text-center">
								<button type="submit" class="btn btn-primary text-center">Add
									Book</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>