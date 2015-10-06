angular.module('webappApp')
.controller('TaskCtrl', function ($http, $timeout, $scope, $routeParams) {

 console.log("In task page");
  $.material.init();
  $http.get("users/all").success(function putDataInScope(data) {
      $scope.users = data;
      
  $http.get('task/getTaskDetails?taskId=' + $routeParams.taskId).success(function(data) {
	  console.log(data);
	  $scope.task = data;
	  console.log("task details");
	  $scope.startDate = moment($scope.task['startDate']).format('Do');
	  $scope.startMonth = moment($scope.task['startDate']).format('MMMM');
	  $scope.lastUpdated = moment($scope.task['startDate']).fromNow();
  }).error(function() {
	  
  });
  
  $http.get('task/getTaskUser?taskId=' + $routeParams.taskId).success(function(data) {
	  console.log(data);
	  $scope.taskUser = data;
  }).error(function() {
	  
  });
     
  }).error(function tryAgainLater() {
     
  });
  
  $scope.addComment = function(){
	  
  }

  
});