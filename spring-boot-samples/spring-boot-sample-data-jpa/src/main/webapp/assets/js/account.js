var app = angular.module('accountPage', []);

app.controller('userCtrl', function($scope, accountService) {
	var ctrl = this;
	accountService.userinfo().then(function(data) {
		ctrl.user = {
			"Name" : data["username"],
			"Email" : data["email"],
			"In Wallet" : "Rs. " + data["wallet"]
		}
	});

});

app.controller('valueCtrl', function($scope, $interval, accountService) {
	var ctrl = this;

	ctrl.values = {};
	ctrl.amount = 0;

	ctrl.changeTab = function(object, tab) {
		$('#value a[href="#' + tab + '"]').tab('show');
		console.log(object);
		if (object != null) {
			ctrl.updatableValue = object;
		}
	};

	ctrl.updateValue = function() {
		ctrl.updatableValue["amount"] = ctrl.amount;
		console.log(ctrl.updatableValue);
		accountService.updatevalue(ctrl.updatableValue).then(function(data) {
			ctrl.refresh();
		});
	};

	ctrl.refresh = function() {
		accountService.getvalues().then(
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
	};

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

	ctrl.refresh();

});

app.service('accountService', function($http) {

	var userinfoRoute = "http://localhost:8080/jpa/account-user";
	var getvaluesRoute = "http://localhost:8080/jpa/showValue";
	var updatevalueRoute = "http://localhost:8080/jpa/updateValue";

	return {
		userinfo : userinfo,
		getvalues : getValues,
		updatevalue : updateValue
	};

	function userinfo() {
		return $http.get(userinfoRoute).then(function(response) {
			return response.data;
		});
	}

	function getValues() {
		return $http.get(getvaluesRoute).then(function(response) {
			return response.data;
		});
	}

	function updateValue(object) {
		return $http.post(updatevalueRoute, object).then(function(response) {
			return response.data;
		})
	}

});