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
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">亲，警告信息!</h4>
					<p>当前浏览器不支持某些 <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> 特性，您可以选择升级或开启更多的浏览器特性.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			
			<!-- table：卡类型开始 -->
			<form action="" method="post" id="bankCardTypeForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<div class="row-fluid sortable ui-sortable">		
				<div class="row-fluid sortable ui-sortable">		
					<div class="box span12">
						<div class="box-header well" data-original-title="">
							<h2><i class="icon-user"></i> 银行卡类型详情</h2>
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
											<a class="btn btn-success" href="${pageContext.request.contextPath }/basedata/addBankCardTypeUI" style="margin-left:5%">
											<i class="icon-user"></i> 新增银行卡类型</a>
										</label>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 309px;">编号</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 256px;">银行卡类型名</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 157px;">更新时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 265px;">可执行操作</th></tr>
							  </thead>   
							  <tbody role="alert" aria-live="polite" aria-relevant="all">
							  <c:forEach items="${requestScope.b_page.recordList }" var="bankCardType" varStatus="obj">
								  <c:if test="${obj.count%2 == '0'}">
								  	<tr class="odd">
								  </c:if>
								  <c:if test="${obj.count%2 != '0'}">
								  	<tr class="even">
								  </c:if>
										<td class=" sorting_1">${bankCardType.bankCardTypeId }</td>
										<td class="center ">${bankCardType.name }</td>
										<td class="center "><fmt:formatDate value="${bankCardType.operateDate }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center ">
											<a class="btn btn-info" href="${pageContext.request.contextPath }/basedata/updateBankCardType/${bankCardType.bankCardTypeId }">
												<i class="icon-edit icon-white"></i>  
												编辑                                            
											</a>
											<a class="btn btn-danger" href="${pageContext.request.contextPath }/basedata/deleteBankCardType/${bankCardType.bankCardTypeId }" id="cardHref" >
												<i class="icon-trash icon-white"></i> 
												删除
											</a>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- 分页开始 -->
							 <div class="row-fluid">
								<div class="span12">
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.b_page.currentPage-1)*requestScope.b_page.pageSize + 1 }  至${requestScope.b_page.currentPage*requestScope.b_page.pageSize };总记录数 ${requestScope.b_page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.b_page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage} ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.b_page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">2</a></li>
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.b_page.pageCount == 3 }">
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.b_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">3</a></li>
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.b_page.pageCount == 4 }">
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.b_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/4/${requestScope.k_page.currentPage}">4</a></li>
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/4/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/4/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.b_page.pageCount >= 5 }">
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage >4 && requestScope.b_page.currentPage < requestScope.b_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage - 1 }/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.b_page.currentPage >4 && requestScope.b_page.currentPage == requestScope.b_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage - 1 }/${requestScope.k_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.b_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/1/${requestScope.k_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.b_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/4/${requestScope.k_page.currentPage}">3</a></li>
												<c:if test="${requestScope.b_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/2/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/3/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/4/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/5/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage >4 && requestScope.b_page.currentPage < requestScope.b_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage + 1 }/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.b_page.currentPage >4 && requestScope.b_page.currentPage == requestScope.b_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage }/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
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
			</div>
			<!-- table：卡类型结束 -->
			
			<!-- table:扣点限制开始 -->
			<form action="" method="post" id="kdlimitForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<div class="row-fluid sortable ui-sortable">		
				<div class="row-fluid sortable ui-sortable">		
					<div class="box span12">
						<div class="box-header well" data-original-title="">
							<h2><i class="icon-user"></i> VIP卡扣点限制信息详情</h2>
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
											<a class="btn btn-success" href="${pageContext.request.contextPath }/basedata/addKDLimitUI" style="margin-left:5%">
											<i class="icon-user"></i> 新增VIP卡限制信息</a>
										</label>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 157px;">扣点限制编号</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 256px;">限制名称</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 157px;">限制点数</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 256px;">银行卡类型</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 157px;">更新时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 265px;">可执行操作</th></tr>
							  </thead>   
							  <tbody role="alert" aria-live="polite" aria-relevant="all">
							  <c:forEach items="${requestScope.k_page.recordList }" var="kdlimit" varStatus="obj">
								  <c:if test="${obj.count%2 == '0'}">
								  	<tr class="odd">
								  </c:if>
								  <c:if test="${obj.count%2 != '0'}">
								  	<tr class="even">
								  </c:if>
										<td class="sorting_1">${kdlimit.limitNo }</td>
										<td class="center ">${kdlimit.limitName }</td>
										<td class="center "><span class="label label-important">${kdlimit.limitPoint }</span></td>
										<td class="center "><span class="label label-warning center">${kdlimit.bankCardType.name }</span></td>
										<td class="center "><fmt:formatDate value="${kdlimit.operateDate }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center ">
											<a class="btn btn-info" href="${pageContext.request.contextPath }/basedata/updateKDLimit/${kdlimit.limitNo }">
												<i class="icon-edit icon-white"></i>  
												编辑                                            
											</a>
											<a class="btn btn-danger" href="${pageContext.request.contextPath }/basedata/deleteKDLimit/${kdlimit.limitNo }" id="kdlimitHref">
												<i class="icon-trash icon-white"></i> 
												删除
											</a>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- 分页开始 -->
							 <div class="row-fluid">
								<div class="span12">
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.k_page.currentPage-1)*requestScope.k_page.pageSize + 1 }  至${requestScope.k_page.currentPage*requestScope.k_page.pageSize };总记录数 ${requestScope.k_page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.k_page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1 ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.k_page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">2</a></li>
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">下一页 → </a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.k_page.pageCount == 3 }">
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.k_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">3</a></li>
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.k_page.pageCount == 4 }">
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.k_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">3</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/4">4</a></li>
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/4">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.k_page.pageCount >= 5 }">
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage >4 && requestScope.k_page.currentPage < requestScope.k_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage }/${requestScope.k_page.currentPage - 1}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.k_page.currentPage >4 && requestScope.k_page.currentPage == requestScope.k_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage }/${requestScope.k_page.currentPage - 1}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.k_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">3</a></li>
												<li <c:if test="${requestScope.k_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/4">3</a></li>
												<c:if test="${requestScope.k_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage}/5">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage >4 && requestScope.k_page.currentPage < requestScope.k_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage }/${requestScope.k_page.currentPage + 1 }">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.k_page.currentPage >4 && requestScope.k_page.currentPage == requestScope.k_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/basedata/list/${requestScope.b_page.currentPage }/${requestScope.k_page.currentPage}">下一页 → </a></li></c:if>	
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
			</div>
			<!-- table:扣点限制结束 -->
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
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/card_js/basedata.js"></script> --%>
	<script type="text/javascript">
	$("a[id='cardHref']").click(function() {
	    var href = $(this).attr("href");
	    $("form[id='bankCardTypeForm']").attr("action", href).submit();
	    return false;
	});

	//提交数据
	$("a[id='kdlimitHref']").click(function() {
	    //先判断是否在customer中有引用，有的话不允许删除
	    /* console.info($(this).parent().parent().children().first().text()) */
	    var commit = true;
	    $.ajax({
	        url : getProjectName() + "/basedata/isBankCardTypeRefByCustomer",
	        data : {
	            bankCardTypeId : $(this).parent().parent().children().first().text()
	        },
	        type : "POST",
	        success : (function(data, status) {
	            if (data["result"] == "failed") {
	                commit = false;
	            } else {
	                alert(data["info"]);
	            }
	        })
	    });
	    //提交数据
	    if (commit) {
	        var href = $(this).attr("href");
	        $("form[id='kdlimitForm']").attr("action", href).submit();
	    }
	    return false;
	});

	</script>
</body>
</html>
