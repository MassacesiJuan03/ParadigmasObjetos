package Tablero;// Los comentarios que comienzan con "*" son dudas.

import Carta.Carta;
import Carta.CartaDinero;
import Casillas.Adelante.Adelante;
import Casillas.ArcaOCasualidad.ArcaOCasualidad;
import Casillas.Carcel.Carcel;
import Casillas.Casillas;
import Casillas.Estacionamiento.Estacionamiento;
import Casillas.Impuestos.Impuestos;
import Casillas.Propiedades.Ferrocarril.Ferrocarril;
import Casillas.Propiedades.Propiedades;
import Casillas.Propiedades.Servicio.Servicio;
import Jugador.Jugador;
import Piezas.PiezasDisponibles;

import java.util.Scanner;

public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 20;
    public Casillas[] casillas;
    private static final int CONSOLE_WIDTH = 160;  // 1280 / 8 (assuming 8 pixels per character)
    private static final int CONSOLE_HEIGHT = 50;  //
    //atributos de instancia
    //private boolean turno;

    public Jugador[] jugadores;
    //Constructor

    public Tablero() {
        this.casillas = new Casillas[CANTIDAD_DE_CASILLAS];
    }

    private void crearCasillas(){
        Casillas[] casillas = new Casillas[CANTIDAD_DE_CASILLAS];
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new Casillas();
        }
        this.casillas = casillas;
    }

    private void especializarCasillas() {
        Casillas[] casillas = new Casillas[CANTIDAD_DE_CASILLAS];

        // Esquinas
        casillas[0] = new Adelante("Salida"); // Casilla de salida (GO)
        casillas[5] = new Estacionamiento("Estacionamiento"); // Estacionamiento gratuito
        casillas[10] = new Carcel("Ir a la cárcel"); // Ir a la cárcel
        casillas[15] = new Propiedades("El Muelle", 400, null, 50); // El Muelle

// Propiedades
        casillas[1] = new Propiedades("Av. Mediterráneo", 60, null, 2); // Av. Mediterráneo
        casillas[2] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[3] = new Propiedades("Av. Báltica", 60, null, 4); // Av. Báltica
        casillas[4] = new Impuestos("Impuestos"); // Impuesto sobre la renta

        casillas[6] = new Propiedades("Av. Oriental", 100, null, 6); // Av. Oriental
        casillas[7] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[8] = new Propiedades("Av. Vermont", 100, null, 6); // Av. Vermont
        casillas[9] = new Propiedades("Av. Connecticut", 120, null, 8); // Av. Connecticut

        casillas[11] = new Propiedades("Plaza San Carlos", 140, null, 10); // Plaza San Carlos
        casillas[12] = new Servicio("Electricidad", 150, null, 0); // Compañía de Electricidad
        casillas[13] = new Propiedades("Av. los Estados", 140, null, 10); // Av. de los Estados
        casillas[14] = new Propiedades("Av. Virginia", 160, null, 12); // Av. Virginia

        casillas[16] = new Propiedades("Plaza Jaime", 180, null, 14); // Plaza San Jaime
        casillas[17] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[18] = new Propiedades("Av. Tennessee", 180, null, 14); // Av. Tennessee
        casillas[19] = new Propiedades("Av. Nueva York", 200, null, 16); // Av. Nueva York

        this.casillas = casillas;
    }

    public void empezarPartida(Scanner scanner) {
        System.out.print("Introduce la cantidad de jugadores: ");
        int cantidadDeJugadores = scanner.nextInt();

        PiezasDisponibles piezas = new PiezasDisponibles();
        jugadores = new Jugador[cantidadDeJugadores];
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ", elige tu nombre:");
            String nombreJugador = scanner.next();

            System.out.println("Jugador " + (i + 1) + ", elige tu pieza:");
            String piezaElegida = piezas.elegirPieza(scanner);
            
            jugadores[i] = new Jugador(piezaElegida);
            jugadores[i].nombre = nombreJugador;
            jugadores[i].posicion = casillas[0];
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
        return jugadores[indiceSiguiente].nombre;
    }
    public Jugador jugadorActual() {
        for (Jugador jugador : jugadores) {
            if (jugador.turno) {
                return jugador;
            }
        }
        return null;
    }

    private void drawProperty(String[][] board, int row, int col, String name, String[] playerSymbols) {
        // Define the dimensions of each cell (width and height)
        int cellWidth = 20;
        int cellHeight = 4; // Adjusted height to fit two lines of text and player symbols

        // Draw the top border of the cell
        for (int i = 0; i < cellWidth; i++) {
            if (col + i < board[0].length) {
                board[row][col + i] = "-";
            }
        }

        // Draw the sides of the cell
        for (int i = 1; i < cellHeight - 1; i++) {
            if (row + i < board.length) {
                board[row + i][col] = "|";
                if (col + cellWidth - 1 < board[0].length) {
                    board[row + i][col + cellWidth - 1] = "|";
                }
            }
        }

        // Draw the bottom border of the cell
        for (int i = 0; i < cellWidth; i++) {
            if (col + i < board[0].length) {
                board[row + cellHeight - 1][col + i] = "-";
            }
        }

        // Draw the name of the property, splitting it into lines if necessary
        String[] nameLines = splitString(name, cellWidth - 2);
        for (int i = 0; i < nameLines.length; i++) {
            String line = nameLines[i];
            for (int j = 0; j < line.length(); j++) {
                if (row + i + 1 < board.length && col + j + 1 < board[0].length) {
                    board[row + i + 1][col + j + 1] = String.valueOf(line.charAt(j));
                }
            }
        }

        // Draw the player symbols
        String jugadoresEnCasilla = "";
        if (playerSymbols.length > 1){
            for (String playerSymbol : playerSymbols) {
                if (playerSymbol.length() > 1) {
                    jugadoresEnCasilla = jugadoresEnCasilla + "|" + playerSymbol;

                }

            }
        }

        board[row + cellHeight - 2 ][col + 1] = jugadoresEnCasilla;

    }

    private String[] splitString(String str, int maxLength) {
        int length = str.length();
        int numLines = (length + maxLength - 1) / maxLength;
        String[] lines = new String[numLines];
        for (int i = 0; i < numLines; i++) {
            int start = i * maxLength;
            int end = Math.min(start + maxLength, length);
            lines[i] = str.substring(start, end);
        }
        return lines;
    }

    public void imprimirTablero() {
        String[][] boardVisual = new String[CONSOLE_HEIGHT][CONSOLE_WIDTH];

        // Initialize the board with spaces
        for (int i = 0; i < CONSOLE_HEIGHT; i++) {
            for (int j = 0; j < CONSOLE_WIDTH; j++) {
                boardVisual[i][j] = " ";
            }
        }

        // Define the board dimensions
        int boardTop = 5;
        int boardLeft = 20;
        int boardWidth = 120;
        int boardHeight = 36;

        // Draw the board outline
        for (int i = boardLeft; i < boardLeft + boardWidth; i++) {
            boardVisual[boardTop][i] = "-";
            boardVisual[boardTop + boardHeight - 1][i] = "-";
        }
        for (int i = boardTop; i < boardTop + boardHeight; i++) {
            boardVisual[i][boardLeft] = "|";
            boardVisual[i][boardLeft + boardWidth - 1] = "|";
        }

        // Define positions for drawing properties
        int[] topRow = {0,1,2,3,4};
        int[] rightColumn = {5, 6, 7, 8, 9};
        int[] bottomRow = {10, 11, 12, 13, 14, 15};
        int[] leftColumn = { 16, 17, 18, 19, 0};

        for (int i = 0; i < topRow.length; i++) {
            drawProperty(boardVisual, boardTop, boardLeft + i * 20, casillas[topRow[i]].getNombre(), getJugadoresEnCasilla(topRow[i]));
        }

        for (int i = 0; i < rightColumn.length; i++) {
            drawProperty(boardVisual, boardTop + i * 6, boardLeft + boardWidth - 20, casillas[rightColumn[i]].getNombre(), getJugadoresEnCasilla(rightColumn[i]));
        }

        for (int i = 0; i < bottomRow.length; i++) {
            drawProperty(boardVisual, boardTop + boardHeight - 6, boardLeft + (bottomRow.length - 1 - i) * 20, casillas[bottomRow[i]].getNombre(), getJugadoresEnCasilla(bottomRow[i]));
        }

        for (int i = 0; i < leftColumn.length; i++) {
            drawProperty(boardVisual, boardTop + (leftColumn.length - 1 - i) * 6, boardLeft, casillas[leftColumn[i]].getNombre(), getJugadoresEnCasilla(leftColumn[i]));
        }

        for (int i = 0; i < CONSOLE_HEIGHT; i++) {
            for (int j = 0; j < CONSOLE_WIDTH; j++) {
                System.out.print(boardVisual[i][j]);
            }
            System.out.println();
        }
    }
    public void avanzar(Jugador jugadorActual) {
        Casillas casillaActual = jugadorActual.posicion;
        Casillas [] casillas = this.casillas;
        int index = -1;
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i] == casillaActual) {
                index = i;
                break;
            }
        }
        int nextIndex = (index + 1) % casillas.length;
        jugadorActual.posicion = casillas[nextIndex];

    }

    // Implementar método getJugadoresEnCasilla
    public String[] getJugadoresEnCasilla(int index) {
        String[] jugadoresEnCasilla = new String[jugadores.length];
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].posicion == casillas[index]) {
                jugadoresEnCasilla[i] = jugadores[i].pieza;
            } else {
                jugadoresEnCasilla[i] = "";
            }
        }
        return jugadoresEnCasilla;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        tablero.crearCasillas();
        tablero.especializarCasillas();
        tablero.empezarPartida(scanner);

        Jugador jugadorActual = tablero.jugadores[0];
        jugadorActual.turno = true;

        boolean juegoEnCurso = true;

        scanner.nextLine();

        while (juegoEnCurso) {
            System.out.println("\n\n--------------------");
            System.out.println("Turno de " + tablero.siguienteTurno(jugadorActual));
            System.out.println("Dinero actual: $" + jugadorActual.getDinero());
            System.out.println("Presiona Enter para tirar los dados");
            scanner.nextLine();

            int[] dados = tablero.jugadorActual().tirarDados();
            System.out.println("Dado 1: " + dados[0]);
            System.out.println("Dado 2: " + dados[1]);
            int suma = dados[0] + dados[1];
            System.out.println("Avanzas " + suma + " casillas");

            for (int i = 0; i < suma; i++) {
                tablero.avanzar(jugadorActual);
            }

            String nombreCasilla = tablero.jugadorActual().posicion.getNombre();
            System.out.println("Casilla actual: " + nombreCasilla);

            //Dependiendo la casilla realiza las operaciones correspondientes
            switch (tablero.jugadorActual().posicion.getType()){
                case "Propiedades":
                    Propiedades propiedad = (Propiedades) tablero.jugadorActual().posicion;
                    propiedad.ofrecerCompra(jugadorActual);
                    propiedad.cobrarRenta(jugadorActual);
                    break;
                case "Ferrocarril":
                    Ferrocarril ferrocarril = (Ferrocarril) tablero.jugadorActual().posicion;
                    ferrocarril.ofrecerCompra(jugadorActual);
                    ferrocarril.cobrarRenta(jugadorActual);
                    break;
                case "Servicio":
                    Servicio servicio = (Servicio) tablero.jugadorActual().posicion;
                    break;
                case "Impuestos":
                    Impuestos impuesto = (Impuestos)tablero.jugadorActual().posicion;
                    impuesto.pagarImpuesto(jugadorActual);
                    break;
                case "Carcel":
                    Carcel carcel = (Carcel) tablero.jugadorActual().posicion;
                    jugadorActual.carcel = true;
                    System.out.println("Usted está en la cárcel");
                    carcel.cobrarMulta(jugadorActual);
                    break;
                case "ArcaOCasualidad":
                    break;
                case "Estacionamiento", "Adelante": break;//No hacen nada
            }

            System.out.println("Dados anteriores:");
            tablero.jugadorActual().imprimirDadosAnteriores();


            tablero.imprimirTablero();

        
            // Actualizar el jugador actual para el siguiente turno
            jugadorActual = tablero.jugadorActual();
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa
        scanner.close();
    }
}