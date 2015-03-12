/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 2daw
 */
@WebServlet(name = "RecuperarAnterior", urlPatterns = {"/Anterior"})
public class RecuperarAnterior extends HttpServlet {

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

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        Usuario usuario = new Usuario();
        Boleto boleto = new Boleto();

        if (usuario.validado(session)) {
            int[][][] primitiva = boleto.obtenerAnterior(session);
            if (primitiva == null) {
                request.setAttribute("error", "No existe ninguna primitiva anterior.");
                dispatcher = request.getRequestDispatcher("Boleto.jsp");
                dispatcher.forward(request, response);
            } else {
                Integer precio = 0;
                for (int[][] p : primitiva) {
                    precio += p.length;
                }
                
                request.setAttribute("primitiva", primitiva);
                request.setAttribute("precio", precio.toString());

                String modo = (String) session.getAttribute("modo");
                String ruta = "";

                if (modo == null) {
                    ruta = "index.jsp";
                } else {
                    ruta = modo + ".jsp";

                }

                dispatcher = request.getRequestDispatcher(ruta);
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("mensaje", "Debe validarse para utilizar la aplicación.");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
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
