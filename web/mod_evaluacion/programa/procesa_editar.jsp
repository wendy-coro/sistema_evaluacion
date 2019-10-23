<%-- 
    Document   : procesa_editar
    Created on : 16-ago-2019, 11:42:47
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
    try {
            Programa producto=new Programa();
            producto.setDescripcion(request.getParameter("descripcion"));
            producto.setNombre(request.getParameter("nombre"));
            producto.setProgramaid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Programa.programa_editar(producto);
             if (result)
                out.println("<script> ; location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> ; location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

%>
