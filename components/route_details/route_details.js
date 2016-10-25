angular
.module('app')
.controller('routeDetailsCtrl', ['$rootScope','$scope', '$http', function($rootScope,$scope, $http) {
	$scope.title = "Route Details";

	$http.get($rootScope.appBaseUrl+'/routeDetails').
	//$http.get('routeDetail.json').
	success(function(data) {
		$scope.listOfRoute = [];
		if(data != null && data._embedded != null && data._embedded.routeDetails != null)
			$scope.listOfRoute = data._embedded.routeDetails;
	});

	// Delete the routeDetail
	$scope.deleteRoute = function (idx) {
		$http({
			method: 'DELETE',
			url: $rootScope.appBaseUrl+'/routeDetails/'+$scope.listOfRoute[idx].id,
		}).success(function (data) {
			$scope.status = "The Route Saved Successfully!!!";
			$scope.listOfRoute.splice(idx,1);
		})
	}

	//For creating a new routeDetail
	$scope.createRouteDetail = function () {
		//Defining $http service for creating a routeDetail
		$http({
			method: 'POST',
			url: $rootScope.appBaseUrl+'/routeDetails',
			data: JSON.stringify($scope.routeDetail),
			headers: { 'Content-Type': 'application/JSON' }
		}).success(function (data, status, headers, config) {
			var location = headers('Location');
			var id = location.substring(location.lastIndexOf("/")+1, location.length); 
			$scope.routeDetail.id = id;
			//Showing success message
			$scope.status = "Route Saved Successfully!!!";
			alert("Route added successfully");
			$scope.listOfRoute.push($scope.routeDetail);
			
			//clearing value from the screen
			$scope.routeDetail = null;
			$('#addRouteModal').modal('hide');
		}).error(function (error) {
			$scope.status = 'Unable to create a routeDetail: ' + error.message;
		});
	}

	$scope.addOrUpdateRouteDetail = function(idx) {
		if($scope.routeDetail.id == null){
			$scope.createRouteDetail();
		} else {
			$scope.updateRouteDetail(idx);
		}
	}

	$scope.assignRouteDetail = function(idx){
		if(idx == -1){
			$scope.routeDetail = null;
		} else {
			$scope.routeDetail = $scope.listOfRoute[idx];
		}
	}
	
	//For updating routeDetail
	$scope.updateRouteDetail = function () {
		$http({
			method: 'PUT',
			url: $rootScope.appBaseUrl+'/custom/routeDetails/' + $scope.routeDetail.id,
			data: JSON.stringify($scope.routeDetail),
			headers: { 'Content-Type': 'application/JSON' }
		}).success(function (data,headers) {
			$scope.status = "Route updated Successfully!!!";
			alert("Route updated successfully");
			//$scope.listOfRoute.push($scope.routeDetail);
			
			//clearing value from the screen
			$scope.routeDetail = null;
			$('#addRouteModal').modal('hide');

		}).error(function (error) {
			//Showing error message
			$scope.status = 'Unable to update a routeDetail: ' + error.message;
		});
	}
}]);