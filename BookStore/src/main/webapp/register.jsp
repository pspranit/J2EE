<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="component/allcss.jsp"%>

</head>
<body style="background-color: #f7faf8;">
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid">
		<div class="row py-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Registration Page</h4>

						<%
						String success = (String) session.getAttribute("successMsg");
						String error = (String) session.getAttribute("errorMsg");

						if (success != null) {
						%>
						<h4 class="text-center text-primary"><%=success%></h4>
						<%
						session.removeAttribute("successMsg");
						}
						if (error != null) {
						%>
						<h4 class="text-center text-danger"><%=error%></h4>
						<%
						session.removeAttribute("errorMsg");
						}
						%>


						<form action="register" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									UserName</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="username">
								<div id="emailHelp" class="form-text"></div>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Contact</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="contact">
								<div id="emailHelp" class="form-text"></div>
							</div>
							
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Address</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="address">
							</div>
							
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Email</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="email">
							</div>


							<div>
								<label class="ps1">Gender</label> <input class="ps"
									placeholder="select your gender" type="radio" name="gender"
									value="male">male <input class="ps" type="radio"
									name="gender" value="female">Female
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Password</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary text-center">Register</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>