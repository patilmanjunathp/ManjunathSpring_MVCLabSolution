<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<div class="container">
	<body>

		<h3 class="btn btn-info col-3">Students Form for ${mode}</h3>
		<form action="save" method="POST">
			<div class="form-inline">
				<input type="hidden" name="studentId" value="${student.studentId}" />
			</div>
			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					placeholder="First Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="lastName" value="${student.lastName}"
					placeholder="Last Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="course" value="${student.course}"
					placeholder="Course" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="country" value="${student.country}"
					placeholder="Country" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-1">Save</button>
		</form>
		<a href="list">Back to Students List</a>
	</body>
</div>
</html>