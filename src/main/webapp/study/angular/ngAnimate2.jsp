<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta charset=UTF-8">

<%@ include file="/WEB-INF/view/commons.jspf" %>


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> ngAnimate.jsp </title>

<c:url var="URL_GET_PAGE_BASE" value="/city/page/"/>
	
	<script type="text/javascript">
	
	
	
		var deps = [
		            
					'ngRoute', 
					'ngAnimate', 
					'ngTouch', 
					'angular-loading-bar'
					
		            ] ;  
		
		
	
		var app = angular.module('employeeApp', depts) ;
		app.controller("mainController", function($scope, $http) {
			
			console.log("mainController..."); 
			
// 			var url = "/Employee/city/page/10";

			var url = "${URL_GET_PAGE_BASE} + 10" ;
			
			var ajax = $http.get(url); // using then instead of success 
			
			ajax.then(function(response) {
				
				console.log("Success..."); 
				
				console.dir(response); 
				
				$scope.cities = response.data.cities ;
				
			}, function(reason) {
				
				console.log("Error..."); 
				
				console.dir(reason); 
				
			}, function(value) {
				
				console.log("Notify..."); 
				
				console.dir(value); 
				
			})
			
			
		});
	
		
		
	</script>


</head>

<body data-ng-controller="mainController" class="container"> <!-- container -->

	<ul>
	
		<li data-ng-repeat="city in cities">
		
			{{city.id}} {{city.name}} {{city.district}}
		
		</li>
	
	</ul>

</body>

</html>









