<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/home.css" rel="stylesheet">
<title>App Page</title>
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
					<li><a href="home">Home</a></li>
					<li><a href="cart">Cart</a></li>
					<li><a href="account">Account</a></li>
					<li class="login"><a href="login">Log In</a></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>
	<script src="jquery-1.8.3.js">
		
	</script>
	<script>
		jQuery(document).ready(function($) {
			$('.container-fluid').invertingImgText();
		});
	</script>
	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>