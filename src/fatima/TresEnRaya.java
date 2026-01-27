package fatima;

import java.util.Scanner;

public class TresEnRaya {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] tablero = new char[4][4];
		char J1 = 'X';
		char J2 = 'O';
		int contador = 1;

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				tablero[i][j] = '-';
			}
		}
		tablero[0][1] = '0';
		tablero[0][2] = '1';
		tablero[0][3] = '2';
		tablero[1][0] = '0';
		tablero[2][0] = '1';
		tablero[3][0] = '2';
		imprimirTablero(tablero);

		while (contador < 9) {
			System.out.println(contador % 2 != 0 ? "jugador1" : "jugador2");
			System.out.println("Vas a elegir la posición de tu ficha.");
			int fila = comprobarNumeros(sc, "fila");
			int columna = comprobarNumeros(sc, "columna");
			do {
				colocarFicha(tablero, fila, columna, contador % 2 != 0 ? J1 : J2);
			} while (tablero[fila][columna] == '-' && tablero[fila][columna] == (contador % 2 != 0 ? J1 : J2));
			imprimirTablero(tablero);
			contador++;
		}
		sc.close();
	}

	public static void imprimirTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(" " + tablero[i][j]);
			}
			System.out.println(" ");
		}
	}

	public static int comprobarNumeros(Scanner sc, String decision) {
		int fila;
		do {
			System.out.println(
					decision.equalsIgnoreCase("fila") ? "Introduce la fila (0-2):" : "Introduce la columna (0-2):");
			fila = sc.nextInt()+1;
			if (fila > 2 || fila < 0) {
				System.out.println("Error: Solo números del 0-2");
			}
		} while (fila > 2 || fila < 0);
		return fila;
	}

	public static boolean comprobarGanador(char[][] tablero, char jugador) {
		int contador = 0;
		boolean win = false;
		for (int i = 1; i < tablero.length; i++) {
			contador = 0;
			for (int j = 1; j < tablero[i].length; j++) {
				if (tablero[i][j] == jugador) {
					contador++;
				} else {
					contador = 0;
				}
			}
		}
		return win;
	}

	public static char[][] colocarFicha(char[][] tablero, int fila, int columna, char jugador) {
		if (tablero[fila][columna] == '-') {
			tablero[fila][columna] = jugador;
		} else {
			System.out.println("Error: Ya hay una ficha en esa posición.");
		}

		return tablero;
	}

}
