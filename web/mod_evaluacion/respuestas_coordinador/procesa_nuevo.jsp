<%-- 
    Document   : procesa_nuevo
    Created on : 27-ago-2019, 11:17:26
    Author     : marco
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>

<%
    try {
            Respuestas_Coordinador respuestas_coordinador= new Respuestas_Coordinador();
            Preguntas_Coordinador preguntas_coordinador = new Preguntas_Coordinador();  
            Preguntas_Coordinador preguntas_coordinadores = preguntas_coordinador.preguntac_buscarporid(Integer.valueOf(request.getParameter("preguntas_cid")));         
            respuestas_coordinador.setPreguntas_coordinador(preguntas_coordinadores);
            respuestas_coordinador.setRespuesta(Integer.valueOf(request.getParameter("respuesta")));
            Coordinador coordinador = new Coordinador();  
            Coordinador coordinadores = coordinador.coordinador_buscarporid(Integer.valueOf(request.getParameter("coordinadorid")));         
            respuestas_coordinador.setCoordinador(coordinadores);
            boolean result= Respuestas_Coordinador.respuestac_insertar(respuestas_coordinador);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");
        } catch (Exception e) {
            out.print(e.getMessage());
        }

%>
