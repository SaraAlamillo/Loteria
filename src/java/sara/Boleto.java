package sara;

import java.util.Random;

/**
 *
 * @author Sara
 */
public class Boleto {
    private Random aleatorio;
    
    private int generarNumero(int max, int min) {
        return aleatorio.nextInt((max - min) + 1) + min;
    }
    public int generarReintegro() {
        return this.generarNumero(9, 1);
    }
    
    public int[] generarApuesta() {
        int[] apuesta = new int[6];
        
        for (int i = 0; i < apuesta.length; i++) {
            Boolean existe = true;
            int numero;
            do {
                numero = this.generarNumero(49, 1);
                if (! this.indexOf(apuesta, numero)) {
                    existe = false;
                }
            } while (existe);
            apuesta[i] = numero;
            
        }
        
        return apuesta;
    }
    
    public boolean indexOf(int[] arr, int targetValue) {
	for(int s: arr){
		if(s == targetValue)
			return true;
	}
	return false;
}
}
