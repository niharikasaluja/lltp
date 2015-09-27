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
    
    this.getFavs = function() {
    	
    }
    
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
	 $('#paginator').datepaginator();
	$http.get("users/userByProject?projectId="+$routeParams.projId).success(function setProjectDetails(data) {
	      $scope.projectUsers = data;
	      console.log("project users");
	      console.log($scope.projectUsers);
	  }).error(function projectFetchFail() {
	     console.log("unable to get the details for the project: " + $routeParams.projId);
	  });
	
	
	if($routeParams.projId) {
		$scope.projId = $routeParams.projId;
		$http.get("task/allTasksForProject?projectId="+$routeParams.projId).success(function setProjectDetails(data) {
		      $scope.tasks = data;
		      console.log($scope.tasks);
		  }).error(function projectFetchFail() {
		     console.log("unable to get the details for the project: " + $routeParams.projId);
		  });
		
		$http.get("users/all").success(function putDataInScope(data) {
		      $scope.allusers = data;
		     
		  }).error(function tryAgainLater() {
		     
		  });
	}
	
	$scope.addUserToProject = function(){
		console.log($routeParams.projId);
		
		console.log($scope.selectedUser.originalObject);
		$http.post('users/assignUserToProject?projId='+$routeParams.projId,$scope.selectedUser.originalObject).
		  then(function(response) {
			  $("#ex1_value").val('');
			  $scope.searchStr = '';
			  $scope.projectUsers = response.data;
		    // this callback will be called asynchronously
		    // when the response is available
		  }, function(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
		
	}
	
  $scope.saveTask = function() {
	  console.log("saving new task for proj: " + $routeParams.projId + $scope.taskTitle);
	  $http.post('task/create?projId='+$routeParams.projId,$scope.projTask).
	  then(function(response) {
		  $('#createTaskModal').modal('toggle');
		  $scope.tasks = response.data;
	    // this callback will be called asynchronously
	    // when the response is available
	  }, function(response) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	  
  }
	
	
 
  $.material.init();
  $http.get("projects/all").success(function putDataInScope(data) {
      $scope.projects = data;
     
  }).error(function tryAgainLater() {
     
  });
  
  $scope.createProject = function(){
	  $http.post("projects/create", angular.toJson($scope.proj)).success(function putDataInScope(data) {
	    console.log("Saved");
	    $scope.proj= {};
	    $('#createProjectModal').modal('toggle');
	    $scope.projects = data;
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
  
  $scope.createUser = function(){
	  $http.post("users/create", angular.toJson($scope.user)).success(function putDataInScope(data) {
		    console.log("Saved");
		    $scope.user= {};
		    $('#createUserModal').modal('toggle');
		    $scope.users = data;
		  }).error(function tryAgainLater() {
			  console.log("Error"); 
		  });
  }
  
});


