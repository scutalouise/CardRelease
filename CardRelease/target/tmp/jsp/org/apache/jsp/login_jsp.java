package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/common/top.jsp");
    _jspx_dependants.add("/common/css.jsp");
    _jspx_dependants.add("/common/js.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zh\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title>欢迎使用体验卡卡系统</title>\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t<meta name=\"description\" content=\"Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.\">\n");
      out.write("\t<meta name=\"author\" content=\"Muhammad Usman\">\n");
      out.write("\n");
      out.write("\t<!-- The styles -->\n");
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
      out.write("\n");
      out.write("<body>\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\t\t<div class=\"span12 center login-header\">\n");
      out.write("\t\t\t\t\t<h2>欢迎您使用体验卡 CardSystem</h2>\n");
      out.write("\t\t\t\t</div><!--/span-->\n");
      out.write("\t\t\t</div><!--/row-->\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\t\t<div class=\"well span5 center login-box\">\n");
      out.write("\t\t\t\t\t<div class=\"alert alert-info\">\n");
      out.write("\t\t\t\t\t\t请使用用户名和密码登录.\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<form class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login\" method=\"post\" name=\"login\">\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-prepend\" title=\"登录名\" data-rel=\"tooltip\" id=\"usernameDIV\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-user\"></i></span><input autofocus class=\"input-large span10\" name=\"loginName\" id=\"username\" type=\"text\" value=\"admin\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-prepend\" title=\"密码\" data-rel=\"tooltip\" id=\"passwordDIV\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-lock\"></i></span><input class=\"input-large span10\" name=\"password\" id=\"password\" type=\"password\" value=\"admin123456\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t\t<!-- \n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-prepend\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"remember\" for=\"remember\"><input type=\"checkbox\" id=\"remember\" name=\"remember\" value=\"1\"/>请记住我</label>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t -->\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<p class=\"center span5\">\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"save\">登录</button>\n");
      out.write("\t\t\t\t\t\t\t<span class=\"help-inline\" style=\"margin-left:5%;\">\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div><!--/span-->\n");
      out.write("\t\t\t</div><!--/row-->\n");
      out.write("\t\t\t\t</div><!--/fluid-row-->\n");
      out.write("\t\t\n");
      out.write("\t</div><!--/.fluid-container-->\n");
      out.write("\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("var isUsernaemReady = true;\n");
      out.write("var isPasswordReady = true;\n");
      out.write("$(\"#username\").blur(function(){\n");
      out.write("\tvar username = $(\"#username\").val();\n");
      out.write("\tif(isNull(username)){\n");
      out.write("\t\t$(\"#username\").css({\"color\":\"#b94a48\",\"border-color\": \"#b94a48\"});\n");
      out.write("\t\t$(\"#usernameDIV span\").css({\"color\":\"#b94a48\",\"border-color\": \"#b94a48\"});isUsernaemReady = false;\n");
      out.write("\t}else{\n");
      out.write("\t\t$(\"#username\").css({\"color\":\"#468847\",\"border-color\": \"#468847\"});\n");
      out.write("\t\t$(\"#usernameDIV span\").css({\"color\":\"#468847\",\"border-color\": \"#468847\"});isUsernaemReady = true;\n");
      out.write("\t}\n");
      out.write("});\n");
      out.write("$(\"#password\").blur(function(){\n");
      out.write("\tvar password = $(\"#password\").val();\n");
      out.write("\tif(isNull(password)){\n");
      out.write("\t\t$(\"#password\").css({\"color\":\"#b94a48\",\"border-color\": \"#b94a48\"});\n");
      out.write("\t\t$(\"#passwordDIV span\").css({\"color\":\"#b94a48\",\"border-color\": \"#b94a48\"});isPasswordReady = false;\n");
      out.write("\t}else{\n");
      out.write("\t\t$(\"#password\").css({\"color\":\"#468847\",\"border-color\": \"#468847\"});\n");
      out.write("\t\t$(\"#passwordDIV span\").css({\"color\":\"#468847\",\"border-color\": \"#468847\"});isPasswordReady = true;\n");
      out.write("\t}\n");
      out.write("});\n");
      out.write("$(\"#save\").click(function(){\n");
      out.write("\tif(isUsernaemReady && isPasswordReady){\n");
      out.write("\t\t$(\"form[name='login']\").submit();\n");
      out.write("\t}else{\n");
      out.write("\t\treturn false;\t\t\n");
      out.write("\t}\n");
      out.write("});\n");
      out.write("\n");
      out.write("</script>\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.message != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
}
