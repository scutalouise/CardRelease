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
						<h2><i class="icon-edit"></i> 体验卡卡充点</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/trade/recharge" method="post" modelAttribute="tradePoint">
							<fieldset>
							  <div class="control-group" id="readCardDIV">
								<label class="control-label" for="focusedInput">*体验卡卡号</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="cardNo" type="text" value="" name="cardNo" readonly="readonly">
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary"  id="readCard">读取卡信息</button>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">银行卡号</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="bankCardNo" readonly="readonly" type="text" value="${requestScope.customer.bankCardNo }" >
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">客户姓名</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="customerName" readonly="readonly" type="text" value="${requestScope.customer.customerName }">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">客户电话</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="customerTel" readonly="readonly" type="text" value="${requestScope.customer.customerTel }">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">*卡充值前点数</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="ptBefore" readonly="readonly" type="text" value="" name="ptBefore">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group" id="ptTradeDIV">
								<label class="control-label" for="focusedInput">*卡充值点数</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="ptTrade" type="text" value="10" name="ptTrade">
								  <span class="help-inline">录入的充值点数,不超过100的正整数</span>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="focusedInput">*卡充值后点数</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="ptAfter" readonly="readonly" type="text" value="" name="ptAfter">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="rechargeButton">体验卡卡充点</button>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/recharge.js"></script>
</body>
</html>
