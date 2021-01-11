<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="./utilities.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success!!!</title>
</head>
<body class="bg-secondary">
	<div class="container mt-5">
		<div class="text-center">

			<%
				String message = (String) request.getAttribute("message");
			%>

			<div class="alert alert-success py-1" role="alert">
				<h5><%=message%>!!!
				</h5>
			</div>
			<a href="${pageContext.request.contextPath}/" class="btn btn-warning">Home</a>
		</div>
	</div>
</body>
</html>