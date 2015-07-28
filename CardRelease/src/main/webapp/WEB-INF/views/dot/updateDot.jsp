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

			<!-- form：增加或修改一个网点 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 编辑一个网点</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/dot/updateDot" method="post" modelAttribute="dot" name="dot">
							<fieldset>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">*网点ID</label>
								<div class="controls">
								  <input type="text" class="input-xlarge disabled" readonly="readonly" value="${dot.dotId }" name="dotId">
								  <span class="help-inline"></span>
								  <input type="hidden" name="_method" value="PUT"/>
								</div>
							  </div>
							  <div class="control-group" id="nameDIV">
								<label class="control-label" for="focusedInput">*网点名</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="name" id="name"/>
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group" id="addressDIV">
								<label class="control-label" for="focusedInput">*网点地址</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="address" id="address"/>
								  <span class="help-inline">推荐：**市**县(区)**街道(乡镇)**街*号</span>
								</div>
							  </div>
							  <div class="control-group" id="phone1DIV">
								<label class="control-label" for="focusedInput">*联系电话</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="phone1" id="phone1"/>
								  <span class="help-inline">电话格式,可带区号...</span>
								</div>
							  </div>
							  <div class="control-group" id="phone2DIV">
								<label class="control-label" for="focusedInput">备用联系电话</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="phone2" id="phone2"></form:input>
								  <span class="help-inline">电话号码</span>
								</div>
							  </div>
							  <div class="control-group" id="faxDIV">
								<label class="control-label" for="focusedInput">网点传真</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="fax" id="fax"></form:input>
								  <span class="help-inline">电话格式,请带区号...</span>
								</div>
							  </div>
							  <div class="control-group" id="ipDIV">
								<label class="control-label" for="focusedInput">网点IP地址</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="ip" id="ip"></form:input>
								  <span class="help-inline">格式为：255.255.255.255</span>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="save">保存网点</button>
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
	<!-- external javascript================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- 导入js -->
	<%@include file= "/common/js.jsp"%>
<script type="text/javascript">
/* 以下为验证 */
var isNameReady = true;
var isAddressReady = true;
var isPhone1Ready = true;
var isPhone2Ready = true;
var isFaxReady = true;
var isIpReady = true;

$("#name").blur(function(){
	var name = $("#name").val();
	if(!isNull(name) && stringFixedLength(name,1,40)){
		$("#nameDIV").attr("class","control-group success");isNameReady = true;
	}else{
		$("#nameDIV").attr("class","control-group error");isNameReady = false;
	}
});
$("#address").blur(function(){
	var address = $("#address").val();
	if(!isNull(address) && stringFixedLength(address,1,80)){
		$("#addressDIV").attr("class","control-group success");isAddressReady = true;
	}else{
		$("#addressDIV").attr("class","control-group error");isAddressReady = false;
	}
});
$("#phone1").blur(function(){
	var phone1 = $("#phone1").val();
	if(!isNull(phone1) && intFixedLength(phone1,8,13)){
		$("#phone1DIV").attr("class","control-group success");isPhone1Ready = true;
	}else{
		$("#phone1DIV").attr("class","control-group error");isPhone1Ready = false;
	}
});
$("#phone2").blur(function(){
	var phone2 = $("#phone2").val();
	if(isNull(phone2) ||(!isNull(phone2) && intFixedLength(phone2,8,13))){
		$("#phone2DIV").attr("class","control-group success");isPhone2Ready = true;
	}else{
		$("#phone2DIV").attr("class","control-group error");isPhone2Ready = false;
	}
});
$("#fax").blur(function(){
	var fax = $("#fax").val();
	if(isNull(fax) ||(!isNull(fax) && intFixedLength(fax,8,13))){
		$("#faxDIV").attr("class","control-group success");isFaxReady = true;
	}else{
		$("#faxDIV").attr("class","control-group error");isFaxReady = false;
	}
});
$("#ip").blur(function(){
	var ip = $("#ip").val();
	if(isNull(ip) || isIP(ip)){
		$("#ipDIV").attr("class","control-group success");isIpReady = true;
	}else{
		$("#ipDIV").attr("class","control-group error");isIpReady = false;
	}
});

$("#save").click(function(){
	if(isNameReady && isAddressReady && isPhone1Ready && isPhone2Ready && isFaxReady && isIpReady){
		$("form[name='dot']").submit();
	}else{
		return false;		
	}
});
</script>
</body>
</html>
