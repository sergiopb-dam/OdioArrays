package fatima;

import java.util.Arrays; // Importante para poder imprimir el resultado bonito
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe una frase (con espacios locos si quieres):");
		String entrada = sc.nextLine(); 

		// 1. PRIMER EMPLEADO: Limpia y trocea
		String[] resultado = obtenerPalabras(entrada);

		System.out.println("--- RESULTADO DEL ARRAY ---");
		System.out.println(Arrays.toString(resultado));
		
		// ---------------------------------------------------------
		// AQUI ESTABA EL FALLO: FALTABA LLAMAR AL SEGUNDO EMPLEADO
		// ---------------------------------------------------------
		
		// 2. SEGUNDO EMPLEADO: Cuenta las largas
		// Le damos el array 'resultado' y le decimos que busque palabras de 4 letras o más
		int cantidad = contarPalabrasLargas(resultado, 4);
		
		// 3. EL JEFE MUESTRA EL DATO
		System.out.println("He encontrado " + cantidad + " palabras largas.");
		
		sc.close();
	}

	// --- TU MISIÓN ESTÁ AQUÍ DENTRO ---
	public static String[] obtenerPalabras(String frase) {

		// PASO 1: Quitar espacios de los lados
		// Pista: Usa frase.trim() y guárdalo en una variable
		String sinEspacios = frase.trim();

		// PASO 2: Convertir a minúsculas
		// Pista: Usa la variable anterior y ponle .toLowerCase()
		String minusculas = sinEspacios.toLowerCase();

		// PASO 3: Cortar en trocitos (Array)
		// Pista: Usa la variable anterior y .split(" ")
		// OJO: Esto devuelve un String[] (Array), no un String normal
		// "\\s+" es una expresión regular que significa "espacio, tabulador o salto de
		// línea REPETIDO"
		String[] trozos = minusculas.split("\\s+");
		
		return trozos; // Devolvemos el array al jefe
	}

	// Copia esto debajo de tu otra función
	public static int contarPalabrasLargas(String[] palabras, int longitudMinima) {
		int contador = 0; // Aquí guardamos la cuenta

		// BUCLE FOR-EACH (El modo rápido de recorrer arrays)
		// Se lee: "Para cada palabra (p) dentro de la lista (palabras)..."
		for (String p : palabras) {

			// --- TU RETO: EL IF ---
			// Si la longitud de la palabra 'p' es MAYOR O IGUAL que 'longitudMinima'...
			// PISTA: Usa p.length() con paréntesis
			if (p.length() >= longitudMinima) {
				contador++; // Sumamos 1 al contador
			}
		}
		return contador;
	}
}