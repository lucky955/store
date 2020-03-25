<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/jquery-1.11.3.js"></script>
<body>
	<div>
		<marquee behavior="scroll" id="topmoveg"></marquee>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: "GET",
       url: "gettophistory",
       dataType: "json",
       success:function(historytitle){
    	   var a = new Date().getDay();
    	  if(a == 0) {
    		   $("#topmoveg").text("今天周日放假！！！");
    	   }else if(a == 6) {
    		   $("#topmoveg").text("今天周六自习！！！");
    	   }else {
    		   $("#topmoveg").text(historytitle);
    	   }
       }
	})
})
</script>