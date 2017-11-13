<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/register.css">


</head>
<body>

	<h1 align="center">SignIn</h1>

	<div classx="container">
		<div class="row">
			<div class="form_bg col-lg-4 col-md-6 col-sm-8 col-xs-12">
				<form action="login" name="myForm" id="myForm" method="post">
					<div class="form-group">
						<label><b>Email</b></label> <input type="email"
							class="form-control" id="mail" name="mail" placeholder="email"
							required> <span style="color: red;" id="error1"></span>
					</div>

					<div class="form-group">
						<label><b>Password</b></label> <input type="password"
							class="form-control" id="pass" placeholder="password" name="pass"
							required> <span id="error2" style="color: red;"></span>
					</div>

					<div class="align-center">
						<button type="submit" class="btn btn-primary" id="submit">Signin
						</button>

						<a href="singin.jsp" class="btn btn-primary" role="button">Singup</a>
					</div>

				</form>
</body>
</html>