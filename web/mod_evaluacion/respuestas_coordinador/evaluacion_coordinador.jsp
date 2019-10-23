<%-- 
    Document   : evaluacion_coordinador
    Created on : 10-sep-2019, 9:25:53
    Author     : marco
--%>

<%@page import="ReglasDeNegocio.Coordinador"%>
<%@page import="ReglasDeNegocio.Respuestas_Coordinador"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ReglasDeNegocio.Preguntas_Coordinador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Preguntas_Coordinador> lista=Preguntas_Coordinador.preguntac_buscartodos();
 Iterator<Preguntas_Coordinador> itPregunta_Coordinador=lista.iterator();
%>
<%
 List<Coordinador> lista3= Coordinador.coordinador_buscartodos();
 Iterator<Coordinador> itCoordinador=lista3.iterator();
%>
 <%
java.util.Calendar ahora = java.util.Calendar.getInstance();
int hora = ahora.get(java.util.Calendar.HOUR_OF_DAY);
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
        
        <title>Evaluacion Coordinador</title>
    </head>
    <body>
         <!--Sección alerta-->
        <%
            String alerta="";
            try {
                      alerta=request.getParameter("alerta").toString();
                } catch (Exception e) {
                }
           
    if (alerta.equals("si")){%>
        <div class="alert alert-success" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
             <strong>Éxito!</strong> La transacción fue éxitosa!
        </div>
        <%} if(alerta.equals("no")){%>
        <div class="alert alert-danger" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
             <strong>Falló!</strong> La transacción fue fallida!
        </div>
       <% }%>
        <!--Fin Sección alerta-->
        
      <h1 align="center">Sistema de Evaluacion</h1> 
      <br>
      <h2 align="center">Evaluación al Coordinador</h2>
      
       <!--Saludo-->
      <p align="right"> Hola, <i>
      <% if ((hora>20)||(hora<6)) { %>
       Buenas Noches
       <% }
       else if ((hora>=6)&&(hora<=12)) { %>
       Buenos Días
       <% }
        else { %>
        Buenas Tardes
        <% } %>
        </i> </p>
        
        <!--Fecha-->
      <p align="right"> Fecha:
       <%= new java.util.Date() %>
      </p>
      


      <form method="POST"  action="procesa_nuevo.jsp">     
          <select required class="form-control" placeholder="Coordinadorid" required id="coordinadorid"   name="coordinadorid"> 
          <option>Seleccione su Coordinador</option>
              <%while(itCoordinador.hasNext()){
                 Coordinador coordinador=itCoordinador.next();%> %>
                <option value="<%=coordinador.getCoordinadorid()%>"><%=coordinador.getNombre()%></option>
            <% } %>
          </select>
         <!--Tabla para listar los datos-->
        <table id="example" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">                <thead>
                <th>Id</th>
                <th>Preguntas</th>
                <th>Respuesta</th>                                            
                <th></th>
                </thead>
                <tbody>
            <%while(itPregunta_Coordinador.hasNext()){
                  Preguntas_Coordinador programa=itPregunta_Coordinador.next();%>  
                <tr>
                   <td><%= programa.getPreguntas_cid()%></td>
                   <td><%= programa.getPregunta()%></td>
                   <td><input type="number" class="form-control" placeholder="Respuesta" required id="respuesta"  name="respuesta"/></td>  
                  <td> <div class="modal-footer">
                   <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                      </div>
                  </td>
                </tr>
               <%}%>                
                </tbody>           
            </table>
            <!--Fin tabla para listar los datos--> 
        </form>
    </body>
</html>
