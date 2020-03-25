<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../attendancePage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="className" value="${className }" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../attendancePage" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>班级</td>
					<td>
						<select class="combox"  name="className" onchange="return navTabSearch(this);" value="${className }">	
							<c:forEach items="${list }" var="c">
								<option value="${c.c_class }" ${className==c.c_class?'selected':''  }>${c.c_class }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="70%" layoutH="86">
		<thead>
			<tr>
				<th>序号</th>
				<th>学生姓名</th>
				<th>教师姓名</th>
				<th>班级</th>
				<th>方向</th>
				<th>状态</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ attendance }" var="att" varStatus="i" >
				<tr>
					<td>${ i.index+1 }</td>
					<td>${ att.student_name }</td>
					<td>${ att.teacher_name }</td>
					<td>${ att.class_no }</td>
					<td>${ att.major }</td>
					<td>${ att.result }</td>
					<td>${ att.attendance_time }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" value="${ page.numPerPage }">
				<option value="3" >3</option>
				<option value="5" >5</option>
				<option value="10" >10</option>
				<option value="15" >15</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="5" currentPage="${page.currentPage}"></div>

	</div>
</div>
