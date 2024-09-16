package Tablero;

import Casillas.Adelante.Adelante;
import Casillas.ArcaOCasualidad.ArcaOCasualidad;
import Casillas.Carcel.Carcel;
import Casillas.Casilla;
import Casillas.Estacionamiento.Estacionamiento;
import Casillas.Impuestos.Impuesto;
import Casillas.Propiedades.Propiedad;
import Casillas.Propiedades.Servicio.Servicio;
import Jugador.Jugador;
import Piezas.Pieza;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * La clase {@code Tablero} representa el tablero de un juego de mesa. 
 * Maneja la inicialización de casillas, la gestión de jugadores, y la ejecución de turnos.
 * @author Forni Diego, Massacesi Juan Ignacio
*/
public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 20;
    private final Casilla[] casillas;
    private static final int ANCHO_CONSOLA = 160;  // Ancho en caracteres de la consola
    private static final int ALTO_CONSOLA = 50;  // Alto en caracteres de la consola

    //atributos de instancia
    private boolean juegoAutomatico;
    private ArrayList<Jugador> jugadores;

    //Constructor
    /**
     * Constructor de la clase {@code Tablero}. 
     * Crea una instancia de un tablero e inicializa el array de casillas con la cantidad definida.
     */
    public Tablero() {
        this.casillas = new Casilla[CANTIDAD_DE_CASILLAS];
    }

    /**
     * Especializa las casillas del tablero con instancias de diferentes tipos de casillas.
     */
    private void especializarCasillas() {
        // Esquinas
        this.casillas[0] = new Adelante("Salida"); // Casilla de salida (GO)
        this.casillas[5] = new Estacionamiento("Estacionamiento"); // Estacionamiento gratuito
        this.casillas[10] = new Carcel("Ir a la cárcel", juegoAutomatico); // Ir a la cárcel
        this.casillas[15] = new Propiedad("El Muelle", juegoAutomatico, 400, null, 150); // El Muelle

        // Propiedades
        this.casillas[1] = new Propiedad("Av. Mediterráneo", juegoAutomatico, 90, null, 45); // Av. Mediterráneo
        this.casillas[2] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        this.casillas[3] = new Propiedad("Av. Báltica", juegoAutomatico, 90, null, 45); // Av. Báltica
        this.casillas[4] = new Impuesto("Impuestos"); // Impuesto sobre la renta

        this.casillas[6] = new Propiedad("Av. Oriental", juegoAutomatico, 100, null, 50); // Av. Oriental
        this.casillas[7] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        this.casillas[8] = new Propiedad("Av. Vermont", juegoAutomatico, 100, null, 50); // Av. Vermont
        this.casillas[9] = new Propiedad("Av. Connecticut", juegoAutomatico, 120, null, 60); // Av. Connecticut

        this.casillas[11] = new Propiedad("Plaza San Carlos", juegoAutomatico, 140, null, 70); // Plaza San Carlos
        this.casillas[12] = new Servicio("Electricidad", juegoAutomatico,150, null, 0); // Compañía de Electricidad
        this.casillas[13] = new Propiedad("Av. los Estados", juegoAutomatico, 140, null, 70); // Av. de los Estados
        this.casillas[14] = new Propiedad("Av. Virginia", juegoAutomatico, 160, null, 60); // Av. Virginia

        this.casillas[16] = new Propiedad("Plaza Jaime", juegoAutomatico, 180, null, 90); // Plaza San Jaime
        this.casillas[17] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        this.casillas[18] = new Propiedad("Av. Tennessee", juegoAutomatico, 180, null, 90); // Av. Tennessee
        this.casillas[19] = new Propiedad("Av. Nueva York", juegoAutomatico, 200, null, 100); // Av. Nueva York
    }

    /**
     * Inicializa la partida solicitando la cantidad de jugadores, sus nombres, piezas y posiciones.
     * Además, pregunta si se desea utilizar el modo automático o manual.
     * 
     * @param scanner Un objeto scanner para leer la entrada del usuario.
     */
    public void empezarPartida(Scanner scanner) {
        int cantidadDeJugadores = 0;
        // Garantizar que se ingrese 2, 3 o 4
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

        jugadores = new ArrayList<>(cantidadDeJugadores); // ArrayList de jugadores

        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ", elige tu nombre:");
            String nombreJugador = scanner.next();

            System.out.println(nombreJugador + ", elige tu pieza:");
            Pieza piezaElegida = Pieza.elegirPieza(scanner);

            int posicion = 0;
            boolean posicionValida = false;

            // Pedir la posición del jugador hasta que sea válida
            while (!posicionValida) {
                try {
                    System.out.println("Jugador " + (i + 1) + ", ingresa tu posición (entre 1 y 20): ");
                    posicion = scanner.nextInt();

                    // Verificar que la posición esté dentro del rango válido
                    if (posicion < 1 || posicion > 20) {
                        throw new IllegalArgumentException("La posición debe estar entre 1 y 20.");
                    }

                    // Si no hay errores, la posición es válida
                    posicionValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un número entero.");
                    scanner.next(); // Limpiar la entrada inválida
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            jugadores.add(new Jugador(piezaElegida.toString()));
            jugadores.get(i).setNombre(nombreJugador);
            jugadores.get(i).setPosicion(posicion - 1);
            
        }

        // Preguntar si desea utilizar el juego automático
        System.out.println("Desea utilizar el juego automático? (Si/No)");
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


            scanner = new Scanner(System.in); // Reconstruir el scanner para que use el nuevo InputStream
        } else {
            this.juegoAutomatico = false;
            System.out.println("Modo manual activado.");
        }
    }

    /**
     * Actualiza el turno del siguiente jugador y elimina jugadores en bancarrota.
     * 
     * @param jugadorAnterior El jugador que terminó su turno.
     * @return El siguiente jugador en turno. Si solo queda un jugador, el juego termina.
     */
    private Jugador siguienteTurno(Jugador jugadorAnterior) {
        // Eliminar jugadores en bancarrota
        for (int i = jugadores.size() - 1; i >= 0; i--) {
            if (jugadores.get(i).isEnBancarrota()) {
                System.out.println(jugadores.get(i).getNombre() + " ha sido eliminado del juego por declararse en bancarrota.");
                jugadorAnterior.eliminarPropiedad(); // Eliminar las propiedades a nombre del jugador
                jugadores.remove(i); // Eliminar al jugador del juego
            }
        }

        // Si solo queda un jugador, terminar el juego
        if (jugadores.size() == 1) {
            System.out.println("");
            System.out.println(jugadores.get(0).getNombre() + " ha ganado el juego!");
            return null; // Indica que el juego ha terminado
        }

        // Encontrar el índice del jugador anterior
        int indiceAnterior = -1;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i) == jugadorAnterior) {
                indiceAnterior = i;
                break;
            }
        }

        // Calcular el índice del siguiente jugador
        int indiceSiguiente = (indiceAnterior + 1) % jugadores.size();

        // Actualizar los turnos
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setTurno(i == indiceSiguiente);
        }

        // Retornar el jugador siguiente
        return jugadores.get(indiceSiguiente);
    }

    /**
     * Dibuja una propiedad en el tablero, representada por una celda de texto con un borde y 
     * una posible lista de jugadores.
     *
     * @param board Una matriz bidimensional de cadenas que representa el tablero de juego.
     * Cada celda del tablero se representa con un carácter o una cadena de caracteres.
     * @param row La fila en la que se dibuja la propiedad en el tablero.
     * @param col La columna en la que se dibuja la propiedad en el tablero.
     * @param name El nombre de la propiedad que se va a dibujar en la celda.
     * Si el nombre es más largo que el ancho de la celda, se dividirá en múltiples líneas.
     * @param nombreJugador Un array de cadenas que representa los jugadores que están en la celda.
     * Cada elemento del array es un símbolo o nombre de jugador. Los jugadores se dibujan dentro de la celda.
     * Si el array está vacío o solo contiene cadenas vacías, no se dibujarán jugadores en la celda.
    */
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

        // Draw the player symbols if there are any players in the cell
        if (nombreJugador.length > 0) {
            String jugadoresEnCasilla = "";
            for (String playerSymbol : nombreJugador) {
                if (!playerSymbol.isEmpty()) {
                    jugadoresEnCasilla += "|" + playerSymbol;
                }
            }

            // Place player symbols in the cell
            int startRow = row + 1;
            int startCol = col + 1;
            for (int i = 0; i < jugadoresEnCasilla.length(); i++) {
                if (startRow + 1 < board.length && startCol + i < board[0].length) {
                    board[startRow + 1][startCol + i] = String.valueOf(jugadoresEnCasilla.charAt(i));
                }
            }
        }
    }

    /**
     * Divide una cadena de texto en múltiples líneas, cada una con una longitud máxima especificada.
     *
     * @param str La cadena de texto que se desea dividir. No debe ser {@code null}.
     * @param maxLength La longitud máxima de cada línea. Debe ser un número positivo.
     * @return Un array de cadenas, donde cada elemento es una línea de la cadena original.
    */
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

    /**
     * Imprime la representación del tablero en la consola.
     */
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
        int boardHeight = 23;
    
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
    /**
     * Obtiene los símbolos de los jugadores que están en una casilla específica del tablero.
     *
     * Este método recorre la lista de jugadores y verifica cuáles están en la casilla con el índice especificado.
     * Luego, devuelve un array de cadenas que contiene los símbolos de los jugadores en esa casilla. 
     * Si hay más de dos jugadores
     * en la misma casilla, los símbolos se truncarán a un máximo de tres caracteres para evitar 
     * la superposición en la representación del tablero.
     *
     * @param index El índice de la casilla en el tablero para la cual se desea obtener los jugadores.
     * Debe ser un valor válido que represente una casilla existente en el tablero.
     * 
     * @return Un array de cadenas que representa los símbolos de los jugadores en la casilla especificada.
     * Cada elemento del array corresponde a un jugador en la casilla, y los valores pueden ser vacíos si no 
     * hay jugadores en la casilla.
     * La longitud del array es igual al número total de jugadores.
    */
    public String[] getJugadoresEnCasilla(int index) {
        // Crear un array de Strings con el mismo tamaño que el número de jugadores
        String[] jugadoresEnCasilla = new String[jugadores.size()];

        // Inicializar todos los valores como vacío
        for (int i = 0; i < jugadoresEnCasilla.length; i++) {
            jugadoresEnCasilla[i] = "";
        }

        // Contar cuántos jugadores están en la casilla
        int count = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPosicion()== index) {
                count++;
            }
        }

        // Recorrer nuevamente para asignar los símbolos, truncando si hay 2 o más jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPosicion() == index) {
                String pieza = jugadores.get(i).getPieza();
                if (count >= 2 && pieza.length() > 3) {
                    pieza = pieza.substring(0, 3);
                }
                jugadoresEnCasilla[i] = pieza;
            }
        }
        return jugadoresEnCasilla;
    }

    // Método polimorfico
    /**
     * Ejecuta la acción asociada a una casilla cuando un jugador cae en ella.
     * 
     * Este método verifica si la casilla en cuestión es una instancia de la clase {@code Adelante}.
     * Si no lo es, llama al método {@code accion} de la casilla para realizar la acción correspondiente para 
     * el jugador. En caso de que la casilla sea de tipo {@code Adelante}, no se realiza ninguna acción para evitar 
     * que el jugador reciba el dinero más de una vez.
     *
     * @param casilla La casilla sobre la que se debe ejecutar la acción. Debe ser una instancia de una clase que
     * extienda {@code Casilla} y tenga implementado el método {@code accion}.
     * @param jugador El jugador que está ejecutando la acción en la casilla.
    */
    private void realizarAccion(Casilla casilla, Jugador jugador){
        if(!(casilla instanceof Adelante)){ // No darle dos veces al jugador $200
            casilla.accion(jugador);
        }
    }

    /**
     * Método principal para ejecutar el juego.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();

        tablero.empezarPartida(scanner);

        tablero.especializarCasillas();

        Jugador jugadorActual = tablero.jugadores.get(0);
        jugadorActual.setTurno(true);

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            System.out.println("\n\n--------------------");
            if(jugadorActual == null){
                return;
            }
            
            System.out.println("Turno de " + jugadorActual.getPieza());
            System.out.println("Dinero actual: $" + jugadorActual.getDinero());

            if (jugadorActual.isTieneCartaSalidaDeCarcel()){
                System.out.println(jugadorActual.getPieza() + ": tiene carta para salir de la cárcel.");
            }

            //Si el jugador no está en la cárcel podra tirar los dados y avanzar.
            if (!jugadorActual.isCarcel()){

                if(tablero.juegoAutomatico == false){
                    System.out.println("Presiona Enter para tirar los dados.");
                    scanner.nextLine();
                }

                int dado = jugadorActual.tirarDado();
                System.out.println("Dado: " + dado);
                System.out.println("Avanzas " + dado + " casillas");

                for (int i = 0; i < dado; i++) {
                    jugadorActual.avanzar();
                    if (tablero.casillas[jugadorActual.getPosicion()] instanceof Adelante){
                        System.out.println("¡Has pasado por el GO y recibes $100!");
                        tablero.casillas[jugadorActual.getPosicion()].accion(jugadorActual); // Pasó por el GO, darle $200 al jugador
                    }
                }
            }

            // Mostrar el nómbre de la casilla actual donde está el jugador.
            String nombreCasilla = tablero.casillas[jugadorActual.getPosicion()].getNombre();
            System.out.println("Casilla actual: " + nombreCasilla);

            jugadorActual.mostrarPropiedades(); // Mostrar propiedades del jugador.

            tablero.imprimirTablero(); // Imprimir el tablero

            // Dependiendo donde cae el jugador la casilla realiza la accion correspondiente.
            tablero.realizarAccion(tablero.casillas[jugadorActual.getPosicion()], jugadorActual);
        
            // Actualizar el jugador actual para el siguiente turno.
            jugadorActual = tablero.siguienteTurno(jugadorActual);
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa.
        scanner.close();
    }
}