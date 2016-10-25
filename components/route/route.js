angular
		.module('app')
		.controller('routeCtrl',['$rootScope','$scope','$http',function($rootScope, $scope, $http) {
							$scope.title = "Route";

							$http.get($rootScope.appBaseUrl + '/routes').
									// $http.get('routeDetail.json').
						success(function(data) {
			$scope.listOfRoute = [];
			if (data != null&& data._embedded != null && data._embedded.routes != null)
			$scope.listOfRoute = data._embedded.routes;
		});

	// Delete the routeDetail
	$scope.deleteRoute = function(idx) {
	if (confirm("Are you sure you want to delete route permanently?")) {

	$http({
			method : 'DELETE',
			url : $rootScope.appBaseUrl+ '/routes/' + $scope.listOfRoute[idx].id,
		})
		.success(function(data) {
				$scope.status = "The Route Saved Successfully!!!";
				$scope.listOfRoute.splice(idx, 1);
		})
			}
		}

		$scope.pickUpPoints = [ 'Majestic', 'Sirsi circle','Place 1', 'Place 2' ];
		$scope.selectedList = [];
		$scope.addToList = function(pickUpPoint) {
		var idx = $scope.selectedList.indexOf(pickUpPoint);

		// is currently selected
		if (idx > 1) {
			$scope.selectedList.splice(idx, 1);
		}

			// is newly selected
		else {
				$scope.selectedList.push(pickUpPoint);
			}
		}

		// For creating a new routeDetail
		$scope.createRoute = function() {

		// $scope.route.pickUpPoints =
		// $scope.selectedList;
		// Defining $http service for creating a
		// routeDetail
		$http({
			method : 'POST',
			url : $rootScope.appBaseUrl + '/routes',
			data : JSON.stringify($scope.route),
			headers : {'Content-Type' : 'application/JSON'}
		})
		.success(function(data, status, headers,config) {
		var location = headers('Location');
		var id = location.substring(location.lastIndexOf("/") + 1, location.length);
		$scope.route.id = id;
		// Showing success message
		$scope.status = "Route Saved Successfully!!!";
		alert("Route added successfully");
		$scope.listOfRoute.push($scope.route);

		// clearing value from the screen
	  $scope.route = null;
	  $('#addRouteModal').modal('hide');
})
	.error(function(error) {
	$scope.status = 'Unable to create a route: '+ error.message;
});
							}

$scope.addOrUpdateRoute = function(idx) {
if ($scope.route.id == null) {
	$scope.createRoute();
	} else {
	
		$scope.updateRoute(idx);
		}
	}

	$scope.assignRoute = function(idx) {
			if (idx == -1) {
			$scope.route = null;
			$scope.selectedList = [];
		   } else {
			$scope.route = angular.copy($scope.listOfRoute[idx]);
			
		    $scope.selectedList = $scope.route.pickUpPoints;
		}
	}

	// For updating routeDetail
	$scope.updateRoute = function () {
		$http({
			method: 'PUT',
			url: $rootScope.appBaseUrl+'/routes/' + $scope.route.id,
			//url: $rootScope.appBaseUrl+'/vehicles',
			data: JSON.stringify($scope.route),
			headers: { 'Content-Type': 'application/JSON' }
		}).success(function (data, status, headers, config) {
			var location = headers('Location');
			var id = location.substring(location.lastIndexOf("/")+1, location.length); 
			$scope.route.id = id;
			
			//Showing success message
			$scope.status = "Route Saved Successfully!!!";
			alert("Route updated successfully");
			//$scope.listOfVehicle.push($scope.vehicle);
			
			//clearing value from the screen
			$scope.route = null;
			$('#addRouteModal').modal('hide');

		}).error(function (error) {
			//Showing error message
			$scope.status = 'Unable to update a route: ' + error.message;
		});
	}
} ]);
