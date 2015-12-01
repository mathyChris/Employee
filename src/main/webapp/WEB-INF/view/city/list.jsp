<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko">
<head>

<!-- <title> city.jsp </title> -->


<%-- <c:url var="url_all" value="/city"/> --%>
<%-- <c:url var="url_page" value="/city/page/"/> --%>

	
</head>
<body class="container"> 


	<div class="table-responsive">
		
			<ul class="pagination">
			
				<li> <a ref="" data-ng-click="prevClick(paging.firstPage - 1)"> Prev </a></li>
				
				<li data-ng-repeat="city in cities">
					
					<a href="" data-ng-click="pageClick(paging.firstPage + $index)">{{paging.firstPage + $index}}</a>
					
				</li>
				
				<li> <a ref="" data-ng-click="nextClick(paging.lastPage + 1)"> Next </a></li>
			
			</ul>
		
			<table class="table table-condensed table-bordered table-striped table-hover" >
			
				<thead>
					<th> Index </th> <th> ID  </th> <th> Name </th> <th>CountryCode</th> <th>District</th> <th>Population</th>
				</thead>
				
				<tbody>
				
					<tr data-ng-repeat="city in cities">
					
						<td> {{$index+1}}</td>
						<td> <a href="#/detail"> {{city.id}}</a></td> <!--  -->
						<td> {{city.name}} </td>
						<td>{{city.countryCode}}</td>
						<td>{{city.population}}</td>
						<td>{{city.district}}</td>
						
						
					</tr>
				</tbody>
	
	
			</table>

	
	</div>
	
	



		
			<div class="form-group">
			
				<textarea rows="10" class="form-control">{{cities}} {{paging}}</textarea>
				
			</div>
			


</body>
</html>






