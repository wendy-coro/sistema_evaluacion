<%-- 
    Document   : nuevo
    Created on : 27-ago-2019, 11:22:26
    Author     : marco
--%>

<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 List<Preguntas_Coordinador> lista= Preguntas_Coordinador.preguntac_buscartodos();
 Iterator<Preguntas_Coordinador> itPreguntas_Coordinador=lista.iterator();
%>
<%
 List<Coordinador> lista1= Coordinador.coordinador_buscartodos();
 Iterator<Coordinador> itCoordinador=lista1.iterator();
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Pregunta</title>
        
    </head>
    <body>  
        
            <form method="POST"  action="procesa_nuevo.jsp">    
                
            <select required class="form-control" placeholder="Preguntas_cid" required id="preguntas_cid"  name="preguntas_cid"> 
            <option>Preguntas</option>
            <%while(itPreguntas_Coordinador.hasNext()){
                 Preguntas_Coordinador preguntas_coordinador=itPreguntas_Coordinador.next();%> %>
                <option value="<%=preguntas_coordinador.getPreguntas_cid()%>"><%=preguntas_coordinador.getPregunta()%></option>
            <% } %>
           </select>
            <input type="number" class="form-control" placeholder="Respuesta" required id="respuesta"  name="respuesta"/> 
          <select required class="form-control" placeholder="Coordinadorid" required id="coordinadorid"   name="coordinadorid"> 
           <option>Coordinadores</option>
              <%while(itCoordinador.hasNext()){
                 Coordinador coordinador=itCoordinador.next();%> %>
                <option value="<%=coordinador.getCoordinadorid()%>"><%=coordinador.getNombre()%></option>
            <% } %>
          </select>
            
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
