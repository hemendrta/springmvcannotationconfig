<%@page import="java.util.ArrayList"%>
<%@page import="springmvcdemo.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<html>
<head>
<%@include file="./utilities.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center">Employees</h4>
				<table class="table table-dark mt-3">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Contact</th>
							<th scope="col">Email</th>
							<th scope="col">Operation</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Employee> employees = (List<Employee>) request.getAttribute("employees");

						for (Employee employee : employees) {
						%>
						<tr>
							<th scope="row"><%=employee.getId()%></th>
							<td><%=employee.getName()%></td>
							<td><%=employee.getContact()%></td>
							<td><%=employee.getEmail()%></td>
							<td><a
								href="employees/deleteEmployeeRecord/<%=employee.getId()%>"><i
									class="fas fa-trash text-danger"></i></a><a
								href="employees/updateEmployeeRecordForm/<%=employee.getId()%>"><i
									class="far fa-edit mx-3"></i></a></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="employees/employeeForm" class="btn btn-success">Add
						Employee</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
