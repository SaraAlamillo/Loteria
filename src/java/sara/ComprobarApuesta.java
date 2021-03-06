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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
@WebServlet(urlPatterns = {"/Apuesta"})
public class ComprobarApuesta extends HttpServlet {

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

        if (usuario.validado(session)) {

            if (request.getParameter("numBol") == null) {

                response.sendRedirect("/Loteria/Boleto");

            } else {

                Integer numBol = Integer.parseInt(request.getParameter("numBol"));
                Boleto boleto = new Boleto();

                if (request.getParameter("enviar") != null) {

                    String[] numApu = request.getParameterValues("numApu");

                    try {
                        
                        Integer precio = 0;

                        for (int clave = 0; clave < numBol; clave++) {
                            
                            Integer numero = Integer.parseInt(numApu[clave]);

                            if (numero < 1 || numero > 8) {
                                
                                request.setAttribute("numBol", numBol);
                                request.setAttribute("numApu", numApu);
                                request.setAttribute("error", "Debe introducir un número entero entre 1 y 8");
                                
                                dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                                dispatcher.forward(request, response);
                            }

                            precio += numero;
                        }
                        
                        int[] apuestas = new int[numApu.length];
                        
                        for (int i = 0; i < numApu.length; i++) {
                            apuestas[i] = Integer.parseInt(numApu[i]);
                            
                        }
                        
                        int[][][] primitiva = boleto.generarPrimitiva(apuestas);
                        boleto.guardarPrimitiva(primitiva, session);
                        
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
                        
                    } catch (NumberFormatException | IOException e) {
                        request.setAttribute("numBol", numBol);
                        request.setAttribute("numApu", numApu);
                        request.setAttribute("error", "Debe seleccionar algún número");
                        
                        dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    request.setAttribute("numBol", numBol);
                    
                    dispatcher = request.getRequestDispatcher("Apuesta.jsp");
                    dispatcher.forward(request, response);
                }
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
