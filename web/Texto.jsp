<%-- 
    Document   : Texto
    Created on : 10-mar-2015, 20:33:11
    Author     : Sara Alamillo Arroyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sara.Boleto" %>
<%
    String[] numApu = (String[]) request.getAttribute("numApu");
    Integer boleto = (Integer) request.getAttribute("numBol");
    String precio = (String) request.getAttribute("precio");
    Boleto bol = new Boleto();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Encabezado.jsp" %>
        <% for (Integer i = 1; i <= boleto; i++) {%>
        <p>Boleto <%= i%>º</p>
        <% Integer apuesta = Integer.parseInt(numApu[i - 1]); %>
        <% for (Integer j = 1; j <= apuesta; j++) {%>
        <p>
            Apuesta <%= j.toString()%>: 
            <% for (int num : bol.generarApuesta()) {%>
            <%=num%>
            <% } %>
        </p>
        <% }%>
        <p>Reintegro: <%=bol.generarReintegro()%></p>
        <p>Importe boleto: <%=apuesta%>€</p>
        <% }%>
        <p>El importe total que debe abonar es <%=precio%>€.</p>
    </body>
</html>
