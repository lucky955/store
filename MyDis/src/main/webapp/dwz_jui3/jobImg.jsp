<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<style type="text/css">
	.mypagediv{
		float:left;
	}
	.mypagediv1{
		text-align:center;
		margin-left: 60px;
		margin-top: 30px;
	}
	#xx {
	    display: inline-block;
	    border: 1px solid #ddd;
	    border-radius: 4px;
	    padding: 5px;
	    transition: 0.3s;
	}

	#xx:hover {
   		box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
	}
</style>

<form id="pagerForm" method="post" action="../jobImgPage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="../jobImgPage" method="post">
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
			<li><a class="add" href="addJobImgPage.jsp" target="dialog"  width="400" height="400" mask="true" rel="add_dialog"><span>添加</span></a></li> 
		</ul>
	</div>
	<div width="100%" layoutH="68" style="border:1px black solid">
	
			<c:forEach items="${jobImg}" var="p">
			
				<c:if test="${fn:contains(p.s_img,'http://www.woniuxy.com')==true}">
					<div class="mypagediv"  >
						<div class="mypagediv1">
							<div ><a target="_blank" href="${p.s_img }"><img src="${p.s_img }"  height="200" width="200"/></a></div> 
							<div><span style="font-size: 15px; padding-top: 5px">${p.s_name }</span></div>
							<div style="margin-top: 15px">
								<div style="text-align:center; color: red;">
										<a href="../deleteJobImgPage?id=${p.id }" target="dialog" width="200" height="100" rel="head_dialog">
											<span style="font-size: 14px">删除</span>
										</a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${fn:contains(p.s_img,'http://www.woniuxy.com')==false}">
				<div class="mypagediv"  >
						<div class="mypagediv1">
							<div ><a target="_blank" href="../../${p.s_img }"><img src="../../${p.s_img }"  height="200" width="200"/></a></div> 
							<div><span style="font-size: 15px; padding-top: 5px">${p.s_name }</span></div>
							<div style="margin-top: 15px">
								<div style="text-align:center; color: red;">
										<a href="../deleteJobImgPage?id=${p.id }" target="dialog" width="200" height="100" rel="head_dialog">
											<span style="font-size: 14px">删除</span>
										</a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
	</div>
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
<script type="text/javascript">
</script>
