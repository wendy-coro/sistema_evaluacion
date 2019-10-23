<%-- 
    Document   : editar
    Created on : 16-ago-2019, 11:49:42
    Author     : marco
--%>

<%@page import="ReglasDeNegocio.Programa"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Programa programa= new Programa();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         programa=Programa.programa_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=programa.getProgramaid()%>">
              <input type="text" required class="form-control" placeholder="Nombre Programa" id="nombre" value="<%=programa.getNombre()%>" name="nombre"/>
              <input type="text" required class="form-control" placeholder="Descripcion Programa" id="descripcion" value="<%=programa.getDescripcion()%>" name="descripcion"/>
              
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>

