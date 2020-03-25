<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="js/jquery-1.11.3.js"></script>

<link href="css/style.css" type="text/css" rel="stylesheet" />
	<div id="partmove" class="partmove">
		<div class="partcn">
			<ul id="employ">
				<li><div class="shit1"></div></li>
				<li><div class="shit2"></div></li>
        	</ul>
		</div>
	</div>

<script type="text/javascript">

$(function(){
	
	  var partmove = document.getElementById("partmove");
	  var partcn = partmove.children[0];
	  var ul = partcn.children[0];
	  var lis = ul.children;
	  var index = 0;
	  var fontWidth= partcn.offsetWidth;

	  
	   setInterval(function name() {
		   if(index > lis.length-1){
			   index=0;
		   }
		   var target = -index * fontWidth;  //获取到索引
		   index++;
		   animate(ul,target); 
	   },2000);

	function animate(obj,target) {
		clearInterval(obj.timer);
		obj.timer = setInterval(function () {
	        var step = 20;
	        var step = obj.offsetLeft < target ? step : -step;
	        if (Math.abs(obj.offsetLeft - target) > Math.abs(step)) {
			obj.style.left = obj.offsetLeft + step + "px";
			} else {
				obj.style.left = target + "px";
				clearInterval(obj.timer);
			}
		}, 15)
	}
	
	
/* 		var str= "<tr>"+
		"<td>序号</td>"+
		"<td>姓名</td>"+
		"<td>身份证号</td>"+
		"<td>机号</td>"+
		"<td>会员</td>"+
		"<td>余额</td>"+
		"</tr>";
		var str2=str; */

	  /* 		var p = parent.("#job");
		$(".shit1").css("width",p.css("width"));
		$(".shit2").css("width",p.css("width")); */
	  $.ajax({
		type: "GET",
        url: "getemploy",
        dataType: "json",
        success:function(employlist){
        	var str ="";
        	alert("ggg");
        	for(var i=0; i<employlist.length;i++){
        		 str += "<tr>"+
				"<td>" + (i+1) + "</td>"+
				"<td>" + employlist[i].s_id + "</td>"+
				"<td>" + employlist[i].s_name + "</td>"+
				"<td>" + employlist[i].s_sex + "</td>"+
				"<td>" + employlist[i].s_city + "</td>"+
				"<td>" + employlist[i].s_company + "</td>"+
			 	"</tr>";
        		if(employlist.length>5){
        			str2 += "<tr>"+
    				"<td>" + (i+1) + "</td>"+
    				"<td>" + employlist[i].s_id + "</td>"+
    				"<td>" + employlist[i].s_name + "</td>"+
    				"<td>" + employlist[i].s_sex + "</td>"+
    				"<td>" + employlist[i].s_city + "</td>"+
    				"<td>" + employlist[i].s_company + "</td>"+
    			 	"</tr>";
        			$(".shit2").html(str2);
        		}else{
        			$(".shit1").html(str);
        		}
        	}
        }
	})
})
</script>