<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>

<html lang="ko" data-ng-app="employeeApp">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/commons.jspf" %>
<title>ngTouch.jsp</title>
<style type="text/css">
	.swipe-box {
		height: 200px;
		background-color: red;
		border: 1px solid black;
	}
</style>

<script type="text/javascript">

	var deps = [

		     'ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'
	           ];

	var app = angular.module("employeeApp", deps);
	
	app.controller("mainController", function($scope, $http) {
		console.log("mainController...");
		
		$scope.swipeLeft = function(e) {
			
			console.log("swipeLeft()...");
			
			console.dir(e);
			
			$(e.target).css('border-radius', '0px') ; // jquery 의 기능을 사용
			
			$scope.msg = "ng-swipe-left fired...";
		};
		
		$scope.swipeRight = function(e) {

			console.log("swipeRight()...");

			console.dir(e); 
			
			$(e.target).css('border-radius', '50px') ;
			
			$scope.msg = "ng-swipe-right fired...";
		};
		
		
		/*
		* image Test
		*
		*/
		
		$scope.imgURL = "http://www.placehold.it/400x400/ff0000/0000ff?text=5" ;
		
		$scope.imgURLs = [
		          
		        {alt : '1' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=1'} , 
		        {alt : '2' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=2'} , 
		        {alt : '3' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=3'} , 
		        {alt : '4' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=4'} , 
		        {alt : '5' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=5'} , 
		        {alt : '6' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=6'} , 
		        {alt : '7' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=7'} , 
		        {alt : '8' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=8'} , 
		        {alt : '9' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=9'} , 
		        {alt : '10' , src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=10'} , 
		     
		          ] ; 

		var index = 5 ; 
		
		$scope.imgURL = $scope.imgURLs[index].src; 
		
		$scope.imgSwipeLeft = function(e) {
			
			console.log("imgSwipeLeft()...");
			
			console.dir(e); // 객체의 속성들을 출력 
					
			$scope.imgMsg = "ng-swipe-left fired...";
			
// 			$scope.imgURL = "http://www.placehold.it/400x400/ff0000/0000ff?text=SwipeLeft..." ; 

// 			var index = 5 ; 		
			
			$scope.imgURLs[index]; 
			
			var indexLeft = index - 1 ;  // index? $scope.index ? $scope.imgURLs.index?
		
 			if(indexLeft < 0) {
 				
 				$scope.imgURL = $scope.imgURLs[9].src ; }
			
 			else {
 				
				$scope.imgURL = $scope.imgURLs[indexLeft].src ; }

//			indexLeft = 0 - 1  ==> index = 9  

				
		};
		
		
		$scope.imgSwipeRight = function(e) {
			
			console.log("imgSwipeRight()...");
			
			console.dir(e);
			
			$scope.imgMsg = "ng-swipe-right fired...";
			
// 			$scope.imgURL ="http://www.placehold.it/400x400/0000ff/ff0000?text=SwipeLeft..." ; 

// 			var index = 5 ; 
			
			$scope.imgURLs[index]; 

			var indexRight = index + 1 ; 
	
			if(indexRight > 9){
	
			
				$scope.imgURL = $scope.imgURLs[0].src; }
			
			else{

				$scope.imgURL = $scope.imgURLs[indexRight].src; }
		
		};
		
		
		$scope.prevent = function(e) {
			
			e.preventDefault(); 
			
		}
		
		
	});
	
</script>
</head>
<body data-ng-controller="mainController" class="container">

	<div data-ng-swipe-left="swipeLeft($event)"
	
		 data-ng-swipe-right="swipeRight($event)" 
		 
		 class="swipe-box">
		 
	</div>	

	<hr>
	<p>{{msg}}</p>
	
	<hr>
	

	
	<img  data-ng-swipe-left="imgSwipeLeft($event)"
	
		 data-ng-swipe-right="imgSwipeRight($event)" 
		 
		 data-ng-click="prevent($event)"

		 ondragStart="return false"
	
		 draggable="false" class="img-responsive" alt="{{imgURL}}" data-ng-src="{{imgURL}}">

		 
	<hr>

	 <p>{{imgMsg}}</p>


</body>
</html>





