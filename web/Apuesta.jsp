<%-- 
    Document   : Apuesta
    Created on : 10-mar-2015, 9:37:36
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String numBol = (String) request.getAttribute("numBol"); %>
<% Integer numero = Integer.parseInt(numBol);%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apuesta</title>
    </head>
    <body>
        <p>Se juegan <%= numBol%> boletos</p>
        <form action="/Loteria/Apuesta" method="POST">
            <% for (Integer i = 0; i < numero; i++) {%>
            <p>
                Boleto <%= numero.toString()%> - Número de apuestas: 
                <select name="numApu">
                    <% for (Integer j = 1; j <= 6; j++) {%>
                    <option value="<%= j.toString()%>"><%= j.toString()%></option>
                    <% } %>
                </select>
            </p>
            <p><input type="submit" name="enviar" value="Continuar" /></p>
            <% }%>
        </form>
    </body>
</html>
