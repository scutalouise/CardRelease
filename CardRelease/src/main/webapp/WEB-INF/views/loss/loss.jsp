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
<base href="<%=basePath%>">		
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
			
			<!-- 挂失操作开始 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 挂失</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" name="lossForm">
							<fieldset>
							  <div class="control-group warning"  id="lossCardNoDIV" >
								<label class="control-label" >将要挂失的卡号</label>
								<div class="controls">
								  <input type="text" id="lossCardNo">
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="lossReadCardNo">读取挂失卡</button>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="loss">挂    失</button>
							  </div>
							</fieldset>
						</form>
					</div>
				</div>
			</div><!--/row-->
			<!-- 挂失操作结束 -->
			
			<!-- 解挂操作开始 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 挂失卡解挂</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" name="cancelLossForm">
							<fieldset>
							  <div class="control-group warning" id="cancelLossReadCardNoDIV">
								<label class="control-label" for="inputWarning">需要解挂的卡号</label>
								<div class="controls">
								  <input id="cancelLossCardNo" type="text" >
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="cancelLossReadCardNo">读取卡信息</button>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="cancelLoss">体验卡解挂失</button>
							  </div>
							</fieldset>
						</form>
					</div>
				</div>
			</div><!--/row-->
			<!-- 解挂操作结束 -->
			
			<!-- 补卡操作开始 -->
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 体验卡补卡</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" name="reReleaseForm">
							<fieldset>
							  <div class="control-group warning" id="reReleaseReadOldCardNoDIV">
								<label class="control-label" for="inputWarning">*已挂失的卡号</label>
								<div class="controls">
								  <input id="reReleaseOldCardNo" type="text" >
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="reReleaseReadOldCardNo">读已挂失卡信息</button>
								</div>
							  </div>
							  <div class="control-group warning" id="reReleaseReadNewCardNoDIV">
								<label class="control-label" for="inputWarning">*新体验卡卡号</label>
								<div class="controls">
								  <input id="reReleaseNewCardNo" type="text" value="">
								  <span class="help-inline"></span>
								  <button type="button" class="btn btn-primary" id="reReleaseReadNewCardNo">读新体验卡信息</button>
								</div>
							  </div>
							  <div class="form-actions">
								<button type="button" class="btn btn-primary" id="reRelease">补发体验卡</button>
								<span class="help-inline"></span>
							  </div>
							</fieldset>
						</form>
					</div>
				</div>
			</div><!--/row-->
			<!-- 补卡操作结束 -->
			
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
	<!-- 发布卡js工具类 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/loss.js" defer="defer"></script>
</body>
</html>
