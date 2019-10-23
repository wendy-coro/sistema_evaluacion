<%-- 
    Document   : procesa_login
    Created on : 27-ago-2019, 16:07:04
    Author     : marco
--%>

<%@page import="ReglasDeNegocio.Estudiante"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
   Estudiante estudiante= new Estudiante();
%>
<%
    
    try {        
        String cedula= request.getParameter("cedula");
        String clave1= request.getParameter("clave");

        //String claveencritada=StringEncrypter.StringEncrypter(clave1);
        //out.print("<script>alert("+claveencritada+");</script>");
        
        estudiante= Estudiante.estudiante_buscar_por_credenciales(cedula, clave1);
        
        if(cedula!=null){
            session.setAttribute("cedula",estudiante.getCedula());
            response.sendRedirect("/Sistema_Evaluacion/mod_evaluacion/maestrias/MaestriaDiseño/coordinador/listar.jsp");
            //out.println("<script>  location.replace('index.jsp');</script>");
            
        }else{
            out.println("<script>  location.replace('Login.jsp');</script>");
            if(request.getParameter("cerrar")!=null){
            session.invalidate();      
           
            }
        }
        } catch (Exception e) {
        }
   
   
%>
