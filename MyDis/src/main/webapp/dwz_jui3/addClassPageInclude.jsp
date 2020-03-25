<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<ul class="tree expand">
			<li><a href="javascript:">开发</a>
				<ul>
					<c:forEach items="${Kallteacherlist }" var="teacher">
						<li><a href="javascript:" onclick="$.bringBack({id:'1', name:'${teacher.t_name}', type:'${teacher.t_type}'})">${teacher.t_name}</a></li>
					</c:forEach>
				</ul>
			</li>
			
 			<li><a href="javascript:">测试</a>
				<ul>
					<c:forEach items="${Callteacherlist }" var="teacher"  varStatus="i">
						<li><a href="javascript:" onclick="$.bringBack({id:'1', name:'${teacher.t_name}', type:'${teacher.t_type}'})">${teacher.t_name}</a></li>
					</c:forEach>
				</ul>
			</li>
	</ul>
</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>


