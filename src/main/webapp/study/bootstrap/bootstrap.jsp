<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta charset=UTF-8">

<%@ include file="/WEB-INF/view/commons.jspf" %>


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> bootstrap.jsp </title>
	
	<style type="text/css">
	
	img{
		
		width : 100% ;
		height : 100px ;
		
	}

	</style>

	<script type="text/javascript">
		
		var app = angular.module("employeeApp", []) ; 
		app.controller("examController", function($scope) {
			
		}) ;
	
	
	
	</script>

</head>
<body data-ng-controller="examController" > 
	<!-- naver 홈페이지-->
	<!-- container는 반드시 최상위에 위치해야 한다, 2종류 밖에 없다. 화면에서 적절히 centering해준다. -->
	<!-- 반응형을 만들기 위해서는 container를 만들어 줘야한다. container는 2종류가 있다. -->

	<div class="container"> 
	
		<div class="row" > <!--  -->
		
			<div class="col-sm-6"> <!-- tablet size를 기준, bootstrap은 화면 크기를 12등분한다. 따라서 col-md-6는 절반 의미 -->
			
				<img alt="xxx" src="http://www.placehold.it/100x100/fffacd/0000ff?text=50%">
			
			</div>
			
			<div class="col-sm-6"> 
			
				<img alt="xxx" src="http://www.placehold.it/100x100/6a5acd/0000ff?text=50%">
			
			</div>
		
		</div>
		
		
		
		<div class="row" >
		
			<div class="col-ss-12"> 
			
					<img alt="xxx" src="http://www.placehold.it/100x100/da70d6/0000ff?text=100%">
			
			</div>
		
		
		</div>	
		
		
		
		
<!-- 		<img width="100%" class="img-responsive" alt="500x200" src="http://www.placehold.it/500x200/00ced1/f4a460?text=container"> -->
		
	</div>
	
	
	
	
	
	<div class="container-fluid"> <!-- 나머지 한 종류 , google과 같은 타입-->

<!-- 		<img width="100%" class="img-responsive" alt="500x200" src="http://www.placehold.it/500x200/9400d3/f4a460?text=container-fluid"> -->
		
		<div class="row" > <!--  -->
		
			<div class="col-sm-6"> <!-- tablet size를 기준, bootstrap은 화면 크기를 12등분한다. 따라서 col-md-6는 절반 의미 -->
			
				<img alt="xxx" src="http://www.placehold.it/100x100/fffacd/0000ff?text=50%">
			
			</div>
			
			<div class="col-sm-6"> 
			
				<img alt="xxx" src="http://www.placehold.it/100x100/6a5acd/0000ff?text=50%">
			
			</div>
		
		</div>
		
		<div class="row" >
		
			<div class="col-ss-12"> 
			
					<img alt="xxx" src="http://www.placehold.it/100x100/da70d6/0000ff?text=100%">
			
			</div>
		
		
		</div>	
		

		
	</div>

</body>
</html>














