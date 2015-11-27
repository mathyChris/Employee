<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp"> <!-- 1. ng-app- 생성 -->
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>angular.jsp</title>

<%@ include file="/WEB-INF/view/commons.jspf" %>

<style type="text/css">
	.red {
		background-color: red;
		color: blue;
	}
</style>

<script type="text/javascript">

	var app = angular.module("employeeApp", []); // 3. angular-module 생성 
	app.controller("examController", function($scope, $http) { // 4. app-controller 생성 

		$scope.title = "Chris's stomps";
	
	
		$scope.titleClick = function() {
			$scope.title += "+";
		};
		

		$scope.depts = [
		                
			{deptno : 10, dname : 'mainOffice1mainOffice1mainOffice1mainOffice1mainOffice1mainOffice1', loc : 'seoul1'},
			{deptno : 20, dname : 'mainOffice2', loc : 'seoul2'},
			{deptno : 30, dname : 'mainOffice3', loc : 'seoul3'},
			{deptno : 40, dname : 'mainOffice4', loc : 'seoul4'},
			{deptno : 50, dname : 'mainOffice5', loc : 'seoul5'}
		
		];
		
		
		$scope.deleteDept = function(index) {
			
			var id = $scope.depts[index].deptno; // index 는 배열의 index의 의미
			alert("id = " + id);
			
			$scope.depts.splice(index, 1); // $scope.depts.splice 는 delete의 의미
			
		};
		
		
		// placehold.it 사이트를 이용하여 이미지를 가져온다.
		$scope.imgs = [
		               
			{alt : '100', src : 'http://www.placehold.it/100x100/ff0000/0000ff?text=cat'},
			{alt : '200', src : 'http://www.placehold.it/200x200/00ff00/0000ff?text=cat1'},
			{alt : '300', src : 'http://www.placehold.it/300x300/00bfff/0000ff?text=dog'},
			{alt : '400', src : 'http://www.placehold.it/400x400/deb887/0000ff?text=duck'},
			{alt : '500', src : 'http://www.placehold.it/500x500/00ced1/0000ff?text=zebra'}
		
		];

		
	});

</script>

</head>

<body data-ng-controller="examController"> <!-- 2. ng-controller 생성 -->

	<h1 data-ng-click="titleClick()">{{title}}</h1> <!-- ng-click 사용 -->
	<p>3 + 4 = {{3 + 4}}</p>
	<hr>
	
	<input type="text" data-ng-model="name"/> <!-- 입력 부분에 ng-model 을 사용  -->
	<h3>{{name}}</h3>
	<hr>


	<div class="table-responsive">
			<table class="table table-condensed table-bordered"> <!-- table-condensed : table의 크기를 줄임 -->
			
				<thead>
			
					<tr><th>No</th><th>deptno</th><th>dname</th><th>loc</th><th> </th></tr>
					</thead>
			
				<tbody>
				
					<tr data-ng-repeat="dept in depts"> <!-- ng-repeat는 for 문 -->
					<!-- dept in depts ==> depts 배열의 각 객체를 dept로 받는다.  -->
					
						<td>{{$index}}</td>  <!-- $index는 배열의 index를 나타낸다. -->
						<td>{{dept.deptno}}</td>
						<td>{{dept.dname}}</td>
						<td>{{dept.loc}}</td>
						
						<td><a href="#" class="btn btn-primary" data-ng-click="deleteDept($index)">Delete</a></td>
			
					</tr>
			
				</tbody>
			
			</table>
	</div>

<hr>



<div class="table-responsive"> 
<table class="table table-condensed table-bordered">
	<thead>
	<tr><th>deptno</th><th>dname</th><th>loc</th></tr>
	</thead>
	<tbody>
	<tr>
		<td class="red">{{depts[0].deptno}}</td>
		<td>{{depts[0].dname}}</td>
		<td>{{depts[0].loc}}</td>
	</tr>
	<tr>
		<td>{{depts[1].deptno}}</td>
		<td>{{depts[1].dname}}</td>
		<td>{{depts[1].loc}}</td>
	</tr>
	<tr>
		<td>{{depts[2].deptno}}</td>
		<td>{{depts[2].dname}}</td>
		<td>{{depts[2].loc}}</td>
	</tr>
	<tr>
		<td>{{depts[3].deptno}}</td>
		<td>{{depts[3].dname}}</td>
		<td>{{depts[3].loc}}</td>
	</tr>
	<tr>
		<td>{{depts[4].deptno}}</td>
		<td>{{depts[4].dname}}</td>
		<td>{{depts[4].loc}}</td>
	</tr>					

	</tbody>
</table>
</div>




<ul class="list-group">
	<li class="list-group-item" data-ng-repeat="img in imgs">
	
		<h3> {{img.src}}</h3>
		<img class="img-circle img-responsive" alt="{{img.alt}}" src="{{img.src}}">
	</li>
</ul>






</body>
</html>




