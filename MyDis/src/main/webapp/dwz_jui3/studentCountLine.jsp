<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="../studentCountLine">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="searchClass" value="${searchClass }" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../studentCountLine" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						姓名<input type="text" name="searchName" />
					</td>
					<td>
						班级
					</td>
					<td>
					<select class="combox"  name="searchClass"  value="${searchClass }">	
							<c:forEach items="${classesList }" var="c">
								<option value="${c.classes }" ${searchClass==c.classes?'selected':''  }>${c.classes }</option>
								<!--  value="${c.classes }" ${className==c.classes?'selected':''  } -->
							</c:forEach>
						</select>
					</td>
					<td>
						<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
					</td> 
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
	</div>
	<table class="table" width="40%" layoutH="112">
		<thead>
			<tr>
				<th width="1%">序号</th>
				<th width="1%">姓名</th>
				<th width="1%">总行数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ studentHomeworkAllLinesList }" var="sc" varStatus="i" >
				<tr target="sid_user" rel="${ sc.id }">
					<td>${ i.index+1 }</td>
					<td>${ sc.username }</td>
					<td>${ sc.allLine }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" value="${ page.numPerPage }">
				<option value="1"  ${page.numPerPage == 1? "selected":""}>1</option>
				<option value="3"  ${page.numPerPage == 3? "selected":""}>3</option>
				<option value="5"  ${page.numPerPage == 5? "selected":""}>5</option>
				<option value="10"  ${page.numPerPage == 10? "selected":""}>10</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="5" currentPage="${page.currentPage}"></div>

	</div>
</div>
