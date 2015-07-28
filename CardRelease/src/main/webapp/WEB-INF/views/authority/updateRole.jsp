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
				<!-- form：修改一个系统角色开始 -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-edit"></i> 修改系统角色</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/authority/updateRole" method="post" modelAttribute="role" name="role">
								<fieldset>
								  <div class="control-group">
									<label class="control-label" for="focusedInput">*角色ID</label>
									<div class="controls">
									  <input type="text" class="input-xlarge disabled" readonly="readonly" value="${role.roleId }" name="roleId">
									  <span class="help-inline"></span>
									  <input type="hidden" name="_method" value="PUT"/>
									</div>
							 	  </div>
								  <div class="control-group" id="roleNameDIV">
									<label class="control-label" for="focusedInput">*角色名</label>
									<div class="controls">
									  <form:input cssClass="input-xlarge focused" id="roleName" path="roleName"/>
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <div class="control-group">
									<label class="control-label">*是否可用</label>
									<div class="controls">
									  <label class="radio">
									    <form:radiobutton path="state" id="optionsRadios1" value="0" />生效
									  </label>
									  <div style="clear:both"></div>
									  <label class="radio">
									    <form:radiobutton path="state" id="optionsRadios2" value="1" />不生效
									  </label>
									</div>
								  </div>
								  <div class="control-group" id="validTimeDIV">
									<label class="control-label" for="focusedInput">*有效时间(截止日期)</label>
									<div class="controls">
									  <input type="text" class="input-xlarge focused" name="validTime" id="validTime" value='<fmt:formatDate value="${role.validTime }" pattern="yyyy-MM-dd"/>' onclick="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd',doubleCalendar:true,minDate:'{%y+5}-%M-%d',readOnly:true})" >
								      <span class="help-inline">请选择一个时间；默认时间在5年以后</span>
									</div>
								  </div>
								  <div class="control-group" id="remarkDIV">
									<label class="control-label" for="focusedInput">备注说明</label>
									<div class="controls">
									  <form:textarea path="remark" cssStyle="resize:none;" rows="4" cols="8" id="remark"/>
									  <span class="help-inline" style="margin-top:20px;">对当前系统角色的说明...</span>
									</div>
								  </div>
								  <div class="form-actions">
									<button type="button" class="btn btn-primary" id="save">修改角色</button>
									<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								  </div>
								</fieldset>
							  </form:form>
						</div>
					</div><!--/span-->
				</div><!--/row-->
				<!-- form：修改一个角色结束 -->
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
<!-- 验证信息 -->
<script type="text/javascript">
var isRoleNameReady = true;
var isValidTimeReady = true;
var isRemarkReady = true;

$("#roleName").blur(function(){
	var roleName = $("#roleName").val();
	if(!isNull(roleName) && roleName.length < 40){
		$("#roleNameDIV").attr("class", "control-group success");isRoleNameReady = true;
	}else{
		$("#roleNameDIV").attr("class", "control-group error");isRoleNameReady = false;
	}
});

$("#validTime").blur(function(){
	var validTime = $("#validTime").val(); 
	if(!isNull(validTime)){
		$("#validTimeDIV").attr("class", "control-group success");isValidTimeReady = true;
	}else{
		$("#validTimeDIV").attr("class", "control-group error");isValidTimeReady = false;
	}
});

$("#remark").blur(function(){
	var remark = $("#remark").val();
	if(isNull(validTime) || (!isNull(validTime) && remark.length < 100)){
		$("#remarkDIV").attr("class", "control-group success");isRemarkReady = true;
	}else{
		$("#remarkDIV").attr("class", "control-group error");isRemarkReady = false;
	}
});

$("#save").click(function(){
	if(isRoleNameReady && isValidTimeReady && isRemarkReady){
		$("form[name='role']").submit();
	}else{
		return false;		
	}
});
</script>
</body>
</html>
