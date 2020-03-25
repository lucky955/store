<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="pageContent">
	<form method="post" action="../updateScore?id=${ uid.id }" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学号</label>
				<input name="s_id" class="required" type="text" size="30" value="${ uid.s_id }"/>
			</p>
			<p>
				<label>第一阶段</label>
				<input name="s_score_one" class="required" type="text" size="30" value="${ uid.s_score_one }"/>
			</p>
			<p>
				<label>第二阶段</label>
				<input name="s_score_two" class="required" type="text" size="30" value="${ uid.s_score_two }"/>
			</p>
			<p>
				<label>第三阶段</label>
				<input name="s_score_three" class="required" type="text" size="30" value="${ uid.s_score_three }"/>
			</p>
			<p>
				<label>班级</label>
				<input name="s_class" class="required" type="text" size="30" value="${ uid.s_class }"/>
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
