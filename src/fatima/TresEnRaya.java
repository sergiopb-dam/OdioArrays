package fatima;

import java.util.Scanner;

public class TresEnRaya {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Matriz 4x4 para usar índices 1-3 y bordes decorativos
		char[][] tablero = new char[4][4];
		char J1 = 'X';
		char J2 = 'O';
		int contador = 1; // Contador de turnos (máx 9)

		// 1. Inicializar tablero con guiones
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				tablero[i][j] = '-';
			}
		}
		// Decoración (Bordes)
		tablero[0][1] = '0';
		tablero[0][2] = '1';
		tablero[0][3] = '2';
		tablero[1][0] = '0';
		tablero[2][0] = '1';
		tablero[3][0] = '2';
		tablero[0][0] = ' ';

		imprimirTablero(tablero);

		boolean ganar = false;

		// Bucle principal: Mientras no haya ganador y no pasemos de 9 turnos
		while (contador <= 9 && !ganar) {
			// Decidir turno usando el operador ternario
			char jugadorActual = (contador % 2 != 0) ? J1 : J2;

			System.out.println("Turno del jugador " + (jugadorActual == J1 ? "1 (X)" : "2 (O)"));
			System.out.println("____________________________");

			boolean fichaColocada = false;

			// Bucle secundario: No salimos de aquí hasta que el usuario elija una casilla
			// válida
			while (!fichaColocada) {
				System.out.println("Elige posición (0, 1 o 2).");
				int fila = comprobarNumeros(sc, "fila");
				int columna = comprobarNumeros(sc, "columna");

				// CORRECCIÓN CLAVE: Verificamos si es un guion '-'
				if (tablero[fila][columna] == '-') {
					colocarFicha(tablero, fila, columna, jugadorActual);
					fichaColocada = true; // Esto rompe el while (!fichaColocada)
				} else {
					System.out.println("¡ERROR! Esa casilla ya está ocupada.");
				}
			}

			imprimirTablero(tablero);

			// Verificar si este movimiento ganó la partida
			ganar = comprobarGanador(tablero, jugadorActual);

			if (ganar) {
				System.out.println("!!! ENHORABUENA JUGADOR " + jugadorActual + " HAS GANADO !!!");
			} else if (contador == 9) {
				System.out.println("--- EMPATE: TABLERO LLENO ---");
			}

			contador++; // Pasamos al siguiente turno
		}
		sc.close();
	}

	public static void imprimirTablero(char[][] tablero) {
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(" " + tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int comprobarNumeros(Scanner sc, String tipo) {
		int numero;
		do {
			System.out.print("Introduce " + tipo + " (0-2): ");
			while (!sc.hasNextInt()) {
				System.out.println("Eso no es un número. Intenta de nuevo.");
				sc.next();
			}
			numero = sc.nextInt();

			if (numero < 0 || numero > 2) {
				System.out.println("Error: Solo números del 0 al 2.");
			}
		} while (numero < 0 || numero > 2);

		return numero + 1; // +1 ya que el tablero interno va de 1 a 3
	}

	public static boolean comprobarGanador(char[][] tablero, char jugador) {
		// 1. Comprobar FILAS
		for (int i = 1; i < 4; i++) {
			if (tablero[i][1] == jugador && tablero[i][2] == jugador && tablero[i][3] == jugador) {
				return true;
			}
		}

		// 2. Comprobar COLUMNAS
		for (int j = 1; j < 4; j++) {
			if (tablero[1][j] == jugador && tablero[2][j] == jugador && tablero[3][j] == jugador) {
				return true;
			}
		}

		// 3. Comprobar DIAGONALES
		if (tablero[1][1] == jugador && tablero[2][2] == jugador && tablero[3][3] == jugador)
			return true;
		if (tablero[1][3] == jugador && tablero[2][2] == jugador && tablero[3][1] == jugador)
			return true;

		return false;
	}

	public static void colocarFicha(char[][] tablero, int fila, int columna, char jugador) {
		tablero[fila][columna] = jugador;
	}
}