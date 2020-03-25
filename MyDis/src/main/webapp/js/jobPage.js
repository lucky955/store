$(function(){
	  var screenHeight = window.screen.height;
	  $("#box").css("height",screenHeight*0.8);
	  var str="";
	  $.ajax({
		type: "POST",
      url: "getemploy",
      dataType: "json",
      success:function(employlist){
      	for(var i=0; i<employlist.length; i++){
	        	str +=	"<div class='unit_job'>" + 
			    			"<img src='"+employlist[i].s_img+"' style='width:100%;'/>" + 
			    			"<p>" +  "姓名:" + employlist[i].s_name + "</p>" +
			    			"<p>" +  "城市:" + employlist[i].s_city + "</p>" +
			    			"<p>" +  "方向:" + employlist[i].s_post + "</p>" +
			    			"<p>" +  "公司:" + employlist[i].s_company + "</p>" +
			    			"<p>" +  "薪资:" + employlist[i].s_salary + "</p>" +
		    			"</div>"
      	}
      	$("#cont1").html(str);
      }
	})
})

var area = document.getElementById('box');
var cont1 = document.getElementById('cont1');
var cont2 = document.getElementById('cont2');

area.scrollTop = 0;
// 克隆cont1给cont2
cont2.innerHTML = cont1.innerHTML;

function myScroll() {
    if(area.scrollTop >= cont1.scrollHeight) {
        area.scrollTop = 0;
    }else {
        area.scrollTop += 2;
    }
}

var time = 50;
var interval = setInterval('myScroll()', time);

