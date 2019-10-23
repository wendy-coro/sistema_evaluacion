<%-- 
    Document   : procesa_nuevo
    Created on : 16-ago-2019, 11:33:49
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
 //String prueba=request.getParameter("nombre_producto").toString();

 //String prueba2=request.getParameter("categoria_producto").toString();
 //out.print(prueba);   
 //out.print(prueba2); */

try {
            Programa programa=new Programa();
            programa.setNombre(request.getParameter("nombre"));
            programa.setDescripcion(request.getParameter("descripcion"));
           boolean result= Programa.programa_insertar(programa);
             if (result)
                out.println("<script> alert('Se ha guardado correctamente...'); location.replace('listar.jsp');</script>");
            else 
                out.println("<script> alert('No se ha guardado correctamente...'); location.replace('listar.jsp');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

  %>
