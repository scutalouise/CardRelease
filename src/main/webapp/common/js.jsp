<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="${pageContext.request.contextPath }/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="${pageContext.request.contextPath }/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="${pageContext.request.contextPath }/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='${pageContext.request.contextPath }/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='${pageContext.request.contextPath }/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="${pageContext.request.contextPath }/js/excanvas.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.pie.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.stack.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="${pageContext.request.contextPath }/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="${pageContext.request.contextPath }/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="${pageContext.request.contextPath }/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="${pageContext.request.contextPath }/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="${pageContext.request.contextPath }/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="${pageContext.request.contextPath }/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="${pageContext.request.contextPath }/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="${pageContext.request.contextPath }/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="${pageContext.request.contextPath }/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="${pageContext.request.contextPath }/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="${pageContext.request.contextPath }/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="${pageContext.request.contextPath }/js/charisma.js"></script>
	
	
	<!-- 引入日期控件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
	
	<!-- 引入自定义工具类 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/utils.js"></script>
	
	
	<!-- 修改密码开始:在ie11中使用有问题 -->
<%-- 	<form:form action="${pageContext.request.contextPath }/authority/updatePassword" method="post" modelAttribute="user" >
	<div class="modal hide fade" id="myModal" style="display: block; width:460px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">X</button>
			<h3>个人信息维护</h3>
		</div>
		<div class="modal-body" style="line-height:28px;">
			<div class="control-group">
				<label class="control-label" for="focusedInput">*当前密码</label>
				<div class="control-group">
				  <input class="input-xlarge focused" id="focusedInput" type="password" value="" style="height:28px;">
				  <span class="help-inline">6到20位</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="focusedInput">*新密码</label>
				<div class="control-group">
				  <input class="input-xlarge focused" id="focusedInput" type="password" value="" name="password" style="height:28px;">
				  <span class="help-inline">6到20位</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="focusedInput">*重复新密码</label>
				<div class="control-group">
				  <input class="input-xlarge focused" id="focusedInput" type="password" value="" style="height:28px;">
				  <span class="help-inline">6到20位</span>
				</div>
			</div>
		</div>
		<div class="modal-footer" style="text-align:left">
			<a href="#" class="btn btn-primary">保存设置</a>
			<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
		</div>
	</div>
	</form:form> --%>
	<!-- 修改密码结束 -->
	
	

	
	
	