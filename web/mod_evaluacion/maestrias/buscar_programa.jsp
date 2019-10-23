<%-- 
    Document   : buscar_programa
    Created on : 27-ago-2019, 14:47:00
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ReglasDeNegocio.Programa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Programa> lista=Programa.programa_buscartodos();
 Iterator<Programa> itPrograma=lista.iterator();
%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js"></script>
        
        <title>Programas</title>
    </head>
    <body>
        <h1>Ingrese al programa que pertenece</h1> 
         <table id="example" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
               
               <thead>
                <th>Id</th>
                <th>Nombre Programa</th>
                <th>Descripcion</th>
                <th></th>
                </thead>
                <tbody>
               <%while(itPrograma.hasNext()){
                  Programa programa=itPrograma.next();%>
                <tr>
                   <td><%= programa.getProgramaid()%></td>
                   <td><%= programa.getNombre()%></td>
                   <td><%= programa.getDescripcion()%></td>
                   
                   <td>
                         <a href="/Sistema_Evaluacion/mod_evaluacion/coordinador/listar.jsp"><span class="icon-user"></span>Inicio</a> 
                   </td>
                </tr>
               <%}%>                
                </tbody>           
            </table>
                
            
             
    </body>
</html>
