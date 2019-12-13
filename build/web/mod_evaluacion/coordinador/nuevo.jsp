<%-- 
    Document   : nuevo
    Created on : 21-ago-2019, 11:11:26
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="ReglasDeNegocio.Programa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Programa> lista= Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=lista.iterator();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Coordinador</title>
        
    </head>
    <body>        
            <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombre Coordinador" required id="nombre" name="nombre"/>
            <input type="text" class="form-control" placeholder="Apellido Coordinador" required id="nombre" name="apellido"/>
            <input type="text" class="form-control" placeholder="Cedula Coordinador" required id="nombre" name="cedula"/>
            <select class="form-control" placeholder="Programaid" required id="programaid" name="programaid">  
            <option>Programa</option>
            <%while(itPrograma.hasNext()){
                Programa programa = itPrograma.next();%> %>
                <option value="<%=programa.getProgramaid()%>"><%=programa.getNombre()%></option>
            <% } %>                             
            </select>           
            <input type="text" class="form-control" placeholder="yyyy/mm/dd" required id="fecha" name="fecha"/>
            
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
