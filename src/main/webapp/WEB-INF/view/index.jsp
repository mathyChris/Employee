<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> Index.jsp </title>



<!-- 	1. 다음과 같이 bootstrap , jquery, angular를 사용함  -->
<!-- <link rel="stylesheet" href="/Employee/bootstrap/dist/css/bootstrap.css"/> <!-- web browser 에서 동작, 따라서 href는 절대주소로 Employee부터 시작  -->
<!-- <script type="text/javascript" src="/Employee/jquery/dist/jquery.js"></script> -->
<!-- <script type="text/javascript" src="/Employee/angular/angular.js"></script> -->

<!--  2. 위의 사용 방법에서 c tag를 이용하는 방법, server 에서부터 url값이 들어올 때는 절대주소는 project를 뺀 부분부터... -->
<%-- <c:url var="bootstrap" value="/bootstrap/dist/css/bootstrap.css"/>  <!-- server 에서 동작  --> --%>
<%-- <c:url var="angular" value="/angular/dist/angular.js"/> --%>
<%-- <c:url var="jquery" value="/jquery/dist/jquery.js"/> --%>

<%-- <link rel="stylesheet" href="${bootstrap}"/> --%>
<%-- <script type="text/javascript" src="${angular}"></script> --%>
<%-- <script type="text/javascript" src="${jquery}"></script> --%>


<%@ include file="/WEB-INF/view/commons.jspf" %>



<style type="text/css">

	.title_animation{
	
		animation : blink 10s infinite; 
	}

	@keyframes blink {
	
/* 		from {
		
			background-color : orange ; 
			opacity : 0 .0 ; 
		}
	
		to  {
		
			background-color : yellow ; 
			opacity : 1.0  ;
		} */
		
	0%   {background-color:orangered; left:0px; top:0px;}
    25%  {background-color:yellow; left:400px; top:0px;}
    50%  {background-color:dodgerblue; left:400px; top:200px;}
    75%  {background-color:lawngreen; left:0px; top:200px;}
    100% {background-color:red; left:0px; top:0px;}
		
	}
	
	
	
	.div1 {
    width: 100px;
    height: 100px;
    background-color: red;
    position: relative;
    -webkit-animation-name: RectangleDance; /* Chrome, Safari, Opera */
    -webkit-animation-duration: 4s ; /* Chrome, Safari, Opera */
    animation-name: RectangleDance;
    animation-duration: 10s ;
    animation-iteration-count: infinite;
}

/* Chrome, Safari, Opera */
@-webkit-keyframes RectangleDance {
    0%   {background-color:orangered; left:0px; top:0px;}
    25%  {background-color:yellow; left:400px; top:0px;}
    50%  {background-color:dodgerblue; left:400px; top:200px;}
    75%  {background-color:lawngreen; left:0px; top:200px;}
    100% {background-color:red; left:0px; top:0px;}
}

/* Standard syntax */
@keyframes RectangleDance {
    0%   {background-color:orangered; left:0px; top:0px;}
    25%  {background-color:yellow; left:600px; top:0px;}
    50%  {background-color:dodgerblue; left:400px; top:200px;}
    75%  {background-color:lawngreen; left:200px; top:200px;}
    100% {background-color:red; left:0px; top:0px;}
}


	.div2 {
    width: 100px;
    height: 100px;
    background-color: red;
    position: relative;
    -webkit-animation-name: RectangleDance; /* Chrome, Safari, Opera */
    -webkit-animation-duration: 4s ; /* Chrome, Safari, Opera */
    animation-name: RectangleDance;
    animation-duration: 8s ;
    animation-iteration-count: infinite;
    animation-direction: reverse; 
}

/* Chrome, Safari, Opera */
@-webkit-keyframes RectangleDance {
    0%   {background-color:orangered; left:0px; top:0px;}
    25%  {background-color:yellow; left:400px; top:0px;}
    50%  {background-color:dodgerblue; left:400px; top:200px;}
    75%  {background-color:lawngreen; left:0px; top:200px;}
    100% {background-color:red; left:0px; top:0px;}
}

/* Standard syntax */
@keyframes RectangleDance {
    0%   {background-color:orangered; left:0px; top:0px;}
    25%  {background-color:yellow; left:400px; top:0px;}
    50%  {background-color:dodgerblue; left:400px; top:200px;}
    75%  {background-color:lawngreen; left:0px; top:200px;}
    100% {background-color:red; left:0px; top:0px;}
}


	.div3 {
    width: 70px;
    height: 20px;
    background-color: orange;
    }


</style>


<script type="text/javascript">

$(document).ready(function() {
	
	$('li > a').click(function() {
		
		$('ul > li').removeClass('active');
		
		var str = $(this).text();
		$('#result').text(str);
// 		$('.div3').text(str);
		
		$(this).parent().addClass('active');
		
	});
});

</script>


</head>
<body>


<h1 class="title_animation"> Employee </h1>

<div class="div1"> Div1 <div class="div2" > Div2 </div> </div>


<ul class="pagination">
<li> <a href="#">Previous</a></li>
<li> <a href="#">1</a></li>
<li class="active"> <a href="#">2</a></li>
<li> <a href="#">3</a></li>
<li> <a href="#">4</a></li>
<li> <a href="#">5</a></li>
<li> <a href="#">6</a></li>
<li> <a href="#">7</a></li>
<li> <a href="#">8</a></li>
<li> <a href="#">9</a></li>
<li> <a href="#">10</a></li>
<li> <a href="#">Next</a></li>
</ul>


<div id="result" class="div3"></div>


</body>
</html>










