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


//	2. deleteController 설정 부분 	
app.controller('deleteController', function($scope, $http, URL, $routeParams){ // $http는 Ajax를 사용하기 위한 것 
	
	console.log("deleteController..."); 
	console.log("URL.DELETE_ITEM_DELETE_BASE = " + URL.DELETE_ITEM_DELETE_BASE); 
	console.log("id = " + $routeParams.id); 

	$scope.$parent.title = "Delete City View"; 	
	
	

	
// 3. modifyController.js 의 조회 기능을 그대로 가져옴
	////// 조회 기능 : controller의 $routeParams 을 
	
	// 조회하는 기능을 설정하기위해 ajax 를 하나 정의 
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id); // /city/2000
	
	
	// data 를 조회하는 기능을 여기에 구현 
	ajax.then(function(value) {
		
		console.dir(value); 
		$scope.city = value.data ;  //cityForm --> city 로 변경...
		
	}, function(reason) {
		
		console.dir(reason) ; 
		alert("Error..."); 
	}); 
	
	
	$scope.submit = function(){
		
		var ajax =$http.put(URL.PUT_ITEM_MODIFY_BASE + $scope.city.id, {
			
			id 			: $scope.city.id , 
			name 		: $scope.city.name , 
			countryCode : $scope.city.countryCode, 
			district 	: $scope.city.district, 
			population 	: $scope.city.population
			
		} ); 
		
		
		ajax.then(function(response) {
			
			console.dir(response); 
			$location.path("/list"); 
			
		}, function(reason) {
			
			console.dir(reponse.data); 
			
		}); 
		
	}; 
	
	
 
	
	}); 

