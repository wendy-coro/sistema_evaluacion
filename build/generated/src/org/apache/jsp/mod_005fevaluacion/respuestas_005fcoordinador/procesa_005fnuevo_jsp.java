package org.apache.jsp.mod_005fevaluacion.respuestas_005fcoordinador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import ReglasDeNegocio.*;

public final class procesa_005fnuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    try {
            Respuestas_Coordinador respuestas_coordinador=new Respuestas_Coordinador();
            Preguntas_Coordinador preguntas_coordinador = new Preguntas_Coordinador();  
            Preguntas_Coordinador preguntas_coordinadores = preguntas_coordinador.preguntac_buscarporid(Integer.valueOf(request.getParameter("preguntas_cid")));         
            respuestas_coordinador.setPreguntas_coordinador(preguntas_coordinadores);
            respuestas_coordinador.setRespuesta(Integer.valueOf(request.getParameter("respuesta")));
            Coordinador coordinador = new Coordinador();  
            Coordinador coordinadores = coordinador.coordinador_buscarporid(Integer.valueOf(request.getParameter("coordinadorid")));         
            respuestas_coordinador.setCoordinador(coordinadores);
            boolean result= Respuestas_Coordinador.respuestac_insertar(respuestas_coordinador);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");
        } catch (Exception e) {
            out.print(e.getMessage());
        }


      out.write('\n');
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
