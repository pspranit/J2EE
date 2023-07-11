<%@page import="com.entity.Users"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-secondary ">
	<a class="navbar-brand" href="index.jsp"><i
		class="fa-solid fa-square-phone pl-2 px-2"></i>BookApp</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="addbook.jsp">Add
					Books </a></li>

			<li class="nav-item"><a class="nav-link" href="displaybook.jsp">View
					Books</a></li>
		</ul>

		<%
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
		%>
		<form class="form-inline my-2 my-lg-0">
			<a href="login.jsp" class="btn btn-danger">LOGIN</a> <a
				href="register.jsp" class="btn btn-primary ml-2">REGISTER</a>

		</form>
		<%
		} else {
		%>

		<form class="form-inline my-2 my-lg-0">
			<a type="dropdown" data-toggle="modal" data-target="#profile"
				class="btn btn-primary text-light"><%=user.getUserName()%></a> <a
				data-toggle="modal" data-target="#exampleModalCenter"
				class="btn btn-danger ml-2 text-white">Logout</a>
		</form>


		<div class="modal fade" id="profile" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header bg-light text-dark ">
						<h5 class="modal-title" id="exampleModalLongTitle">User
							Profile</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body text-center">
						<h6>
							User Name :
							<%=user.getUserName()%></h6>
						<h6>
							Contact :
							<%=user.getContact()%></h6>

						<h6>
							Address :
							<%=user.getAddress()%></h6>

						<h6>
							Email :
							<%=user.getEmail()%></h6>

						<h6>
							Gender :
							<%=user.getGender()%></h6>
						<h6>
							Password :
							<%=user.getPassword()%></h6>

						<button type="button" class="btn btn-secondary mt-2"
							data-dismiss="modal">Ok</button>

					</div>

					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<%
		}
		%>
	</div>

	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-warning text-light ">
					<h5 class="modal-title text-purple" id="exampleModalLongTitle">Logout
						Pop-Up</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body text-center">
					<h6>Do you want Logout..</h6>

					<button type="button" class="btn btn-secondary mt-2"
						data-dismiss="modal">Close</button>
					<a href="userlogout" class="btn btn-danger mt-2 ml-2">Logout</a>
				</div>

				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
</nav>