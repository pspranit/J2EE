
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Asset</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>


	<div class="container-fluid">
		<div class="row py-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Asset Page</h4>

						<form action="assetlink" method="post">


							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Name</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="name">
								<div id="emailHelp" class="form-text"></div>
							</div>

							<h5>Select Operating System:</h5>
							<select name="dropdown">
								<option value="">Select</option>
								<option value="Linux">Linux</option>
								<option value="Windows">Windows</option>
								<option value="Mac">Mac</option>
								<option value="Android">Android</option>
							</select>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Version </label> <input type="text" class="form-control"
									id="exampleInputPassword1" name="version">
							</div>

							<div>
								<h5>Select Screen Size</h5>
								<input type="radio" name="radio" value="13 inch"> 13
								inch <input type="radio" name="radio" value="14 inch">
								14 inch <input type="radio" name="radio" value="15 inch">
								15 inch
							</div>

							<br>
							<div class="mb-3">
								<h5>is5GSupported:</h5>
								<input type="checkbox" name="checkbox" value="yes">
								yes <input type="checkbox" name="checkbox" value="no">
								No
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Notes </label>
								<textarea type="text" class="form-control"
									id="exampleInputPassword1" name="notes"></textarea>
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