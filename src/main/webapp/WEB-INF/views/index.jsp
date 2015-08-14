<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 导入top -->
<%@include file="/common/top.jsp" %>
<html lang="zh">
<head>
	<meta charset="utf-8">
	<title>欢迎使用体验卡卡系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
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
			<div class="sortable row-fluid">
				<a data-rel="tooltip" title="总的客户数量" class="well span3 top-block" href="#">
					<span class="icon32 icon-red icon-user"></span>
					<div>客户总数</div>
					<div>${sessionScope.customer }</div>
					<!-- <span class="notification">6</span> -->
				</a>

				<a data-rel="tooltip" title="统计今天的充值次数(非点数)"  class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-star-on"></span>
					<div>今日充点次数</div>
					<div>${sessionScope.recharge }</div>
					<span class="notification green">${sessionScope.recharge }</span>
				</a>

				<a data-rel="tooltip" title="统计今天的消费次数(非点数)" class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-cart"></span>
					<div>今日消费次数</div>
					<div>${sessionScope.sale }</div>
					<span class="notification yellow">${sessionScope.sale }</span>
				</a>
				
				<a data-rel="tooltip" title="新发卡张数" class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>今日新发卡</div>
					<div>${sessionScope.hairpin }</div>
					<span class="notification red">${sessionScope.hairpin }</span>
				</a>
			</div>
<!-- 			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i> 哲理的话分享</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<h1>Charisma <small>free, premium quality, responsive, multiple skin admin template.</small></h1>
						<p>水因受阻而出声，人因挫折而成熟。</p>
						<p><b>只要内心深处存芳草 人生就有不败的春天。</b></p>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
 -->		<!-- content ends -->
			</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		<hr>
	</div><!--/.fluid-container-->

	<%@include file= "/common/footer.jsp"%>
	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- 导入js -->
	<%@include file= "/common/js.jsp"%>
</body>
</html>
