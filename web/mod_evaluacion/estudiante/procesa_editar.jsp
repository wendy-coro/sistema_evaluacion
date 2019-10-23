<%-- 
    Document   : procesa_editar
    Created on : 20-ago-2019, 12:58:53
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>

<!DOCTYPE html>

<%
    try {
            Estudiante estudiante=new Estudiante();
            estudiante.setNombre(request.getParameter("nombre"));
            estudiante.setApellido(request.getParameter("apellido"));                        
            estudiante.setCedula(request.getParameter("cedula"));
            Programa programa = new Programa();  
            Programa programas = programa.programa_buscarporid(Integer.valueOf(request.getParameter("programaid")));         
            estudiante.setPrograma(programas);
            estudiante.setFecha(request.getParameter("fecha"));
            estudiante.setEstudianteid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Estudiante.estudiante_editar(estudiante);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>