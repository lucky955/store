<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: "GET",
        url: "gettoptitle",
        dataType: "json",
        success:function(movetilte){
       		$("#history").text("蜗牛学院在校人数: " + movetilte + "人");
        }
	})

})
</script>
<body>
	<div id="history"></div>
</body>