package fatima;

public class TresEnRaya {

	public static void main(String[] args) {
		char[][] tablero = new char[3][3];
		int jugador1;
		int jugador2;
		int contador = 1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[i][j] = '-';
			}
		}
		imprimirTablero(tablero);
		
		while (contador < 9) {
			System.out.println(contador % 2 == 0 ? "jugador2" : "jugador1");
			contador++;	
		}
		
		
	}
	public static void imprimirTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(" " + tablero[i][j]);
			}
			System.out.println(" ");
		}
	}
	

}
