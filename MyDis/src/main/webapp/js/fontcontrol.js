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
