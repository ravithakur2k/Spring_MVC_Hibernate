<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<!-- Add the new Button: Add Customer -->

			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd';return false"
				class="add-button">
			<!--  add our html table here -->
			<table border="1">
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<!-- loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}">
						<c:url var="updatelink" value="/customer/showFormForUpdate">
							<c:param name="customerid" value="${tempCustomer.id}"></c:param>
						</c:url>
						<c:url var="deletelink" value="/customer/delete">
							<c:param name="customerid" value="${tempCustomer.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href="${updatelink}">Update</a> | <a
								href="${deletelink}"
								onclick="if(!(confirm('Are you sure you want to delete the customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>