<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<style>
form>div>label {
	display: inline-block;
	width: 100px;
}
</style>

<link rel="stylesheet" type="text/css"
	href="assets/thirdparty/bootstrap/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assignment 23 - Contacts Manager</title>
</head>
<body>
	<div class="container">
		<h1>Add new person data</h1>
		<hr />

		<form action="add-person" method="POST">
			<div>
				<label>Firstname</label> <input type="text" name="firstname">
			</div>

			<div>
				<label>Lastname</label> <input type="text" name="lastname">
			</div>

			<div>
				<label>Phone</label> <input type="tel" size="40" name="phone">
			</div>

			<div>
				<label>Email</label> <input type="email" size="50" name="email">
			</div>

			<div>
				<label></label> <input type="submit" value="Add">
			</div>
		</form>

		<jsp:include page="./list-all-persons" />

	</div>
</body>
</html>







