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
			
			
			
		
		
		
		
		
<!-- 			<a href="#/append" class="btn btn-primary">Append</a> -->
		
			<table class="table table-condensed table-bordered table-striped table-hover" >
			
				<thead>
					<tr><td> <a href="#/append" class="btn btn-primary">Append</a> </td></tr>
					
					<tr><th colspan = "8">
					
						<!-- angular-ui-bootstrap 을 사용하기 위한 tag -->
						
<!-- 						<div> -->
<!-- 							<uib-pagination total-items="paging.totalItem"  -->
<!-- 											ng-model="paging.pageNo"  -->
<!-- 											num-pages = "10" -->
<!-- 											ng-change="pageChanged()"> -->
							
<!-- 							</uib-pagination> -->
							
<!-- 						</div> -->
						
						
						<div data-uib-pagination 
							 data-total-items="paging.totalItem" style="800px;"
							 data-ng-model="pageNo"
							 data-max-size="10"
							 data-ng-change="selectPage()"
							 data-boundary-links="true">
						</div>
					
					
					
					
					</th></tr>
				
					<tr>
					
						<th> Index </th> 
						<th> Id  </th> 
						<th> Name </th> 
						<th>CountryCode</th> 
						<th>District</th> 
						<th>Population</th>
						<th>Edit</th>
						<th>Delete</th>
					
					</tr>
				</thead>
				
				<tbody>
				
					<tr data-ng-repeat="city in cities">
					
						<td> {{$index+1}}</td>
						<td> <a href="#/detail/{{city.id}}"> {{city.id}}</a></td> <!-- route의 path로  -->
						<td> {{city.name}} </td>
						<td>{{city.countryCode}}</td>
						<td>{{city.district}}</td>
						<td>{{city.population}}</td>
						<td><a href="#/modify/{{city.id}}" class="btn btn-success"> Edit ...</a></td>
						<td><a href="#/delete/{{city.id}}" class="btn btn-info"> Delete...</a></td>
						
					</tr>
				</tbody>
	
	
			</table>

	
	</div>
	
	



		
			<div class="form-group">
			
				<textarea rows="10" class="form-control">{{cities}} {{paging}}</textarea>
				
			</div>
			


</body>
</html>






