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
  
  $http.get('task/getTaskComments?taskId=' + $routeParams.taskId).success(function(data) {
	  console.log(data);
	  $scope.taskComments = data;
  }).error(function() {
	  
  });
  
  }).error(function tryAgainLater() {
     
  });
  
  $scope.addComment = function(){
	  console.log("Comment added");
	  $http.post('comment/addComment?taskId='+$routeParams.taskId,$scope.comment).
	  then(function(response) {
		  console.log(response);
		  $scope.taskComments = response.data;
		  // this callback will be called asynchronously
	    // when the response is available
	  }, function(response) {
		  console.log(response);
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
  }

  
});