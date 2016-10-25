angular
    .module('app', [
        'ui.router','ui.bootstrap'
    ]).run(function($rootScope) {
        
    	$rootScope.appBaseUrl = "http://5.44.107.29:8080/leadfleet-api";
    })
    .config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider) {
        $urlRouterProvider.otherwise('/');
        $stateProvider
            .state('vehicle', {
                url: '/',
                templateUrl: 'components/vehicle/vehicle.html',
                controller: 'vehicleCtrl'
            })
            .state('route', {
                url: '/route',
                templateUrl: 'components/route/route.html',
                controller: 'routeCtrl'
            })
            .state('user', {
                url: '/user',
                templateUrl: 'components/user/user.html',
                controller: 'userCtrl'
            })
            .state('package', {
                url: '/package',
                templateUrl: 'components/package/package.html',
                controller: 'packageCtrl'
            })
            .state('add_company', {
                url: '/add_company',
                templateUrl: 'components/add_company/add_company.html',
                controller: 'addCompanyCtrl'
            })
            .state('add_employee', {
                url: '/add_employee',
                templateUrl: 'components/add_employee/employee.html',
                controller: 'addEmployeeCtrl'
            })
            .state('route_details', {
                url: '/route_details',
                templateUrl: 'components/route_details/route_details.html',
                controller: 'routeDetailsCtrl'
            })
            .state('customer', {
                url: '/customer',
                templateUrl: 'components/customer/customer.html',
                controller: 'customerCtrl'
            })
            .state('duty_log', {
                url: '/duty_log',
                templateUrl: 'components/duty_log/duty_log.html',
                controller: 'addDutyLogCtrl'
            });
    }])