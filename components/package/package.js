angular.module('app')
    .controller('packageCtrl', ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {
    	 $scope.title = "Packages";
    $scope.packageInstance = [];
    $scope.packages = [];
        
        

    
    
   $http({
    	method:'GET',
    	url:$rootScope.appBaseUrl+'/packages',
	//$http.get('package.json').
    
    headers: {
        'Content-Type': 'application/JSON',
        	'Accept' : ''
    }
}).
    

    
	success(function(data) {
		$scope.packageData.packages.existingPackages = [];
		if(data != null && data._embedded != null && data._embedded.packages != null)
			$scope.packageData.packages = data._embedded.packages;
    
		
		
		
    
	});

    

    $scope.init = function () {
        //getting saved VehicleTypes from server to select    	
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/vehicles/fetchVehicleTypes',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            $scope.fetchedVehicleTypes = data;
            $scope.fetchedVehicleTypes.push('other');
        }).error(function (error) {
            //Showing error message
            $scope.status = 'Unable to get Vehicle Types: ' + error.message;
        });

        //getting saved PackageType from server to select    	
       /* $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/packages/fetchPackageTypes',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            $scope.fetchedPackageTypes = data;
            $scope.fetchedPackageTypes.push('other');
        }).error(function (error) {
            //Showing error message
            $scope.status = 'Unable to get Package Type: ' + error.message;
        });*/
        
        


        //getting saved packages from server to select    	
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/packages',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            if (data && data._embedded && data._embedded.packages && data._embedded.packages.length > 0) {
                var packages = data._embedded.packages;
                $scope.existingPackages = addDescriptionFromPackage(packages);
                
             
        			$scope.packageData.packages = data._embedded.packages;
            
                
                
                
            } else {
                $scope.existingPackages = [];
            }

        }).error(function (error) {
            alert('Unable to get saved Packages');
        });
    };
    var addDescriptionFromPackage = function (packages) {
        angular.forEach(packages, function (item) {
            if (item && item != null && item.packageLimits && item.packageLimits != null && item.packageAdditionalCharges && item.packageAdditionalCharges != null) {
                item.packageDescription =  " price : " + item.price +    ", unit : " + item.unit + ",distanceInKm : " + item.packageLimits.distanceInKm + ", timeInHours : " + item.packageLimits.timeInHours + ", weeks : " + item.packageLimits.weeks + ", numDays : " + item.packageLimits.numDays + ", tripType : " + item.packageLimits.tripType + ", Additional Charges(perHour, perKm) : (" + item.packageAdditionalCharges.perHour +
                    ", " + item.packageAdditionalCharges.perKm + ")";
            }
        });
        return packages;
    };
    
 
    
    $scope.packageData = {
        name: "",
        location: "",
        packages: $scope.packages
    };


    $scope.createPackage = function () {
        $scope.packageInstance = null;
    };
    $scope.editPackage = function (idx) {
        $scope.packageInstance = angular.copy($scope.packageData.packages[idx]);
        $scope.packageInstance.index = idx;
    };
   $scope.addSelectedPackage = function () {
        var isDuplicate = false;
        if ($scope.packageData.packages.length === 0) {
        	
        	//Modified regarding select package window
        	
        	  $("#selectPackageModal").modal('hide');
        	  
        	  $scope.status = "packages added Successfully!!!";
	            alert("packages added Successfully!!!");
        	
        	
            angular.forEach($scope.existingPackages, function (item) {
            	//
            	 $("#selectPackageModal").modal('hide');
            	 
            	
                if (item.checked) {
                    $scope.packageData.packages.push(item);
                    item.checked = false;
                    
                }
            });
        } else {
            angular.forEach($scope.existingPackages, function (existingPackage) {
            	//newly written
            	 $("#selectPackageModal").modal('hide');
            	
                angular.forEach($scope.packageData.packages, function (packageItem) {
                	//newly written
                	 $("#selectPackageModal").modal('hide');
                	
                    if (!isDuplicate && existingPackage.checked && (packageItem.vehicleType === existingPackage.vehicleType && packageItem.packageType === existingPackage.packageType)) {
                        alert("There are one or many duplicate in selection of package.Please Remove duplicate data and continue.");
                        isDuplicate = true;
                        existingPackage.checked = false;
                    }
                });
                if (!isDuplicate && existingPackage.checked) {
                    $scope.packageData.packages.push(existingPackage);
                    
                  
                    existingPackage.checked = false;
                }
            });
        }
    }
  
    //To add newly created package in package list
    $scope.addPackage = function () {
    	
    	
       /* if ($scope.packageInstance.packageType === 'other') {
            $scope.packageInstance.packageType = $scope.packageInstance.otherpackageType;
        }*/   
    	
    	
    	
        if ($scope.packageInstance.vehicleType === 'other') {
            $scope.packageInstance.vehicleType = $scope.packageInstance.othervehicleType;
        }
       /* //newly written unit
        if ($scope.packageInstance.unit === 'other') {
            $scope.packageInstance.unit = $scope.packageInstance.otherunit;
        }*/
        
        
        var temp = addDescriptionFromPackage([$scope.packageInstance]);
        $scope.packageData.packages.push(temp[0]);
        $scope.packageInstance = [];
    }

    
    
    
   // angular.module('app', [])
        //.controller('packageCtrl', ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {
    //.controller('packageCtrl',['$scope', function($scope){
    $scope.isDisabled = false;
    $scope.disableClick = function() {
        alert("Are you sure you want to disable package!");
        $scope.isDisabled = true;
        return false;
    }

    //To delete package 
    $scope.deletePackage = function (index) {
        if (confirm('Are you sure you want to delete this?')) {
       
            $scope.packageData.packages.splice(index, 1);
        }
    }

    $scope.resetpackageData = function () {
        $scope.packageData = '';
        $scope.packageData.packages = [];
    }
    $scope.resetPackageInstance = function () {
        $scope.packageInstance = [];
    }

  // $scope.addOrUpdatePackage = function (idx) {
   
    //new code for addPackage post request
    
    	 $scope.addOrUpdatePackage = function (idx) {
    	        //Defining $http service for creating a company
    	        $http({
    	            method: 'POST',
    	            //url: 'http://5.44.107.29:8080/leadfleet-api/packages',
    	           url: $rootScope.appBaseUrl + '/packages',
    	            data: JSON.stringify($scope.packageInstance),
    	            headers: {
    	                'Content-Type': 'application/JSON',
    	                'Accept' : ''
    	            }
    	        }).
    	        success(function (data) {
    	        	$("#addPackageModal").modal('hide');
    	        
    	            //$scope.status = "packages Saved Successfully!!!";
    	            alert("packages Saved Successfully!!!");
    	            $scope.packageInstance = '';
    	            $scope.packageInstance = [];
    	        //clearing value from the screen
    			$scope.packageInstance = null;
    			//$("#addPackageModal").modal('hide');
    		}).error(function (error) {
    	            alert('package not saved successfully');
    	        });
            //
    	
        if (idx == null || idx === undefined) {
            $scope.addPackage();
        } else {
            $scope.updatePackage(idx);
        }
        return;
    }
    $scope.updatePackage = function (idx) {
        var temp = addDescriptionFromPackage([$scope.packageInstance]);
        $scope.packageData.packages[idx] = temp[0];
        $scope.packageInstance = [];
    };

}]);      
  
