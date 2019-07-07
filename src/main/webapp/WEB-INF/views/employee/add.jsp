<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
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
		<h1 class="well">Registration Form Employee</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="employee.html" method="post">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Full Name</label> <input type="text" name="name"
									required="required" placeholder="Enter Full Name Here..."
									class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Phone</label> <input type="text" name="phone"
									required="required" placeholder="Enter Your Phone Here.."
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." class="form-control"
								name="address" required="required"></textarea>
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Age</label> <input type="number" min="20" max="35"
									name="age" required="required" placeholder="Enter Age Here.."
									class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>ID Card</label> <input type="text" name="id_card"
									required="required" placeholder="Enter ID Card Here.."
									class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>Email</label> <input type="email" name="email"
									required="required" placeholder="Enter Email Here.."
									class="form-control">
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Username</label> <input type="text" name="username"
									required="required" placeholder="Enter Username Here.."
									class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Password</label> <input type="password" name="password"
									required="required" placeholder="Enter Password Here.."
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>Employee started working</label> <input type="date"
								required="required" name="date_start_work"
								placeholder="Enter Phone Number Here.." class="form-control">
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
									value="Save" name="addEmployee" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>