<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('images/backgroud.png');text-align: center;">
	<div style="margin-top: 20% ;background-color: rgb(222,222,222,0.5);width: 30%;margin-left: 35%" >
	
		<div style="margin-top: 5%">欢迎${ loginStudent.username}来提交代码</div>
		<div style="margin: auto;padding: 2%">
			<form action="fileUpLoad" enctype="multipart/form-data" method="post">
				<p style="margin-top: 2%">上传文件：</p>
				<input type="file" name="file" webkitdirectory mozdirectory><br /> 
				<input type="submit" value="提交">
			</form>
			<c:if test="${ pageLineCode == 300}">
				<div style="margin-top: 2%">请选择你要提交的文件，好吧</div>
			</c:if>
			<c:if test="${ pageLine!=null}">
				<div style="margin-top: 2%">你提交的有效代码为${ pageLine}行</div>
			</c:if>
		</div>
	</div>
	

</body>
</html>