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

<title>ngAnimate.jsp</title>

<c:url var="URL_GET_PAGE_BASE" value="/city/page/"/>

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
		
		var url = "${URL_GET_PAGE_BASE}" + 10;
		
		var ajax = $http.get(url);
		
		
// 		two ways for expressing functions in the below   
// 		One way 

		ajax.then(success, reason); 
		
			function success(response) {
				
				console.log("success...");
				
				console.dir(response);
				
				$scope.cities = response.data.cities;
				
			}
			
			function reason(reason) {
				console.log("error...");
				console.dir(reason);
			}
		
		
//		Two way 		
/* 		ajax.then(function(response) {
			
			console.log("success...");
			
			console.dir(response);
			
			$scope.cities = response.data.cities;
			
		}, function(reason) {
			console.log("error...");
			console.dir(reason);
		}, function(value) {
			console.log("notify...");
			console.dir(value);
		}); */
		
	});
	
</script>

	<style type="text/css">
	

 		.myFade.ng-enter{
			
			opacity : 0.0 ; 
			
/* 			transition : all 5s;	 */
			
/* 			transform : scale(0,0);  */

			transform : rotate(-180deg); 
			
			transition : 3s ease-out;
/* 			transition's 'default setting is 'all'	 */
				
		}
	
		.myFade.ng-enter-active{
		
			opacity : 1.0  ;
/* 			transform : scale(1,1);  */
			
			transform : rotate(0deg); 
		
		} 
		
		
		.myFade.ng-leave { opacity: 1; }


		.myFade.ng-leave.ng-leave-active { opacity: 0; }
		
	
	</style>

</head>
<body data-ng-controller="mainController" class="container">

	<ul class="list-group">
		<li class="list-group-item myFade" data-ng-repeat="city in cities">
			<button class="btn btn-primary"> {{city.id}} </button> 
			<button class="btn btn-success"> {{city.name}} </button>
			<button class="btn btn-info"> {{city.district}} </button>
		</li>
	</ul>
	
	
	<div class="panel-group">
		<div class="panel panel-primary" data-ng-repeat="city in cities">
		
			<div class="panel-heading">  {{city.name}} </div>
			<div class="panel-body">  {{city.id}} {{city.district}} {{city.population}}</div>
			<div class="panel-footer"> {{city.countryCode}} </div>
			
		</div>
	</div>
	
</body>

</html>






