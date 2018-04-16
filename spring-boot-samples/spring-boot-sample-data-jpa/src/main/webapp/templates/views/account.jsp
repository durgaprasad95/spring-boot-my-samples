<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User-Account Page</title>
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
<body>
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
							<li><a href="home">Home</a></li>
							<li><a href="cart">Cart</a></li>
							<li><a href="account">${user.username}</a></li>
							<li><a href="logout">Log Out</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="eror">Home</a></li>

						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
		</nav>
	</div>
	<div class="row-fluid">
		<div id="account-menu" class="span2 navbar-inverse">
			<ul class="nav navbar-inner nav-pills nav-stacked">
				<li class="active"><a data-toggle="tab" href="#user">User</a></li>
				<li><a data-toggle="tab" href="#value">Value</a></li>
				<li><a data-toggle="tab" href="#menu2">CSS</a></li>
				<li><a data-toggle="tab" href="#menu3">About</a></li>
			</ul>
		</div>

		<div id="account-content" class="span7 pull-right tab-content">
			<div id="user" class="tab-pane active">
				<h3>HOME</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div id="value" class="tab-pane">
				<h3>Menu 1</h3>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div id="menu2" class="tab-pane">
				<h3>Menu 2</h3>
				<p>Sed ut perspiciatis unde omnis iste natus error sit
					voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			</div>
			<div id="menu3" class="tab-pane">
				<h3>Menu 3</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi
					architecto beatae vitae dicta sunt explicabo.</p>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="jquery-1.8.3.js">
		
	</script>
	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>