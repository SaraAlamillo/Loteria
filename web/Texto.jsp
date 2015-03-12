<%-- 
    Document   : Texto
    Created on : 10-mar-2015, 20:33:11
    Author     : Sara Alamillo Arroyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sara.Boleto" %>
<%
    int[][][] primitiva = (int[][][]) request.getAttribute("primitiva");
    String precio = (String) request.getAttribute("precio");
    Boleto boleto = new Boleto();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Encabezado.jsp" %>
        <% for (int i = 0; i < primitiva.length; i++) {%>
        <p>Boleto <%= i + 1%>º</p>
        <% for (int j = 0; j < primitiva[i].length; j++) {%>
        <p>
            Apuesta <%= j + 1%>: 
            <% for (int k = 0; k < primitiva[i][j].length; k++) {
                    if (k == (primitiva[i][j].length - 1)) { %>
            <%= primitiva[i][j][k]%>
            <% } else { %>
            <%= primitiva[i][j][k]%>,
            <% }
    } %>
        </p>
        <% } %>
        <p>Reintegro: <%=boleto.generarReintegro()%></p>
        <p>Importe boleto: <%= primitiva[i].length %>€</p>
        <% } %>
        <p>El importe total que debe abonar es <%=precio%>€.</p>
    </body>
</html>
