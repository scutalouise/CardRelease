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
			<!-- content starts -->

			<!-- table：用户开始 -->
			<form action="" method="post" id="userForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<div class="row-fluid sortable ui-sortable">		
				<div class="row-fluid sortable ui-sortable">		
					<div class="box span12">
						<div class="box-header well" data-original-title="">
							<h2><i class="icon-user"></i> 系统用户详情</h2>
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
											<a class="btn btn-success" href="${pageContext.request.contextPath }/authority/addUserUI" style="margin-left:5%">
											<i class="icon-user"></i> 新增系统用户</a>
										</label>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 109px;">用户真实姓名</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 155px;">系统登陆名</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 115px;">电话</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 55px;">性别</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 125px;">系统角色</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 155px;">所属网点</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 265px;">可执行操作</th></tr>
							  </thead>   
							  <tbody role="alert" aria-live="polite" aria-relevant="all">
							  <c:forEach items="${requestScope.user_page.recordList }" var="user" varStatus="obj">
								  <c:if test="${obj.count%2 == '0'}">
								  	<tr class="odd">
								  </c:if>
								  <c:if test="${obj.count%2 != '0'}">
								  	<tr class="even">
								  </c:if>
										<td class=" sorting_1">${user.userName }</td>
										<td class="center ">${user.loginName }</td>
										<td class="center ">${user.phone }</td>
										<td class="center "><c:if test="${user.sex == 0}">男</c:if><c:if test="${user.sex == 1}">女</c:if></td>
										<td class="center ">${user.role.roleName }</td>
										<td class="center "><span class="label label-important">${user.dot.name }</span></td>
										<td class="center ">
											<a class="btn btn-info" href="${pageContext.request.contextPath }/authority/updateUser/${user.userId }">
												<i class="icon-edit icon-white"></i>  
												编辑                                            
											</a>
											<a class="btn btn-danger" href="${pageContext.request.contextPath }/authority/deleteUser/${user.userId }" id="userHref">
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
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.user_page.currentPage-1)*requestScope.user_page.pageSize + 1 }  至${requestScope.user_page.currentPage*requestScope.user_page.pageSize };总记录数 ${requestScope.user_page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.user_page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.k_page.currentPage}/${requestScope.function_page.currentPage} ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.k_page.currentPage}/${requestScope.function_page.currentPage}">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.k_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.user_page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.k_page.currentPage}">← 上一页</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">2</a></li>
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.user_page.pageCount == 3 }">
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.user_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">3</a></li>
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.user_page.pageCount == 4 }">
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.user_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/4/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">4</a></li>
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/4/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/4/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.user_page.pageCount >= 5 }">
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage >4 && requestScope.user_page.currentPage < requestScope.user_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage - 1 }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.user_page.currentPage >4 && requestScope.user_page.currentPage == requestScope.user_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage - 1 }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.user_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/1/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.user_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/4/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">4</a></li>
												<c:if test="${requestScope.user_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/2/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/3/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/4/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/5/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage >4 && requestScope.user_page.currentPage < requestScope.user_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage + 1 }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.user_page.currentPage >4 && requestScope.user_page.currentPage == requestScope.user_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
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
			<!-- table：用户结束 -->
			<!-- table：角色开始 -->
			<form action="" method="post" id="roleForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<div class="row-fluid sortable ui-sortable">		
				<div class="row-fluid sortable ui-sortable">		
					<div class="box span12">
						<div class="box-header well" data-original-title="">
							<h2><i class="icon-user"></i> 系统角色详情</h2>
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
											<a class="btn btn-success" href="${pageContext.request.contextPath }/authority/addRoleUI" style="margin-left:5%">
											<i class="icon-user"></i> 新增系统角色</a>
										</label>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 109px;">角色ID</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 105px;">角色名</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 125px;">是否可用</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 157px;">有效时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 177px;">设置时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 265px;">可执行操作</th></tr>
							  </thead>   
							  <tbody role="alert" aria-live="polite" aria-relevant="all">
							  <c:forEach items="${requestScope.role_page.recordList }" var="role" varStatus="obj">
								  <c:if test="${obj.count%2 == '0'}">
								  	<tr class="odd">
								  </c:if>
								  <c:if test="${obj.count%2 != '0'}">
								  	<tr class="even">
								  </c:if>
								        <td class=" sorting_1">${role.roleId }</td>
										<td class=" center">${role.roleName }</td>
										<td class="center "><c:if test="${role.state == 0}"><span class="label label-success">有效</span></c:if><c:if test="${role.state == 1}"><span class="label label-warning">失效</span></c:if></td>
										<td class="center "><fmt:formatDate value="${role.setTime }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center "><fmt:formatDate value="${role.operateDate }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center ">
											<a class="btn btn-info" href="${pageContext.request.contextPath }/authority/updateRole/${role.roleId }">
												<i class="icon-edit icon-white"></i>  
												编辑                                            
											</a>
											<a class="btn btn-danger" href="${pageContext.request.contextPath }/authority/deleteRole/${role.roleId }" id="roleHref">
												<i class="icon-trash icon-white"></i> 
												删除
											</a>
											<a class="btn btn-warning" href="${pageContext.request.contextPath }/authority/addRoleFunctionUI/${role.roleId }">
												<i class="icon-trash icon-white"></i> 
												角色功能
											</a>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- 分页开始 -->
							 <div class="row-fluid">
								<div class="span12">
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.role_page.currentPage-1)*requestScope.role_page.pageSize + 1 }  至${requestScope.role_page.currentPage*requestScope.role_page.pageSize };总记录数 ${requestScope.role_page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.role_page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage} ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.role_page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">2</a></li>
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>
											</c:if>
											<c:if test="${requestScope.role_page.pageCount == 3 }">
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.role_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">3</a></li>
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.role_page.pageCount == 4 }">
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.role_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/4/${requestScope.function_page.currentPage}">4</a></li>
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/4/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/4/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.role_page.pageCount >= 5 }">
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage >4 && requestScope.role_page.currentPage < requestScope.role_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage - 1}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.role_page.currentPage >4 && requestScope.role_page.currentPage == requestScope.role_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage - 1}/${requestScope.function_page.currentPage}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.role_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/1/${requestScope.function_page.currentPage}">1</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">2</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">3</a></li>
												<li <c:if test="${requestScope.role_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/4/${requestScope.function_page.currentPage}">4</a></li>
												<c:if test="${requestScope.role_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/2/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/3/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/4/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/5/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage >4 && requestScope.role_page.currentPage < requestScope.role_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage + 1}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.role_page.currentPage >4 && requestScope.role_page.currentPage == requestScope.role_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
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
			<!-- table：角色结束 -->
			<!-- table:功能开始 -->
			<form action="" method="post" id="functionForm">
				<input type="hidden" name="_method" value="DELETE">
			</form>
			<div class="row-fluid sortable ui-sortable">		
				<div class="row-fluid sortable ui-sortable">		
					<div class="box span12">
						<div class="box-header well" data-original-title="">
							<h2><i class="icon-user"></i> 系统功能详情</h2>
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
											<a class="btn btn-success" href="${pageContext.request.contextPath }/authority/addFunctionUI" style="margin-left:5%">
											<i class="icon-user"></i> 新加系统功能</a>
										</label>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered bootstrap-datatable " id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 109px;">功能ID</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 135px;">名称</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 257px;">URL</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 121px;">状态</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 137px;">创建时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 137px;">修改时间</th>
								  <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1"  style="width: 265px;">可执行操作</th></tr>
							  </thead>   
							  <tbody role="alert" aria-live="polite" aria-relevant="all">
							  <c:forEach items="${requestScope.function_page.recordList }" var="function" varStatus="obj">
								  <c:if test="${obj.count%2 == '0'}">
								  	<tr class="odd">
								  </c:if>
								  <c:if test="${obj.count%2 != '0'}">
								  	<tr class="even">
								  </c:if>
										<td class=" sorting_1">${function.functionId }</td>
										<td class="center ">${function.functionName }</td>
										<td class="center ">${function.url }</td>
										<td class="center "><c:if test="${function.state == 0}"><span class="label label-warning">失效</span></c:if><c:if test="${function.state == 1}"><span class="label label-success">有效</span></c:if></td>
										<td class="center "><fmt:formatDate value="${function.createDate }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center "><fmt:formatDate value="${function.operateDate }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
										<td class="center ">
											<a class="btn btn-info" href="${pageContext.request.contextPath }/authority/updateFunction/${function.functionId }">
												<i class="icon-edit icon-white"></i>  
												编辑                                            
											</a>
											<a class="btn btn-danger" href="${pageContext.request.contextPath }/authority/deleteFunction/${function.functionId }" id="functionHref">
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
									<div class="dataTables_info" id="DataTables_Table_0_info">显示${(requestScope.function_page.currentPage-1)*requestScope.function_page.pageSize + 1 }  至${requestScope.function_page.currentPage*requestScope.function_page.pageSize };总记录数 ${requestScope.function_page.recordCount } </div>
								</div>
								<div class="span12 center">
									<div class="dataTables_paginate paging_bootstrap pagination">
										<ul>
											<%-- ${requestScope.page.pageCount} :  ${requestScope.page.pageSize} : ${requestScope.page.currentPage}  --%>
											<c:if test="${requestScope.function_page.pageCount == 1 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1 ">← 上一页</a></li>
												<li class="active"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">1</a></li>
												<li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">下一页 → </a></li>
											</c:if>
											<c:if test="${requestScope.function_page.pageCount == 2 }">
												<li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">2</a></li>
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">下一页 → </a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">下一页 → </a></li></c:if>
											</c:if> 
											<c:if test="${requestScope.function_page.pageCount == 3 }">
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.function_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">3</a></li>
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.function_page.pageCount == 4 }">
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.function_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">3</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/4">4</a></li>
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/4">下一页 → </a></li></c:if>	
											</c:if>
											<c:if test="${requestScope.function_page.pageCount >= 5 }">
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage == 4 }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage >4 && requestScope.function_page.currentPage < requestScope.function_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage - 1}">← 上一页</a></li></c:if>
												<c:if test="${requestScope.function_page.currentPage >4 && requestScope.function_page.currentPage == requestScope.function_page.pageCount }"><li class="prev"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage - 1}">← 上一页</a></li></c:if>
												<li <c:if test="${requestScope.function_page.currentPage == 1 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/1">1</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 2 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">2</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 3 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">3</a></li>
												<li <c:if test="${requestScope.function_page.currentPage == 4 }">class="active"</c:if> ><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/4">4</a></li>
												<c:if test="${requestScope.function_page.currentPage == 1 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/2">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 2 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/3">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 3 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/4">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage == 4 }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage}/${requestScope.role_page.currentPage}/5">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage >4 && requestScope.function_page.currentPage < requestScope.function_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage + 1}">下一页 → </a></li></c:if>	
												<c:if test="${requestScope.function_page.currentPage >4 && requestScope.function_page.currentPage == requestScope.function_page.pageCount }"><li class="next"><a href="${pageContext.request.contextPath }/authority/${requestScope.user_page.currentPage }/${requestScope.role_page.currentPage}/${requestScope.function_page.currentPage}">下一页 → </a></li></c:if>	
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
			<!-- table:功能结束 -->
				
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
		<script type="text/javascript">
	
	$("a[id='userHref']").click(function(){
		var href = $(this).attr("href");
		$("form[id='userForm']").attr("action", href).submit();			
		return false;
	});
	$("a[id='roleHref']").click(function(){
		var href = $(this).attr("href");
		$("form[id='roleForm']").attr("action", href).submit();
		return false;
	});
	$("a[id='functionHref']").click(function(){
		var href = $(this).attr("href");
		$("form[id='functionForm']").attr("action", href).submit();
		return false;
	});
	</script>
</body>
</html>
