'use strict';

/**
 * @ngdoc overview
 * @name webappApp
 * @description # webappApp
 * 
 * Main module of the application.
 */
var myApp = angular.module(
		'webappApp',
		[ 'ngAnimate', 'ngAria', 'ngCookies', 'ngMessages', 'ngResource',
				'ngRoute', 'ngSanitize', 'ngTouch' ]).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/main.html',
				controller : 'MainCtrl',
				controllerAs : 'main'
			}).when('/about', {
				templateUrl : 'views/about.html',
				controller : 'AboutCtrl',
				controllerAs : 'about'
			}).otherwise({
				redirectTo : '/'
			});
		});

myApp.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(function ($q) {
        return {
            'response': function (response) {
                //Will only be called for HTTP up to 300
                console.log(response);
                return response;
            },
            'responseError': function (rejection) {
                if(rejection.status === 401) {
                   // location.reload();
                	console.log("Rejected");
                	$('#myModal').modal('show');
                }
                return $q.reject(rejection);
            }
        };
    });
}]);

myApp.run(function() {

});


