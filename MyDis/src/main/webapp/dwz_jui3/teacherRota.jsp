<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../rotaPage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../queryTeacher" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<!-- <td>
						姓名<input type="text" name="searchName" />
					</td>
					<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
					</td> -->
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="addTeacherRotaPage.jsp" target="dialog" width="800" height="500" mask="true" rel="add_dialog"><span>添加</span></a></li>
			<li><a class="delete" href="../deleteTeacherRota?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="../updateTeacherRotaPage?uid={sid_user}" target="dialog" rel="update_dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="70%" layoutH="86">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>电话</th>
				<th>值班日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ teacherRota }" var="tea" varStatus="i" >
				<tr target="sid_user" rel="${ tea.id }">
					<td>${ i.index+1 }</td>
					<td>${ tea.t_name }</td>
					<td>${ tea.t_phone }</td>
					<td>${ tea.t_day }</td>
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
