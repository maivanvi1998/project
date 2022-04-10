<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="header.css" type="text/css">
</head>
<body>

	<div class="left" style="float: left; width: 15%; margin-left: 5%">
		<h2 style="color: red;">PRJ321x</h2>
		<p style="color: blue;">Welcom to my Website</p>
	</div>

	<div class="right" style="float: left; width: 80%; margin-top: 30px;">
		<form action="SearchController" method="post">
			<button style="height: 36px;" class="btn">Categories</button>
			<input value="${searchValue}" style="height: 36px; width: 80%" class="input" type="text"
				name="search" placeholder="What are you looking for?">
			<input style="background-color: orange; height: 36px; width: 30px;" type="submit" value="">
		</form>


	</div>


	<div class="topnav" style="clear: left;">
		<div class="nava">
			<a style="color: orange; margin-left: 250px;" href="HomeControll">Home</a> <a
				href="#">Products</a> <a href="#">About us</a>
		</div>
		<a id="login" href="#" style="float: right;">Register</a> <a
			id="login" href="login.jsp" style="float: right;">Login</a>

	</div>
</body>
</html>