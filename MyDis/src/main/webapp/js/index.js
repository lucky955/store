$(function(){
	
	/*板块下标*/
	var elementIndex = 0;
	/*标题数量*/
	var titleNum = document.getElementById("title").children.length;
	/*标题百分比*/
	var perTitle = 100/titleNum;
	/*获取屏幕高度，标题宽度并写入*/
	var screenHeight = window.screen.height;
	$("#main").css("height",screenHeight);
	$(".tl").css("width",perTitle + "%");
	/*首标题变色*/
	$(".tl").eq(0).addClass("change");
	/*元素变换*/
	setInterval(function elementChange(){
		/*板块下标*/
		if(elementIndex==titleNum){
			elementIndex=0;
		}
		/*标题栏变化*/
		$(".tl").eq(elementIndex).addClass("change").siblings().removeClass("change");
		/*对应内容变化*/
		$("#content div").eq(elementIndex).show().siblings().hide();
		elementIndex++;
	},10000);
	
	/*时间显示*/
	setInterval(function(){
		var date = new Date();
		document.getElementById("times").innerText = 
			date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() ;
	}, 1000);  
	
	/*班级阶段信息显示*/
	var str = 
		"<tr>"+
			"<td>班级</td>"+
			"<td>老师</td>"+
			"<td>方向</td>"+
			"<td>人数</td>"+
			"<td>阶段</td>"+
	  	"</tr>";
	
	$.ajax({
		type: "POST",
        url: "getclass",
        dataType: "json",
        success:function(classlist){
        	for(var i=0;i<classlist.length;i++){
				str += 
					"<tr>"+
						"<td>" + classlist[i].c_class + "</td>"+
						"<td>" + classlist[i].c_teacher + "</td>"+
						"<td>" + classlist[i].c_type + "</td>"+
						"<td>" + classlist[i].c_number + "</td>"+
						"<td>" + classlist[i].c_progress + "</td>"+
			 		"</tr>";
        	}
        	$("#clsmsg").html(str);
    	}
	});
	
	/*考勤*/
	$.ajax({
		type: "POST",
       url: "gettophistory",
       dataType: "json",
       success:function(result){
    	   var day = new Date().getDay();
    	  if(day == 0) {
    		   $("#attendance").text("今天周日放假！！！");
    	   }else if(day == 6) {
    		   $("#attendance").text("今天周六自习！！！");
    	   }else {
    		   $("#attendance").text(result);
    	   }
       }
	});
	
	$.ajax({
		type: "POST",
        url: "gettoptitle",
        dataType: "json",
        success:function(movetilte){
       		$("#top_left").text("在校人数: " + movetilte + "人");
        }
	});
	
	$.ajax({
		type: "GET",
        url: "getteachers",
        dataType: "json",
        success:function(teachers){
        	//通过数组和getDay获取当前日期
        	var a = new Date().getDay();
        	var teacherImg1="";
        	var teacherImg2="";
        	for(var i=0;i<teachers.length;i++){
        		if(teachers[i].t_day==1){
        			$(".one").css("display","");
        			$(".one").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==2){
        			$(".two").css("display","");
        			$(".two").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==3){
        			$(".three").css("display","");
        			$(".three").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==4){
        			$(".four").css("display","");
        			$(".four").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==5){
        			$(".five").css("display","");
        			$(".five").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==6){
        			$(".six").css("display","");
        			$(".six").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}else if(teachers[i].t_day==7){
        			$(".seven").css("display","");
        			$(".seven").append("　"+teachers[i].t_type+":"+teachers[i].t_name);
        		}
         		if(teachers[i].t_type=="开发"){
	        		if(a==teachers[i].t_day){
	        			teacherImg1+="<img src='" + teachers[i].t_img + "'  height='200px'>";
	        		}
        		}else{
        			if(a==teachers[i].t_day){
        				teacherImg2 += "<img src='"+ teachers[i].t_img +"'  height='200px'>";
	        		}
        		}
         		
/*          		var weekdiv = document.getElementById("plan_content");
         		var weeklist = weekdiv.children;
         		for(var i=1; i<weeklist.length+1;i++){
         			if(a==i){
         				
         			}
         		} */
         		
         		if(a==1){
         			$(".one").css("background-color","orange");
         		}else if(a==2){
         			$(".two").css("background-color","orange");
         		}else if(a==3){
         			$(".three").css("background-color","orange");
         		}else if(a==4){
         			$(".four").css("background-color","orange");
         		}else if(a==5){
         			$(".five").css("background-color","orange");
         		}else if(a==6){
         			$(".six").css("background-color","orange");
         		}else if(a==7){
         			$(".seven").css("background-color","orange");
         		}
        	}
        	$("#k_duty").append(teacherImg1);
       		$("#c_duty").append(teacherImg2);
        }
	})
	$.ajax({
		type: "POST",
        url: "getexpelled",
        dataType: "json",
        success:function(expelled){
       		$("#top_left").append("劝退人数: " + expelled + "人");
        }
	});

});