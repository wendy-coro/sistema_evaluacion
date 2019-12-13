package org.apache.jsp.mod_005fevaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import ReglasDeNegocio.Programa;

public final class buscar_005fprograma_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 List<Programa> lista=Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=lista.iterator();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script> \n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Programas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <table id=\"example\" class=\"table table-striped table-bordered dt-responsive nowrap\" style=\"width:100%\">\n");
      out.write("               \n");
      out.write("               <thead>\n");
      out.write("                <th>Id</th>\n");
      out.write("                <th>Nombre Programa</th>\n");
      out.write("                <th>Descripcion</th>\n");
      out.write("                <th></th>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("               ");
while(itPrograma.hasNext()){
                  Programa programa=itPrograma.next();
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                   <td>");
      out.print( programa.getProgramaid());
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( programa.getNombre());
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( programa.getDescripcion());
      out.write("</td>\n");
      out.write("                   <td>\n");
      out.write("                         <a class=\"btn btn-danger\" href='procesa_eliminar.jsp?codigo=");
      out.print( programa.getProgramaid());
      out.write("' onclick=\"return confirm('¿Está seguro que desea eliminar este registro?');\">Eliminar</a>\n");
      out.write("                         <button type=\"button\"  onclick=\"return modaleditar(");
      out.print( programa.getProgramaid());
      out.write(")\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#ModalEditar\">Editar</button>  \n");
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                </tr>\n");
      out.write("               ");
}
      out.write("                \n");
      out.write("                </tbody>           \n");
      out.write("            </table>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("                \n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/buttons/1.5.2/js/buttons.bootstrap4.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap4.min.js\"></script>\n");
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
