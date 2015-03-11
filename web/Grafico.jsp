<%-- 
    Document   : Grafico
    Created on : 11-mar-2015, 11:20:05
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sara.Boleto" %>
<% String[] numApu = (String[]) request.getAttribute("numApu"); %>
<% int[][] apuestasGeneradas = (int[][]) request.getAttribute("apuestasGeneradas"); %>
<% String boleto = (String) request.getAttribute("numBol"); %>
<% Integer numBol = Integer.parseInt(boleto);%>
<%! Boleto bol = new Boleto(); %>
<%! int precio = 0;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <% for (int fila = 0; fila < 10; fila++) { %>
            <tr>
                <% for (int numApuesta = 1; numApuesta <= numApu.length; numApuesta++) { %>
                    <% for (int columna = 0; columna < 5; columna++) { %>
                        <% if (fila == 0 && columna == 0) {%>
                            <td style="background-color: black; color: white;"><%= numApuesta%></td>
                        <% } else { %>
                            <% int valorColumna = fila + (columna * 10);%>
                            <% if (bol.indexOf(apuestasGeneradas[numApuesta - 1], valorColumna)) {%>
                                <td style="background-color: green; color: white;"><%= valorColumna%></td>
                            <% } else {%>
                                <td><%= valorColumna%></td>
                            <% }%>
                        <% }%>
                    <% } %>
                <% } %>
            </tr>
            <% }%>
        </table>
    </body>
</html>
