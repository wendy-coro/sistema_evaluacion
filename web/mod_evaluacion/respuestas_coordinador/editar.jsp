<%-- 
    Document   : editar
    Created on : 27-ago-2019, 10:13:28
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%
 List<Preguntas_Coordinador> lista= Preguntas_Coordinador.preguntac_buscartodos();
 Iterator<Preguntas_Coordinador> itPreguntas_Coordinador=lista.iterator();
%>
<%
 List<Coordinador> lista1= Coordinador.coordinador_buscartodos();
 Iterator<Coordinador> itCoordinador=lista1.iterator();
%>
<%!
   Respuestas_Coordinador respuestas_coordinador= new Respuestas_Coordinador();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         respuestas_coordinador = Respuestas_Coordinador.respuestac_buscarporid(codigo);                       
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Respuestas</title>
     
    </head>
    
    <body>                    
          <form method="POST" action="procesa_editar.jsp">
          <input type="hidden" id="codigo" name="codigo" value="<%=respuestas_coordinador.getRespuesta_cid()%>">         
                 
            <select required class="form-control" placeholder="Preguntas_cid" id="preguntas_cid" value="<%=respuestas_coordinador.getPreguntas_coordinador()%>"  name="preguntas_cid"> 
            <%while(itPreguntas_Coordinador.hasNext()){
                 Preguntas_Coordinador preguntas_coordinador=itPreguntas_Coordinador.next();%> %>
                <option value="<%=preguntas_coordinador.getPreguntas_cid()%>"><%=preguntas_coordinador.getPregunta()%></option>
            <% } %>
          </select>
          <input type="number" class="form-control" placeholder="Respuesta" required id="respuesta" name="respuesta"/> 
         <select required class="form-control" placeholder="Coordinadorid" id="coordinadorid" value="<%=respuestas_coordinador.getCoordinador()%>"  name="coordinadorid"> 
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
