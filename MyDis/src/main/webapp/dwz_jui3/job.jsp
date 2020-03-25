<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../jobPage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../queryJob" method="post">
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
			<li><a class="add" href="addJobPage.jsp" target="dialog" width="300" height="300" mask="true" rel="add_dialog"><span>添加</span></a></li>
			<!-- <li><a class="delete" href="../delete?idcode={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li> -->
			<li><a class="edit" href="../updatejobinfor?uid={sid_user}" width="500" height="500" target="dialog" rel="update_dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="86" width="100%">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">学号</th>
				<th width="5%">姓名</th>
				<th width="5%">性别</th>
				<th width="5%">城市</th>
				<th width="10%">公司</th>
				<th width="10%">毕业院校</th>
				<th width="5%">学历</th>
				<th width="10%">专业</th>
				<th width="5%">入职岗位</th>
				<th width="10%">毕业时间</th>
				<th width="10%">薪资</th>
				<th width="10%">就业时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ job }" var="j" varStatus="i" >
				<tr target="sid_user" rel="${j.id  }">
					<td>${ i.index+1 }</td>
					<td>${ j.s_id }</td>
					<td>${ j.s_name }</td>
					<td>${ j.s_sex }</td>
					<td>${ j.s_city }</td>
					<td>${ j.s_company }</td>
					<td>${ j.s_school }</td>
					<td>${ j.s_education }</td>
					<td>${ j.s_major }</td>
					<td>${ j.s_post }</td>
					<td>${ j.s_graduationtime }</td>
					<td>${ j.s_salary }</td>
					<td>${ j.s_employmenttime }</td>
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
