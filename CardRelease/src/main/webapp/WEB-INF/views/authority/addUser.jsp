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

			<!-- form：增加一个用户 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 新增一个用户</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/authority/addUser" method="post" modelAttribute="user" name="user">
							<fieldset>
							  <div class="control-group" id="userNameDIV">
								<label class="control-label" for="focusedInput">用户真实姓名</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="userName" type="text" value="" name="userName">
								  <span class="help-inline">您的真实姓名......</span>
								</div>
							  </div>
							  <div class="control-group" id="loginNameDIV">
								<label class="control-label" for="focusedInput">*系统登录名</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="loginName" type="text" value="" name="loginName">
								  <span class="help-inline">区分大小写，不能与已有登录名重复......</span>
								</div>
							  </div>
							  <div class="control-group" id="passwordDIV">
								<label class="control-label" for="focusedInput">*密码</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="password" type="password" value="" name="password">
								  <span class="help-inline">6到20位</span>
								</div>
							  </div>
							  <div class="control-group" id="repeatPasswordDIV">
								<label class="control-label" for="focusedInput">*重复密码</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="repeatPassword" type="password" value="">
								  <span class="help-inline">重复您刚录入的密码...</span>
								</div>
							  </div>
							  <div class="control-group" id="phoneDIV">
								<label class="control-label" for="focusedInput">您的电话</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="phone" type="text" value="" name="phone">
								  <span class="help-inline">电话号码</span>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label">性别</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="sex" id="optionsRadios1" value="0" checked="checked">
									男
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="sex" id="optionsRadios2" value="1">
									女
								  </label>
								</div>
							  </div>
							  <div class="control-group" id="dotIdSelect">
								<label class="control-label" for="selectError3">*所属网点</label>
								<div class="controls">
								  <select name="dot.dotId">
								  	<option value="">------请选择一个网点------</option>
									<c:forEach items="${requestScope.dots }" var="dot">
										<option value="${dot.dotId }">${dot.name }</option>
									</c:forEach>
								  </select>
								</div>
							  </div>
							  <div class="control-group" id="roleIdSelect">
								<label class="control-label" for="selectError3">*系统角色</label>
								<div class="controls">
								  <select name="role.roleId">
								  	<option value="-1">------请选择一个角色------</option>
									<c:forEach items="${requestScope.roles }" var="role">
										<option value="${role.roleId }">${role.roleName }</option>
									</c:forEach>
								  </select>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="save">保存用户</button>
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
	 $("#loginNameDIV div input").focusout(function() {
		 /* 判断，loginName是否存在 */
		 if($("#loginNameDIV div input").val() != ""){
			 $.ajax({
		            url:getProjectName() + "/authority/isLoginNameExist" ,
		            data:{loginName:$("#loginNameDIV div input").val()},
		            type:"POST",
		            success:(function(data,status) {
		            			if(data["result"] == "failed"){
		            				$(".form-actions button").show();
		            				$("#loginNameDIV div span").text(data["info"]);
		            				$("#loginNameDIV").attr("class","control-group success");
		            			}else if(data["result"] == "success"){
		            				$(".form-actions button").hide();
		            				$("#loginNameDIV div span").text(data["info"]);
		            				$("#loginNameDIV").attr("class","control-group error");     		        
		            			}
		                    })
		        });		 
		 }
    });
/* 以下为表单验证 */
var isUserNameReady = false;
var isLoginNameReady = false;
var isPasswordReady = false;
var isRepeatPasswordReady = false;
var isPhoneReady = false;
var isDotIdSelectReady = false;
var isRoleIdSelectReady = false;
$("#userName").blur(function(){
	var  username = $("#userName").val();
	if(isNull(username) || (!isNull(username) && username.trim().length <= 20)){
		$("#userNameDIV").attr("class", "control-group success");isUserNameReady = true;
	}else{
		$("#userNameDIV").attr("class", "control-group error");isUserNameReady = false;
	}
});
$("#loginName").blur(function(){
	var loginName = $("#loginName").val();
	if(isNull(loginName) || loginName.length >= 20 ){
		$("#loginNameDIV").attr("class", "control-group error");isLoginNameReady = false;
	}else{
		$("#loginNameDIV").attr("class", "control-group success");isLoginNameReady = true;
	}
})
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
$("#phone").blur(function(){
	var	phone = $("#phone").val();
	if(!isNull(phone) && !intFixedLength(phone,11,11)){
		$("#phoneDIV").attr("class", "control-group error");isPhoneReady = false;
	}else{
		$("#phoneDIV").attr("class", "control-group success");isPhoneReady = true;
	}
});
$("#dotIdSelect select").change(function(){
	if(isFirstOptionSelected($("#dotIdSelect select"))){
		$("#dotIdSelect").attr("class", "control-group error");isDotIdSelectReady = false;
	}else{
		$("#dotIdSelect").attr("class", "control-group success");isDotIdSelectReady = true;
	}	
});
$("#roleIdSelect select").change(function(){
	if(isFirstOptionSelected($("#roleIdSelect select"))){
		$("#roleIdSelect").attr("class", "control-group error");isRoleIdSelectReady = false;
	}else{
		$("#roleIdSelect").attr("class", "control-group success");isRoleIdSelectReady = true;
	}	
});

$("#save").click(function(){
	if(isUserNameReady && isLoginNameReady && isPasswordReady && isRepeatPasswordReady && isPhoneReady && isDotIdSelectReady && isRoleIdSelectReady){
		$("form[name='user']").submit();
	}else{
		return false;		
	}
});
	</script>
</body>
</html>
