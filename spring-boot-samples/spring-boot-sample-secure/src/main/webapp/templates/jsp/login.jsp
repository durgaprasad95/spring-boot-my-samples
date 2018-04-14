<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.username.focus();'>
	<h3>Custom Login Page</h3>
	<c:if test="${not empty error }">
		<div class="errorblock">
			Your login was unsuccessful.<br /> Caused:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>
	<form action="/secure/login" name="f" method="post">
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" name="username" value="" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Submit" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="reset" value="Reset" /></td>
			</tr>
		</table>

	</form>
</body>
</html>