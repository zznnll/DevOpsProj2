<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<div class="row">
		<div class="container">
		<br></br>
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>BirthDate</th>
						<th>Gender</th>
						<th>Mobile Number</th>
						<th>Job Scope</th>
						<th>Job Type</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="worker" items="${listWorkers}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${worker.name}" /></td>
							<td><c:out value="${worker.date}" /></td>
							<td><c:out value="${worker.gender}" /></td>
							<td><c:out value="${worker.phone}" /></td>
							<td><c:out value="${worker.role}" /></td>
							<td><c:out value="${worker.type}" /></td>
							<td><c:out value="${worker.email}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a class="edit" href="edit?name=<c:out value='${worker.name}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out
value='${worker.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/index.jsp"
					class="btn btn-success">Add New Employee</a>
			</div>
		</div>
	</div>

</body>
</html>