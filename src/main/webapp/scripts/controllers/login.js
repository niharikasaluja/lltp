'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('LoginController', function ($http, $timeout, $scope) {
	  
	  $scope.login = function(){
		  $http({
				method:'post',
				url:'login',
				params:{'j_username':$scope.username, 'j_password': $scope.password},
				
	    	}).success(function (data){
	    		console.log(data);
	    		
	    	}).error(function(data){
	    		console.log(data);				     	
	    	});  
	  }
		
  
  });
