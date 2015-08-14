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
				<!-- form：增加一个卡类型限制开始 -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-edit"></i> 新增一种卡类型</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath }/basedata/addBankCardType" method="post" modelAttribute="bankCardType" name="bankCardType">
								<fieldset>
								  <div class="control-group" id="bankCardTypeIdDIV">
									<label class="control-label" for="focusedInput">银行卡类型编号</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="bankCardTypeId" type="text" value="" name="bankCardTypeId">
									  <span class="help-inline">2位数的编码，不能重复...</span>
									</div>
								  </div>
								  <div class="control-group" id="nameDIV">
									<label class="control-label" for="focusedInput">*卡类型名称</label>
									<div class="controls">
									  <input class="input-xlarge focused" id="name" type="text" value="" name="name">
									  <span class="help-inline"></span>
									</div>
								  </div>
								  <div class="form-actions">
									<button type="button" class="btn btn-primary" id="save">保存卡类型</button>
									<span class="help-inline" style="margin-left:5%;">${requestScope.message}</span>
								  </div>
								</fieldset>
							  </form:form>
						</div>
					</div><!--/span-->
				</div><!--/row-->
				<!-- form：增加一个卡类型限制结束 -->
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
<script type="text/javascript">
 /* 以下为验证信息 */
 var isBankCardTypeIdReady = false;
 var isNameReady = false;

 $("#bankCardTypeId").focusout(function(){
	var bankCardTypeId =  $("#bankCardTypeId").val();
	if(intFixedLength(bankCardTypeId,2,2)){
		$("#bankCardTypeIdDIV").attr("class","control-group success");isBankCardTypeIdReady = true;
		$.ajax({
            url:getProjectName() + "/basedata/isBankCardTypeIdExist" ,
            data:{bankCardTypeId:$("#bankCardTypeIdDIV div input").val()},
            type:"POST",
            success:(function(data,status) {
            			if(data["result"] == "failed"){
            				$(".form-actions button").show();
            				$("#bankCardTypeIdDIV div span").text(data["info"]);
            				$("#bankCardTypeIdDIV").attr("class","control-group success");
            			}else if(data["result"] == "success"){
            				$(".form-actions button").hide();
            				$("#bankCardTypeIdDIV div span").text(data["info"]);
            				$("#bankCardTypeIdDIV").attr("class","control-group error");     		        
            			}
                    })
        });	
	}else{
		$("#bankCardTypeIdDIV").attr("class","control-group error");isBankCardTypeIdReady = false;
	}
 });
 $("#name").blur(function(){
	 var name =  $("#name").val();
	 if(!isNull(name) && name.length < 25){
		$("#nameDIV").attr("class","control-group success");isNameReady = true;
	 }else{
		 $("#nameDIV").attr("class","control-group error");isNameReady = false;
	 }
 });
 
 $("#save").click(function(){
		if(isBankCardTypeIdReady && isNameReady){
			$("form[name='bankCardType']").submit();
		}else{
			return false;		
		}
	});
 </script>
</body>
</html>
