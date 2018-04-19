var app = angular.module('accountPage', []);

app.controller('userCtrl', function($scope, userService) {
	var ctrl = this;
	userService.userinfo().then(function(data) {
		ctrl.user = {
			"Name" : data["username"],
			"Email" : data["email"],
			"In Wallet" : "Rs. " + data["wallet"]
		}
	});

});

app.controller('showValueCtrl', function($scope, $interval, valueService) {
	var ctrl = this;

	ctrl.values = {};

	ctrl.valueHeading = function(key) {
		if (key === "fruitValues") {
			return "Fruits";
		}
		if (key === "vegetableValues") {
			return "Vegetables";
		}
		if (key === "groceryValues") {
			return "Groceries";
		}
	}

	$interval(function() {
		valueService.values().then(
				function(data) {
					_.map(data, function(value, key) {
						var formatData = [];
						_.each(value, function(element) {
							formatData.push(_.pick(element, 'name', 'quantity',
									'amount'));
						});
						value = formatData;
						ctrl.values[key] = value;
					});
				});
	}, 1000);
});

app.service('userService', function($http) {
	var userinfoRoute = "http://localhost:8080/jpa/account-user";
	return {
		userinfo : userinfo
	};
	function userinfo() {
		return $http.get(userinfoRoute).then(function(response) {
			return response.data;
		});
	}

});

app.service('valueService', function($http) {
	var valueRoute = "http://localhost:8080/jpa/showValue";
	return {
		values : getValues
	};
	function getValues() {
		return $http.get(valueRoute).then(function(response) {
			return response.data;
		});
	}

});