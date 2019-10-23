<%-- 
    Document   : nuevo
    Created on : 20-ago-2019, 13:09:46
    Author     : marco
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="ReglasDeNegocio.Programa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Programa> lista= Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=lista.iterator();
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Estudiante</title>
        
    </head>
    <body>  
        
            <form method="POST"  action="procesa_nuevo.jsp">            
            <input type="text" class="form-control" placeholder="Nombre" required id="nombre" name="nombre"/>
            <input type="text" class="form-control" placeholder="Apellido" required id="apellido" name="apellido"/>
            <input type="text" class="form-control" placeholder="Cedula" required id="cedula" name="cedula"/>         
            
            <select class="form-control" placeholder="Progamaid" required id="programaid" name="programaid">  
            <option>Programas</option>
            <%while(itPrograma.hasNext()){
                Programa programa = itPrograma.next();%> %>
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
