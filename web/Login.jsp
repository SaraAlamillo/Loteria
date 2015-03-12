<%-- 
    Document   : Login
    Created on : 12-mar-2015, 1:28:11
    Author     : Sara
--%>
<% String nombre = (String) request.getAttribute("nombre"); %>
<% String clave = (String) request.getAttribute("clave");%>
<% String mensaje = (String) request.getAttribute("mensaje");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Encabezado.jsp" %>
        <form action="/Loteria/Usuario" method="POST">
            <p>Usuario: <input type="text" name="nombre" value="<%= nombre == null ? "" : nombre%>" /></p>
            <p>Contraseña: <input type="text" name="clave" value="<%= clave == null ? "" : clave%>" /></p>
            <p><input type="submit" name="enviar" value="Acceder" /></p>
        </form>
        <% if (mensaje != null) {%>
        <p><%= mensaje%></p>
        <% }%>
    </body>
</html>