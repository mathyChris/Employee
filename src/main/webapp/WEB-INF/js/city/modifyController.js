/**
 * @author java
 */

//	1. route 설정하는 부분
 	app.config(function($routeProvider) { 
		
 		console.log("/modify config ... "); 
	
 		$routeProvider.when("/modify/:id" , { // main.jsp 의 <div data-ng-view> 부분으로 들어간다. 
			
 			templateUrl: "modify.html", 
 			controller : "modifyController"	
		
 		}) ; 
		
 	});


//	2. detailController 설정 부분 	
app.controller('modifyController', function($scope, $http, URL, $routeParams, $location){ // $http는 Ajax를 사용하기 위한 것 
	
	console.log("modifyController..."); 
	console.log("URL.PUT_ITEM_MODIFY_BASE = " + URL.PUT_ITEM_MODIFY_BASE); 
	console.log("URL.GET_ITEM_MODIFY_BASE = " + URL.GET_ITEM_MODIFY_BASE);
	console.log("id = " + $routeParams.id); 
	
	$scope.$parent.title = "Modify City View"; 	
	
	
	////// 조회 기능 : controller의 $routeParams 을 
	
	// 조회하는 기능을 설정하기위해 ajax 를 하나 정의 
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id); // /city/2000 라는 형태의 URL을 받는다는 뜻 ...
	
	
	// data 를 조회하는 기능을 여기에 구현 
	ajax.then(function(value) {
		
		console.dir(value); 
		$scope.city = value.data ;  //cityForm --> city 로 변경...
		
	}, function(reason) {
		
		console.dir(reason) ; 
		alert("Error..."); 
	}); 
	
	
	$scope.submit = function(){
		
		var ajax =$http.put(URL.PUT_ITEM_MODIFY_BASE + $scope.city.id, { // 모든 정보는 URL 로 주고 받는다. 
			
			id 			: $scope.city.id , 
			name 		: $scope.city.name , 
			countryCode : $scope.city.countryCode, 
			district 	: $scope.city.district, 
			population 	: $scope.city.population
			
		} ); 
		
		
		ajax.then(function(response) {
			
			console.dir(response); 
			$location.path("/list"); // list 로 장면 전환하기 위해 path 를 걸어줌 
			
		}, function(reason) {
			
			console.dir(reponse.data); 
			
		}); 
		
	}; 
 
	
	}); // # app-controller










