'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('MainCtrl', function ($http, $timeout, $scope, $location) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    this.getUrlPath = function() {
    	return $location.path();
    }
    console.log("In Main");
    console.log($location.path());
    $.material.init();
    $http.get("users/count").success(function putDataInScope(data) {
        $scope.countdata = data;
       
    }).error(function tryAgainLater() {
       
    });
    
  });
/*$http.get("projects/count").success(function putDataInScope(data) {
    $scope.projectdata = data;
   
}).error(function tryAgainLater() {
   
});*/



/*Project Controller*/
angular.module('webappApp')
.controller('ProjCtrl', function ($http, $timeout, $scope, $route, $routeParams) {
	console.log($routeParams.projId);
  console.log("In Proj");
  $.material.init();
  $http.get("projects/all").success(function putDataInScope(data) {
      $scope.projects = data;
     
  }).error(function tryAgainLater() {
     
  });
  
  $scope.createProject = function(){
	  $http.post("projects/create", angular.toJson($scope.proj)).success(function putDataInScope(data) {
	    console.log("Saved");
	     
	  }).error(function tryAgainLater() {
		  console.log("Error"); 
	  });
  }
  
});


angular.module('webappApp')
.controller('UserCtrl', function ($http, $timeout, $scope) {

  console.log("In User");
  $.material.init();
  $http.get("users/all").success(function putDataInScope(data) {
      $scope.users = data;
     
  }).error(function tryAgainLater() {
     
  });
  
});


