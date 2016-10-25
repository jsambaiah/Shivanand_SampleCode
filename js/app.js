'use strict';

// Declare app level module which depends on views, and components
angular.module('main', [
  'ngRoute',
  'myApp.employee'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/employee'});
}]);
