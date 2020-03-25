<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="pageContent">
	<form method="post" action="../updateActivity" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称</label>
				<input name="a_name" class="required" type="text" size="30" value="${ uid.a_name }"/>
			</p>
			<p>
				<label>班级</label>
				<input name="a_class" class="required" type="text" size="30" value="${ uid.a_class }"/>
			</p>
			<p>
				<label>时间</label>
				<input name="a_time" class="required" type="text" size="30" value="${ uid.a_time }"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">����</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">ȡ��</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
