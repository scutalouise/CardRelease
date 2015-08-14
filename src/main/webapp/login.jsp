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
		<div class="container-fluid">
		<div class="row-fluid">
		
			<div class="row-fluid">
				<div class="span12 center login-header">
					<h2>欢迎您使用体验卡 CardSystem</h2>
				</div><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info">
						请使用用户名和密码登录.
					</div>
					<form class="form-horizontal" action="${pageContext.request.contextPath }/login" method="post" name="login">
						<fieldset>
							<div class="input-prepend" title="登录名" data-rel="tooltip" id="usernameDIV">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="loginName" id="username" type="text" value="" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="密码" data-rel="tooltip" id="passwordDIV">
								<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password" id="password" type="password" value="" />
							</div>
							<div class="clearfix"></div>
							<!-- 
							<div class="input-prepend">
							<label class="remember" for="remember"><input type="checkbox" id="remember" name="remember" value="1"/>请记住我</label>
							</div>
							 -->
							<div class="clearfix"></div>

							<p class="center span5">
							<button type="button" class="btn btn-primary" id="save">登录</button>
							<span class="help-inline" style="margin-left:5%;">
								<c:if test="${requestScope.message != null}">${requestScope.message}</c:if>
								<c:if test="${sessionScope.message != null}">${sessionScope.message}</c:if>
							</span>
							</p>
						</fieldset>
					</form>
				</div><!--/span-->
			</div><!--/row-->
				</div><!--/fluid-row-->
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- 导入js -->
	<%@include file= "/common/js.jsp"%>
<script type="text/javascript">
var isUsernaemReady = true;
var isPasswordReady = true;
$("#username").blur(function(){
	var username = $("#username").val();
	if(isNull(username)){
		$("#username").css({"color":"#b94a48","border-color": "#b94a48"});
		$("#usernameDIV span").css({"color":"#b94a48","border-color": "#b94a48"});isUsernaemReady = false;
	}else{
		$("#username").css({"color":"#468847","border-color": "#468847"});
		$("#usernameDIV span").css({"color":"#468847","border-color": "#468847"});isUsernaemReady = true;
	}
});
$("#password").blur(function(){
	var password = $("#password").val();
	if(isNull(password)){
		$("#password").css({"color":"#b94a48","border-color": "#b94a48"});
		$("#passwordDIV span").css({"color":"#b94a48","border-color": "#b94a48"});isPasswordReady = false;
	}else{
		$("#password").css({"color":"#468847","border-color": "#468847"});
		$("#passwordDIV span").css({"color":"#468847","border-color": "#468847"});isPasswordReady = true;
	}
});
$("#save").click(function(){
	if(isUsernaemReady && isPasswordReady){
		$("form[name='login']").submit();
	}else{
		return false;		
	}
});

</script>
</body>
</html>
