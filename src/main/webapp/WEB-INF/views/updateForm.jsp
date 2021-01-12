<%@page import="springmvcdemo.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./utilities.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Update Page</title>
</head>
<body class="bg-secondary">

	<div class="container mt-4 bg-light">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h4 class="text-center mt-3">Employee Update Form</h4>
				<%
					Employee employee = (Employee) request.getAttribute("employee");
				%>
				<form
					action="${pageContext.request.contextPath}/employees/addEmployee"
					id="employeeRegistration" method="post">
					<!-- 
						private String name;
						private long contact;
						private String email;
						 -->
					<div class="form-group mt-3">
						<label for="contact">Employee Id</label> <input
							class="form-control" name="id" id="id" placeholder="Employee ID"
							value="<%=employee.getId()%>" readonly="readonly">
					</div>

					<div class="form-group mt-3">
						<label for="aadhar">Employee Aadhar</label> <input
							class="form-control" name="aadhar" id="aadhar"
							placeholder="Employee Aadhar" value="<%=employee.getAadhar()%>">
					</div>

					<div class="form-group mt-3">
						<label for="pan">Employee PAN</label> <input class="form-control"
							name="pan" id="pan" placeholder="Employee PAN"
							value="<%=employee.getPan()%>">
					</div>

					<div class="form-group mt-3">
						<label for="name">Employee Name</label> <input
							class="form-control" name="name" id="name"
							placeholder="Employee Name" value="<%=employee.getName()%>">
					</div>

					<div class="form-group mt-3">
						<label for="contact">Employee Contact Number</label> <input
							class="form-control" name="contact" id="contact"
							placeholder="Employee Contact Number"
							value="<%=employee.getContact()%>">
					</div>

					<div class="form-group mt-3">
						<label for="email">Employee Email</label> <input
							class="form-control" name="email" id="email"
							placeholder="Employee Email" value="<%=employee.getEmail()%>">
					</div>

					<div class="form-group mt-3">
						<label for="address">Employee Address</label> <input
							class="form-control" name="address" id="address"
							placeholder="Employee Address" value="<%=employee.getAddress()%>">
					</div>

					<div class="text-center mt-4">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-warning">Back</a>
						<button class="btn btn-success" type="submit">Update
							Details</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>