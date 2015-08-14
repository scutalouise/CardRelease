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

			<!-- form：修改一个用户 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 个人信息维护</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/authority/updatePassword" method="post" modelAttribute="user" name="user">
							<fieldset>
							 <input type="hidden" name="userId" value="${sessionScope.user.userId }" id="userId">
							  <div class="control-group" id="userDiv">
									<label class="control-label" for="focusedInput">*当前密码</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="currentPassword" type="password" value="" >
									  <span class="help-inline" id="currentPasswordSpan">6到20位</span>
									</div>
							  </div>
							  <div class="control-group" id="passwordDIV">
									<label class="control-label" for="focusedInput">*新密码</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="password" type="password" value="" name="password" >
									  <span class="help-inline">6到20位</span>
									</div>
							  </div>
							  <div class="control-group" id="repeatPasswordDIV">
									<label class="control-label" for="focusedInput">*重复新密码</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="repeatPassword" type="password" value="">
									  <span class="help-inline">6到20位</span>
									</div>
							  </div>
							  <div class="form-actions">
								   	<button type="button" class="btn btn-primary" id="save">修改密码</button>
								   	<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
							  </div>
							</fieldset>
						  </form:form>
					</div>
				</div><!--/span-->
			</div><!--/row-->
				
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
	<!-- 使用ajax判断修改密码的用户，当前密码是否正确，不正确将不能修改密码 -->
<script type="text/javascript">
var isRepeatPasswordReady = false;
var isCurrentPasswordReady = false;
var isRepeatPasswordReady = false;
$("#currentPassword").focusout(function() {
	var currentPassword = $("#currentPassword").val();
	if(stringFixedLength(currentPassword,6,20)){
	  	$.ajax({
	          url:getProjectName() + "/authority/isPasswordCorrect",
	          type:"POST",
	          data:{userId:$("#userId").val(),password:$("#currentPassword").val()},
	          success:(function(data,status) {
	          			if(data["result"] == "failed"){
	          				$("#save").hide();
	          				$("#userDiv").attr("class","control-group error");   
	          				isCurrentPasswordReady = false;
	          			}else{
	          				$("#save").show();
	          				$("#userDiv").attr("class","control-group success");
	          				isCurrentPasswordReady = true;
	          			}
	                      $("#currentPasswordSpan").text(data["info"]);
	                  })
	     });
	}else{
		$("#userDiv").attr("class","control-group error");isCurrentPasswordReady = false;
	}
});
  
$("#password").blur(function(){
	var password = $("#password").val();
	if(!stringFixedLength(password,6,20)){
		$("#passwordDIV").attr("class", "control-group error");isPasswordReady = false;
	}else{
		$("#passwordDIV").attr("class", "control-group success");isPasswordReady = true;
	}
});

$("#repeatPassword").blur(function(){
	var repeatPassword = $("#repeatPassword").val();
	var password = $("#password").val();
	if(isNull(repeatPassword) && !stringFixedLength(repeatPassword,6,20) || password != repeatPassword){
		$("#repeatPasswordDIV").attr("class", "control-group error");isRepeatPasswordReady = false;
	}else{
		$("#repeatPasswordDIV").attr("class", "control-group success");isRepeatPasswordReady = true;
	}
});

$("#save").click(function(){
	if(isPasswordReady && isRepeatPasswordReady && isCurrentPasswordReady){
		$("form[name='user']").submit();
	}else{
		return false;		
	}
});
</script>
</body>
</html>
