<%-- 
    Document   : Grafico
    Created on : 11-mar-2015, 11:20:05
    Author     : Sara
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
        <p>Reintegro: <%= boleto.generarReintegro()%></p>
        <p>Importe boleto: <%= primitiva[i].length %>€</p>
        <table border="1">
            <% for (int fila = 0; fila < 10; fila++) { %>
            <tr>
                <%
                    for (int j = 0; j < primitiva[i].length; j++) {
                        for (int columna = 0; columna < 5; columna++) {
                            int valorColumna = fila + (columna * 10);
                            if (fila == 0 && columna == 0) {
                %>
                <td style="background-color: black; color: white;"><%= j%></td>
                <%
                } else if (boleto.indexOf(primitiva[i][j], valorColumna)) {
                %>
                <td style="background-color: green; color: white;"><%= valorColumna%></td>
                <%
                } else {
                %>
                <td><%=valorColumna%></td>
                <%
                            }
                        }
                    }
                %>
            </tr>
            <% }%>
        </table>
        <% } %>
        <br />
        <p>El importe total que debe abonar son <%= precio%>€</p>
    </body>
</html>
