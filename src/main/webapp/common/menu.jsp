<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- left menu starts -->
<div class="span2 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">目录菜单</li>
			<c:forEach items="${sessionScope.functions }" var="function">
				<%-- <c:if test="${fn:contains(function.url,'/index') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-home"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if> --%>
				<c:if test="${fn:startsWith(function.url,'/index') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-home"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/dot') && !fn:endsWith(function.url,'Report') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-eye-open"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/customer') && !fn:endsWith(function.url,'Report') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-user"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/authority') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-certificate"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/cardRelease') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-edit"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/loss') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-edit"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/basedata') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-wrench"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/trade/comsume') }"><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class=" icon-star"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/trade/recharge') }"><li><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class=" icon-star"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/dotReport') }"><li><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-th"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
				<c:if test="${fn:startsWith(function.url,'/customerReport') }"><li><li><a class="ajax-link" href="${pageContext.request.contextPath }${function.url}"><i class="icon-th"></i><span class="hidden-tablet"> ${function.functionName}</span></a></li></c:if>
			</c:forEach>
		</ul>
	</div><!--/.well -->
</div><!--/span-->
<!-- left menu ends -->	
