<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入top -->
<%@include file="/common/top.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<style>
/*<link href='http://fonts.googleapis.com/css?family=Creepster|Audiowide' rel='stylesheet' type='text/css'>*/
/* latin-ext */
@font-face {
	font-family: 'Audiowide';
	font-style: normal;
	font-weight: 400;
	src: local('Audiowide'), local('Audiowide-Regular'),
		url(http://fonts.gstatic.com/s/audiowide/v4/7pSgz2MbVvTCvvm7vukSHxJtnKITppOI_IvcXXDNrsc.woff2)
		format('woff2');
	unicode-range: U+0100-024F, U+1E00-1EFF, U+20A0-20AB, U+20AD-20CF,
		U+2C60-2C7F, U+A720-A7FF;
}
/* latin */
@font-face {
	font-family: 'Audiowide';
	font-style: normal;
	font-weight: 400;
	src: local('Audiowide'), local('Audiowide-Regular'),
		url(http://fonts.gstatic.com/s/audiowide/v4/8XtYtNKEyyZh481XVWfVOltXRa8TVwTICgirnJhmVJw.woff2)
		format('woff2');
	unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC,
		U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;
}
/* latin */
@font-face {
	font-family: 'Creepster';
	font-style: normal;
	font-weight: 400;
	src: local('Creepster'), local('Creepster-Regular'),
		url(http://fonts.gstatic.com/s/creepster/v5/un014as1qOcrVg1hrkn_UVtXRa8TVwTICgirnJhmVJw.woff2)
		format('woff2');
	unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC,
		U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;
}

* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Audiowide', cursive, arial, helvetica, sans-serif;
	background: url(${pageContext.request.contextPath}/img/error_bg.png) repeat;
	background-color: #212121;
	color: white;
	font-size: 18px;
	padding-bottom: 20px;
}

.error-code {
	font-family: 'Creepster', cursive, arial, helvetica, sans-serif;
	font-size: 200px;
	color: white;
	color: rgba(255, 255, 255, 0.98);
	width: 50%;
	text-align: right;
	margin-top: 5%;
	text-shadow: 5px 5px hsl(0, 0%, 25%);
	float: left;
}

.not-found {
	width: 47%;
	float: right;
	margin-top: 5%;
	font-size: 50px;
	color: white;
	text-shadow: 2px 2px 5px hsl(0, 0%, 61%);
	padding-top: 70px;
}

.clear {
	float: none;
	clear: both;
}

.content {
	text-align: center;
	line-height: 30px;
}

input[type=text] {
	border: hsl(247, 89%, 72%) solid 1px;
	outline: none;
	padding: 5px 3px;
	font-size: 16px;
	border-radius: 8px;
}

a {
	text-decoration: none;
	color: #9ECDFF;
	text-shadow: 0px 0px 2px white;
}

a:hover {
	color: white;
}
</style>
<title>Error</title>
</head>
<body>

	<p class="error-code">${errorCode }</p>
	<!-- 
	<p class="not-found">
		Not<br />Found
	</p>
	 -->
	<div class="clear"></div>
	<div class="content">${exception }<br />
		<a href="${pageContext.request.contextPath }/login.jsp">回到登录页面...</a> <br />
	</div>
</body>
</html>
