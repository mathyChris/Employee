<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<!DOCTYPE html>

<html lang="ko" data-ng-app="employeeApp">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- reponsive app 구현위해  -->

<meta charset="UTF-8">

<%@ include file="/WEB-INF/view/commons.jspf" %>

<title>main.jsp</title>


<!-- URL Resolve -->
<c:url var ="URL_GET_LIST" value="/city/"/>
<c:url var ="URL_GET_PAGE_BASE" value="/city/page/"/>
<c:url var ="URL_GET_ITEM_BASE" value="/city/"/>

<script type="text/javascript">

//{} 는 객체 생성 
	var urls = { 
			
			GET_LIST : 			"${URL_GET_LIST}" , 
			GET_PAGE_BASE : 	"${URL_GET_PAGE_BASE}" , 
			GET_ITEM_BASE : 	"${URL_GET_ITEM_BASE}"
			
	}; 

	var deps = [ 
	            
	            'ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar' // chart , progress 이든 dependency 로 사용하기 위해 여기에 추가하면 된다. 
	            
	           ];

	var app = angular.module('employeeApp', deps); 
	
	// constant 의 사용 
	app.constant("URL", urls) ;  // angular 의 factory 에 넣은 것과 같다. 따라서 얼마든지 여러 곳에 injection 가능(여기저기 사용 가능) 
	// listControl.js ==> using 'URL' in "app.controller(~ , URL)"

	
	
	
	// angular 의 문법, router 설정 ==> provider 로 ...
// 	app.config(function($routeProvider) { 	// 설정하는 부분 
		
// 		console.log("Route config ... "); 
	
// 		$routeProvider.when("/list" , {  // 부분 페이지가 아래에 들어간다. <div data-ng-view>로 ...
			
// 			templateUrl: "list.html", 
// 			controller : "listController"	
		
		
// 		}) ; 
		
// 	});
	
	
	// 
	app.controller('mainController', function($scope, $http, $location) { // 모델 설정 ==> scope 
		
		console.log("mainController...");
		
		$location.path("/list") ; //  automatic, adding '#/list' to URL in 'URL window'
		// http://localhost:8080/Employee/city/main.html#/list
	
	});
	
	
</script>



<c:url var="listController" value="/js/city/listController.js"/>
<c:url var="detailController" value="/js/city/detailController.js"/>

<script type="text/javascript" src="${listController}"></script>
<script type="text/javascript" src="${detailController}"></script>



</head>

<body data-ng-controller="mainController" class="container">

	<h1> {{title}} </h1>
	
	<div data-ng-view> <!--  -->
	
	
	</div>

</body>

</html>







