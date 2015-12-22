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
	
		<div class="col-sm-8 col-sm-offset-2"> <!-- column 을 적용, small size에서는 4칸만 사용, offset-3앞에서 3칸 떨어뜨림 -->
	
			<div class="panel panel-default">
			<div class="panel-heading"> Modify City </div>
			
			<pre>{{city}}</pre> <!-- model에 있는 city 를 그냥 출력,type을 보기 위해 -->
			
			<div class="panel-body">
			
				<form name = "cityForm" novalidate="novalidate" data-ng-submit="submit()"><!-- controller 에 submit()을 만들어야 한다. -->
					
					
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






