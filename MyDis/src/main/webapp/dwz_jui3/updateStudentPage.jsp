<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="pageContent">
	<form method="post" action="../updateStudent?id=${uid.id }" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学号</label>
				<input name="s_id" class="required" type="text" size="30" value="${ uid.s_id }"/>
			</p>
			<p>
				<label>姓名</label>
				<input name="s_name" class="required" type="text" size="30" value="${ uid.s_name }"/>
			</p>
			<p>
				<label>性别</label>
				<input name="s_sex" class="required" type="text" size="30" value="${ uid.s_sex }"/>
			</p>
			<p>
				<label>班级</label>
				<input name="s_class" class="required" type="text" size="30" value="${ uid.s_class }"/>
			</p>
			<p>
				<label>电话</label>
				<input name="s_phone" class="required" type="text" size="30" value="${ uid.s_phone }"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">±£´æ</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">È¡Ïû</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
