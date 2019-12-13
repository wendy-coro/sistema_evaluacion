package org.apache.jsp.mod_005fevaluacion.Loogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ReglasDeNegocio.Estudiante;
import java.util.Iterator;
import java.util.List;

public final class procesa_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Estudiante estudiante= new Estudiante();

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
      out.write("\n");
      out.write('\n');

    
    try {        
        String cedula= request.getParameter("cedula");
        String clave1= request.getParameter("clave");

        //String claveencritada=StringEncrypter.StringEncrypter(clave1);
        //out.print("<script>alert("+claveencritada+");</script>");
        
        estudiante= Estudiante.estudiante_buscar_por_credenciales(cedula, clave1);
        
        if(estudiante!=null){
            session.setAttribute("cedula",estudiante.getCedula());
            response.sendRedirect("/Proyect_Pagina_web1/Menu/menu2.jsp");
            //out.println("<script>  location.replace('index.jsp');</script>");
            
        }else{
            out.println("<script>  location.replace('Login.jsp');</script>");
            if(request.getParameter("cerrar")!=null){
            session.invalidate();      
           
            }
        }
        } catch (Exception e) {
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
