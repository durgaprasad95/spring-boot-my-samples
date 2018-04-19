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

app.controller('showValueCtrl', function($scope, valueService) {
	var ctrl = this;
	var keys = [ "name", "quantity", "cost" ];
	valueService.values().then(function(data) {
		data = _.each(data, fucntion(x){
			_.map(x, function(key, value) {
			switch (key) {
			case "fruitValues":
				key = "Fruits";
				break;
			case "vegetableValues":
				key = "Vegetables";
				break;
			case "groceryValues":
				key = "Groceries";
				break;
			}
			_.each(value, function(y) {
				return {
					"name" : y["name"],
					"quantity" : y["quantity"],
					"cost" : "Rs: " + y["cost"]
				};
			});
			});
			});
		ctrl.values = data;
		console.log(ctrl.values);
	});

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