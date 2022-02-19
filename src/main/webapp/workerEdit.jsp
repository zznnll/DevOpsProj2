<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Workers Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Update Worker Details</title>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Worker Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/WorkerManageServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${worker != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${worker == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${worker != null}">
Edit Worker Details
</c:if>
						<c:if test="${worker == null}">
Add New Worker
</c:if>
					</h2>
				</caption>
				<c:if test="${worker != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${worker.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Worker's Name</label> <input type="text"
						value="<c:out
value='${worker.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Birth Date</label> <input type="text"
						value="<c:out
value='${worker.date}' />" class="form-control"
						name="date">
				</fieldset>
				<fieldset class="form-group">
					<label>Gender</label> <input type="text"
						value="<c:out
value='${worker.gender}' />" class="form-control"
						name="gender">
				</fieldset>
				<fieldset class="form-group">
					<label> Mobile Number</label> <input type="text"
						value="<c:out
value='${worker.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<fieldset class="form-group">
					<label> Job Scope</label> <input type="text"
						value="<c:out
value='${worker.role}' />" class="form-control"
						name="role">
				</fieldset>
				<fieldset class="form-group">
					<label> Job Type</label> <input type="text"
						value="<c:out
value='${worker.type}' />" class="form-control"
						name="type">
				</fieldset>
				<fieldset class="form-group">
					<label> Email</label> <input type="text"
						value="<c:out
value='${worker.email}' />" class="form-control"
						name="email">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>