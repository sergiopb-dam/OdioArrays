package fatima;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BarcoFatima {

    // --- CONFIGURACIÓN ---
    static final int FILAS = 5;
    static final int COLUMNAS = 5;
    static final int BARCOS_POR_JUGADOR = 3;

    // --- SÍMBOLOS ---
    static final char AGUA = '~';
    static final char TOCADO = 'X';
    static final char FALLO = 'O';

    // --- VARIABLES JUGADOR 1 ---
    // barcosJ1: Dónde están los barcos del J1 (SECRETO)
    // vistaJ1:  Cómo ve el J2 el tablero del J1 (DISPAROS RECIBIDOS)
    static boolean[][] barcosJ1 = new boolean[FILAS][COLUMNAS];
    static char[][] vistaJ1 = new char[FILAS][COLUMNAS];
    static int barcosHundidosDeJ1 = 0;

    // --- VARIABLES JUGADOR 2 ---
    // barcosJ2: Dónde están los barcos del J2 (SECRETO)
    // vistaJ2:  Cómo ve el J1 el tablero del J2 (DISPAROS RECIBIDOS)
    static boolean[][] barcosJ2 = new boolean[FILAS][COLUMNAS];
    static char[][] vistaJ2 = new char[FILAS][COLUMNAS];
    static int barcosHundidosDeJ2 = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Inicialización
        inicializarTableros(vistaJ1, barcosJ1);
        inicializarTableros(vistaJ2, barcosJ2);
        
        System.out.println("--- ⚔️ HUNDIR LA FLOTA: 1 vs 1 ⚔️ ---");
        System.out.println("Los barcos se han colocado aleatoriamente.");
        System.out.println("¡Que empiece la batalla!");

        boolean turnoJ1 = true; // Empieza el Jugador 1
        boolean juegoTerminado = false;

        // 2. Bucle del Juego
        while (!juegoTerminado) {
            System.out.println("\n-------------------------------------------");
            if (turnoJ1) {
                System.out.println("🔫 TURNO DEL JUGADOR 1 (Disparas al J2)");
                // Mostramos el mapa del enemigo (vistaJ2) para saber dónde hemos disparado ya
                mostrarTablero("Mapa del Enemigo (J2)", vistaJ2);
                
                // J1 dispara a los barcos de J2, actualizamos vistaJ2
                boolean acierto = realizarDisparo(barcosJ2, vistaJ2);
                
                if (acierto) {
                    barcosHundidosDeJ2++;
                    System.out.println("💥 ¡BOOM! Le has dado a un barco del J2.");
                }

                if (barcosHundidosDeJ2 == BARCOS_POR_JUGADOR) {
                    System.out.println("\n🏆 ¡FELICIDADES JUGADOR 1! HAS GANADO.");
                    juegoTerminado = true;
                }

            } else {
                System.out.println("🔫 TURNO DEL JUGADOR 2 (Disparas al J1)");
                // Mostramos el mapa del enemigo (vistaJ1)
                mostrarTablero("Mapa del Enemigo (J1)", vistaJ1);
                
                // J2 dispara a los barcos de J1, actualizamos vistaJ1
                boolean acierto = realizarDisparo(barcosJ1, vistaJ1);
                
                if (acierto) {
                    barcosHundidosDeJ1++;
                    System.out.println("💥 ¡BOOM! Le has dado a un barco del J1.");
                }

                if (barcosHundidosDeJ1 == BARCOS_POR_JUGADOR) {
                    System.out.println("\n🏆 ¡FELICIDADES JUGADOR 2! HAS GANADO.");
                    juegoTerminado = true;
                }
            }

            // Cambiamos de turno
            turnoJ1 = !turnoJ1; 
        }
        
        scanner.close();
    }

    // --- FUNCIONES ---

    // Función genérica para disparar. Recibe los arrays del OBJETIVO.
    // Devuelve TRUE si acertó barco, FALSE si agua o repetido.
    public static boolean realizarDisparo(boolean[][] barcosObjetivo, char[][] vistaObjetivo) {
        int f = -1, c = -1;
        boolean coordenadasValidas = false;

        while (!coordenadasValidas) {
            try {
                System.out.print("Fila (0-" + (FILAS - 1) + "): ");
                f = scanner.nextInt();
                System.out.print("Columna (0-" + (COLUMNAS - 1) + "): ");
                c = scanner.nextInt();

                if (f >= 0 && f < FILAS && c >= 0 && c < COLUMNAS) {
                    if (vistaObjetivo[f][c] != AGUA) {
                        System.out.println("⚠️ Ya disparaste ahí. Prueba otra vez.");
                    } else {
                        coordenadasValidas = true; // Salimos del bucle
                    }
                } else {
                    System.out.println("⚠️ Coordenadas fuera de rango.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Introduce solo números.");
                scanner.nextLine();
            }
        }

        // Comprobamos impacto
        if (barcosObjetivo[f][c]) {
            vistaObjetivo[f][c] = TOCADO;
            return true; // Ha tocado barco
        } else {
            System.out.println("💧 Agua...");
            vistaObjetivo[f][c] = FALLO;
            return false;
        }
    }

    public static void inicializarTableros(char[][] vista, boolean[][] barcos) {
        Random random = new Random();
        
        // Limpiar agua
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                vista[i][j] = AGUA;
                barcos[i][j] = false;
            }
        }

        // Colocar barcos aleatorios
        int colocados = 0;
        while (colocados < BARCOS_POR_JUGADOR) {
            int f = random.nextInt(FILAS);
            int c = random.nextInt(COLUMNAS);
            if (!barcos[f][c]) {
                barcos[f][c] = true;
                colocados++;
            }
        }
    }

    public static void mostrarTablero(String titulo, char[][] tablero) {
        System.out.println(titulo);
        System.out.print("  ");
        for (int j = 0; j < COLUMNAS; j++) System.out.print(j + " ");
        System.out.println();
        for (int i = 0; i < FILAS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}