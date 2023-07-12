<%@page import="model.Asset"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="DAO.DAOAsset"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.ps {
	height: 40px;
	margin-left: 900px;
	margin-top: 8px;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

	<%
	DAOAsset asset = new DAOAsset(DBConnect.getConn());
	List<Asset> list = (List) asset.showAsset();
	%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center">
			<h1 class="text-primary">ASSET LIST</h1>
			<a class="btn btn-secondary ps" href="addAsset.jsp">ADD ASSET</a>
		</div>
		<%
		String mssg = (String) session.getAttribute("success");
		if (mssg != null) {
		%>
		<h1 class="text-danger"><%=mssg%></h1>
		<%
		session.removeAttribute("success");
		}
		%>
		<table class="table">
			<thead class="table-light">
				<td>Id</td>
				<td>Name</td>
				<td>Operating System</td>
				<td>Version</td>
				<td>ScreenSize</td>
				<td>is5GSupported</td>
				<td>Notes</td>
			</thead>
			<tbody>
				<%
				if (list != null) {
					for (Asset asset2 : list) {
				%>
					<td><%=asset2.getId() %></td>
					<td><%=asset2.getName() %></td>
					<td><%=asset2.getOperatingSystem()%></td>
					<td><%=asset2.getVersion()%></td>
					<td><%=asset2.getScreenSize()%></td>
					<td><%=asset2.getIs5GSupported() %></td>
					<td><%=asset2.getNotes() %></td>
			</tbody>
			<%
			}
			}
			%>

		</table>
	</div>
</body>
</html>