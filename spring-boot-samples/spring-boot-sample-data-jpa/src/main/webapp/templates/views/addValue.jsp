<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<style type="text/css">
.table {
	margin-bottom: 20px;
	text-align: center;
}

.borderless td, .borderless tr {
	border: none;
}
</style>
</head>
<body class="container-fluid">
	<h3>Add Prices</h3>
	<form:form modelAttribute="value" servletRelativeAction="/addValue">
		<table class="table borderless">
			<tr>
				<td>Name:</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><form:select path="type">
						<form:option value="" selected="selected"></form:option>
						<form:option value="Fruit">Fruit</form:option>
						<form:option value="Vegetable">Vegetable</form:option>
						<form:option value="Grocery">Grocery</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input type="number" path="units" min="1" max="100" /></td>
			</tr>
			<tr>
				<td>Scale:</td>
				<td><form:select path="measuringScale">
						<form:option value="" selected="selected"></form:option>
						<form:option value="unit">Unit</form:option>
						<form:option value="lt">Litres</form:option>
						<form:option value="Kg">Kilograms</form:option>
						<form:option value="gm">Grams</form:option>
						<form:option value="Dozen (Dz)">Dozen</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Cost:</td>
				<td><form:input type="number" path="amount" min="1" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input type="submit"
					ng-click="ctrl.refresh();ctrl.changeTab('null','addvalue')"
					class="btn btn-primary" value="Save Value" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/underscore-min.js"></script>
	<script src="assets/js/angular.min.js"></script>
	<script src="assets/js/account.js"></script>
</body>
</html>