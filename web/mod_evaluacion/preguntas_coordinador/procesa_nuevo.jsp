<%-- 
    Document   : procesa_nuevo
    Created on : 16-ago-2019, 11:33:49
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
try {
            Preguntas_Coordinador pregunta_coordinador=new Preguntas_Coordinador();
            pregunta_coordinador.setPregunta(request.getParameter("pregunta"));
           boolean result= Preguntas_Coordinador.pregunta_coordinador_insertar(pregunta_coordinador);
             if (result)
                out.println("<script> alert('Se ha guardado correctamente...'); location.replace('listar.jsp');</script>");
            else 
                out.println("<script> alert('No se ha guardado correctamente...'); location.replace('listar.jsp');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

  %>
