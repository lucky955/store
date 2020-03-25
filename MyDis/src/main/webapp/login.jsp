<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css"/>
<script src="js/jquery-1.11.3.js"></script>
<title></title>
</head>

<body>
	<form action="login" method="post">
		<div id="window">
			
			<a href="login.jsp"><div id="navLog" = class="navigate">登录</div></a>
			<a href="enroll.jsp"><div id="navEnroll"   class="navigate">注册</div></a>
			
			<div id="head"><img src="images/head.jpg" style="width: 100%;border-radius: 10%;"/></div>
			
			<div class="form_item">
				<img src="images/user.jpg" class="icon"/>
				<input type="text" name="username" placeholder="用户名"/>
				<p></p>
			</div>
			
			<div class="form_item">
				<img src="images/pwd.jpg" class="icon"/>
				<input type="password" name="password" placeholder="密码"/>
				<p></p>
			</div>
			
			<div id="btn"><button>登录</button></div>
		
		</div>
	</form>
</body>
</html>
    