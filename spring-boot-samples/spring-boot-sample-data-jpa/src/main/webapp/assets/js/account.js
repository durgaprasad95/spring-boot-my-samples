var app = angular.module('accountPage', []);
app.controller('accountUser', function($scope, $http) {
	var ctrl = this;
	$scope.user = "";
	$http.get("http://localhost:8080/jpa/account-user").then(
			processData(response));
	processData = function(response) {
		$scope.user = response.data;
		console.log(" Hello " + $scope.user.email);
	};
	console.log($scope.user);
});
