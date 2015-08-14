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
				<!-- form：修改系统功能 -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-edit"></i> 修改系统功能</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/authority/updateFunction" method="post" modelAttribute="function" name="function">
								<fieldset>
								  <div class="control-group">
									<label class="control-label" for="focusedInput">*功能ID</label>
									<div class="controls">
									  <input type="text" class="input-xlarge disabled" readonly="readonly" value="${function.functionId }" name="functionId">
									  <span class="help-inline"></span>
									  <input type="hidden" name="_method" value="PUT"/>
									</div>
							 	  </div>
								  <div class="control-group" id="functionNameDIV">
									<label class="control-label" for="focusedInput">*系统功能名字</label>
									<div class="controls">
									  <form:input path="functionName" cssClass="input-xlarge focused" id="functionName"/>
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <div class="control-group">
									<label class="control-label">*是否可用</label>
									<div class="controls">
									  <label class="radio">
									    <form:radiobutton path="state" id="optionsRadios2" value="1" />生效
									  </label>
									  <div style="clear:both"></div>
									  <label class="radio">
									    <form:radiobutton path="state" id="optionsRadios1" value="0" />不生效
									  </label>
									</div>
								  </div>
								  <div class="control-group" id="urlDIV">
									<label class="control-label" for="focusedInput">*URL</label>
									<div class="controls">
									  <form:input path="url" cssClass="input-xlarge focused" id="url"/>
									  <span class="help-inline">例如：/basedata</span>
									</div>
								  </div>
								  <div class="form-actions">
									<button type="button" class="btn btn-primary" id="save">修改功能</button>
									<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								  </div>
								</fieldset>
							  </form:form>
						</div>
					</div><!--/span-->
				</div><!--/row-->
				<!-- form：增加一个系统功能结束 -->
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
<!-- 验证信息 -->
<script type="text/javascript">
var isFunctionNameReady = true;
var isUrlReady = true;

$("#functionName").blur(function(){
	var functionName = $("#functionName").val();
	if(!isNull(functionName) && functionName.length < 40){
		$("#functionNameDIV").attr("class", "control-group success");isFunctionNameReady = true;
	}else{
		$("#functionNameDIV").attr("class", "control-group error");isFunctionNameReady = false;
	}
});

$("#url").blur(function(){
	var url = $("#url").val(); 
	if(!isNull(url) && url.length < 100){
		$("#urlDIV").attr("class", "control-group success");isUrlReady = true;
	}else{
		$("#urlDIV").attr("class", "control-group error");isUrlReady = false;
	}
});

$("#save").click(function(){
	if(isFunctionNameReady && isUrlReady){
		$("form[name='function']").submit();
	}else{
		return false;		
	}
});
</script>
</body>
</html>
