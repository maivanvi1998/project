<%@page import="javax.print.attribute.standard.Media"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css">
<title>Sign Up</title>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
	<h1 style="text-align: center; color: red;">${mess}</h1>
	<h2 style="text-align: center; color: red;">${error}</h2>
	<div id="logreg-forms">
		<form class="form-signin" action="SignUp" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center;">
				Sign Up</h1>
			<input style="margin-bottom: 3px;" name="user" type="text"
				id="inputEmail" class="form-control" placeholder="Email address"
				required="" autofocus=""> <input name="pass" type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				required=""> <input name="repeatPass" type="password"
				id="inputPassword" class="form-control"
				placeholder="Repeat Password" required="">
			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign up
			</button>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
		</form>
		<br>

	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/script.js"></script>
</body>
</html>