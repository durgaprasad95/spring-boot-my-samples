<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="assets/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
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
							<li><a href="account">${user.username}</a></li>
							<li><a href="logout">Log Out</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<script src="jquery-1.8.3.js">
		
	</script>
	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>