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
	<!-- 导入css -->
	<%@include file="/common/css.jsp" %>
	<%-- <OBJECT id=rd codeBase=${pageContext.request.contextPath }/comRD800.dll classid="clsid:638B238E-EB84-4933-B3C8-854B86140668" style="display:none"></OBJECT> --%>
	<Object id=rd codeBase="${pageContext.request.contextPath }/comRD800.cab#version=1,0,0,6" classid="clsid:638B238E-EB84-4933-B3C8-854B86140668" style="display:none"></Object>
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

			<!-- form：扣点，客户消费 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 体验卡扣点</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/trade/comsume" method="post" modelAttribute="tradePoint">
							<fieldset>
							  <div class="control-group">
								<label class="control-label" style="margin-top: 2px;font-size: 16px;">尊敬的客户:</label>
								<div class="controls" >
									<span class="help-inline" style="font-weight: bold;color: #d41e24;font-size: 24px;line-height: 36px;" id="customerNameSpan"></span>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <label class="control-label" style="text-align:left;font-size: 16px;">您今日体验:<span class="help-inline" style="font-weight: bold;color: #d41e24;font-size: 24px;" id="todayComsumeSpan"></span></label>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <label class="control-label" style="text-align:left;font-size: 16px;">您累计体验:<span class="help-inline" style="font-weight: bold;color: #d41e24;font-size: 24px;" id="sumComsumeSpan"></span></label>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <label class="control-label" style="text-align:left;font-size: 16px;">您剩余体验:<span class="help-inline" style="font-weight: bold;color: #d41e24;font-size: 24px;" id="remainComsumeSpan"></span></label>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <span class="help-inline">每次体验将扣减您1个点.</span>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <span class="help-inline">尊贵的客户,祝您旅途愉快!</span>
								</div>
							  </div>
							  <div class="control-group">
								<div class="controls" >
								  <span class="help-inline" id="message" style="color: #B94846;"></span>
								</div>
							  </div>
							  <div class="form-actions" id="comsumeButtonDIV">
								<button type="button" class="btn btn-primary" id="comsumeButton">体验 一次</button>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/comsume.js"></script>
</body>
</html>
