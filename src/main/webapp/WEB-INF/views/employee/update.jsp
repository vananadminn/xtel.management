<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update employee</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<base href='<c:url value="/"></c:url>'>
</head>
<body>
	<div class="container">
		<h1 class="well">Update Form Employee</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="employee.html">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>ID</label> <input type="text" name="id"
									value="${list.getId()}" required="required" readonly="readonly"
									placeholder="not edit" class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Full Name</label> <input type="text" name="name"
									value="${list.getName()}" required="required"
									placeholder="Enter Full Name Here..." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Phone</label> <input type="text" name="phone"
									value="${list.getPhone()}" required="required"
									placeholder="Enter Your Phone Here.." class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>Address</label> <input placeholder="Enter Address"
								class="form-control" name="address" required="required"
								value="${list.getAddress()}">
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Age</label> <input type="number" min="20" max="35"
									name="age" required="required" placeholder="Enter Age Here.."
									value="${list.getAge()}" class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>ID Card</label> <input type="text" name="id_card"
									readonly="readonly" placeholder="Not edit"
									value="${list.getId_card()}" class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>Email</label> <input type="email" name="email"
									required="required" placeholder="Enter Email Here.."
									class="form-control" value="${list.getEmail()}">
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Username</label> <input type="text" name="username"
									readonly="readonly" placeholder="not edit" class="form-control"
									value="${list.getUsername()}">
							</div>
							<div class="col-sm-6 form-group">
								<label>Password</label> <input type="password" name="password"
									required="required" placeholder="Enter Password Here.."
									class="form-control" value="${list.getPassword()}">
							</div>
						</div>

						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Employee started working</label> <input type="date"
									name="date_start_work" value="${list.getDate_start_work()}"
									placeholder="Not edit" readonly="readonly" class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>Employee started working official</label> <input
									type="date" required="required" name="date_do_work_official"
									value="${list.getDate_do_work_official()}"
									placeholder="Enter Employee start official date here.."
									class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>Employee end work</label> <input type="date"
									name="date_end_work" value="KXD"
									placeholder="Enter Employee end work date here.."
									class="form-control">
							</div>

						</div>
						<div class="form-group">
							<label>Status</label> <select name="status" class="btn-success"
								required="required">
								<option value="working">Working</option>
								<option value="not working">Not working</option>
							</select>
						</div>
						<div class="form-group">
							<label>Position</label> <select name="position"
								required="required" class="btn-warning">
								<option value="Employee">Employee</option>
							</select>
						</div>

						<div class="control-group">
							<div class="controls">
								<input class="btn btn-large btn-success" type="submit"
									value="Save" name="updateEmployee" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>