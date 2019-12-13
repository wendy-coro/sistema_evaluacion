package org.apache.jsp.mod_005fevaluacion.respuestas_005fcoordinador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ReglasDeNegocio.Coordinador;
import ReglasDeNegocio.Respuestas_Coordinador;
import java.util.Iterator;
import java.util.List;
import ReglasDeNegocio.Preguntas_Coordinador;

public final class evaluacion_005fcoordinador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

 List<Preguntas_Coordinador> lista=Preguntas_Coordinador.preguntac_buscartodos();
 Iterator<Preguntas_Coordinador> itPregunta_Coordinador=lista.iterator();

      out.write('\n');

 List<Coordinador> lista3= Coordinador.coordinador_buscartodos();
 Iterator<Coordinador> itCoordinador=lista3.iterator();

      out.write('\n');
      out.write(' ');

java.util.Calendar ahora = java.util.Calendar.getInstance();
int hora = ahora.get(java.util.Calendar.HOUR_OF_DAY);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script> \n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Evaluacion Coordinador</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <!--Sección alerta-->\n");
      out.write("        ");

            String alerta="";
            try {
                      alerta=request.getParameter("alerta").toString();
                } catch (Exception e) {
                }
           
    if (alerta.equals("si")){
      out.write("\n");
      out.write("        <div class=\"alert alert-success\" role=\"alert\">\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("             <strong>Éxito!</strong> La transacción fue éxitosa!\n");
      out.write("        </div>\n");
      out.write("        ");
} if(alerta.equals("no")){
      out.write("\n");
      out.write("        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("             <strong>Falló!</strong> La transacción fue fallida!\n");
      out.write("        </div>\n");
      out.write("       ");
 }
      out.write("\n");
      out.write("        <!--Fin Sección alerta-->\n");
      out.write("        \n");
      out.write("      <h1 align=\"center\">Sistema de Evaluacion</h1> \n");
      out.write("      <br>\n");
      out.write("      <h2 align=\"center\">Evaluación al Coordinador</h2>\n");
      out.write("      \n");
      out.write("       <!--Saludo-->\n");
      out.write("      <p align=\"right\"> Hola, <i>\n");
      out.write("      ");
 if ((hora>20)||(hora<6)) { 
      out.write("\n");
      out.write("       Buenas Noches\n");
      out.write("       ");
 }
       else if ((hora>=6)&&(hora<=12)) { 
      out.write("\n");
      out.write("       Buenos Días\n");
      out.write("       ");
 }
        else { 
      out.write("\n");
      out.write("        Buenas Tardes\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        </i> </p>\n");
      out.write("        \n");
      out.write("        <!--Fecha-->\n");
      out.write("      <p align=\"right\"> Fecha:\n");
      out.write("       ");
      out.print( new java.util.Date() );
      out.write("\n");
      out.write("      </p>\n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("      <form method=\"POST\"  action=\"procesa_nuevo.jsp\">     \n");
      out.write("          <select required class=\"form-control\" placeholder=\"Coordinadorid\" required id=\"coordinadorid\"   name=\"coordinadorid\"> \n");
      out.write("          <option>Seleccione su Coordinador</option>\n");
      out.write("              ");
while(itCoordinador.hasNext()){
                 Coordinador coordinador=itCoordinador.next();
      out.write(" %>\n");
      out.write("                <option value=\"");
      out.print(coordinador.getCoordinadorid());
      out.write('"');
      out.write('>');
      out.print(coordinador.getNombre());
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("          </select>\n");
      out.write("         <!--Tabla para listar los datos-->\n");
      out.write("        <table id=\"example\" class=\"table table-striped table-bordered dt-responsive nowrap\" style=\"width:100%\">                <thead>\n");
      out.write("                <th>Id</th>\n");
      out.write("                <th>Preguntas</th>\n");
      out.write("                <th>Respuesta</th>                                            \n");
      out.write("                <th></th>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("            ");
while(itPregunta_Coordinador.hasNext()){
                  Preguntas_Coordinador programa=itPregunta_Coordinador.next();
      out.write("  \n");
      out.write("                <tr>\n");
      out.write("                   <td>");
      out.print( programa.getPreguntas_cid());
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( programa.getPregunta());
      out.write("</td>\n");
      out.write("                   <td><input type=\"number\" class=\"form-control\" placeholder=\"Respuesta\" required id=\"respuesta\"  name=\"respuesta\"/></td>  \n");
      out.write("                  <td> <div class=\"modal-footer\">\n");
      out.write("                   <button id=\"btn_guardar\" name=\"btn_guardar\" type=\"submit\" class=\"btn btn-primary\" >Guardar</button>\n");
      out.write("                      </div>\n");
      out.write("                  </td>\n");
      out.write("                </tr>\n");
      out.write("               ");
}
      out.write("                \n");
      out.write("                </tbody>           \n");
      out.write("            </table>\n");
      out.write("            <!--Fin tabla para listar los datos--> \n");
      out.write("        </form>\n");
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
