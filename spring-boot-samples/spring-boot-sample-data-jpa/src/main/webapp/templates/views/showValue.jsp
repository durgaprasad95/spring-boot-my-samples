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

	<h3>Today's Prices</h3>
	<table class="table borderless">
		<thead>
			<tr>
				<th></th>
				<th>NAME</th>
				<th>QUANTITY</th>
				<th>COST (in Rs.)</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody ng-repeat="(key,value) in ctrl.values">
			<tr ng-repeat="x in value">
				<td ng-if="$first">{{ctrl.valueHeading(key) | uppercase}} :</td>
				<td ng-hide="$first"></td>
				<td ng-repeat="(key,value) in x">{{value | uppercase}}</td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/underscore-min.js"></script>
	<script src="assets/js/angular.min.js"></script>
	<script src="assets/js/account.js"></script>
</body>
</html>