// Los comentarios que comienzan con "*" son dudas.

import java.util.Scanner;

public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 40;
    //atributos de instancia
    //private boolean turno;

    public Jugador[] jugadores;
    //Constructor

    public Tablero() {
    }

    public void empezarPartida(Scanner scanner) {
        System.out.print("Introduce la cantidad de jugadores: ");
        int cantidadDeJugadores = scanner.nextInt();

        Piezas piezas = new Piezas();
        jugadores = new Jugador[cantidadDeJugadores];
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ", elige tu pieza:");
            String piezaElegida = piezas.elegirPieza(scanner);
            jugadores[i] = new Jugador(piezaElegida);
        }
    }

    public String siguienteTurno(Jugador jugadorAnterior) {
        // Encontrar el índice del jugador anterior
        int indiceAnterior = -1;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == jugadorAnterior) {
                indiceAnterior = i;
                break;
            }
        }

        // Calcular el índice del siguiente jugador
        int indiceSiguiente = (indiceAnterior + 1) % jugadores.length;

        // Actualizar los turnos
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].turno = (i == indiceSiguiente);
        }

        // Retornar la pieza del jugador cuyo turno es ahora
        return jugadores[indiceSiguiente].pieza;
    }
    public Jugador jugadorActual() {
        for (Jugador jugador : jugadores) {
            if (jugador.turno) {
                return jugador;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        tablero.empezarPartida(scanner);

        // Iniciar el primer turno
        Jugador jugadorActual = tablero.jugadores[0];
        jugadorActual.turno = true;

        boolean juegoEnCurso = true;

        // Esperar a que el usuario presione "Enter" antes de iniciar el primer turno
        scanner.nextLine();

        while (juegoEnCurso) {
            System.out.println("--------------------");
            System.out.println("Turno de " + tablero.siguienteTurno(jugadorActual));
            System.out.println("Presiona Enter para tirar los dados");
            scanner.nextLine();

            int[] dados = tablero.jugadorActual().tirarDados();
            System.out.println("Dado 1: " + dados[0]);
            System.out.println("Dado 2: " + dados[1]);
            int suma = dados[0] + dados[1];
            System.out.println("Avanzas " + suma + " casillas");

            // Avanzar casilla por casilla
            for (int i = 0; i < suma; i++) {
                tablero.jugadorActual().avanzar();
            }
            
            System.out.println("Posición actual: " + tablero.jugadorActual().posicion);

            // Actualizar el jugador actual para el siguiente turno
            jugadorActual = tablero.jugadorActual();
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa
        scanner.close();
    }
}