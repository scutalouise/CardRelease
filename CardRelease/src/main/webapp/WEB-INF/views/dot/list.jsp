<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 导入top -->
<%@include file="/common/top.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="utf-8">
	<title>欢迎使用体验卡卡系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!-- The styles -->
	<!-- 导入css -->
	<%@include file="/common/css.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
</head>
<body>
		<%@include file="/common/topbar.jsp" %>
		<div class="container-fluid">
		<div class="row-fluid">
		<%@include file="/common/menu.jsp" %>	
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">亲，警告信息!</h4>
					<p>当前浏览器不支持某些 <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> 特性，您可以选择升级或开启更多的浏览器特性.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			<form action="" method="post" id="dotForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<!-- table：网点开始 -->
			<div class="row-fluid sortable ui-sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title="">
						<h2><i class="icon-user"></i> 网点详情</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper" role="grid">
							<div class="row-fluid">
								<div class="span6" style="width:35%;">
									<div id="DataTables_Table_0_length" class="dataTables_length">
										<label>
											<a class="btn btn-success" href="${pageContext.request.contextPath }/dot/addDotUI" style="margin-left:5%">
											<i class="icon-user"></i> 新增网点</a>
										</label>
									</div>
								</div>
							</div>
						<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
						  <thead>
							  <tr role="row">
							  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 309px;">网点名称</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 256px;">网点地址</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 149px;">网点电话</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 157px;">网点IP</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 565px;">可执行操作</th></tr>
						  </thead>   
						  <tbody role="alert" aria-live="polite" aria-relevant="all">
						  <c:forEach items="${requestScope.page.recordList }" var="dot" varStatus="obj">
							  <c:if test="${obj.count%2 == '0'}">
							  	<tr class="odd">
							  </c:if>
							  <c:if test="${obj.count%2 != '0'}">
							  	<tr class="even">
							  </c:if>
									<td class=" sorting_1">${dot.name }</td>
									<td class="center ">${dot.address }</td>
									<td class="center ">${dot.phone1 }</td>
									<td class="center ">${dot.ip }</td>
									<td class="center ">
										<a class="btn btn-info" href="${pageContext.request.contextPath }/dot/updateDot/${dot.dotId}">
											<i class="icon-edit icon-white"></i>  
											编辑                                            
										</a>
										<%-- <a class="btn btn-danger" href="${pageContext.request.contextPath }/deleteDot/${dot.dotId}" id="dotHref">
											<i class="icon-trash icon-white"></i> 
											删除
										</a> --%>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<!-- 分页开始 -->
							 <div class="row-fluid">
								<div class="span12">
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.page.currentPage-1)*requestScope.page.pageSize + 1 }  至${requestScope.page.currentPage*requestScope.page.pageSize };总记录数 ${requestScope.page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/dot/1 ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/dot/1">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/dot/1">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/2">2</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/2">下一页 → </a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/2">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.page.pageCount == 3 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/2">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/3">3</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/3">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.page.pageCount == 4 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/3">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/3">3</a></li>
												<li <c:if test="${requestScope.page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/4">4</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/4">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.page.pageCount >= 5 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/3">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage < requestScope.page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/${requestScope.page.currentPage - 1 }">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage == requestScope.page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/dot/${requestScope.page.currentPage - 1 }">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/3">3</a></li>
												<li <c:if test="${requestScope.page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/dot/4">4</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/dot/5">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage < requestScope.page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/dot/${requestScope.page.currentPage + 1 }">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage == requestScope.page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/dot/${requestScope.page.currentPage }">下一页 → </a></li></c:if>	
											</c:if>
										</ul>
									</div>
								</div>
							 </div>
						<!-- 分页结束 -->
					</div>            
					</div>
				</div><!--/span-->
			</div>
			<!-- table：网点结束 -->
			
			<!-- content ends -->
			</div><!--/#content.span10-->
		  </div><!--/fluid-row-->
				
		<hr>

		<footer>
			<p class="pull-left">&copy; <a href="http://www.sanploy.com/" target="_blank">Sanploy</a> 2015</p>
			<p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
		</footer>
	
	</div><!--/.fluid-container-->
	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- 导入js -->
	<%@include file= "/common/js.jsp"%>
<!-- 	<script type="text/javascript">
	$("#dotHref").click(function(){
		var href = $(this).attr("href");
		$("#dotForm").attr("action", href).submit();			
		return false;
	}); 
	</script>	
	-->
</body>
</html>
