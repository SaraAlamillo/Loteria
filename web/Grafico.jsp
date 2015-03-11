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
        <% for (int b = 0; b < numBol; b++) { %>
        <table border="1">
            <% for (int fila = 0; fila < 10; fila++) { %>
            <tr>
                <% int apuesta = Integer.parseInt(numApu[b]); %>
                <% for (int numApuesta = 1; numApuesta <= apuesta; numApuesta++) { %>
                    <% for (int columna = 0; columna < 5; columna++) { %>
                    <% if (fila == 0 && columna == 0) {%>
                            <td style="background-color: black; color: white;"><%= numApuesta%></td>
                        <% } else { %>
                            <% int valorColumna = fila + (columna * 10);%>
                            <% if (bol.indexOf(apuestasGeneradas[b], valorColumna)) { %>
                            <td style="background-color: green; color: white;"><%= valorColumna%></td>
                            <% } else { %>
                            <td><%=valorColumna %></td>
                            <% } %>
                        <% }%>
                    <% } %>
                <% } %>
            </tr>
            <% }%>
        </table>
        <br />
        <%} %>
    </body>
</html>
