angular.module('webappApp')
.controller('TaskCtrl', function ($http, $timeout, $scope) {

 console.log("In task page");
  $.material.init();
  $http.get("users/all").success(function putDataInScope(data) {
      $scope.users = data;
     
  }).error(function tryAgainLater() {
     
  });
  
//  $scope.createUser = function(){
//	  $http.post("users/create", angular.toJson($scope.user)).success(function putDataInScope(data) {
//		    console.log("Saved");
//		    $scope.user= {};
//		    $('#createUserModal').modal('toggle');
//		    $scope.users = data;
//		  }).error(function tryAgainLater() {
//			  console.log("Error"); 
//		  });
//  }
  
});