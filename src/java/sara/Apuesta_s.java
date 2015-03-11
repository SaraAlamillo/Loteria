package sara;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sara
 */
@WebServlet(urlPatterns = {"/Apuesta"})
public class Apuesta_s extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("numBol") == null) {
            response.sendRedirect("/Loteria/Boleto");
        } else {
            String numBol = request.getParameter("numBol");
            RequestDispatcher dispatcher;
            request.setAttribute("numBol", numBol);
            Boleto boleto = new Boleto();
            if (request.getParameter("enviar") != null) {
                try {
                    String[] numApu = request.getParameterValues("numApu");
                    Integer precio = 0;
                    int cantidadBoletos = Integer.parseInt(numBol);
                    int[][] apuestasGeneradas = new int[cantidadBoletos][];

                    for (int clave = 0; clave < numApu.length; clave++) {
                        Integer numero = Integer.parseInt(numApu[clave]);

                        if (numero < 1 || numero > 8) {
                            request.setAttribute("error", "Debe introducir un número entero entre 1 y 8");
                            dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                            dispatcher.forward(request, response);
                        }

                        precio = precio + numero;
                        int cantidadApuestas = Integer.parseInt(numApu[clave]);
                        for (int i = 0; i < cantidadApuestas; i++) {
                            apuestasGeneradas[clave] = boleto.generarApuesta();
                        }
                    }
                    request.setAttribute("numApu", numApu);
                    request.setAttribute("numBol", numBol);
                    request.setAttribute("apuestasGeneradas", apuestasGeneradas);
                    request.setAttribute("precio", precio.toString());
                    //dispatcher = request.getRequestDispatcher("Texto.jsp");
                   dispatcher = request.getRequestDispatcher("Grafico.jsp");
                    dispatcher.forward(request, response);
                } catch (NumberFormatException | IOException e) {
                    request.setAttribute("error", "Debe seleccionar algún número");
                    dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
