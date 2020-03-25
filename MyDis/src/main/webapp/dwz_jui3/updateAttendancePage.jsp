<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="pageContent">
	<form method="post" action="../updateAttendance" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学好</label>
				<input name="s_id" class="required" type="text" size="30" value="${ uid.s_id }"/>
			</p>
			<p>
				<label>状态</label>
				<input name="s_state" class="required" type="text" size="30" value="${ uid.s_state }"/>
			</p>
			<p>
				<label>时间</label>
				<input name="s_time" class="required" type="text" size="30" value="${ uid.s_time }"/>
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
