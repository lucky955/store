<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="js/jquery-1.11.3.js"></script>

<link href="css/style.css" type="text/css" rel="stylesheet" />
<body style="overflow: hidden;">
	<div id="partmove" class="partmove" >
		<div class="partcn">
			<ul id="employ">
        	</ul>
		</div>
	</div>
</body>
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
	   },6000);

	function animate(obj,target) {
		
		clearInterval(obj.timer);
		obj.timer = setInterval(function () {
	        var step = 10;
	        var step = obj.offsetLeft < target ? step : -step;
	        if (Math.abs(obj.offsetLeft - target) > Math.abs(step)) {
			obj.style.left = obj.offsetLeft + step + "px";
			} else {
				obj.style.left = target + "px";
				clearInterval(obj.timer);
			}
		}, 10)
	}
	
	
	
	var test = "<tr>"+
	"<td style='width:15%'>学号</td>"+
	"<td style='width:5%;'>姓名</td>"+
	"<td style='width:5%;'>城市</td>"+
	"<td style='width:10%;'>毕业大学</td>"+
	"<td style='width:10%;'>就业公司</td>"+
	"<td style='width:5%;'>文凭</td>"+
	"<td style='width:10%;'>专业专业</td>"+
	"<td style='width:8%;'>学习方向</td>"+
	"<td style='width:10%;'>工作时间</td>"+
	"<td style='width:7%;'>薪资待遇</td>"+
	  "</tr>";
	  var str =test;
	  $.ajax({
		type: "GET",
        url: "getemploy",
        dataType: "json",
        success:function(employlist){
        	for(var i=0; i<employlist.length; i++){
        		if(i%4==0){
					str=test;
					$("#employ").append("<li><div></div></li>");
        		}
				str += "<tr>"+
				"<td style='width:15%;'>" + employlist[i].s_id + "</td>"+
				"<td style='width:5%;'>" + employlist[i].s_name + "</td>"+
				"<td style='width:5%;'>" + employlist[i].s_city + "</td>"+
				"<td style='width:10%;'>" + employlist[i].s_school + "</td>"+
				"<td style='width:10%;'>" + employlist[i].s_company + "</td>"+
				"<td style='width:5%;'>" + employlist[i].s_education + "</td>"+
				"<td style='width:10%;'>" + employlist[i].s_major + "</td>"+
				"<td style='width:8%;'>" + employlist[i].s_post + "</td>"+
				"<td style='width:10%;'>" + employlist[i].s_graduationtime + "</td>"+
				"<td style='width:7%;'>" + employlist[i].s_salary + "</td>"+
			 	"</tr>";
        		$("ul li div:last").html(str);
        	}
        	$(".shit").html(test);
    		//设置宽度
        	var pwidth = parent.$("#job").css("width");
    		$("ul li div").css("width",pwidth);
    		$(".shit").css("width",pwidth);
        }
	})
})
</script>