package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:startsWith", org.apache.taglibs.standard.functions.Functions.class, "startsWith", new Class[] {java.lang.String.class, java.lang.String.class});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getInstance();
  _jspx_fnmap_1.mapFunction("fn:startsWith", org.apache.taglibs.standard.functions.Functions.class, "startsWith", new Class[] {java.lang.String.class, java.lang.String.class});
  _jspx_fnmap_1.mapFunction("fn:endsWith", org.apache.taglibs.standard.functions.Functions.class, "endsWith", new Class[] {java.lang.String.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/common/top.jsp");
    _jspx_dependants.add("/common/css.jsp");
    _jspx_dependants.add("/common/topbar.jsp");
    _jspx_dependants.add("/common/menu.jsp");
    _jspx_dependants.add("/common/js.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!-- 导入top -->\n");
      out.write('\r');
      out.write('\n');

	String basePath = "";
	String path = request.getContextPath(); 
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("<html lang=\"zh\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title>欢迎使用体验卡卡系统</title>\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t<meta name=\"description\" content=\"Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.\">\n");
      out.write("\t<meta name=\"author\" content=\"Muhammad Usman\">\n");
      out.write("\t<!-- 导入css -->\n");
      out.write("\t");
      out.write("\t<!-- The styles -->\r\n");
      out.write("\t<link id=\"bs-css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap-cerulean.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t  body {\r\n");
      out.write("\t\tpadding-bottom: 40px;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  .sidebar-nav {\r\n");
      out.write("\t\tpadding: 9px 0;\r\n");
      out.write("\t  }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap-responsive.css\" rel=\"stylesheet\">                 \t\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/charisma-app.css\" rel=\"stylesheet\">                         \t\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/jquery-ui-1.8.21.custom.css\" rel=\"stylesheet\">              \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/fullcalendar.css' rel='stylesheet'>                         \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/fullcalendar.print.css' rel='stylesheet'  media='print'>    \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/chosen.css' rel='stylesheet'>                               \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/uniform.default.css' rel='stylesheet'>                      \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/colorbox.css' rel='stylesheet'>                             \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/jquery.cleditor.css' rel='stylesheet'>                      \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/jquery.noty.css' rel='stylesheet'>                          \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/noty_theme_default.css' rel='stylesheet'>                   \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/elfinder.min.css' rel='stylesheet'>                         \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/elfinder.theme.css' rel='stylesheet'>                       \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/jquery.iphone.toggle.css' rel='stylesheet'>                 \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/opa-icons.css' rel='stylesheet'>                            \t\r\n");
      out.write("\t<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/uploadify.css' rel='stylesheet'>      \r\n");
      out.write("\t<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("\t<!--[if lt IE 9]>\r\n");
      out.write("\t  <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t<!-- The fav icon -->\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/favicon.ico\">                      \t");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- topbar starts -->\r\n");
      out.write("\t<div class=\"navbar\">\r\n");
      out.write("\t\t<div class=\"navbar-inner\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".top-nav.nav-collapse,.sidebar-nav.nav-collapse\">\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<!-- <a class=\"brand\" href=\"index.html\"> <img alt=\"Charisma Logo\" src=\"img/logo20.png\" /> <span>Sanploy</span></a> -->\r\n");
      out.write("\t\t\t\t<a class=\"brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/index\"> <img alt=\"四川省农村信用社\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/card_image/logo.png\"/></a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- theme selector starts -->\r\n");
      out.write("\t\t\t\t<div class=\"btn-group pull-right theme-container\" >\r\n");
      out.write("\t\t\t\t\t<a class=\"btn dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-tint\"></i><span class=\"hidden-phone\"> 主题 /皮肤</span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\" id=\"themes\">\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"classic\" href=\"#\"><i class=\"icon-blank\"></i> 经典</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"cerulean\" href=\"#\"><i class=\"icon-blank\"></i> 天蓝</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"cyborg\" href=\"#\"><i class=\"icon-blank\"></i> 黑色</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"redy\" href=\"#\"><i class=\"icon-blank\"></i> 深红</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"journal\" href=\"#\"><i class=\"icon-blank\"></i> Journal</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"simplex\" href=\"#\"><i class=\"icon-blank\"></i> 简约</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"slate\" href=\"#\"><i class=\"icon-blank\"></i> 板岩</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"spacelab\" href=\"#\"><i class=\"icon-blank\"></i> 太空</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a data-value=\"united\" href=\"#\"><i class=\"icon-blank\"></i> 橙红</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>                            \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- theme selector ends -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- user dropdown starts -->\r\n");
      out.write("\t\t\t\t<div class=\"btn-group pull-right\" >\r\n");
      out.write("\t\t\t\t\t<a class=\"btn dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-user\"></i><span class=\"hidden-phone\">");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/authority/updatePasswordUI/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">个人信息维护</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login/loginOut\">注销退出</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- user dropdown ends -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- topbar ends -->\r\n");
      out.write("\t\r\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- left menu starts -->\r\n");
      out.write("<div class=\"span2 main-menu-span\">\r\n");
      out.write("\t<div class=\"well nav-collapse sidebar-nav\">\r\n");
      out.write("\t\t<ul class=\"nav nav-tabs nav-stacked main-menu\">\r\n");
      out.write("\t\t\t<li class=\"nav-header hidden-tablet\">目录菜单</li>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div><!--/.well -->\r\n");
      out.write("</div><!--/span-->\r\n");
      out.write("<!-- left menu ends -->\t\r\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<noscript>\n");
      out.write("\t\t\t\t<div class=\"alert alert-block span10\">\n");
      out.write("\t\t\t\t\t<h4 class=\"alert-heading\">亲，警告信息!</h4>\n");
      out.write("\t\t\t\t\t<p>当前浏览器不支持某些 <a href=\"http://en.wikipedia.org/wiki/JavaScript\" target=\"_blank\">JavaScript</a> 特性，您可以选择升级或开启更多的浏览器特性.</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</noscript>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div id=\"content\" class=\"span10\">\n");
      out.write("\t\t\t<!-- content starts -->\n");
      out.write("\t\t\t<div class=\"sortable row-fluid\">\n");
      out.write("\t\t\t\t<a data-rel=\"tooltip\" title=\"总的客户数量\" class=\"well span3 top-block\" href=\"#\">\n");
      out.write("\t\t\t\t\t<span class=\"icon32 icon-red icon-user\"></span>\n");
      out.write("\t\t\t\t\t<div>客户总数</div>\n");
      out.write("\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.customer }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\t\t\t\t\t<!-- <span class=\"notification\">6</span> -->\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<a data-rel=\"tooltip\" title=\"统计今天的充值次数(非点数)\"  class=\"well span3 top-block\" href=\"#\">\n");
      out.write("\t\t\t\t\t<span class=\"icon32 icon-color icon-star-on\"></span>\n");
      out.write("\t\t\t\t\t<div>今日充点次数</div>\n");
      out.write("\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.recharge }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\t\t\t\t\t<span class=\"notification green\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.recharge }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<a data-rel=\"tooltip\" title=\"统计今天的消费次数(非点数)\" class=\"well span3 top-block\" href=\"#\">\n");
      out.write("\t\t\t\t\t<span class=\"icon32 icon-color icon-cart\"></span>\n");
      out.write("\t\t\t\t\t<div>今日消费次数</div>\n");
      out.write("\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sale }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\t\t\t\t\t<span class=\"notification yellow\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sale }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<a data-rel=\"tooltip\" title=\"新发卡张数\" class=\"well span3 top-block\" href=\"#\">\n");
      out.write("\t\t\t\t\t<span class=\"icon32 icon-color icon-envelope-closed\"></span>\n");
      out.write("\t\t\t\t\t<div>今日新发卡</div>\n");
      out.write("\t\t\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.hairpin }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\t\t\t\t\t<span class=\"notification red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.hairpin }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("<!-- \t\t\t\n");
      out.write("\t\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\t\t<div class=\"box span12\">\n");
      out.write("\t\t\t\t\t<div class=\"box-header well\">\n");
      out.write("\t\t\t\t\t\t<h2><i class=\"icon-info-sign\"></i> 哲理的话分享</h2>\n");
      out.write("\t\t\t\t\t\t<div class=\"box-icon\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-minimize btn-round\"><i class=\"icon-chevron-up\"></i></a>\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-close btn-round\"><i class=\"icon-remove\"></i></a>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"box-content\">\n");
      out.write("\t\t\t\t\t\t<h1>Charisma <small>free, premium quality, responsive, multiple skin admin template.</small></h1>\n");
      out.write("\t\t\t\t\t\t<p>水因受阻而出声，人因挫折而成熟。</p>\n");
      out.write("\t\t\t\t\t\t<p><b>只要内心深处存芳草 人生就有不败的春天。</b></p>\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write(" -->\t\t<!-- content ends -->\n");
      out.write("\t\t\t</div><!--/#content.span10-->\n");
      out.write("\t\t</div><!--/fluid-row-->\n");
      out.write("\t\t<hr>\n");
      out.write("\t</div><!--/.fluid-container-->\n");
      out.write("\n");
      out.write("\t<footer>\n");
      out.write("\t\t<p class=\"pull-left\">&copy; <a href=\"http://www.sanploy.com/\" target=\"_blank\">Sanploy</a> 2015</p>\n");
      out.write("\t\t<p class=\"pull-right\">Powered by: <a href=\"http://usman.it/free-responsive-admin-template\">Charisma</a></p>\n");
      out.write("\t</footer>\n");
      out.write("\t<!-- external javascript\n");
      out.write("\t================================================== -->\n");
      out.write("\t<!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("\t<!-- 导入js -->\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- external javascript\r\n");
      out.write("\t================================================== -->\r\n");
      out.write("\t<!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- jQuery -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\t<!-- jQuery UI -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery-ui-1.8.21.custom.min.js\"></script>\r\n");
      out.write("\t<!-- transition / effect library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-transition.js\"></script>\r\n");
      out.write("\t<!-- alert enhancer library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-alert.js\"></script>\r\n");
      out.write("\t<!-- modal / dialog library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-modal.js\"></script>\r\n");
      out.write("\t<!-- custom dropdown library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-dropdown.js\"></script>\r\n");
      out.write("\t<!-- scrolspy library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-scrollspy.js\"></script>\r\n");
      out.write("\t<!-- library for creating tabs -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-tab.js\"></script>\r\n");
      out.write("\t<!-- library for advanced tooltip -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-tooltip.js\"></script>\r\n");
      out.write("\t<!-- popover effect library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-popover.js\"></script>\r\n");
      out.write("\t<!-- button enhancer library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-button.js\"></script>\r\n");
      out.write("\t<!-- accordion library (optional, not used in demo) -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-collapse.js\"></script>\r\n");
      out.write("\t<!-- carousel slideshow library (optional, not used in demo) -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-carousel.js\"></script>\r\n");
      out.write("\t<!-- autocomplete library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-typeahead.js\"></script>\r\n");
      out.write("\t<!-- tour library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap-tour.js\"></script>\r\n");
      out.write("\t<!-- library for cookie management -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.cookie.js\"></script>\r\n");
      out.write("\t<!-- calander plugin -->\r\n");
      out.write("\t<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/fullcalendar.min.js'></script>\r\n");
      out.write("\t<!-- data table plugin -->\r\n");
      out.write("\t<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.dataTables.min.js'></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- chart libraries start -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/excanvas.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.flot.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.flot.pie.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.flot.stack.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.flot.resize.min.js\"></script>\r\n");
      out.write("\t<!-- chart libraries end -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- select or dropdown enhancer -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.chosen.min.js\"></script>\r\n");
      out.write("\t<!-- checkbox, radio, and file input styler -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.uniform.min.js\"></script>\r\n");
      out.write("\t<!-- plugin for gallery image view -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.colorbox.min.js\"></script>\r\n");
      out.write("\t<!-- rich text editor library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.cleditor.min.js\"></script>\r\n");
      out.write("\t<!-- notification plugin -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.noty.js\"></script>\r\n");
      out.write("\t<!-- file manager library -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.elfinder.min.js\"></script>\r\n");
      out.write("\t<!-- star rating plugin -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.raty.min.js\"></script>\r\n");
      out.write("\t<!-- for iOS style toggle switch -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.iphone.toggle.js\"></script>\r\n");
      out.write("\t<!-- autogrowing textarea plugin -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.autogrow-textarea.js\"></script>\r\n");
      out.write("\t<!-- multiple file upload plugin -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.uploadify-3.1.min.js\"></script>\r\n");
      out.write("\t<!-- history.js for cross-browser state change on ajax -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.history.js\"></script>\r\n");
      out.write("\t<!-- application script for Charisma demo -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/charisma.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 引入日期控件 -->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 引入自定义工具类 -->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/card_js/utils.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 修改密码开始:在ie11中使用有问题 -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- 修改密码结束 -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.userName == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("当前用户名");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.functions }", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("function");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_if_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/index') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-home\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/dot') && !fn:endsWith(function.url,'Report') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-eye-open\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/customer') && !fn:endsWith(function.url,'Report') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-user\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/authority') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-certificate\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/cardRelease') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-edit\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/loss') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-edit\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/basedata') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-wrench\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/trade/comsume') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\" icon-star\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
    return false;
  }

  private boolean _jspx_meth_c_if_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/trade/recharge') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\" icon-star\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/dotReport') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-th\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
    return false;
  }

  private boolean _jspx_meth_c_if_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:startsWith(function.url,'/customerReport') }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<li><li><a class=\"ajax-link\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"><i class=\"icon-th\"></i><span class=\"hidden-tablet\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${function.functionName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span></a></li>");
        int evalDoAfterBody = _jspx_th_c_if_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
    return false;
  }
}
