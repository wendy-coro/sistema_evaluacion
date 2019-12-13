package org.apache.jsp.mod_005fevaluacion.Loogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Iniciar sesión</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css\">\n");
      out.write("    <link href=\"css/simple-sidebar.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"font.css\">\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    <div id=\"page-content-wrapper\">\n");
      out.write("       <nav>\n");
      out.write("        \n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"icon-user\"></span> Estudiantes</button>\n");
      out.write("\n");
      out.write("      </nav>\n");
      out.write("  </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div class=\"contenedor-form\">        \n");
      out.write("        <div class=\"formulario\">\n");
      out.write(" \n");
      out.write("\t\t\t\t<form role=\"form\" action=\"procesa_login.jsp\" target=\"sessionJsp\">\n");
      out.write("\t\t\t\t\t<!--span class=\"login100-form-title p-b-120\">\n");
      out.write("\t\t\t\t\t\tBienvenido\n");
      out.write("\t\t\t\t\t</span-->\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input m-t-10 m-b-35\" data-validate = \"Ingrese usuario\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"nombre\" placeholder=\"Ingrese su Usuario\" >\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"Nombre usuario\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input m-b-50\" data-validate=\"Ingrese contraseña\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"clave\" placeholder=\"Ingrese su Contraseña\" >\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"Contraseña\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <h3 align=\"center\">\n");
      out.write("                                        <button id=\"btn_guardar\" name=\"btn_guardar\" type=\"submit\" class=\"btn btn-info\">Acceder</button>\n");
      out.write("\t\t\t\t        </h3>\n");
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</form>\t\t\t\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("    <script src=\"js/jquery-3.1.1.min.js\"></script>    \n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("    \n");
      out.write("  <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- Menu Toggle Script -->\n");
      out.write("  <script>\n");
      out.write("    $(\"#menu-toggle\").click(function(e) {\n");
      out.write("      e.preventDefault();\n");
      out.write("      $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("    });\n");
      out.write("  </script>\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("</html>");
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
}
