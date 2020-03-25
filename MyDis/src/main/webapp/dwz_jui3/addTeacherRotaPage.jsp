<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="pageContent">
	<form method="post" action="../addTeacherRote" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>值班教师：</label>
				 
		<dl class="nowrap">
			<dt>老师姓名：</dt>
			<dd>
				<input class="required" name="district.name" type="text" readonly/>
			</dd>
		</dl>
		
		<dl class="nowrap">
			<dt>老师电话：</dt>
			<dd>
				<input name="district.id" value="" type="hidden"/>
				<input name="district.phone" class="required"  type="text" readonly/>
				<a class="btnLook" href="../getteachergg" lookupGroup="district">查找带回</a>	
			</dd>
		</dl>
		
			<p>
				<label>日期</label>
				<select name="rota_day">
					<option value="1">周一</option>
					<option value="2">周二</option>
					<option value="3">周三</option>
					<option value="4">周四</option>
					<option value="6">周六</option>
				</select>
			</p>
		</div>
		
		<div class="formBar">
		
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
				
			</ul>
		</div>
	</form>
</div>
