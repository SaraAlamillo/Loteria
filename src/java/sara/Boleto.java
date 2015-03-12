package sara;

import java.util.Random;

/**
 *
 * @author Sara
 */
public class Boleto {

    public int generarNumero(int max, int min) {
        Random aleatorio = new Random();
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
                if (!this.indexOf(apuesta, numero)) {
                    existe = false;
                }
            } while (existe);
            apuesta[i] = numero;

        }

        return apuesta;
    }
    
    public int[][][] generarPrimitiva(int[] apuestas) {
        int cantidadBoletos = apuestas.length;
        int[][][] primitiva = new int[cantidadBoletos][][];
        
        for (int i = 0; i < cantidadBoletos; i++) {
            for (int j = 0; j < apuestas[i]; j++) {
                primitiva[i][j] = this.generarApuesta();
            }
        }
        
        return primitiva;
    }

    public boolean indexOf(int[] arr, int targetValue) {
        for (int s : arr) {
            if (s == targetValue) {
                return true;
            }
        }
        return false;
    }
}
