package org.apache.jsp.mod_005fevaluacion.coordinador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import ReglasDeNegocio.Programa;
import java.util.List;

public final class mostrar_005fcoordinador_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 List<Programa> lista= Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=lista.iterator();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Buscar Coordinador</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("            <form method=\"POST\"  action=\"listar_coordinador.jsp\">\n");
      out.write("            <select class=\"form-control\" placeholder=\"Programaid\" required id=\"programaid\" name=\"programaid\">  \n");
      out.write("            <option>Programa</option>\n");
      out.write("            ");
while(itPrograma.hasNext()){
                Programa programa = itPrograma.next();
      out.write(" %>\n");
      out.write("                <option value=\"");
      out.print(programa.getProgramaid());
      out.write('"');
      out.write('>');
      out.print(programa.getNombre());
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("                             \n");
      out.write("            </select>           \n");
      out.write("            <input type=\"text\" class=\"form-control\" placeholder=\"Fecha\" required id=\"fecha\" name=\"fecha\"/>\n");
      out.write("          \n");
      out.write("             <div class=\"modal-footer\">\n");
      out.write("                <button id=\"btn_guardar\" name=\"btn_guardar\" type=\"submit\" class=\"btn btn-primary\" >Guardar</button>\n");
      out.write("                 <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("          \n");
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
