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
<title>Login</title>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
<%
Cookie[] listCookie = request.getCookies();
String user = "";
String password ="";
if(listCookie != null){
	for(Cookie ck: listCookie){
		if(ck.getName().equalsIgnoreCase("user")){
			user = ck.getValue();
		}
		if(ck.getName().equalsIgnoreCase("pass")){
			password = ck.getValue();
		}
	}
}
%>
	<h1 style="text-align: center; color: red;">${error}</h1>
	<div id="logreg-forms">
		<form class="form-signin" action="LoginController" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center;">
				Sign in</h1>
			<input style="margin-bottom: 3px;" value="<%out.println(user);%>" name="user" type="text" id="inputEmail" class="form-control"
				placeholder="Email address" required="" autofocus=""> 
				<input value="<%out.println(password);%>"
				name="pass" type="password" id="inputPassword" class="form-control"
				placeholder="Password" required=""> 
				<label style="margin-top: 5px;">
				<input
				type="checkbox" name="remember"> Remember me
				</label>
			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<a href="#" id="forgot_pswd">Forgot password?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
			<a href="signup.jsp">
			<button class="btn btn-primary btn-block" type="button"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>
			</a>
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