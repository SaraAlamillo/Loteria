/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class Usuario {

    private final String nombre = "sara";
    private final String clave = "sara";

    public boolean validar(String pNombre, String pClave) {
        return !((this.nombre == null ? pNombre != null : !this.nombre.equals(pNombre)) || (this.clave == null ? pClave != null : !this.clave.equals(pClave)));
    }

    public void registrarAcceso(HttpSession session) {
       session.setAttribute("nombre", this.nombre);
       session.setAttribute("clave", this.clave);
    }
    
    public void salir(HttpSession session) {
        session.removeAttribute("nombre");
        session.removeAttribute("clave");
    }
    
    public boolean validado(HttpSession session) {
        return this.validar((String) session.getAttribute("nombre"), (String) session.getAttribute("clave"));
    }
}
