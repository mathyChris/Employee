<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp"> <!-- data-ng-app 붙은 부분 , 여기서는 html 이 angular 관리 영역에 들어가게 된다.  -->
<head>
<meta charset=UTF-8">

<%@ include file="/WEB-INF/view/commons.jspf" %>


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> city.jsp </title>



<c:url var="url_all" value="/city"/>
<c:url var="url_page" value="/city/page/"/>
<script type="text/javascript">

	
/* 	
	// 기본 angular 기능 구현 
	var app = angular.module('employeeApp', []) ;
	app.controller('listController', function($scope){
			
		
// 		alert('listController called...'); 	

		$scope.result = 0; 
		
		$scope.getData = function(){
			
			$scope.result += 1 ; 
			
		}; 
		
		$scope.clear = function(){
			
			$scope.result = 0 ; 
			
		};
		
	}); 
 */
 
	var app = angular.module('employeeApp', []) ;
	app.controller('listController', function($scope, $http){ // $http는 Ajax를 사용하기 위한 것 
		
// 		var url_all = "/Employee/city" ;
// 		var page = "/Employee/city/page";
		
		
		var url_all = "${url_all}"; 
		var url_page = "${url_page}";
		
		
		$scope.pageNo = 1  ;
		$scope.cities = []; 
		$scope.paging = [] ; 
		
		$scope.selectPage = function(){ 
		
			$http.get(url_page + $scope.pageNo).success(function(data, status, headers, config) {
				
				console.dir(data);
// 				alert("Success in url_all...."); 
				
				$scope.cities = data.cities ; // firefox 의 요소 검사에 console에 나오는 data 이름인 cities 를 사용 
				$scope.paging = data.paging ; 
				
			}) ;
 
	
	};
	
	
		$scope.selectPage(); 
	
		$scope.prevClick = function(pageNo) {
			
	// 		alert("PageNo = " + (pageNo - 1));
			$scope.pageNo = pageNo;
			$scope.selectPage(); 
			
		};
	
	
		$scope.nextClick = function(pageNo) {
			
// 			alert("PageNo = " + (pageNo + 1)); 
			$scope.pageNo = pageNo;
			$scope.selectPage(); 
			
		}; 
		
		
		$scope.pageClick = function(pageNo) {
			
			$scope.pageNo = pageNo;
			$scope.selectPage(); 
					
		};
		
 
	
	}); 
</script>

	
</head>
<body data-ng-controller="listController" class="container"> 

<h1> City List</h1>


	<div class="row">
	
		<div class="col-sm-2">
		
		</div>
		
		<div class="col-sm-8">
		
		
		<div class="table-responsive">
		
			<ul class="pagination">
				<li> <a ref="#" data-ng-click="prevClick(paging.firstPage - 1)"> Prev </a></li>
				
				<li data-ng-repeat="">
					
				</li>
				
				<li> <a ref="#" data-ng-click="nextClick(paging.lastPage + 1)"> Next </a></li>
			
			</ul>
		
			<table class="table table-condensed table-bordered table-striped table-hover" >
			
				<thead>
					<th> Index </th> <th>Name </th> <th> ID </th> <th>CountryCode</th> <th>District</th> <th>Population</th>
				</thead>
				
				<tbody>
				
					<tr data-ng-repeat="city in cities">
					
						<td> {{$index+1}}</td>
						<td>{{city.name}}</td>
						<td>{{city.id}}</td>
						<td>{{city.countryCode}}</td>
						<td>{{city.population}}</td>
						<td>{{city.district}}</td>
						
						
					</tr>
				</tbody>
	
	
			</table>
		</div>
		
		
		</div>
		
		<div class="col-sm-8"></div>
	
	</div>
	
	



	<div class="row">
	
		<div class="col-sm-12">
		
			<div class="form-group">
			
				<textarea rows="10" class="form-control">{{cities}} {{paging}}</textarea>
				
			</div>
			
		</div>
	
	
	</div>
	




<!-- <button class="btn btn-primary" data-ng-click="getData()"> GET </button>  -->
<!-- <button class="btn btn-success" data-ng-click="clear()"> Clear</button> -->
<!-- <hr> -->
<!-- <textarea rows="20" cols="50">{{result}}</textarea> -->

<!-- <button class="btn btn-default"> Default</button> -->

</body>
</html>






