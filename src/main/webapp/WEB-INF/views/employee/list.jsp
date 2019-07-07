<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>List Employees</title>
<base href='<c:url value="/"></c:url>'>
<style>
#employee {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 90%;
	margin: auto;
}

#employee td, #employee th {
	border: 1px solid #ddd;
	padding: 8px;
}

#employee tr:nth-child(even) {
	background-color: #f2f2f2;
}

#employee tr:hover {
	background-color: #ddd;
}

#employee th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>

</head>
<body>
	<div style="margin: auto">
		<table id="employee">
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Age</th>
				<th>Address</th>
				<th>Email</th>
				<th>ID card</th>
				<th>Username</th>
				<th>Password</th>
				<th>Date start work</th>
				<th>Date do work</th>
				<th>Date end work</th>
				<th>Status</th>
				<th>Position</th>
				<th>Actions
				<th><a style="color: black; text-align: center"
					href="/management/employee/add.html">Add new</a></th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.getName()}</td>
					<td>${list.getPhone()}</td>
					<td>${list.getAge()}</td>
					<td>${list.getAddress()}</td>
					<td>${list.getEmail()}</td>
					<td>${list.getId_card()}</td>
					<td>${list.getUsername()}</td>
					<td>* ${list.getPassword()} *</td>
					<td>${list.getDate_start_work()}</td>
					<td>${list.getDate_do_work_official()}</td>
					<td>${list.getDate_end_work()}</td>
					<td>${list.getStatus()}</td>
					<td>${list.getPosition()}</td>
					<td><a type="button" class="btn btn-danger"
						href="employee/delete.html?id=${list.getId()}">Delete</a></td>
					<td><a type="button" class="btn btn-warning" onclick=""
						href="employee/update/${list.getId()}.html">Update</a></td>
				</tr>
			</c:forEach>
		</table>

		<c:if test="${empty list}">
			<div class="alert alert-warning">
				<strong>Warning!</strong> ${listIsEmpty}
			</div>
		</c:if>

	</div>
</body>
</html>