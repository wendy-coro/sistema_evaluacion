package org.apache.jsp.mod_005fevaluacion.coordinador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import ReglasDeNegocio.Coordinador;
import java.util.ArrayList;

public final class Select_005fcoordinador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Seleccionar curso -->\n");
      out.write("        <div class=\"panel form-style-6\" style=\"float: left;max-width: 900px; padding-top: 40px;\">\n");
      out.write("            <div class=\"title\" style=\"margin-top: -60px;\">Selecione Su cordinador de Programa</div>\n");
      out.write("       <br/>\n");
      out.write("           \n");
      out.write("               <form action=\"procesa_nuevo.jsp\">\n");
      out.write("                   <br/><br>\n");
      out.write("                <label>Seleccione su Coordinador</label>\n");
      out.write("        <select name=\"coursename\" class=\"text\">\n");
      out.write("        ");
 
            List<Coordinador> lista=Coordinador.coordinador_buscartodos();
            for(int i=0;i<lista.size();i=i+2){
        
      out.write("\n");
      out.write("        <option value=\"");
      out.print(lista.get(i));
      out.write('"');
      out.write('>');
      out.print(lista.get(i));
      out.write("</option>\n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <a class=\"btn btn-danger\" href='/Sistema_Evaluacion/mod_evaluacion/respuestas_coordinador/nuevo.jsp'>Evaluar</a>\n");
      out.write("            </form>\n");
      out.write("           \n");
      out.write("         \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
}
