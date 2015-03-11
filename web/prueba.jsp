<%-- 
    Document   : prueba
    Created on : 11-mar-2015, 8:30:20
    Author     : Sara
--%>
<%@page import="sara.Boleto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Boleto p = new Boleto(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=p.generarNumero(5, 1) %></h1>
    </body>
</html>
