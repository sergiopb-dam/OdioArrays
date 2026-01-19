package fatima;

public class BarquitoOle {

	public static void main(String[] args) {
		int[][] tablero = new int[5][5]; // Todo agua (0) al principio
		
		System.out.println("--- INTENTANDO COLOCAR BARCOS ---");

		// 1. Intentamos poner un barco en la fila 1, columna 1
		colocarBarco(tablero, 1, 1);

		// 2. Intentamos poner OTRO barco en el MISMO SITIO (debería fallar)
		colocarBarco(tablero, 1, 1);

		// 3. Ponemos otro en otro lado
		colocarBarco(tablero, 3, 4);

		System.out.println("\n--- RESULTADO FINAL ---");
		mostrarTablero(tablero); // Tu función de antes
	}

	// --- TU NUEVA FUNCIÓN DE "ELITE" ---
	// Recibe el tablero y las coordenadas donde QUIERES poner el barco
	public static void colocarBarco(int[][] matriz, int fila, int col) {

		// PASO 1: Miramos qué hay dentro antes de tocar nada
		if (matriz[fila][col] == 1) {
			System.out.println("❌ ERROR: Ya hay un barco en [" + fila + "][" + col + "]");
		} else {
			// PASO 2: Si es 0 (agua), lo convertimos en barco
			matriz[fila][col] = 1;
			System.out.println("✅ Barco colocado con éxito en [" + fila + "][" + col + "]");
		}
	}

	// TU FUNCIÓN DE MOSTRAR (La que ya tenías, solo para ver el resultado)
	public static void mostrarTablero(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}
}