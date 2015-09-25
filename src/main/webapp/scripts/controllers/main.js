'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('MainCtrl', function ($http, $timeout) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    console.log("In Main");
    
    $http.get("users/all").success(function putDataInScope(data) {
      //  $scope.data = data;
       
    }).error(function tryAgainLater() {
       
    });
    
  });
