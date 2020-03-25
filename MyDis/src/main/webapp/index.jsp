<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link><link rel="stylesheet" href="css/index.css" />
<title>展示页</title>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/index.js" ></script>
</head>
	<body style="font-size: 62.5%;">
		<div id="main">
			
			<div id="top_left">标记</div>
			<div id="top_right">
				<marquee behavior="scroll" id="attendance">考勤</marquee>
			</div>
			<div id="times"></div>
			
			<div id="left">
				<div id="left_title">今日值班</div>
				<div class="on_duty" id="k_duty">
<!-- 					<img src="images/demo.jpg" alt="No Picture" style="width:100%">
 -->				</div>
				<div class="on_duty" id="c_duty">
<!-- 					<img src="images/demo.jpg" alt="No Picture" style="width:100%">
 -->				</div>
				<div id="plan">日期安排</div>
				<div id="plan_content" style="font-size: 20px">
					<div class="one">周一:</div>
					<div class="two">周二:</div>
					<div class="three">周三:</div>
					<div class="four">周四:</div>
					<div class="six">周六:</div>
				</div>
			</div>
			<div id="center">
				<div id="title">
					<div class="tl">就业信息</div>
					<div class="tl">活动信息</div>
					<div class="tl">班级信息</div>
				</div>
				<div id="content">
					<div id="job" class="hide">
						<iframe src="jbPage" style="width: 100%; height:61em"></iframe>
					</div>
					<div id="activity" class="hide">
						<iframe src="actPage" style="width: 100%; height: 61em"></iframe>
					</div>
					<div id="classes" class="hide">
						<table id="clsmsg"></table>
					</div>
				</div>
			</div>
		</div>
	</body>
	
<script type="text/javascript">


</script>

</html>
