<%--
    Document   : Boleto
    Created on : 10-mar-2015, 0:29:27
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String mensaje_error = (String) request.getAttribute("error");%>
<% String numBol = (String) request.getAttribute("numBol");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boletos</title>
    </head>
    <body>
        <%@include file="Encabezado.jsp" %>
        <form action="/Loteria/Boleto" method="POST">
            <p>Número de boletos: <input type="text" name="numBol" value="<%= numBol == null? "" : numBol %>" /></p>
            <p><input type="submit" name="enviar" value="Continuar" /></p>
            <p><a href="/Loteria/Anterior">Repetir la última primitiva</a></p>
            <% if (mensaje_error != null) {%>
            <p><%= mensaje_error%></p>
            <% }%>        
        </form>
    </body>
</html>
