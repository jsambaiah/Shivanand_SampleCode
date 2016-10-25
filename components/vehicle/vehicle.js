angular
.module('app')
.controller('vehicleCtrl', ['$rootScope','$scope', '$http', function($rootScope,$scope, $http) {
	$scope.title = "Vehicle";
	 
	//populating Year of manufacturer
	var yom = []; 
	var year = new Date().getFullYear();
	for(var i = year ; i > year -30; i--)
	{
		yom.push(i);
	}
	$scope.yom = yom;


	
	$http.get($rootScope.appBaseUrl+'/vehicles').
	//$http.get('vehicle.json').
	success(function(data) {
		$scope.listOfVehicle = [];
		if(data != null && data._embedded != null && data._embedded.vehicles != null)
			$scope.listOfVehicle = data._embedded.vehicles;
	});
	
	
	// Delete the vehicle
	$scope.deleteVehicle = function (idx) {
		if (confirm("Are you sure want to delete vehicle permanently?"))
        {
		$http({
			method: 'DELETE',
		url: $rootScope.appBaseUrl+'/vehicles/'+$scope.listOfVehicle[idx].id,
		}).success(function (data) {
			$scope.status = "The vehicle deleted Successfully!!!";
			alert("vehicle deleted successfully");
		    $scope.listOfVehicle.splice(idx,1);
		    
			 
		})
	}
	}
	
	
	
	

	//For creating a new vehicle
	$scope.createVehicle = function () {
		//Defining $http service for creating a routeDetail
		$http({
			method: 'POST',
			url: $rootScope.appBaseUrl+'/vehicles',
			data: JSON.stringify($scope.vehicle),
			headers: { 'Content-Type': 'application/JSON' }
		}).success(function (data, status, headers, config) {
			var location = headers('Location');
			var id = location.substring(location.lastIndexOf("/")+1, location.length); 
			$scope.vehicle.id = id;
			//Showing success message
			$scope.status = "vehicle Saved Successfully!!!";
			alert("vehicle added successfully");
			$scope.listOfVehicle.push($scope.vehicle);
			
			
			//clearing value from the screen
			$scope.vehicle = null;
			$('#addVehicleModal').modal('hide');
			
		}).error(function (error) {
			$scope.status = 'Unable to create a vehicle: ' + error.message;
		});
	}
	
	$scope.addOrUpdateVehicle = function(idx) {
		if($scope.vehicle.id == null){
			$scope.createVehicle();
		} else {
			$scope.updateVehicle(idx);
		}
	}

	$scope.assignVehicle = function(idx){
		if(idx == -1){
			$scope.vehicle = null;
		} else {
			
			$scope.vehicle = angular.copy($scope.listOfVehicle[idx]);
		}
	}
	
	//For updating vehicleDetail
	$scope.updateVehicle = function () {
		$http({
			method: 'PUT',
			url: $rootScope.appBaseUrl+'/vehicles/' + $scope.vehicle.id,
			//url: $rootScope.appBaseUrl+'/vehicles',
			data: JSON.stringify($scope.vehicle),
			headers: { 'Content-Type': 'application/JSON' }
		}).success(function (data, status, headers, config) {
			var location = headers('Location');
			var id = location.substring(location.lastIndexOf("/")+1, location.length); 
			$scope.vehicle.id = id;
			//Showing success message
			$scope.status = "vehicle Saved Successfully!!!";
			alert("vehicle updated successfully");
			//$scope.listOfVehicle.push($scope.vehicle);
			//clearing value from the screen
			$scope.vehicle = null;
			$('#addVehicleModal').modal('hide');

		}).error(function (error) {
			//Showing error message
			$scope.status = 'Unable to update a vehicle: ' + error.message;
		});
	}
}]);