<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="component/allcss.jsp"%>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row py-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Login Page</h4>

						<%
						String error = (String) session.getAttribute("invalidMsg");

						if (error != null) {
						%>
						<h5 class="text-center text-danger"><%=error%></h5>

						<%
						session.removeAttribute("invalidMsg");
						}
						%>


						<%
						String logMsg = (String) session.getAttribute("logMsg");

						if (logMsg != null) {
						%>
						<h6 class="text-center text-primary"><%=logMsg%></h6>

						<%
						session.removeAttribute("logMsg");
						}
						%>


						<form action="userlogin" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Username </label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="username">
								<div id="emailHelp" class="form-text"></div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary text-center">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>