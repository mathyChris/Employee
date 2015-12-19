<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko">
<head>
<title>modify.jsp</title>
	
</head>
<body class="container"> 

	<a class="btn btn-primary" href="#/list">List...</a>
	
	
	<pre>{{city}}</pre>
	
	
	<div class="row">  <!--  grid 로 만든다. 큰 화면에서 입력란이 너무 크다...이를 조절해보자. -->
	
		<div class="col-sm-8 col-sm-offset-2"> <!-- colume 을 적용, samll size에서는 4칸만 사용, offset-3앞에서 3칸 떨어뜨림 -->
	
			<div class="panel panel-default">
			<div class="panel-heading"> Modify City </div>
			
			<pre>{{city}}</pre> <!-- model에 있는 city 를 그냥 출력,type을 보기 위해 -->
			
			<div class="panel-body">
			
				<form name = "cityForm" novalidate="novalidate" data-ng-submit="submit()"><!-- controller 에 submit()을 만들어야 한다. -->
					
					<!-- ID  -->
					<div class="form-group">	
						<label for="name">ID :</label>		<!-- label을 클릭하면 input으로 커서가 간다. -->
						
						<input id="id"
							   name="id" 
						       type="text" 
						       class="form-control" 
						       required = "required"
						       data-ng-model="city.id" 
						       readonly="readonly"
						       disabled="disabled"
						       /> 
						       
					</div>
					
							
					<!--  Name -->
					<div class="form-group">	
						<label for="name">Name :</label>		<!-- label을 클릭하면 input으로 커서가 간다. -->
						
						<input id="name"
							   name="name" 
						       type="text" 
						       class="form-control" 
						       required = "required"
						       data-ng-model="city.name" 
						       data-ng-maxlength = "35" 
						       /> 
						       
					<div>cityForm.name.$invalid = {{cityForm.name.$invalid}}</div>      
					<div>cityForm.name.$error.required = {{cityForm.name.$error.required}}</div> 
					<div>cityForm.name.$error.maxlength = {{cityForm.name.$error.maxlength}}</div> 
					
					<div data-ng-show="cityForm.name.$dirty">
					    <div class="alert alert-warning" data-ng-show="cityForm.name.$error.required">필수 입력 항목입니다.</div>  <!-- ng-show 는 ""안이 true인 경우 보이게 한다.-->
					    <div class="alert alert-warning" data-ng-show="cityForm.name.$error.maxlength">35자리까지 입력 가능합니다.</div>
					  <!-- data-ng-hide  , data-ng-show -->
					</div> 
					
					
					</div>
					
					<!-- CountryCode -->
					<div class="form-group">	
					
						<label for="countryCode">CountryCode :</label>	<!-- countryCode 는 select option 으로 구현하도록... -->	
						<input id="countryCode" 
							   name="countryCode"
							   type="text" 
							   class="form-control"
							   required = "required"
						       data-ng-model="city.countryCode" 
						       data-ng-maxlength = "3"
						       data-ng-minlength = "3"
								>  
								
					<div>cityForm.countryCode.$invalid = {{cityForm.countryCode.$invalid}}</div>      
					<div>cityForm.countryCode.$error.required = {{cityForm.countryCode.$error.required}}</div> 
					<div>cityForm.countryCode.$error.maxlength = {{cityForm.countryCode.$error.maxlength}}</div> 
					<div>cityForm.countryCode.$error.minlength = {{cityForm.countryCode.$error.minlength}}</div> 
					
					
				    <div data-ng-show="cityForm.countryCode.$dirty">
					  <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.required">필수 입력 항목입니다.</div> 
<!-- 					  <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.maxlength">최대 3자리까지 입력 가능합니다.</div> -->
<!-- 					  <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.minlength">최소 3자리부터 입력 가능합니다.</div> -->
					  
					  <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.minlength // cityForm.countryCode.$error.maxlength">3자리만 입력 가능합니다.</div>
					</div> 			
								
					</div>
					
					
					<!-- District -->
					<div class="form-group">	
						<label for="district">District :</label>		
						<input id="district" 
							   name = "district"
							   type="text" 
							   class="form-control"
							   required = "required"
						       data-ng-model="city.district" 
						       data-ng-maxlength = "20">  
						        
					 
					 <div>cityForm.district.$invalid = {{cityForm.district.$invalid}}</div>      
					 <div>cityForm.district.$error.required = {{cityForm.district.$error.required}}</div> 
					 <div>cityForm.district.$error.maxlength = {{cityForm.district.$error.maxlength}}</div> 
					 <div>cityForm.district.$error.minlength = {{cityForm.district.$error.minlength}}</div> 
					
					 			
					 <div data-ng-show="cityForm.district.$dirty">
						  <div class="alert alert-warning" data-ng-show="cityForm.district.$error.required">필수 입력 항목입니다.</div> 
						  <div class="alert alert-warning" data-ng-show="cityForm.district.$error.maxlength">20자리까지 입력 가능합니다.</div>
					 </div> 			
								
					</div>
					
					
					<!-- Population -->
					<div class="form-group">	
						<label for="population">Population :</label>		
						<input id="population" 
							   name = "population"
							   type="number" 
							   class="form-control"
							   required = "required"
						       data-ng-model="city.population" 
						       data-ng-min = "0"
						       data-ng-max = "2147483647">  <!-- w3school 에서 확인, mysql 의 int  -->
						       
					 <div>cityForm.population.$invalid = {{cityForm.population.$invalid}}</div>      
					 <div>cityForm.population.$error.required = {{cityForm.population.$error.required}}</div> 
					 <div>cityForm.population.$error.number = {{cityForm.population.$error.number}}</div> 
					 <div>cityForm.population.$error.max = {{cityForm.population.$error.max}}</div> 
					 <div>cityForm.population.$error.min = {{cityForm.population.$error.min}}</div> 
					
					 			
					 <div data-ng-show="cityForm.population.$dirty">
						  <div class="alert alert-warning" data-ng-show="cityForm.population.$error.required">필수 입력 항목입니다.</div>
						  <div class="alert alert-warning" data-ng-show="cityForm.population.$error.number">숫자만 입력 가능합니다.</div> 
						  <div class="alert alert-warning" data-ng-show="cityForm.population.$error.max">11자리까지만 입력 가능합니다.</div>
						  <div class="alert alert-warning" data-ng-show="cityForm.population.$error.min">0이상 입력 가능합니다.</div>
					 </div> 				       
						       
					</div>
					
					<!-- Submit --><!-- submit 는 valid 한 경우에만 작동하게 해야함 -->
					<div class="form-group">	
						<input type="submit" 
							   value="확인"
							   class="btn btn-primary" 
			
							   data-ng-disabled="cityForm.$invalid"/> 
							   
					<div>  cityForm.$invalid = {{cityForm.$invalid}} </div>
					
					</div>
					
				</form>
			
			</div>
		</div>
	
	</div>

</div>
	

</body>
</html>






