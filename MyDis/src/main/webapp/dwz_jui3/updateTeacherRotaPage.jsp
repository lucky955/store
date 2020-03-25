<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="pageContent">
	<form method="post" action="../updateTeacherRota1" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<c:forEach items="${findInfor }" var="user">
				<p>
					<label>姓名</label> <input name="name" type="text" size="30" value="${ user.t_name }" />
				</p>
				<p>
					<label>电话</label> <input name="phone" type="text" size="30" value="${ user.t_phone }" />
				</p>
				<p>
					<label>值班日期</label> <input name="day" type="text" size="30" value="${ user.t_day }" />
				</p>
			</c:forEach>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">返回</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
