<%-- 
    Document   : editar
    Created on : 21-ago-2019, 13:08:32
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%
 List<Programa> listap= Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=listap.iterator();
%>

<%!
   Coordinador coordinador= new Coordinador();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         coordinador = Coordinador.coordinador_buscarporid(codigo);                       
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Coordinador</title>
     
    </head>
    
    <body>                    
          <form method="POST" action="procesa_editar.jsp">
          <input type="hidden" id="codigo" name="codigo" value="<%=coordinador.getCoordinadorid()%>">         
           <input type="text" class="form-control" placeholder="Nombre" required id="nombre" name="nombre"/>
            <input type="text" class="form-control" placeholder="Apellido" required id="apellido" name="apellido"/>
            <input type="text" class="form-control" placeholder="Cedula" required id="cedula" name="cedula"/>        
                 
                
            <select required class="form-control" placeholder="Programaid" id="programaid" value="<%=coordinador.getPrograma()%>"  name="programaid"> 
            <%while(itPrograma.hasNext()){
                Programa programa=itPrograma.next();%> %>
                <option value="<%=programa.getProgramaid()%>"><%=programa.getNombre()%></option>
            <% } %>
          </select>
           <input type="text" class="form-control" placeholder="Fecha" required id="fecha" name="fecha"/> 
         
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>