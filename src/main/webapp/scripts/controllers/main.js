'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('MainCtrl', function ($http, $timeout, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    console.log("In Main");
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


