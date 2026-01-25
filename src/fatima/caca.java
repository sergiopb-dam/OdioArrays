package fatima;
import java.util.Random;

public class caca {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[][] enteros = new int[6][5];

        try {
			for (int fila = 0; fila < enteros.length - 1; fila++) {
			    for (int columna = 0; columna < enteros[0].length - 1; columna++) {
			        int aleatorioActual = aleatorio.nextInt(1, 10);
			        
			        enteros[fila][columna] = aleatorioActual;
			        enteros[fila][enteros[0].length - 1] += aleatorioActual;
			        enteros[enteros.length - 1][columna] += aleatorioActual;
			        enteros[enteros.length - 1][enteros[0].length - 1] += aleatorioActual;
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (int fila = 0; fila < enteros.length; fila++) {
            for (int columna = 0; columna < enteros[0].length; columna++) {
                System.out.print(enteros[fila][columna] + "\t");
            }
            System.out.println();
        }
    }
}