<%-- 
    Document   : Encabezado
    Created on : 11-mar-2015, 16:45:27
    Author     : 2daw
--%>
<%@page import="sara.Usuario" %>
<%! Usuario usuario = new Usuario(); %>
<p><a href="/Loteria/Modo?modo=texto">Modo texto</a> // <a href="/Loteria/Modo?modo=grafico">Modo gr�fico</a></p>
<% if (usuario.validado(request.getSession())) { %>
<p><a href="/Loteria/CerrarSesion">Cerrar sesi�n</a></p>
<% } %>
