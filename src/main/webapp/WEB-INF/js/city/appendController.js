/**
 * @author java
 */

//	1. route 설정하는 부분
 	app.config(function($routeProvider) { 
		
 		console.log("/append config ... "); 
	
 		$routeProvider.when("/append" , { // main.jsp 의 <div data-ng-view> 부분으로 들어간다. 
			
 			templateUrl: "append.html", 
 			controller : "appendController"	
		
 		}) ; 
		
 	});


//	2. detailController 설정 부분 	
app.controller('appendController', function($scope, $http, $location, URL){ // $http는 Ajax를 사용하기 위한 것 
	
	console.log("appendController..."); 
	console.log("URL.POST_ITEM_APPEND = " + URL.POST_ITEM_APPEND); 

	$scope.$parent.title = "Append City View"; 	
	
//	$scope.city = {
//		
//			name : "", 
//			conturyCode : ""
//	}
	
	$scope.city = {} ; 
	
	$scope.submit = function(){
	
		var ajax = $http.post(URL.POST_ITEM_APPEND, { // post method ==> insert 
			
			name : $scope.city.name , 
			district : $scope.city.district , 
			countryCode : $scope.city.countryCode , 
			population : $scope.city.population  
			
			
		}) ;
		
		ajax.then(function(value) {
			
			$location.path("/list"); 
			// app.controller 안의 function 안에 $location 을 사용하여 입력이 정상적으로 수행 시 /list 로 이동
			
		}, function(reason) {
			
			console.dir(reason) ; 
			
			$scope.city = reason.data ; 
			
		})
		
	} ; 
	
	}); 

