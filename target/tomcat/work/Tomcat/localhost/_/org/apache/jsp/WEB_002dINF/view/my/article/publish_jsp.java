/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-10-12 00:11:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.my.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class publish_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');

request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>文章发布</title>\r\n");
      out.write("<script>\r\n");
      out.write("\t\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\t\twindow.editor1 = K.create('textarea[name=\"content1\"]', {\r\n");
      out.write("\t\t\t\tcssPath : '/resource/kindeditor/plugins/code/prettify.css',\r\n");
      out.write("\t\t\t\tuploadJson : '/resource/kindeditor/jsp/upload_json.jsp',\r\n");
      out.write("\t\t\t\tfileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',\r\n");
      out.write("\t\t\t\tallowFileManager : true,\r\n");
      out.write("\t\t\t\tafterCreate : function() {\r\n");
      out.write("\t\t\t\t\tvar self = this;\r\n");
      out.write("\t\t\t\t\tK.ctrl(document, 13, function() {\r\n");
      out.write("\t\t\t\t\t\tself.sync();\r\n");
      out.write("\t\t\t\t\t\tdocument.forms['example'].submit();\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tK.ctrl(self.edit.doc, 13, function() {\r\n");
      out.write("\t\t\t\t\t\tself.sync();\r\n");
      out.write("\t\t\t\t\t\tdocument.forms['example'].submit();\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tprettyPrint();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction query(){\r\n");
      out.write("\t\talert(editor1.html())\r\n");
      out.write("\t\t\t//alert( $(\"[name='content1']\").attr(\"src\"))\r\n");
      out.write("\t\t} \r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"\" id=\"form\">\r\n");
      out.write("\t\t<div class=\"form-group row \">\r\n");
      out.write("\t\t\t<label for=\"title\">文章标题</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"title\" name=\"title\" placeholder=\"请输入标题\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-group row \">\r\n");
      out.write("\t\t\t<textarea name=\"content1\" cols=\"100\" rows=\"8\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 860px; height: 250px; visibility: hidden;\">");
      out.print(htmlspecialchars(htmlData));
      out.write("</textarea>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group row \">\r\n");
      out.write("\t\t\t<label for=\"title\">文章标题图片</label> <input type=\"file\"\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"file\" name=\"file\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group row \">\r\n");
      out.write("\t\t  \t<label for=\"channel\">文章栏目</label> \r\n");
      out.write("\t\t\t<select class=\"custom-select custom-select-sm mb-3\" id=\"channel\"  name=\"channelId\">\r\n");
      out.write("\t\t\t  <option></option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<label for=\"category\">文章分类</label> \r\n");
      out.write("\t\t\t<select class=\"custom-select custom-select-sm mb-3\" id=\"category\" name=\"categoryId\">\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group row\" >\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-success\" onclick=\"publish()\">发布</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//发布文章\r\n");
      out.write("function publish(){\r\n");
      out.write("\t//alert(editor1.html())\r\n");
      out.write("\t\r\n");
      out.write("\t\t//序列化表单数据带文件\r\n");
      out.write("\t\t var formData = new FormData($( \"#form\" )[0]);\r\n");
      out.write("\t\t//改变formData的值\r\n");
      out.write("\t\t//editor1.html() 是富文本的内容\r\n");
      out.write("\t\t formData.set(\"content\",editor1.html());\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\tdata:formData,\r\n");
      out.write("\t\t\t// 告诉jQuery不要去处理发送的数据\r\n");
      out.write("\t\t\tprocessData : false,\r\n");
      out.write("\t\t\t// 告诉jQuery不要去设置Content-Type请求头\r\n");
      out.write("\t\t\tcontentType : false,\r\n");
      out.write("\t\t\turl:\"/article/publish\",\r\n");
      out.write("\t\t\tsuccess:function(obj){\r\n");
      out.write("\t\t\t\tif(obj){\r\n");
      out.write("\t\t\t\t\talert(\"发布成功1111!\")\r\n");
      out.write("\t\t\t\t\t$('#center').load(\"/article/listMyArticle\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"发布失败\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\r\n");
      out.write("/* \t\r\n");
      out.write("\t$.post(\"/article/publish\",$(\"form\").serialize()+\"&content=\"+editor1.html(),function(obj){\r\n");
      out.write("\t\tif(obj)\r\n");
      out.write("\t\talert(\"发布成功\");\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\talert(\"发布失败\")\r\n");
      out.write("\t}) */\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//自动加载文章的栏目\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"/article/getAllChn\",\r\n");
      out.write("\t\tsuccess:function(list){\r\n");
      out.write("\t\t\t$(\"#channel\").empty();\r\n");
      out.write("\t\t\tfor(var i in list){\r\n");
      out.write("\t\t\t\t$(\"#channel\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t//为栏目添加绑定事件\r\n");
      out.write("\t$(\"#channel\").change(function(){\r\n");
      out.write("\t\t //先清空原有的栏目下的分类\r\n");
      out.write("\t\t $(\"#category\").empty();\r\n");
      out.write("\tvar cid =$(this).val();//获取当前的下拉框的id\r\n");
      out.write("\t//根据ID 获取栏目下的分类\r\n");
      out.write("\t $.get(\"/article/getCatsByChn\",{channelId:cid},function(list){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t for(var i in list){\r\n");
      out.write("\t\t  $(\"#category\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t \r\n");
      out.write("\t })\r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
