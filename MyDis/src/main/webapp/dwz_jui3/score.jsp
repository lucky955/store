<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../scorePage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../queryScore" method="post">
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
			<li><a class="add" href="addScorePage.html" target="dialog" width="800" height="500" mask="true" rel="add_dialog"><span>添加</span></a></li>
			<li><a class="delete" href="../deleteScore?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="../updateScorePage?uid={sid_user}" target="dialog" rel="update_dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="86">
		<thead>
			<tr>
				<th width="10%">序号</th>
				<th width="15%">学号</th>
				<th width="20%">第一阶段</th>
				<th width="20%">第二阶段</th>
				<th width="20%">第三阶段</th>
				<th width="15%">班级</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ score }" var="sc" varStatus="i" >
				<tr target="sid_user" rel="${ sc.id }">
					<td>${ i.index+1 }</td>
					<td>${ sc.s_id }</td>
					<td>${ sc.s_score_one }</td>
					<td>${ sc.s_score_two }</td>
					<td>${ sc.s_score_three }</td>
					<td>${ sc.s_class }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" value="${ page.numPerPage }">
				<option value="3"  ${page.numPerPage == 3? "selected":""}>3</option>
				<option value="5"  ${page.numPerPage == 5? "selected":""}>5</option>
				<option value="10"  ${page.numPerPage == 10? "selected":""}>10</option>
				<option value="15"  ${page.numPerPage == 15? "selected":""}>15</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="5" currentPage="${page.currentPage}"></div>

	</div>
</div>
