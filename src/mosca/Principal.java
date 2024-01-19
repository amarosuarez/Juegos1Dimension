package mosca;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// Variable donde almacenaremos el nombre del jugador
		String jugador;
		
		// Variable donde se almacenará la posición a golpear
		int pos;
		
		// Creamos el Scanner
		Scanner sc = new Scanner(System.in);
		
		// Creamos el objeto tablero
		Tablero tab = new Tablero();
		
		// Le pedimos el nombre al jugador y lo almacenamos
		System.out.println("¿Cómo te llamas?");
		jugador = sc.nextLine();
		
		// Generamos la posición de la mosca
		tab.posicionMosca();
		
		do {
			// Pintamos el tablero
			tab.pintaTablero();
			
			do {
				// Le preguntamos al jugador cual posición quiere elegir y lo almacenamos
				System.out.println("¿Cuál posición deseas golpear " + jugador + "?");
				pos = sc.nextInt();
			} while (pos < 0 || pos > tab.tablero.length - 1);
			
			// Comprobamos si se ha matado a la mosca
			switch (tab.compruebaMosca(pos)) {
				case 0:
					System.out.println("¡Enhorabuena " + jugador + "! Has matado a la mosca");
					break;
				case 1:
					System.out.println("¡Oh no! La mosca ha revoloteado");
					tab.posicionMosca();
					break;
				case -1:
					System.out.println("La mosca sigue viva");
					// Bucle para cambiar la casilla seleccionada
					for (int i=0; i<tab.tablero.length; i++) {
						if (pos==i) tab.tablero[i] = "X";
					}
					break;
			}
			
			
		} while (tab.compruebaMosca(pos) < 0 || tab.compruebaMosca(pos) > 0);
		
		System.out.println("Gano?");
		
		
		
		// Cerramos el Scanner
		sc.close();
	}
	
}
