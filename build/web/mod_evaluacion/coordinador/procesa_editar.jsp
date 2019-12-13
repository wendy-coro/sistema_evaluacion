<%-- 
    Document   : procesa_editar
    Created on : 21-ago-2019, 13:05:34
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>

<%
    try {
            Coordinador coordinador=new Coordinador();
            coordinador.setNombre(request.getParameter("nombre"));
            coordinador.setApellido(request.getParameter("apellido"));                        
            coordinador.setCedula(request.getParameter("cedula"));
            Programa programa = new Programa();  
            Programa programas = programa.programa_buscarporid(Integer.valueOf(request.getParameter("programaid")));         
            coordinador.setPrograma(programas);
            coordinador.setFecha(request.getParameter("fecha"));
            coordinador.setCoordinadorid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Coordinador.coordinador_editar(coordinador);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>