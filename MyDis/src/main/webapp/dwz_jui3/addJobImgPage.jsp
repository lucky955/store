<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="../jobImgupLoad" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<dl>
				<dt>学生:</dt>
				<dd>
					<input type="text" name="a_name">
				</dd>
			</dl>
			<dl>
				<dt>图片:</dt>
				<dd>
					<input type="file" size="20" name="file" >
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div> 