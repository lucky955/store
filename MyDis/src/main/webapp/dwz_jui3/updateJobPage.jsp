<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/updatejobinfor1" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<c:forEach items="${jobInfor }" var="user">
				<p>
					<label>学号：</label> <input name="sid" type="text" size="30"
						value="${user.s_id }" />
				</p>
				<p>
					<label>姓名：</label> <input name="name" type="text" size="30"
						value="${user.s_name }" />
				</p>
				<p>
					<label>性别：</label> <input name="sex" type="text" size="30"
						value="${user.s_sex }"  />
				</p>
				<p>
					<label>学历：</label> <input name="education" type="text" size="30"
						value="${user.s_education }" />
				</p>
				<p>
					<label>学校：</label> <input name="school" type="text" size="30"
						value="${user.s_school }" />
				</p>
				<p>
					<label>专业：</label> <input name="major" type="text" size="30"
						value="${user.s_major }" />
				</p>
				<p>
					<label>毕业时间：</label> <input name="graduationtime" type="text" size="30"
						value="${user.s_graduationtime }" />
				</p>
				<p>
					<label>就业企业：</label> <input name="company" type="text" size="30"
						value="${user.s_company }"  />
				</p>
				<p>
					<label>职位：</label> <input name="post" type="text" size="30"
						value="${user.s_post }" />
				</p>
				<p>
					<label>薪资：</label> <input name="salary" type="text" size="30"
						value="${user.s_salary }"  />
				</p>
				<p>
					<label>就业城市：</label> <input name="city" type="text" size="30"
						value="${user.s_city }" />
				</p>
				<p>
					<label>就业时间：</label> <input name="employmenttime" type="text" size="30"
						value="${user.s_employmenttime }" />
				</p>
			</c:forEach>
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