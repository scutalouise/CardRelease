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

			<!-- form：提交报表查询条件 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 网点报表查询条件</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<%-- <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="customer" target="_blank" id="dotForm"> --%>
						<form class="form-horizontal" action="" method="post" target="_blank" id="customerForm">
							<fieldset>
							  <div class="control-group">
								<label class="control-label" for="selectError3">报表选择</label>
								<div class="controls">
								  <select id="selectError3" name="customerReportType">
								  	<option value="1">------客户交易汇总表------</option>
								  	<option value="2">------客户交易明细表------</option>
								  </select>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="selectError3">客户选择</label>
								<div class="controls">
								  <select id="bankSelect" name="bankCardNo">
								  	<option value="-1">------全部客户------</option>
									<c:forEach items="${requestScope.customers }" var="customer">
										<option value="${customer.bankCardNo }">${customer.customerName }</option>
									</c:forEach>
								  </select>
								</div>
							  </div>
							  <div class="control-group" id="startDateDIV">
								<label class="control-label" for="focusedInput">*起始日期</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="startDate" type="text" value="" name="startDate" onclick="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd',doubleCalendar:true,maxDate:'%y-%M-%d',readOnly:true})">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group" id="endDateDIV">
								<label class="control-label" for="focusedInput">*截止日期</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="endDate" type="text" value="" name="endDate" onclick="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd',doubleCalendar:true,minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d',readOnly:true})">
								  <span class="help-inline"></span>
								</div>
							  </div>
							
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="queryButton">查询报表</button>
								<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								<button type="button" class="btn btn-primary" id="exportButton">导出excel</button>
							  </div>
							</fieldset>
						</form>
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
	$("#queryButton").click(function() {
		if(isStartDateReady && isEndDateReaDy){
			$("form[id='customerForm']").attr("action", "${pageContext.request.contextPath}/customerReport/html").submit();
		}else{
			return false;
		}
	});
	$("#exportButton").click(function() {
		if(isStartDateReady && isEndDateReaDy){
			$("form[id='customerForm']").attr("action", "${pageContext.request.contextPath}/customerReport/excel").submit();
		}else{
			return false;
		}
	});
	
	$("select[name='customerReportType']").change(function(){
		/* console.log($("select[name='bankCardNo'] option:first").val()); */
		if($("select[name='customerReportType']").children('option:selected').val() == 1){
			if($("select[name='bankCardNo'] option:first").val() != -1){
				$("select[name='bankCardNo'] option:selected").attr("selected",false);
				$("select[name='bankCardNo']").prepend("<option value='-1' selected='selected'>------全部客户------</option>");  //为Select插入一个Option(第一个位置)
			}
		}
		if($("select[name='customerReportType']").children('option:selected').val() == 2){
			if($("select[name='bankCardNo'] option:first").val() == -1){
				$("select[name='bankCardNo'] option:first").remove();
			}
		}
	}
	);
	 
	 </script>
</body>
</html>
