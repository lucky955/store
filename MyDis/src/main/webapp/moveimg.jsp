<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title></title>
<script src="js/jquery-1.11.3.js"></script>

    <link href="css/style.css" type="text/css" rel="stylesheet" />
  </head>
  <body>
    <div class="box" id="box">
	    <div id="dd">
	    	<img src="images/ggg.jpg" width="100%" height="650px"/>
	    </div>
    </div>
    

<script type="text/javascript">
$(function(){
	var dd = document.getElementById("dd");
	var imgs = dd.children;
	var index=0;
	setInterval(function name(){
		if(index==0){
			$("img").attr("src","images/ggg.jpg");
			index=1;
		}else{
			$("img").attr("src","images/timg.jpg");
			index=0;
		}
		$("img").fadeTo(3000,1);
		$("img").fadeTo(3000,1);
		$("img").fadeTo(2000,0);
	},8000);
})

</script>
</body>
</html>