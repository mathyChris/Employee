/**
 * @author java
 */

//	1. route 설정하는 부분
 	app.config(function($routeProvider) { 
		
 		console.log("/delete config ... "); 
	
 		$routeProvider.when("/delete/:id" , { // main.jsp 의 <div data-ng-view> 부분으로 들어간다. 
			
 			templateUrl: "delete.html", 
 			controller : "deleteController"	
		
 		}) ; 
		
 	});


 	app.controller('deleteController', function($scope, $http, URL, $routeParams) {
 		console.log("deleteController...");
 		console.log("URL.DELETE_ITEM_DELETE_BASE = " + URL.DELETE_ITEM_DELETE_BASE);
 		console.log("id = " + $routeParams.id);
 		
 		$scope.$parent.title = "Delete City View";
 		
 		var ajax = $http.delete(URL.DELETE_ITEM_DELETE_BASE + $routeParams.id); // delete method 사용 
 		
 		ajax.then(function() {
 			$scope.$parent.title = "삭제 성공";
 		}, function() {
 			$scope.$parent.title = "삭제 실패";
 		});

 	}); 