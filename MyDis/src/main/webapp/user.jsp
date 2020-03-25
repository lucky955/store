<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script src="js/jquery-1.11.3.js"></script>
	<style>
		html{height: 100%}
		body{height: 100%;font-size: 62.5%;}
		*{border-color: black;padding: 0;margin: 0;border: 1px solid black;}
		#main{width: 100%;height: 100%;position: absolute;
		box-sizing: border-box;}
		.window{width: 30%;height: 85%;float: left;position: relative;
		left: 35%;margin-top: 3%;}
		.navigate{width: 49.7%;height: 5%;float: left;border-top: 0;text-align: center;}
		#navLog{border-left: 0;}
		#navEnroll{border-right: 0;}
		.change{border-bottom: 0;}
		.head{border-radius: 100%;width: 26%;height: 20%;position: relative;left: 37%;top: 15%;}
		.in_username{width: 90%;height: 9%;float: left;border-radius: 3em;margin: 40% 0 0 5%;}
		.in_password{width: 90%;height: 9%;float: left;border-radius: 3em;margin: 7% 0 0 5%;}
		.icon{margin: 0.8em 0 0 1.8em;}
		.input_border{width: 79%;height: 60%;position: relative;top: -0.7em;}
		#login{background-color: white;width: 90%;height: 9%;float: left;border-radius: 3em;margin: 7% 0 0 5%;}
	</style>
	<script>
		$(function(){
			
			$(".window").eq(1).hide();
			$(".navigate").eq(0).addClass("change");
			
			$(".navigate").click(function(){
				$(this).addClass("change").siblings().removeClass("change");
				var window_index = $(this).index();
				$(".window").eq(window_index).show().siblings().hide();
			})
			
		})
	</script>
	<body>
			<div class="window">
			<form action="login" method="post">
				
				<div id="navLog" class="navigate">登录</div>
				<div id="navEnroll" class="navigate">注册</div>
				
				<div class="head"></div>
				
				<div class="in_username">
					<img src="images/password.png" class="icon"/>
					<input type="text" name="student_name" placeholder="请输入用户名" class="input_border"/>
				</div>
				
				<div class="in_password">
					<img src="images/password.png" class="icon"/>
					<input type="text" name="password" placeholder="请输入密码" class="input_border"/>
				</div>
				
				<input type="submit" value="登录" id="login"/>
				
			</form>
			</div>
			<div class="window">
			<form action="enroll" method="post">
				
				<div id="navLog" class="navigate">登录</div>
				<div id="navEnroll" class="navigate">注册</div>
				
				<div class="head"></div>
				
				<div class="in_username">
					<img src="images/password.png" class="icon"/>
					<input type="text" name="student_name" placeholder="请输入用户名" class="input_border"/>
				</div>
				
				<div class="in_password">
					<img src="images/password.png" class="icon"/>
					<input type="text" name="password" placeholder="请输入密码" class="input_border"/>
				</div>
				
				<input type="submit" value="注册" id="login"/>
				
			</form>
			</div>
	</body>
</html>
