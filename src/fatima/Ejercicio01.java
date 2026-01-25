package fatima;

import java.util.Scanner;
import java.util.Arrays; // Necesario para imprimir el array correctamente

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. Pide al usuario una frase completa
		System.out.println("Introduce una frase: ");
		String frase = sc.nextLine();

		// 2. Llamada a obtenerPalabras
		String[] palabras = obtenerPalabras(frase);

		// Si el usuario no escribió nada, controlamos el error
		if (palabras.length == 0 || (palabras.length == 1 && palabras[0].isEmpty())) {
			System.out.println("No has introducido texto válido.");
		} else {
			// 3. Llamadas a las funciones lógicas
			int numPalabrasLargas = contarPalabrasLargas(palabras, 5);
			String laMasLarga = palabraMasLarga(palabras);

			// 4. Mostrar resultados según el enunciado

			// "muestra el array de palabras" -> Usamos Arrays.toString
			System.out.println("El array de palabras es: " + Arrays.toString(palabras));

			// "el número total de palabras" -> Usamos la propiedad .length
			System.out.println("El número total de palabras es: " + palabras.length);

			// "cuántas palabras tienen 5 o más letras"
			System.out.println("Hay " + numPalabrasLargas + " palabras largas (5 o más letras).");

			// "la palabra más larga encontrada"
			System.out.println("La palabra más larga es: " + laMasLarga);
		}

		sc.close();
	}

	// FUNCIÓN 1: OBTENER PALABRAS
	// "elimine espacios, minusculas, devuelva array"
	public static String[] obtenerPalabras(String frase) {
		frase = frase.trim().toLowerCase();
		// El regex "\\s+" maneja si el usuario pone varios espacios seguidos por error
		return frase.split("\\s+");
	}

	// FUNCIÓN 2: CONTAR PALABRAS LARGAS
	// "devuelva cuántas tienen longitud mayor o igual que longitudMinima"
	public static int contarPalabrasLargas(String[] palabras, int longitudMinima) {
		int contador = 0;
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length() >= longitudMinima) {
				contador++;
			}
		}
		return contador;
	}

	// FUNCIÓN 3: PALABRA MAS LARGA
	// "devuelva la más larga (si hay varias, devuelve la primera)"
	public static String palabraMasLarga(String[] palabras) {
		String palabraGanadora = ""; // Empezamos con cadena vacía

		for (int i = 0; i < palabras.length; i++) {
			// IMPORTANTE: Usamos '>' y no '>='
			// Al usar solo 'mayor que', si encontramos una palabra igual de larga,
			// NO entramos en el if, manteniendo así la "primera" que encontramos.
			if (palabras[i].length() > palabraGanadora.length()) {
				palabraGanadora = palabras[i];
			}
		}
		return palabraGanadora;
	}
}