<%-- 
    Document   : Texto
    Created on : 10-mar-2015, 20:33:11
    Author     : Sara Alamillo Arroyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sara.Boleto" %>
<% String[] numApu = (String[]) request.getAttribute("numApu"); %>
<% String boleto = (String) request.getAttribute("numBol"); %>
<% String precio = (String) request.getAttribute("precio"); %>
<% Integer numBol = Integer.parseInt(boleto);%>
<%! Boleto bol = new Boleto(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% for (Integer i = 1; i <= numBol; i++) {%>
        <p>Boleto <%= i%>º</p>
        <% Integer apuesta = Integer.parseInt(numApu[i - 1]); %>
        <% for (Integer j = 1; j <= apuesta; j++) { %>
        <p>
            Apuesta <%= j.toString() %>: 
            <% for(int num : bol.generarApuesta()){ %>
            <%=num %>
            <% } %>
        </p>
        <% } %>
        <p>Reintegro: <%=bol.generarReintegro() %></p>
        <p>Importe boleto: <%=apuesta %>€</p>
        <% }%>
        <p>El importe total que debe abonar es <%=precio %>€.</p>
    </body>
</html>
