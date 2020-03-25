<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../classesPage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="class_type" value="${class_type}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../queryClasses" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						班级
					</td>
					<td>
						<select class="combox" name="class_type" onchange="return navTabSearch(this);" value="${ class_type }">
							<option value="" ${ class_type==''?'selected':'' }>全部</option>
							<option value="开发" ${ class_type=='开发'?'selected':'' }>开发</option>
							<option value="测试" ${ class_type=='测试'?'selected':'' }>测试</option>
						</select>
					</td>
					<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
					</td> 
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="addClassesPage.html" target="dialog" width="800" height="500" mask="true" rel="add_dialog"><span>添加</span></a></li>
			<li><a class="edit" href="../updateClassesPage?uid={sid_user}" target="dialog" rel="update_dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="70%" layoutH="112">
		<thead>
			<tr>
				<th>序号</th>
				<th>班级</th>
				<th>教师</th>
				<th>类型</th>
				<th>人数</th>
				<th>阶段</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ classes }" var="clas" varStatus="i" >
				<tr target="sid_user" rel="${ clas.id }">
					<td>${ i.index+1 }</td>
					<td>${ clas.c_class }</td>
					<td>${ clas.c_teacher }</td>
					<td>${ clas.c_type }</td>
					<td>${ clas.c_number }</td>
					<td>${ clas.c_progress }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" value="${ page.numPerPage }">
				<option value="3">3</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="5" currentPage="${page.currentPage}"></div>

	</div>
</div>
