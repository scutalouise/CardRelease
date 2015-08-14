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
				<!-- form：角色对应功能修改 -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-edit"></i> 设置角色所拥有的功能</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/authority/addRoleFunction" method="post" modelAttribute="roleFunction">
								<fieldset>
								  <div class="control-group">
									<label class="control-label" for="focusedInput">*角色Id</label>
									<div class="controls">
									  <input class="input-xlarge disabled" readonly="readonly" type="text" value="${requestScope.role.roleId}" name="roleId">
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <div class="control-group">
									<label class="control-label" for="focusedInput">*角色名</label>
									<div class="controls">
									  <input class="input-xlarge disabled" readonly="readonly" type="text" value="${requestScope.role.roleName}">
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <!-- 以下为功能列表，如果当前role拥有此功能，则选中； -->
							      <c:forEach items="${functions }" var="fun" varStatus="status">
									  <div class="control-group">
									  	  <label class="control-label">系统功能</label>
									            <label class="checkbox inline">
												<div class="checker">
													<span><input type="checkbox" class="opacity: 0;" value="${fun.functionId }" name="functionId"  
															<c:forEach items="${roleFunctions }" var="rf">
																<c:if test="${rf.function.functionId == fun.functionId }">
																	checked="checked"
																</c:if>
															</c:forEach>
														 ></span>
												</div>${fun.functionName } 
												</label>
									  </div>
							      </c:forEach>
								  
								  <div class="form-actions">
									<button type="submit" class="btn btn-primary">保存角色功能关系</button>
									<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								  </div>
								</fieldset>
							  </form:form>
						</div>
					</div><!--/span-->
				</div><!--/row-->
				<!-- form：角色与功能关系结束 -->
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
		
</body>
</html>
