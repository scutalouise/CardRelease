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
				<!-- form：增加一个VIP卡扣点限制开始 -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-edit"></i> 新增VIP卡扣点限制</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/basedata/addKDLimit" method="post" modelAttribute="kdlimit" name="kdlimit">
								<fieldset>
								  <div class="control-group">
									<label class="control-label" for="focusedInput">*VIP卡扣点限制编号</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="focusedInput" type="text" value="${kdlimit.limitNo }" name="limitNo" readonly="readonly">
									  <span class="help-inline">自动生成，不能修改...</span>
									</div>
								  </div>
								  <div class="control-group" id="limitNameDIV">
									<label class="control-label" for="focusedInput">*扣点限制的名称</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="limitName" type="text" value="" name="limitName">
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <div class="control-group" id="limitPointDIV">
									<label class="control-label" for="focusedInput">*限制点数</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="limitPoint" type="text" value="" name="limitPoint">
									  <span class="help-inline">最大99</span>
									</div>
								  </div>
								  <div class="control-group" id="bankCardTypeDIV">
										<label class="control-label" for="selectError3">*银行卡类型</label>
										<div class="controls">
										  <select id="selectError3" name="bankCardType.bankCardTypeId">
										  		<option value="">-----请选择一种银行卡类型-----</option>
										  	<c:forEach items="${requestScope.bankcardTypes }" var="bankCardType">
										  		<option value="${bankCardType.bankCardTypeId }">${bankCardType.name }</option>
										  	</c:forEach>
										  </select>
										</div>
								  </div>
								  <div class="form-actions">
									<button type="button" class="btn btn-primary" id="save">保存扣点信息</button>
									<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								  </div>
								</fieldset>
							  </form:form>
						</div>
					</div><!--/span-->
				</div><!--/row-->
				<!-- form：增加一个VIP卡扣点限制结束 -->
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
var isLimitNameReady = false;
var isLimitPointReady = false;
var isBankCardTypeReady = false;

$("#bankCardTypeDIV").focusout(function() {
	if($("#bankCardTypeDIV option:selected").index() > 0){
	   	$.ajax({
	           url:getProjectName() + "/basedata/isKDLimitExist" ,
	           data:{bankCardTypeId:$("#bankCardTypeDIV option:selected").val()},
	           type:"POST",
	           success:(function(data,status) {
	           			if(data["result"] == "failed"){
	           				$(".form-actions button").show();
	           				$("#bankCardTypeDIV").attr("class","control-group success");
	           				isBankCardTypeReady = true;
	           			}else if(data["result"] == "success"){
	           				$(".form-actions button").hide();
	           				$("#bankCardTypeDIV").attr("class","control-group error");  
	           				isBankCardTypeReady = false;
	           			}
	                   })
	       });
	}else{
		$("#bankCardTypeDIV").attr("class","control-group error");
		isBankCardTypeReady = true;
	}
});

$("#limitName").blur(function(){
	var limitName = $("#limitName").val();
	if(!isNull(limitName) && limitName.length <40){
		$("#limitNameDIV").attr("class","control-group success");isLimitNameReady = true;
	}else{
		$("#limitNameDIV").attr("class","control-group error");isLimitNameReady = false;
	}
});

$("#limitPoint").blur(function(){
	var limitPoint = $("#limitPoint").val();
	if(intFixedLength(limitPoint,1,2)){
		$("#limitPointDIV").attr("class","control-group success");isLimitPointReady = true;
	}else{
		$("#limitPointDIV").attr("class","control-group error");isLimitPointReady = false;
	}
});
$("#save").click(function(){
	if(isLimitNameReady && isLimitPointReady && isBankCardTypeReady){
		$("form[name='kdlimit']").submit();
	}else{
		return false;		
	}
});
</script>
</body>
</html>
