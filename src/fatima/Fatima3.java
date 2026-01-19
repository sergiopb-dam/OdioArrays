package fatima;
import java.util.Scanner;
public class Fatima3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1. Declaración de constantes y el array bidimensional
		// 4 filas (alumnos) y 5 columnas (asignaturas)
		final int ALUMNOS = 4;
		final int ASIGNATURAS = 5;
		double[][] notas = new double[ALUMNOS][ASIGNATURAS];

		// 2. Entrada de datos (Rellenar la matriz)
		System.out.println("--- INTRODUCCIÓN DE NOTAS ---");
		for (int i = 0; i < ALUMNOS; i++) {
			System.out.println("Introduzca las notas del Alumno " + (i + 1) + ":");
			for (int j = 0; j < ASIGNATURAS; j++) {
				System.out.print("  Asignatura " + (j + 1) + ": ");
				notas[i][j] = scanner.nextDouble();
			}
		}

		// 3. Mostrar la tabla de notas
		System.out.println("\n--- TABLA DE RESULTADOS ---");
		System.out.println("Alumno\t\tAsig 1\tAsig 2\tAsig 3\tAsig 4\tAsig 5");
		System.out.println("----------------------------------------------------------");

		for (int i = 0; i < ALUMNOS; i++) {
			System.out.print("Alumno " + (i + 1) + "\t"); // Imprime el nombre de la fila
			for (int j = 0; j < ASIGNATURAS; j++) {
				System.out.print(notas[i][j] + "\t"); // Imprime cada nota separada por tabulador
			}
			System.out.println(); // Salto de línea después de cada alumno
		}

		// 4. Calcular estadísticas (Mínimo, Máximo, Media)
		System.out.println("\n--- ESTADÍSTICAS POR ALUMNO ---");

		for (int i = 0; i < ALUMNOS; i++) {
			// Inicializamos valores con la primera nota del alumno actual
			double suma = 0;
			double min = notas[i][0];
			double max = notas[i][0];

			for (int j = 0; j < ASIGNATURAS; j++) {
				double notaActual = notas[i][j];

				// Sumar para la media
				suma += notaActual;

				// Comprobar mínimo
				if (notaActual < min) {
					min = notaActual;
				}

				// Comprobar máximo
				if (notaActual > max) {
					max = notaActual;
				}
			}

			double media = suma / ASIGNATURAS;

			// Mostramos los resultados formateados
			System.out.printf("Alumno %d -> Mín: %.2f | Máx: %.2f | Media: %.2f%n", (i + 1), min, max, media);
		}

		scanner.close();
	}

}
