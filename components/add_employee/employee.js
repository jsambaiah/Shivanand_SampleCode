angular.module('app')
    .controller('addEmployeeCtrl', ['$rootScope', '$scope', '$http', '$filter', '$state', function ($rootScope, $scope, $http, $filter, $state) {

    var startDate = new Date();
    var FromEndDate = new Date();
    var ToEndDate = new Date();
    ToEndDate.setDate(ToEndDate.getDate() + 365);

    $('.from_date').datepicker({
        weekStart: 1,
        startDate: startDate,
        autoclose: true,
        todayHighlight: true
    })
        .on('changeDate', function (selected) {
        startDate = new Date(selected.date.valueOf());
        startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
        startDate.setDate(startDate.getDate() + 1);
        $('.to_date').datepicker('setStartDate', startDate);
    });
    $('.to_date')
        .datepicker({
        weekStart: 1,
        startDate: startDate,
        endDate: ToEndDate,
        autoclose: true,
        todayHighlight: true
    })
        .on('changeDate', function (selected) {
        FromEndDate = new Date(selected.date.valueOf());
        FromEndDate.setDate(FromEndDate.getDate(new Date(selected.date.valueOf())));
        FromEndDate.setDate(FromEndDate.getDate() - 1);
        $('.from_date').datepicker('setEndDate', FromEndDate);
    });


    $scope.isRouteInfoAvailable = false;
    $scope.employeeInstance = [];
    $scope.listOfEmployees = [];
    $scope.noCompanySelected = false;
    $scope.employeeData = {
        name: "",
        location: "",
        employees: $scope.listOfEmployees,
        selectedCompany: false
    };
    $scope.submitEmployeeRouteForm = function () {
        if ($scope.isRouteInfoAvailable) {
            $scope.addEmployeeRouteDetails();
        } else {
            $scope.getEmployeeRouteInfo();
        }
    }

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
        }).error(function (error) {
            //Showing error message
            $scope.status = 'Unable to get Vehicle Types: ' + error.message;
        });
        //to get all list of company
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/customers',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            if (data && data._embedded && data._embedded.customers && data._embedded.customers.length > 0) {
                $scope.companyNames = data._embedded.customers;
            }
        });
        /**
         * To get saved PackageType from server to select
         */
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/packages/fetchPackageTypes',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            $scope.fetchedPackageTypes = data;
        }).error(function (error) {
            alert('Unable to get Package Type');
        });
        /**
         * Getting saved pickup points from server to select 
         */
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/routes',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            $scope.storedPickupPoints = [];
            if (data && data._embedded && data._embedded.routes) {
                var routes = data._embedded.routes;
                angular.forEach(routes, function (route) {
                    angular.forEach(route.pickUpPoints, function (pickUpPoint) {
                        if ($scope.storedPickupPoints.indexOf(pickUpPoint) == -1) {
                            $scope.storedPickupPoints.push(pickUpPoint);
                        }
                    });
                });
            }

        }).error(function (error) {
            alert('Unable to get pickup points');
        });
        $scope.listOfVehicle = null;
        $http.get($rootScope.appBaseUrl + '/vehicles').
        success(function (data) {
            if (data && data._embedded && data._embedded.vehicles) {
                $scope.listOfVehicle = data._embedded.vehicles;
                $scope.updatedListOfVehicle = angular.copy($scope.listOfVehicle);
            }
        });
        $http.get($rootScope.appBaseUrl + '/drivers').
        success(function (data) {
            if (data && data._embedded && data._embedded.drivers) {
                $scope.listOfDrivers = data._embedded.drivers;
                $scope.updatedListOfDrivers = angular.copy($scope.listOfDrivers);
            }
        });
    };

    /**
     * To Search all List of employee for selected company
     *
     */
    $scope.getEmployeeForSelectedCompany = function () {
        if ($scope.employeeData.selectedCompany && $scope.employeeData.selectedCompany._links && $scope.employeeData.selectedCompany._links.employees) {
            $scope.noCompanySelected = false;
            $http({
                method: 'GET',
                url: $scope.employeeData.selectedCompany._links.employees.href,
                headers: {
                    'Content-Type': 'application/JSON'
                }
            }).success(

            function (data) {
                if (data && data._embedded && data._embedded.employees) {
                    $scope.associatedEmployeesTocompany = data._embedded.employees;
                } else {
                    $scope.associatedEmployeesTocompany = [];
                }

            })
                .error(function (error) {
                $scope.associatedEmployeesTocompany = [];
            });
        } else {
            $scope.noCompanySelected = true;
        }

    }

   
    $scope.createEmployee = function () {
        $scope.employeeInstance = null;
    };
    /**
     * open edit dialog box  for selected employee details
     *
     */
    $scope.editEmployee = function (idx) {
        $scope.employeeInstance = angular.copy($scope.employeeData.employees[idx]);
        $scope.employeeInstance.index = idx;
    };
    /**
     * To add selected employees to main data holder from existing employee list
     */
    $scope.addSelectedEmployee = function () {
        var isDuplicate = false;
        if ($scope.employeeData.employees.length === 0) {
            angular.forEach($scope.associatedEmployeesTocompany, function (item) {
                if (item.checked) {
                    $scope.employeeData.employees.push(item);
                    item.checked = false;
                }
            });
        } else {
            angular.forEach($scope.associatedEmployeesTocompany, function (existingEmployee) {
                angular.forEach($scope.employeeData.employees, function (employee) {
                    if (!isDuplicate && existingEmployee.checked && employee.employeeId === existingEmployee.employeeId) {
                        alert("There are one or many duplicate in selection of employee.Please Remove duplicate data and continue.");
                        isDuplicate = true;
                        existingEmployee.checked = false;
                    }
                });
                if (!isDuplicate && existingEmployee.checked) {
                    $scope.employeeData.employees.push(existingEmployee);
                    existingEmployee.checked = false;
                }
            });
        }
        $('#selectEmployeeModal').modal('hide');
    };
    $scope.isAnyItemSelected = function () {
    	$scope.isItemSelected = false;
    	angular.forEach($scope.associatedEmployeesTocompany, function (item) {
            if (item.checked) {
            	$scope.isItemSelected = true;
            }
        });
    };
    /**
     * To delete employee from selected table
     */
    $scope.deleteEmployee = function (index) {
        if (confirm('Are you sure you want to delete this employee from table?')) {
            $scope.employeeData.employees.splice(index, 1);
        }
    }
    /**
     * To reset whole form
     */
    $scope.resetEmployeeData = function () {
        $scope.listOfEmployees = [];
        $scope.employeeData = {
            name: "",
            location: "",
            employees: $scope.listOfEmployees,
            selectedCompany: false
        };
    }
    /**
     * To reset add employee dialog box
     */
    $scope.resetEmployeeInstance = function () {
        $scope.employeeInstance = {
        		employeeId:'',
        		department:'',
        		departmentCode:'',
        		name:'',
        		lastName:'',
        		gender:'',
        		mobileNo:'',
        		email:'',
        		addressLine1:'',
        		addressLine2:'',
        		city:'',
        		zipCode:'',
        		pickupArea:'',
        		pickUpPoint:''
        };
    }

    $scope.addOrUpdateEmployee = function (idx) {
        if (idx == null || idx === undefined) {
            $scope.addEmployee();
        } else {
            $scope.updateEmployee(idx);
        }
        $('#addEmployeeModal').modal('hide');
        return;
    }
    $scope.updateEmployee = function (idx) {
        if ($scope.employeeData.employees[idx].id) {
            var selectedCompany = angular.copy($scope.employeeData.selectedCompany);
            for (i = 0; i < selectedCompany.employees.length; i++) {
                if (selectedCompany.employees[i].id === $scope.employeeData.employees[idx].id) {
                	$scope.employeeInstance.id=$scope.employeeData.employees[idx].id;
                    selectedCompany.employees.splice(i, 1);
                    selectedCompany.employees.push($scope.employeeInstance);
                    break;
                }
            };
            //Defining $http service for creating a company
            $http({
                method: 'PUT',
                url: $rootScope.appBaseUrl + '/customers/'+selectedCompany.id,
                data: JSON.stringify(selectedCompany),
                headers: {
                    'Content-Type': 'application/JSON',
                    'Accept': ''
                }
            }).
            success(function (data) {
                $scope.employeeData.employees[idx] = $scope.employeeInstance;
                alert('Employee Information updated successfully');
            }).error(function (error) {
                alert('Unable to update Employee Information');
            });
        } else {
            $scope.employeeData.employees[idx] = $scope.employeeInstance;
        }


    };
    /**
     * add newly added employee to main data structure
     */
    $scope.addEmployee = function () {
    	if(!isduplicate()){
	        if (!$scope.employeeInstance.id) {
	            var selectedCompany = angular.copy($scope.employeeData.selectedCompany);
	            if(!selectedCompany.employees){
	            	selectedCompany.employees=[];
	            }
	            selectedCompany.employees.push($scope.employeeInstance);
	
	            //Defining $http service for creating a company
	            $http({
	                method: 'PUT',
	                url: $rootScope.appBaseUrl + '/customers/'+selectedCompany.id,
	                data: JSON.stringify(selectedCompany),
	                headers: {
	                    'Content-Type': 'application/JSON',
	                    'Accept': ''
	                }
	            }).
	            success(function (data) {
	            	 //Defining $http service for creating a company
	                $http({
	                    method: 'GET',
	                    url: $rootScope.appBaseUrl + '/customers/'+selectedCompany.id,
	                    headers: {
	                        'Content-Type': 'application/JSON',
	                        'Accept': ''
	                    }
	                }).
	                success(function (data) {
	                	$scope.employeeData.selectedCompany.employees=data.employees;
	                	 angular.forEach(data.employees, function (existingEmployee) {
	                		 if(existingEmployee.employeeId === $scope.employeeInstance.employeeId){
	                			//add new created employee to existing employee records
	         	                $scope.employeeData.employees.push(existingEmployee);
	         	                alert('Employee added');
	                		 }
	                	 });
	                });
	            }).error(function (error) {
	                //Showing error message
	                alert('Unable to add employee');
	            });
	        } else {
	            $scope.employeeData.employees.push($scope.employeeInstance);
	        }
    	}
    }
    
    var isduplicate = function(){
    	var isDuplicate = false;
        if ($scope.employeeData.employees.length === 0) {
        	isDuplicate = false;
        } else {
            angular.forEach($scope.employeeData.employees, function (employee) {
                if (!isDuplicate && $scope.employeeInstance.employeeId && employee.employeeId === $scope.employeeInstance.employeeId) {
                    alert("This is a duplicate entry.Please Remove duplicate data and continue.");
                    isDuplicate = true;
                }
            });
        }
        return isDuplicate;
    };

    /**
     * Adding company information
     *
     */
    $scope.getEmployeeRouteInfo = function () {
        for (i = 0; i < $scope.employeeData.employees.length; i++) {
            delete $scope.employeeData.employees[i]._links;
            delete $scope.employeeData.employees[i].$$hashKey;
            delete $scope.employeeData.employees[i].checked;


            //adding addition attribute which required to back-end
            if (!$scope.employeeData.employees[i].middleName) {
                $scope.employeeData.employees[i].middleName = null;
            }
            if (!$scope.employeeData.employees[i].shift) {
                $scope.employeeData.employees[i].shift = null;
            }
            if (!$scope.employeeData.employees[i].photo) {
                $scope.employeeData.employees[i].photo = null;
            }
            if (!$scope.employeeData.employees[i].adharNo) {
                $scope.employeeData.employees[i].adharNo = null;
            }


        }
        //Defining $http service for creating a company
        $http({
            method: 'POST',
            url: $rootScope.appBaseUrl + '/vehicleLogs/fetchVehicleLog',
            data: JSON.stringify($scope.employeeData.employees),
            headers: {
                'Content-Type': 'application/JSON',
                'Accept': ''
            }
        }).
        success(function (data) {
            $scope.employeeRouteDetails = data;
            //Showing success message
            $scope.status = "Employee Information Saved Successfully!!!";
            //alert("Employee Information Saved Successfully!!!");
            $scope.isRouteInfoAvailable = true;

        })
            .error(function (error) {
            $scope.isRouteInfoAvailable = false;
            alert("Unable to add Employee Information");
        });

    };

    $scope.selectedRoute = function (newIdx) {
    	//cleaning previously stored data
    	$scope.updatedListOfDrivers=[];
    	$scope.updatedListOfVehicle=[];
    	//removing selected driver from existing list
    	 angular.forEach($scope.listOfVehicle, function (vehicle) {
    		 if(!vehicle.selectedAlready){
    			 $scope.updatedListOfVehicle.push(vehicle);
    		 }
    	 });
    	
    	//removing selected vehicle from existing list
    	 angular.forEach($scope.listOfDrivers, function (driver) {
    		 if(!driver.selectedAlready){
    			 $scope.updatedListOfDrivers.push(driver);
    		 }
    	 });
    	
        $scope.selectedRouteIndex = newIdx;
    }
    $scope.selectedVehicle = function (newid) {
        $scope.selectedVehicleId = newid;
    };
    $scope.addVehicle = function () {
        //de-selecting previously selected driver and vehicle
        if ($scope.employeeRouteDetails[$scope.selectedRouteIndex].vehicle && $scope.employeeRouteDetails[$scope.selectedRouteIndex].driver) {
            angular.forEach($scope.listOfVehicle, function (vehicle) {
                if ($scope.employeeRouteDetails[$scope.selectedRouteIndex].vehicle.regNo === vehicle.regNo) {
                    vehicle.selectedAlready = false;
                }

            });
            angular.forEach($scope.listOfDrivers, function (driver) {
                if ($scope.employeeRouteDetails[$scope.selectedRouteIndex].driver.id === driver.id) {
                    driver.selectedAlready = false;
                }

            });
        }

        $scope.employeeRouteDetails[$scope.selectedRouteIndex].vehicle = {
            "id": $scope.selectedVehicle.id,
            "regNo": $scope.selectedVehicle.regNo
        };
        $scope.employeeRouteDetails[$scope.selectedRouteIndex].driver = {
            "id": $scope.selectedDriver.id,
            "name": $scope.selectedDriver.name,
            "contactNo": $scope.selectedDriver.contactNo

        };
        angular.forEach($scope.listOfVehicle, function (vehicle) {
            if ($scope.employeeRouteDetails[$scope.selectedRouteIndex].vehicle.regNo === vehicle.regNo) {
                vehicle.selectedAlready = true;
            }

        });
        angular.forEach($scope.listOfDrivers, function (driver) {
            if ($scope.employeeRouteDetails[$scope.selectedRouteIndex].driver.id === driver.id) {
                driver.selectedAlready = true;
            }

        });
        $('#addVehicleModal').modal('hide');
    };
	
    $scope.addEmployeeRouteDetails = function () {
        for (i = 0; i < $scope.employeeRouteDetails.length; i++) {
            delete $scope.employeeRouteDetails[i].$$hashKey;
            for (j = 0; j < $scope.employeeRouteDetails[i].employeeLogList.length; j++) {
                delete $scope.employeeRouteDetails[i].employeeLogList[j].$$hashKey;
            }
            $scope.employeeRouteDetails[i].requestStartDate = $filter('date')(new Date($scope.employeeData.requestStartDate), "yyyy-MM-dd");
            $scope.employeeRouteDetails[i].requestEndDate = $filter('date')(new Date($scope.employeeData.requestEndDate), "yyyy-MM-dd");
            $scope.employeeRouteDetails[i].shiftStartTime = $scope.employeeData.shiftStartTime;
            $scope.employeeRouteDetails[i].shiftEndTime = $scope.employeeData.shiftEndTime;
            $scope.employeeRouteDetails[i].packageType = $scope.employeeData.packageType;
        };
        //Defining $http service for creating a company
        $http({
            method: 'POST',
            url: $rootScope.appBaseUrl + '/vehicleLogs/saveVehicleLog',
            data: JSON.stringify($scope.employeeRouteDetails),
            headers: {
                'Content-Type': 'application/JSON',
                'Accept': ''
            }
        }).
        success(function (data) {
            $scope.isRouteInfoAvailable = false;
            alert("Employee route Information Saved Successfully!!!");
            reset();

        }).error(function (error) {
            reset();
            $scope.isRouteInfoAvailable = false;
            alert('Unable to add Employee route Information');

        });
    };
    var reset = function () {
        $scope.employeeRouteDetails = [];
        $scope.employeeData = [];
    };

}]);