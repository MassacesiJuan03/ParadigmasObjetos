package Tablero;// Los comentarios que comienzan con "*" son dudas.

import Casillas.Adelante.Adelante;
import Casillas.ArcaOCasualidad.ArcaOCasualidad;
import Casillas.Carcel.Carcel;
import Casillas.Casillas;
import Casillas.Estacionamiento.Estacionamiento;
import Casillas.Impuestos.Impuestos;
import Casillas.Propiedades.Propiedades;
import Casillas.Propiedades.Servicio.Servicio;
import Jugador.Jugador;
import Piezas.Pieza;
import java.util.Scanner;

public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 20;
    private Casillas[] casillas;
    private static final int ANCHO_CONSOLA = 160;  // 1280 / 8 (assuming 8 pixels per character)
    private static final int ALTO_CONSOLA = 50;  //
    //atributos de instancia

    private boolean juegoAutomatico;
    //private boolean turno;

    public Jugador[] jugadores;
    //Constructor

    public Tablero() {
        this.casillas = new Casillas[CANTIDAD_DE_CASILLAS];
    }
    /*
    private void crearCasillas(){
        Casillas[] casillas = new Casillas[CANTIDAD_DE_CASILLAS];
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new Casillas();
        }
        this.casillas = casillas;
    }
    */
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
        int cantidadDeJugadores = 0;




        // garantizar que se ingrese 2, 3 o 4
        do {
            System.out.print("Introduce la cantidad de jugadores (2 a 4): ");
            if (scanner.hasNextInt()) {
                cantidadDeJugadores = scanner.nextInt();
                if (cantidadDeJugadores < 2 || cantidadDeJugadores > 4) {
                    System.out.println("Número de jugadores inválido. Debe ser entre 2 y 4.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, introduce un número entre 2 y 4.");
                scanner.next(); // limpiar la entrada inválida
            }
        } while (cantidadDeJugadores < 2 || cantidadDeJugadores > 4);

        jugadores = new Jugador[cantidadDeJugadores];
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ", elige tu nombre:");
            String nombreJugador = scanner.next();

            System.out.println(nombreJugador + ", elige tu pieza:");
            Pieza piezaElegida = Pieza.elegirPieza(scanner);

            jugadores[i] = new Jugador(piezaElegida.toString());
            jugadores[i].nombre = nombreJugador;
            jugadores[i].posicion = casillas[0];
        }

        // Preguntar si desea utilizar el juego automático
        System.out.println("Desea utilizar el juego automático? (Si/no)");
        String respuesta;

        do {
            respuesta = scanner.next().trim().toLowerCase();
            if (!respuesta.equals("si") && !respuesta.equals("no")) {
                System.out.println("Entrada inválida. Por favor, responde 'Si' o 'No'.");
            }
        } while (!respuesta.equals("si") && !respuesta.equals("no"));

        if (respuesta.equals("si")) {
            this.juegoAutomatico = true;
            System.out.println("Modo automático activado.");
        } else {
            this.juegoAutomatico = false;
            System.out.println("Modo manual activado.");
        }
    }


    private String siguienteTurno(Jugador jugadorAnterior) {
        // Eliminar jugadores con dinero negativo
        for (int i = jugadores.length - 1; i >= 0; i--) {
            if (jugadores[i].getDinero() < 0) {
                System.out.println(jugadores[i].nombre + " ha sido eliminado del juego por quedarse sin dinero.");
                Jugador[] newJugadores = new Jugador[jugadores.length - 1];
                System.arraycopy(jugadores, 0, newJugadores, 0, i);
                System.arraycopy(jugadores, i + 1, newJugadores, i, jugadores.length - i - 1);
                jugadores = newJugadores;
            }
        }

        // Si solo queda un jugador, terminar el juego
        if (jugadores.length == 1) {
            System.out.println(jugadores[0].nombre + " ha ganado el juego!");
            return null; // Indica que el juego ha terminado
        }

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

        // Retornar el nombre del jugador cuyo turno es ahora
        return jugadores[indiceSiguiente].nombre;
    }
    private Jugador jugadorActual() {
        for (Jugador jugador : jugadores) {
            if (jugador.turno) {
                return jugador;
            }
        }
        return null;
    }

    private void dibujarPropiedad(String[][] board, int row, int col, String name, String[] nombreJugador) {
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
        if (nombreJugador.length > 1){
            for (String playerSymbol : nombreJugador) {
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
        String[][] boardVisual = new String[ALTO_CONSOLA][ANCHO_CONSOLA];
    
        // Initialize the board with spaces
        for (int i = 0; i < ALTO_CONSOLA; i++) {
            for (int j = 0; j < ANCHO_CONSOLA; j++) {
                boardVisual[i][j] = " ";
            }
        }
    
        // Define the board dimensions
        int boardTop = 1;
        int boardLeft = 20;
        int boardWidth = 120;
        int boardHeight = 22;
    
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
        int[] topRow = {0,1,2,3,4,5};
        int[] rightColumn = {6, 7, 8, 9};
        int[] bottomRow = {10, 11, 12, 13, 14, 15};
        int[] leftColumn = {16, 17, 18, 19};
    
        int cellHeight = 4;
        int cellWidth = 20;
    
        // Draw top row
        for (int i = 0; i < topRow.length; i++) {
            dibujarPropiedad(boardVisual, boardTop, boardLeft + i * cellWidth, casillas[topRow[i]].getNombre(), getJugadoresEnCasilla(topRow[i]));
        }
    
        // Draw right column
        for (int i = 0; i < rightColumn.length; i++) {
            dibujarPropiedad(boardVisual, boardTop + (i+1) * cellHeight, boardLeft + boardWidth - cellWidth, casillas[rightColumn[i]].getNombre(), getJugadoresEnCasilla(rightColumn[i]));
        }
    
        // Draw bottom row
        for (int i = 0; i < bottomRow.length; i++) {
            dibujarPropiedad(boardVisual, boardTop + boardHeight - cellHeight, boardLeft + (bottomRow.length - 1 - i) * cellWidth, casillas[bottomRow[i]].getNombre(), getJugadoresEnCasilla(bottomRow[i]));
        }
    
        // Draw left column
        for (int i = 0; i < leftColumn.length; i++) {
            dibujarPropiedad(boardVisual, boardTop + (leftColumn.length - i) * cellHeight, boardLeft, casillas[leftColumn[i]].getNombre(), getJugadoresEnCasilla(leftColumn[i]));
        }
    
        // Print the board, only up to the last non-empty row
        int lastNonEmptyRow = 0;
        for (int i = 0; i < ALTO_CONSOLA; i++) {
            boolean rowHasContent = false;
            for (int j = 0; j < ANCHO_CONSOLA; j++) {
                if (!boardVisual[i][j].equals(" ")) {
                    rowHasContent = true;
                    break;
                }
            }
            if (rowHasContent) {
                lastNonEmptyRow = i;
            }
        }
    
        for (int i = 0; i <= lastNonEmptyRow; i++) {
            for (int j = 0; j < ANCHO_CONSOLA; j++) {
                System.out.print(boardVisual[i][j]);
            }
            System.out.println();
        }
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

    // Método para realizar el casting
    public void realizarCasteo(Jugador jugadorActual, Casillas[] casillas){
        Casillas posicionCasilla = jugadorActual.getPosicion();

        if (posicionCasilla instanceof Adelante){
            Adelante tipoAdelante = (Adelante) posicionCasilla;
            tipoAdelante.accion(jugadorActual);
        }
        else if (posicionCasilla instanceof Carcel){
            Carcel tipoCarcel = (Carcel) posicionCasilla;
            if (!tipoCarcel.tirarDobles(jugadorActual, casillas)){
                tipoCarcel.accion(jugadorActual);
            }
        }
        else if(posicionCasilla instanceof Impuestos){
            Impuestos tipoImpuestos = (Impuestos) posicionCasilla;
            tipoImpuestos.accion(jugadorActual);
        }
        else if (posicionCasilla instanceof Propiedades){
            Propiedades tipoPropiedades = (Propiedades) posicionCasilla;
            tipoPropiedades.accion(jugadorActual);
        }
        else if (posicionCasilla instanceof Servicio){
            Servicio tipoServicio = (Servicio) posicionCasilla;
            tipoServicio.accion(jugadorActual);
        }
        else if (posicionCasilla instanceof ArcaOCasualidad){
            ArcaOCasualidad tipoArcaOCasualidad = (ArcaOCasualidad) posicionCasilla;
            tipoArcaOCasualidad.accion(jugadorActual);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        //tablero.crearCasillas();
        tablero.especializarCasillas();
        tablero.empezarPartida(scanner);

        Jugador jugadorActual = tablero.jugadores[0];
        jugadorActual.turno = true;

        boolean juegoEnCurso = true;

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
                jugadorActual.avanzar(tablero.casillas);
            }

            tablero.imprimirTablero();

            String nombreCasilla = tablero.jugadorActual().posicion.getNombre();
            System.out.println("Casilla actual: " + nombreCasilla);

            tablero.realizarCasteo(jugadorActual, tablero.casillas);

            System.out.println("Dados anteriores:");
            tablero.jugadorActual().imprimirDadosAnteriores();
        
            // Actualizar el jugador actual para el siguiente turno
            jugadorActual = tablero.jugadorActual();
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa
        scanner.close();
    }
}