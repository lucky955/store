<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">

$(function(){
	$.ajax({
		type: "GET",
        url: "getteachers",
        dataType: "json",
        success:function(teachers){
        	//通过数组和getDay获取当前日期
        	var a = new Date().getDay();
        	var weekday=new Array(7)
        	weekday[0]="周日"
        	weekday[1]="周一"
        	weekday[2]="周二"
        	weekday[3]="周三"
        	weekday[4]="周四"
        	weekday[5]="周五"
        	weekday[6]="周六"
        	var str="开发<br/>";
        	var teacherImg1="";
        	var str2="测试<br/>";
        	var teacherImg2="";
        	
        	
        	for(var i=0;i<teachers.length;i++){
        		if(teachers[i].t_type=="开发"){
	        		if(weekday[a]==teachers[i].t_day){
	        			alert(teachers[i].t_day);
	        			str+="<div style='background-color:orange;'>" + teachers[i].t_day + "&nbsp;&nbsp;&nbsp;&nbsp;" +teachers[i].t_name+"</div><br/>";
	        			teacherImg1+="<img src='" + teachers[i].t_img + "'  height='200px'>";
	        		}else{
		       			str += teachers[i].t_day + " &nbsp;&nbsp;&nbsp;&nbsp;" + teachers[i].t_name + "<br/>";
	        		}
        		}else{
        			if(weekday[a]==teachers[i].t_day){
        				str2+="<div style='background-color:orange;'>" + teachers[i].t_day + "&nbsp;&nbsp;&nbsp;&nbsp;" +teachers[i].t_name+"</div><br/>";
        				/* str2 += "<font style='color:red'>" + teachers[i].t_day + "&nbsp;&nbsp;&nbsp;&nbsp;" + teachers[i].t_name + "</font><br/>"; */
        				teacherImg2 += "<img src='" + teachers[i].t_img + "'  height='200px'>";
	        		}else{
	        			str2 += teachers[i].t_day + "&nbsp;&nbsp;&nbsp;&nbsp;" + teachers[i].t_name + "<br/>";
	        		}     
        		}
        	}
        	
       		$("#teacher1").append(str);
       		$("#teacherImg1").append(teacherImg1);
       		$("#teacher2").append(str2);
       		$("#teacherImg2").append(teacherImg2);
        }
	})
})

</script>

<style type="text/css">
	table {
	border: 1px red soild;
	margin: 0px;
	padding: 0px;
	
}
font {
	size: 20px;
}
</style>
	<div id="teacher" style="font-size: 20px">
		<div style="float: left;width: 48%;height: 100%">
			<div id="teacher1" style="float: left;width: 30%;height: 100%"></div>
			<div id="teacherImg1" style="float: left;"></div>
		</div>
		 <div style="float: left;height: 100%;width: 50%">
			<div id="teacher2" style="float: left;margin-left: 2%;height: 100%;width: 30%"></div>
			<div id="teacherImg2" style="float: left;"></div>
		</div> 
	</div>