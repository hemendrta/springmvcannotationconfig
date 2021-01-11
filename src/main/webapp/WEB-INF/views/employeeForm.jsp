<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./utilities.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page</title>
</head>
<body class="bg-secondary">

	<div class="container mt-4 bg-light">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h4 class="text-center mt-3">Employee Registration Form</h4>
				<%
					
				%>
				<form action="addEmployee" id="employeeRegistration" method="post">
					<!-- 
						private String name;
						private long contact;
						private String email;
						 -->
					<div class="form-group mt-3">
						<label for="name">Employee Name</label> <input
							class="form-control" name="name" id="name"
							placeholder="Employee Name">
					</div>

					<div class="form-group mt-3">
						<label for="contact">Employee Contact Number</label> <input
							class="form-control" name="contact" id="contact"
							placeholder="Employee Contact Number">
					</div>

					<div class="form-group mt-3">
						<label for="email">Employee Email</label> <input
							class="form-control" name="email" id="email"
							placeholder="Employee Email">
					</div>

					<div class="text-center mt-4">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-warning">Back</a>
						<button class="btn btn-success" type="submit">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>