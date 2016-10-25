angular.module('app').controller('addDutyLogCtrl', ['$rootScope', '$scope', '$http', '$filter', '$state', function ($rootScope, $scope, $http, $filter, $state) {

    $scope.noCompanySelected = false;
    $scope.associatedEmployeesTocompany = [];
    $scope.dutyLogData = {
        supervisorCheck: false,
        employeeLogList: [],
        sheetNo:'',
        customerData :false
    };
    var startDate = new Date();

	$('.travelDate').datepicker({
	    weekStart: 1,
        todayHighlight: true, 
	    autoclose: true
	});
    /**
     * To get Duty log data as soon some give travel date and vehicle number
     */
    $scope.populateVehicleLog = function () {
        $scope.$watch('travelDate', function () {
            if ($scope.travelDate && $scope.vehicleNumber) {
                var temp = $filter('date')(new Date($scope.travelDate), "dd/MM/yyyy");
                //getting saved Vehicle log from server 	
                $http({
                    method: 'GET',
                    url: $rootScope.appBaseUrl + '/vehicleLogs/populateVehicleLog?vehicleRegNo=' + $scope.vehicleNumber + '&travelDate=' + temp,
                    headers: {
                        'Content-Type': 'application/JSON'
                    }
                }).success(function (data) {
                	if(data){
	                    $scope.dutyLogData = data;
	                    $scope.dutyLogData.travelDate = $filter('date')(new Date($scope.travelDate), "yyyy-MM-dd");
	                    $scope.dutyLogData.vehicleNumber = $scope.vehicleNumber;
                     }
                }).error(function (error) {
                    alert('Unable to get Vehicle log,Please check your inputs and try again');
                });
            }
        });
    };
    /**
     * To add selected employees to main data holder from existing employee list
     */
    $scope.addSelectedEmployee = function () {
        angular.forEach($scope.associatedEmployeesTocompany, function (item) {
            if (item.checked && $scope.dutyLogData) {
                if (!$scope.dutyLogData.employeeLogList) {
                    $scope.dutyLogData.employeeLogList = [];
                }
                $scope.dutyLogData.employeeLogList.push({
                    employee: item
                });
                item.checked = false;
            }
        });
        $('#addDutyLogModal').modal('hide');
    };
    $scope.isAnyItemSelected = function () {
    	$scope.isItemSelected = false;
    	angular.forEach($scope.associatedEmployeesTocompany, function (item) {
            if (item.checked) {
            	$scope.isItemSelected = true;
            }
        });
    };
    //to load data which are required for initial data load
    $scope.init = function () {
        //to get all list of company
        $http({
            method: 'GET',
            url: $rootScope.appBaseUrl + '/customers',
            headers: {
                'Content-Type': 'application/JSON'
            }
        }).success(function (data) {
            if (data._embedded && data._embedded.customers && data._embedded.customers.length > 0) {
                $scope.customerNames = data._embedded.customers;
            }
        }).error(function (error) {
           alert('Unable to get employees');
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
                angular.forEach(data._embedded.routes, function (route) {
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
    };

    /**
     * To Search all List of dutyLog for selected company
     *
     * @return {list} list of dutyLog
     */
    $scope.getEmployeeForSelectedCompany = function () {
        if ($scope.dutyLogData.customerData && $scope.dutyLogData.customerData._links && $scope.dutyLogData.customerData._links.employees) {
            $scope.noCompanySelected = false;
            $http({
                method: 'GET',
                url: $scope.dutyLogData.customerData._links.employees.href,
                headers: {
                    'Content-Type': 'application/JSON'
                }
            }).success(
            function (data) {
                if (data._embedded.employees) {
                    $scope.associatedEmployeesTocompany = data._embedded.employees;
                } else {
                    $scope.associatedEmployeesTocompany = [];
                }

            }).error(function (error) {
                $scope.associatedEmployeessTocompany = [];
            });
        } else {
            $scope.noCompanySelected = true;
        }

    }
    
    /**
     * To reset whole form
     */
    $scope.resetDutyLogData = function () {
        $scope.dutyLogData = {
                supervisorCheck: false,
                employeeLogList: [],
                customerData :false,
                sheetNo:'',
                travelDate : '',
                vehicleNumber:''
                
            };
    	$scope.travelDate=undefined;
    	$scope.vehicleNumber=undefined;
        
    }

    //To delete employee 
    $scope.deleteEmployee = function (index) {
        if (confirm('Are you sure you want to delete this employee from table?')) {
            $scope.dutyLogData.employeeLogList.splice(index, 1);
        }
    }

    $scope.submitDutyLogInfo = function () {
        $scope.dutyLogData.customerName = $scope.dutyLogData.customerData.name;
        $scope.dutyLogData.dutyLogEntryList = $scope.dutyLogData.employeeLogList;
        delete $scope.dutyLogData.employeeLogList;
        delete $scope.dutyLogData.customerData;
        delete $scope.dutyLogData.requestStartDate;
        delete $scope.dutyLogData.requestEndDate;
        //Defining $http service for creating a company
        $http({
            method: 'POST',
            url: $rootScope.appBaseUrl + '/dutyLogSheets/saveDutyLogSheet',
            data: JSON.stringify([$scope.dutyLogData]),
            headers: {
                'Content-Type': 'application/JSON',
                'Accept' : ''
            }
        }).success(function (data) {
            //Showing success message
            alert("DutyLog route Information Saved Successfully!!!");
            $scope.dutyLogData = [];

        }).error(function (error) {
            alert('Unable to add DutyLog Information');
        });
    };

}]);