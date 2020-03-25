<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link href="css/index.css" rel="stylesheet" />
<title></title>

<style type="text/css">
.act_img{
margin-top:100px;
margin-left:100px;
float:left;
width:500px;
height:500px;
}
.img{
 float:left;
 width:400px;
 height:400px;
}
.act_title{
	width:300px;
	height:300px;
	border:1px red white;
	margin-top:100px;
	margin-left:100px;
	float:left;
}
</style>

</head>
<body>
	
</body>
<script src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(function(){
	var str = "";
	var divlist = $("body").children;
	var index = 0;
	$.ajax({
	type: "GET",
	url: "getactivity",
	dataType: "json",
		success:function(activitylist){
			index = activitylist.length;
			for(var i=0;i<activitylist.length;i++){
				alert(i);
 				$("body").append("<div class ='c1'></div>");
 				str="<div class='act_img'><img class='img' src='../../"+activitylist[i].a_img+"'></div>"
				+"<div class='act_title'>"+activitylist[i].a_name+"</div>";
				$("body div:last").append(str);
			}
			$(".c1").eq(0).show().siblings().hide();
		}
	})
	
	var i=0;
    setInterval(function() {
        i++;
        if (i == index) {
            i = 0;
        }
        $(".c1").eq(i).show().siblings().hide();
    }, 1000);

	
	
})
</script>
</html>