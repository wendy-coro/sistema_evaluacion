<%-- 
    Document   : editar
    Created on : 11/12/2019, 22:36:26
    Author     : usuario
--%>
<%@page import="ReglasDeNegocio.Archivo"%>
<%!
   Archivo archivo= new Archivo();
   %>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         archivo=Archivo.archivo_buscarporid(codigo);
        
        } catch (Exception e) {
        }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <p><center><h1><font  color="black" face=" Times New Roman"> EDITAR ARCHIVO</font></h1></center></p>
    
    </head>
    
    <body>
          <form method="POST" action="procesa_editar.jsp">
           
              
              <input type="hidden" id="codigo" name="codigo" value="<%=archivo.getId_archivo()%>"> 
              </br> 
              <font  color="black" face=" Caviar Dreams ">Documento:  </font>
              <input type="text" required class="form-control" placeholder=" Fiel " id="fiel" value="<%=archivo.getFiel()%>" name="fiel"/>
              </br> 
               <font  color="black" face="Caviar Dreams ">Tipo de Documento:</font>
              <input type="text" required class="form-control" placeholder="Tipo " id="tipo" value="<%=archivo.getTipo()%>" name="tipo"/>
              </br> 
              <font  color="black" face="Caviar Dreams ">Ruta del Documento: </font>
              <input type="text" required class="form-control" placeholder="Ruta " id="ruta" value="<%=archivo.getRuta()%>" name="ruta"/>
              </br> 
               
          <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
    </body>
</html>

