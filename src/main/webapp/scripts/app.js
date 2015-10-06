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
				'ngRoute', 'ngSanitize', 'ngTouch','angucomplete-alt' ]).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/main.html',
				controller : 'MainCtrl',
				controllerAs : 'main'
			}).when('/about', {
				templateUrl : 'views/about.html',
				controller : 'AboutCtrl',
				controllerAs : 'about'
			}).when('/project/:projId', {
				templateUrl : 'views/project.html',
				controller : 'ProjCtrl'
			}).when('/project/dashboard/:projDashId', {
				templateUrl : 'views/projectdashboard.html',
				controller : 'ProjCtrl'
			})
			.when('/projectList', {
				templateUrl : 'views/prj-list.html',
				controller : 'ProjCtrl'
			})
			.when('/task/:taskId', {
				templateUrl : 'views/task.html',
				controller : 'TaskCtrl'
			})
			.when('/userList', {
				templateUrl : 'views/user-list.html',
				controller : 'UserCtrl'
			})
			
			.when('/login', {
				templateUrl : 'views/login.html',
				controller : 'LoginController'
			}).otherwise({
				redirectTo : '/'
			});
		});

myApp.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(function ($q) {
        return {
            'response': function (response) {
                //Will only be called for HTTP up to 300
               
                return response;
            },
            'responseError': function (rejection) {
                if(rejection.status === 401) {
                   // location.reload();
                	console.log("Rejected");
                	console.log(window.location);
                	window.location.href = "#/login"
                }
                return $q.reject(rejection);
            }
        };
    });
}]);

myApp.run(function() {

});


myApp.run(function($rootScope, $http, $location){
	  $rootScope.errors = [];
	  //$rootScope.navigateTo = "/main";
	  
	    
	    $rootScope.$watch(function() { 
	        return $location.path(); 
	        
	      },
	      function(a){  
	        console.log('url has changed: ' + a);
	        $.material.init();
	        $('#paginator').datepaginator();
	        $http.get("users/isLoggedIn").success(function(data) {
	            console.log(data);
	            $rootScope.loggedUser = data;
	          }).error(function (data) {
	        	  
	          });
	      }); 
	    

	});


