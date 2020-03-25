<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="pageContent">
	<form method="post" action="../updateClasses?id=${ cls.id }" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>班级</label>
				<input name="c_class" class="required" type="text" size="30" value="${ cls.c_class }"/>
			</p>
			<p>
				<label>教师</label>
				<input name="c_teacher" class="required" type="text" size="30" value="${ cls.c_teacher }"/>
			</p>
			<p>
				<label>类型</label>
				<input name="c_type" class="required" type="text" size="30" value="${ cls.c_type }"/>
			</p>
			<p>
				<label>人数</label>
				<input name="c_number" class="required" type="text" size="30" value="${ cls.c_number }"/>
			</p>
			<p>
				<label>阶段</label>
				<input name="c_progress" class="required" type="text" size="30" value="${ cls.c_progress }"/>
			</p>
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
