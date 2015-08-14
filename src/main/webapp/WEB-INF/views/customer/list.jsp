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

			<form action="" method="post" >
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<!-- table：客户开始 -->
			<div class="row-fluid sortable ui-sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title="">
						<h2><i class="icon-user"></i> VIP客户详情</h2>
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
										<a class="btn btn-success" href="${pageContext.request.contextPath }/customer/addCustomerUI" style="margin-left:5%"><i class="icon-user"></i> 新增客户</a>
									</label>
								</div>
							</div>
							<div class="span6">
								<div class="dataTables_filter" id="DataTables_Table_0_filter">
									<label>搜索: <input type="text" aria-controls="DataTables_Table_0"></label>
								</div>
							</div>
						</div>
						<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
						  <thead>
							  <tr role="row">
							  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 209px;">客户银行卡号</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 119px;">VIP卡号</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 109px;">银行卡类型</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 127px;">客户姓名</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 127px;">客户电话</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 97px;">原始点数</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 97px;">剩余点数</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 97px;">状态</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 127px;">失效时间</th>
							  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 565px;">可执行操作</th></tr>
						  </thead>   
						  <tbody role="alert" aria-live="polite" aria-relevant="all">
						  <c:forEach items="${requestScope.page.recordList }" var="customer" varStatus="obj">
							  <c:if test="${obj.count%2 == '0'}">
							  	<tr class="odd">
							  </c:if>
							  <c:if test="${obj.count%2 != '0'}">
							  	<tr class="even">
							  </c:if>
									<td class=" sorting_1">${customer.bankCardNo }</td>
									<td class="center ">${customer.cardNo }</td>
									<td class="center "><span class="label label-success">${customer.bankCardType.name }</span></td>
									<td class="center ">${customer.customerName }</td>
									<td class="center ">${customer.customerTel }</td>
									<td class="center ">${customer.originalPt }</td>
									<td class="center ">${customer.remainingPt }</td>
									<td class="center "><c:if test="${customer.loss == '0' }"><span class="label label-success">正常</span></c:if><c:if test="${customer.loss == '1' }"><span class="label label-important">挂失卡</span></c:if><c:if test="${customer.loss == '2' }"><span class="label label-warning">已补卡</span></c:if></td>
									<td class="center "><span class="label label-warning"><fmt:formatDate value="${customer.invalid }" pattern="yyyy-MM-dd"/></span></td>
									<td class="center ">
										<a class="btn btn-info" href="${pageContext.request.contextPath }/customer/updateCustomer/${customer.bankCardNo}">
											<i class="icon-edit icon-white"></i>  
											编辑                                            
										</a>
										<%-- <a class="btn btn-danger" href="${pageContext.request.contextPath }/customer/deleteCustomer/${customer.bankCardNo}">
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
												<li class="prev"><a href="${pageContext.request.contextPath }/customer/1 ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/customer/1">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/customer/1">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/2">2</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/2">下一页 → </a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/2">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.page.pageCount == 3 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/2">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/3">3</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/3">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.page.pageCount == 4 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/3">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/3">3</a></li>
												<li <c:if test="${requestScope.page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/4">4</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/4">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.page.pageCount >= 5 }">
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/3">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage < requestScope.page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/${requestScope.page.currentPage - 1 }">← 上一页</a></li></c:if>
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage == requestScope.page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/customer/${requestScope.page.currentPage - 1 }">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/1">1</a></li>
												<li <c:if test="${requestScope.page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/2">2</a></li>
												<li <c:if test="${requestScope.page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/3">3</a></li>
												<li <c:if test="${requestScope.page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/customer/4">3</a></li>
												<c:if test="${requestScope.page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/customer/5">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage < requestScope.page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/customer/${requestScope.page.currentPage + 1 }">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.page.currentPage >4 && requestScope.page.currentPage == requestScope.page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/customer/${requestScope.page.currentPage }">下一页 → </a></li></c:if>	
											</c:if>
										</ul>
									</div>
								</div>
							 </div>
						<!-- 分页结束 -->
					</div>            
					</div>
				</div><!--/span12-->
			</div>
			<!-- table：客户结束 -->
			
			<!-- content ends -->
			</div><!--/#content.span10-->
		  </div><!--/fluid-row-->
				
		<hr>

	<%@include file= "/common/footer.jsp"%>
	</div><!--/.fluid-container-->
	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- 导入js -->
	<%@include file= "/common/js.jsp"%>
	<script type="text/javascript">
	$(function(){
		$(".btn-danger").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return false;
		});
	})
	</script>		
</body>
</html>
