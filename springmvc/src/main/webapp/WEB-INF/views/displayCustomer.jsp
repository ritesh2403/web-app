<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List By ritesh ghorui</title>
</head>
<body>
<p>welcome to portal by devilicious-luffy</p>
	<form>
		<br> <br>
		<table>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Action</th>
			</tr>

<c:url var="loadLink" value="/customer/loadData">
			</c:url>
			<c:forEach var="tempCustomers" items="${customers}">
			
				<c:url var="updateLink" value="/customer/update">
				<c:param name="customerId" value="${tempCustomers.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerdelId" value="${tempCustomers.id}"></c:param>
				</c:url>
				<tr>
					<td>${tempCustomers.firstName}</td>
					<td>${tempCustomers.lastName}</td>
					<td>${tempCustomers.email}</td>
					<td><a href="${updateLink}">Update</a> | <a
						href="${deleteLink}"
						onclick="if (!confirm('Are you sure you want to delete this customer?')) { return false }">Delete</a>
					</td>

				</tr>


			</c:forEach>
			
			
			
		</table>
		<a href="${loadLink}">Load Data</a>
	</form>
</body>
</html>
