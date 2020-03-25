<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="pageContent">
	<form method="post" action="../updateTeacher" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓名</label>
				<input name="t_name" class="required" type="text" size="30" value="${ tea.t_name }"/>
			</p>
			<p>
				<label>类型</label>
				<input name="t_type" class="required" type="text" size="30" value="${ tea.t_type }"/>
			</p>
			<p>
				<label>电话</label>
				<input name="t_phone" class="required" type="text" size="30" value="${ tea.t_phone }"/>
			</p>
			<p>
				<label>头像</label>
				<input name="file" type="file">
			</p>
			<c:if test="${fn:contains(tea.t_img,'http://www.woniuxy.com')==true}">
					<img src="${tea.t_img }" style="width: 200px; margin-top: 30px">
			</c:if>
			<c:if test="${fn:contains(tea.t_img,'http://www.woniuxy.com')==false}">
					<img src="../../${tea.t_img }" style="width: 200px; margin-top: 30px">
			</c:if> 
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
