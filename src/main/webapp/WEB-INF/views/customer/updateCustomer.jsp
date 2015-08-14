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

			<!-- form：增加一个网点 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 编辑客户信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form:form id="customerFrom" action="${pageContext.request.contextPath }/customer/updateCustomer" cssClass="form-horizontal" method="post" modelAttribute="customer" name="customer">
							<fieldset>
							  <div class="control-group" id="bankCardNoDIV">
								<label class="control-label" for="focusedInput">*银行卡号</label>
								<div class="controls">
								  <input type="text" class="input-xlarge disabled" readonly="readonly" value="${customer.bankCardNo }" name="bankCardNo">
								  <span class="help-inline"></span>
								  <input type="hidden" name="_method" value="PUT"/>
								</div>
							  </div>
							  <div class="control-group" id="vipCardNoDIV">
								<label class="control-label" for="focusedInput">*体验卡卡号</label>
								<div class="controls">
								  <%-- <form:input cssClass="input-xlarge focused" path="cardNo" readonly="readonly"/> --%>
								  <input type="text" class="input-xlarge focused" id="vipCardNo" name="cardNo" value="${customer.cardNo }" readonly="readonly">
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="readCardNo">读取卡信息</button>
								</div>
							  </div>
							  <div class="control-group" id="bankCardTypeIdDIV">
							  	 <label class="control-label" for="focusedInput">*银行卡类型</label>
								 <div class="controls">
							  	  	<form:select path="bankCardType.bankCardTypeId" id="selectError" >
										<form:option value="-----请选择一种银行卡类型-----"></form:option>
										<form:options items="${bankCardTypes }" itemValue="bankCardTypeId" itemLabel="name"/>
							  	  	</form:select>
								 </div>
							  </div>
							  <div class="control-group" id="customerNameDIV">
								<label class="control-label" for="focusedInput">*客户姓名</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="customerName" id="customerName"/>
								  <span class="help-inline"></span>
								</div>
							  </div>
							  <div class="control-group" id="customerTelDIV">
								<label class="control-label" for="focusedInput">*客户电话</label>
								<div class="controls">
								  <form:input cssClass="input-xlarge focused" path="customerTel" id="customerTel"/>
								  <span class="help-inline" id="customerTelSPAN">电话格式,不带区号...</span>
								</div>
							  </div>
							  <div class="control-group" id="invalidDIV">
								<label class="control-label" for="focusedInput">失效时间</label>
								<div class="controls">
								  <input type="text" class="input-xlarge focused" id="invalid" name="invalid" value='<fmt:formatDate value="${customer.invalid }" pattern="yyyy-MM-dd"/>' onclick="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd',doubleCalendar:true,minDate:'%y-%M-%d',readOnly:true})" >
								  <span class="help-inline" id="invalidSPAN">格式为：2015-01-01;只能选择大于今天的日期</span>
								</div>
							  </div>
							  <div class="control-group" id="hairpinDotDIV">
									<label class="control-label">*发卡地区</label>
									<div class="controls">
									  <select name="hairpinDot">
									  		<option value="-1">-----请选择发卡区域-----</option>
									  		<option value="达川区" <c:if test="${customer.hairpinDot eq '达川区' }">selected="selected"</c:if> >达川区</option>
									  		<option value="通川区" <c:if test="${customer.hairpinDot eq '通川区' }">selected="selected"</c:if> >通川区</option>
									  		<option value="西区支行" <c:if test="${customer.hairpinDot eq '西区支行' }">selected="selected"</c:if> >西区支行</option>
									  		<option value="经开区支行" <c:if test="${customer.hairpinDot eq '经开区支行' }">selected="selected"</c:if> >经开区支行</option>
									  		<option value="开江" <c:if test="${customer.hairpinDot eq '开江' }">selected="selected"</c:if> >开江</option>
									  		<option value="大竹" <c:if test="${customer.hairpinDot eq '大竹' }">selected="selected"</c:if> >大竹</option>
									  		<option value="宣汉" <c:if test="${customer.hairpinDot eq '宣汉' }">selected="selected"</c:if> >宣汉</option>
									  		<option value="渠县" <c:if test="${customer.hairpinDot eq '渠县' }">selected="selected"</c:if> >渠县</option>
									  		<option value="万源" <c:if test="${customer.hairpinDot eq '万源' }">selected="selected"</c:if> >万源</option>
									  </select>
									</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="save">修改客户信息</button>
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
	<!-- 发布读写卡js工具类 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/customer.js" defer="defer"></script>
</body>
</html>
