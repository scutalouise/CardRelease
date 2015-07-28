<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<!-- <a class="brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" /> <span>Sanploy</span></a> -->
				<a class="brand" href="${pageContext.request.contextPath}/index"> <img alt="四川省农村信用社" src="${pageContext.request.contextPath }/card_image/logo.png"/></a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> 主题 /皮肤</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> 经典</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i> 天蓝</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> 黑色</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> 深红</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> 简约</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> 板岩</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> 太空</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> 橙红</a></li>
					</ul>                            
				</div>
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"><c:if test="${sessionScope.user.userName == null}">当前用户名</c:if> ${sessionScope.user.userName }</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/authority/updatePasswordUI/${sessionScope.user.userId}">个人信息维护</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath }/login/loginOut">注销退出</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	
