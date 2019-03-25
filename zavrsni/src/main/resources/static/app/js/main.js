var application = angular.module('application', ['ngRoute']);

application.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/zadaci.html'
		})
		.when('/zadaci/add', {
			templateUrl : '/app/html/add-zadaci.html'
		})
		.when('/zadaci/edit/:id', {
			templateUrl : '/app/html/edit-zadaci.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);