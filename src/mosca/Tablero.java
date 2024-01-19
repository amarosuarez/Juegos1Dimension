package mosca;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que contiene los métodos para generar el tablero, la posición de la mosca, 
 * la elección de la casilla y la comprobación de si ha matado a la mosca
 * 
 * @author Amaro
 * @version 1.0
 */
public class Tablero {

	/**
	 * Atributo estático que almacena el tamaño del tablero
	 */
	final static int TAM_TABLERO = 10;
	
	/**
	 * Atributo que almacena las posiciones del jugador y de la mosca
	 */
	String[] tablero = new String[TAM_TABLERO];

	/**
	 * Atributo que almacena la posición de la mosca
	 */
	int pos;
	
	/**
	 * Constructor vacío
	 */
	public Tablero() {}

	/**
	 * Función que pinta el tablero en pantalla
	 */
	void pintaTablero() {
		// Bucle para pintar las casillas del tablero
		for (int i=0; i<TAM_TABLERO; i++) {
			// Comprobamos si el valor de la tabla es la mosca para ocultarla
			if (tablero[i].equals("M")) {
				System.out.print("?\t");		
			} else {				
				System.out.print(tablero[i]+"\t");		
			}
		}
		
		// Pintamos un salto de línea
		System.out.println();
		
		// Bucle para pintar la posición de cada casilla
		for (int i=0; i<TAM_TABLERO; i++) {
			System.out.print(i + "\t");
		}
		
		// Pintamos un salto de línea para que no siga imprimiendo de seguido
		System.out.println();
	}
	
	/**
	 * Función que genera la posición de la mosca y rellena el tablero
	 */
	void posicionMosca() {
		// Creamos el objeto Random
		Random rand = new Random();
		
		// Generamos la posición aleatoria
		pos = rand.nextInt(TAM_TABLERO);
		
		// Variable donde se almacena el valor a almacenar
		String valor;
		
		// Bucle para almacenar a la mosca en la tabla
		for (int i=0; i<TAM_TABLERO; i++) {
			
			// Según si el indice es igual a la posicion generada pintamos M (Mosca) o ?
			if (i==pos) {
				valor = "M";
			} else {
				valor = "?";
			}
			
			// Lo almacenamos en la tabla
			tablero[i] = valor;
		}
	}
	
	/**
	 * Función que comprueba si se ha matado a la mosca
	 * @param posicion Parámetro que obtiene la posición elegida por el usuario
	 * @return Devuelve si se ha matado la mosca o no (-1 sigue viva, 0 ha muerto, 1 revolotea)
	 */
	int compruebaMosca(int posicion) {
		// Variable donde se almacenará si se ha matado a la mosca
		int muerta = -1;
		
		// Comprobamos si se ha matado a la mosca
		if (pos == posicion) {
			muerta = 0;
		} else if (pos == posicion+1 || pos == posicion-1){
			muerta = 1;
		}
		
		// Devolvemos si se ha matado a la mosca
		return muerta;
	}
}
