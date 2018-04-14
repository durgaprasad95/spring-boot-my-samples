<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/home.css" rel="stylesheet">
<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body class="container-fluid">
	<div class="row-fluid">
		<nav class="navbar navbar-inverse">
		<div class="navbar-inner">
			<a class="brand">Carting Site</a> <a class="btn-navbar"
				data-toggle="collapse" data-target=".nav-collapse"> <i
				class="icon-bar"></i> <i class="icon-bar"></i> <i class="icon-bar"></i>
			</a>
			<div class="nav-collapse collapse">
				<ul class="nav pull-right">
					<c:choose>
						<c:when
							test="${sessionScope.user != null || sessionScope.user != ''}">
							<li><a href="eror">Home</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="home">Home</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="cart">Cart</a></li>
					<li><a href="account">Account</a></li>
					<li class="login"><a href="login">Log In</a></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>
	<div class="row-fluid">
		<div class="span7">
			<h1>Enter Your Credentials</h1>
			<form:form modelAttribute="user">
				<table>
					<tr>
						<td>Username: &nbsp;</td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Password: &nbsp;</td>
						<td><form:password path="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td align="center"><input type="submit"
							class="btn btn-primary" value="Log in" /></td>
						<td><a class="btn btn-primary" href="signup"><span>Sign
									Up</span> </a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="jquery-1.8.3.js">
		
	</script>
	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>