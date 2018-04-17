var app = angular.module('accountPage', []);

app.controller('accountUser', function($scope, userService) {
	var ctrl = this;
	var user = {};
	ctrl.user = null;
	userService.userinfo().then(function(data,user) {
		user = data;
		console.log(user);
	});
	console.log(userService.userinfo());
	console.log(user);

});

app.service('userService', function($http) {
	var userinfoRoute = "http://localhost:8080/jpa/account-user";
	return {
		userinfo : userinfo
	};
	function userinfo() {
		return $http.get(userinfoRoute).then(function(response) {
			return response;
		});
	}

});
