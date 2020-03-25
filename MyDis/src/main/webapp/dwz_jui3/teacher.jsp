<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../teacherPage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="teacher_type" value="${teacher_type}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../teacherPage" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<!-- <td>
						姓名<input type="text" name="searchName" />
					</td>
					<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
					</td> -->
					<td>
					<span>教学方向</span>
					</td>
					<td>
					<select class="combox" name="teacher_type" onchange="return navTabSearch(this);" value="${ teacher_type }">
						<option value="" ${ teacher_type==''?'selected':'' }>全部</option>
						<option value="开发" ${ teacher_type=='开发'?'selected':'' }>开发</option>
						<option value="测试" ${ teacher_type=='测试'?'selected':'' }>测试</option>
					</select>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			
			<li><a class="add" href="addTeacherPage.html" target="dialog" width="800" height="500" mask="true" rel="add_dialog"><span>添加</span></a></li>
			<!-- <li><a class="delete" href="../deleteTeacher?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li> -->
			<li><a class="edit" href="../updateTeacherPage?id={sid_user}" target="dialog" width="500" height="500" rel="update_dialog"><span>修改</span></a></li>
			<li><span>点击姓名查看头像</span></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="110">
		<thead>
			<tr>
				<th width="10%">序号</th>
				<th width="15%">姓名</th>
				<th width="15%">类型</th>
				<th width="30%">电话</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ teacher }" var="tea" varStatus="i" >
				<tr target="sid_user" rel="${ tea.id }">
					<td>${ i.index+1 }</td>
					<td>
						<a href="../headImgPage?path=${ tea.t_img }" target="dialog" width="600" height="600" rel="head_dialog"><span class="teacherName">${ tea.t_name }</span></a>
					</td>
					<td>${ tea.t_type }</td>
					<td>${ tea.t_phone }</td>
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
