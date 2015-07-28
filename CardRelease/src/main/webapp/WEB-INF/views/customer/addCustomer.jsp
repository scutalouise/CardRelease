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
			<!-- form：增加一个客户 ：开始-->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 新增一个客户</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form action="${pageContext.request.contextPath }/customer/addCustomer" cssClass="form-horizontal" method="post" modelAttribute="customer" id="customerFrom">
							<fieldset>
							  <div class="control-group" id="bankCardNoDIV">
								<label class="control-label" for="focusedInput">*银行卡号</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="bankCardNo" type="text" value="" name="bankCardNo">
								  <span class="help-inline">不超过30位的整数编码...</span>
								</div>
							  </div>
							  <div class="control-group" id="vipCardNoDIV">
								<label class="control-label" for="focusedInput">*体验卡卡号</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="vipCardNo" type="text" value="" name="cardNo" >
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="readCardNo">读取卡信息</button>
								</div>
							  </div>
							  <div class="control-group" id="bankCardTypeIdDIV">
									<label class="control-label" for="selectError3">*银行卡类型</label>
									<div class="controls">
									  <select id="selectError3" name="bankCardType.bankCardTypeId">
									  		<option>-----请选择一种银行卡类型-----</option>
									  	<c:forEach items="${requestScope.bankCardTypes }" var="bankCardType">
									  		<option value="${bankCardType.bankCardTypeId }">${bankCardType.name }</option>
									  	</c:forEach>
									  </select>
									</div>
							  </div>
							  <div class="control-group" id="customerNameDIV">
								<label class="control-label" for="focusedInput">*客户姓名</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="customerName" type="text" value="" name="customerName">
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group" id="customerTelDIV">
								<label class="control-label" for="focusedInput">*客户电话</label>
								<div class="controls">
								  <input class="input-xlarge focused" type="text" value="" name="customerTel" id="customerTel">
								  <span class="help-inline" id="customerTelSPAN">电话格式,不带区号...</span>
								</div>
							  </div>
							  <div class="control-group" id="originalPtDIV">
								<label class="control-label" for="focusedInput">*原始点数</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="originalPt" type="text" value="" name="originalPt">
								  <span class="help-inline" id="originalPtSPAN">不超过100的正整数...</span>
								</div>
							  </div>
							  <div class="control-group" id="invalidDIV">
								<label class="control-label" for="focusedInput">*失效时间</label>
								<div class="controls">
								  <input type="text" id="invalid" class="input-xlarge focused" name="invalid"  onclick="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd',doubleCalendar:true,minDate:'{%y+5}-%M-%d',readOnly:true})" >
								  <span class="help-inline">格式为：2015-01-01;默认时间为5年以后；</span>
								</div>
							  </div>
							  <div class="control-group" id="hairpinDotDIV">
									<label class="control-label">*发卡地区</label>
									<div class="controls">
									  <select name="hairpinDot">
									  		<option value="-1">请选择发卡区域</option>
									  		<option value="达川区">达川区</option>
									  		<option value="通川区">通川区</option>
									  		<option value="西区支行">西区支行</option>
									  		<option value="经开区支行">经开区支行</option>
									  		<option value="开江">开江</option>
									  		<option value="大竹">大竹</option>
									  		<option value="宣汉">宣汉</option>
									  		<option value="渠县">渠县</option>
									  		<option value="万源">万源</option>
									  </select>
									</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="save">保存客户信息</button>
								<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
							  </div>
							</fieldset>
						  </form:form>
					</div>
				</div><!--/span-->
			</div><!--/row-->
			<!-- form：增加一个客户：结束 -->
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
	<!-- 发布读写卡js工具类 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/customer.js"></script>
</body>
</html>
