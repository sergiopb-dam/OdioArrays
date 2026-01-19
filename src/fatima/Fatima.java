package fatima;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Fatima {

	public static void main(String[] args) {
		int[] enteros = new int[99];
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		numero = sc.nextInt();
		enteros = rellenarTabla(enteros);
		buscarFatima(enteros,numero);
		sc.close();
	}
	public static int[] rellenarTabla(int[] tabla) {			
		Random numero = new Random();
		for (int i = 0; i < tabla.length; i++) {
		tabla[i] = numero.nextInt(1,11);
		}
		return tabla;
	}
	
	private static void buscarFatima(int[] Fatima, int numero) {
		for (int i = 0; i < Fatima.length; i++) {
			if (Fatima[i] == numero) {
				System.out.println(i + " " + numero);
			}
		}
	}
	
}
