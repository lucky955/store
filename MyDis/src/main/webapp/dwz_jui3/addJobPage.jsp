<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="../fileupload" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
				上传文件：<input type="file" name="file"><br /> 
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