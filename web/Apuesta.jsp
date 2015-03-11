<%-- 
    Document   : Apuesta
    Created on : 10-mar-2015, 9:37:36
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String numBol = (String) request.getAttribute("numBol"); %>
<% Integer numero = Integer.parseInt(numBol);%>
<% String mensaje_error = (String) request.getAttribute("error");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apuesta</title>
    </head>
    <body>
        <%@include file="Encabezado.jsp" %>
        <p>Se juegan <%= numBol%> boletos</p>
        <form action="/Loteria/Apuesta?numBol=<%= numBol%>" method="POST">
            <% for (Integer i = 1; i <= numero; i++) {%>
            <p>
                Boleto <%= i.toString()%> - Número de apuestas: 
                <select name="numApu">
                    <option value="0">Seleccione</option>
                    <% for (Integer j = 1; j <= 8; j++) {%>
                    <option value="<%= j.toString()%>"><%= j.toString()%></option>
                    <% } %>
                </select>
            </p>
            <% }%>
            <p><input type="submit" name="enviar" value="Continuar" /></p>
        </form>
        <% if (mensaje_error != null) {%>
        <p><%= mensaje_error%></p>
        <% }%>  
    </body>
</html>
