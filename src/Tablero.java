// Los comentarios que comienzan con "*" son dudas.

import java.util.Scanner;

public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 40;
    public Casillas[] casillas;
    //atributos de instancia
    //private boolean turno;

    public Jugador[] jugadores;
    //Constructor

    public Tablero() {
        this.casillas = new Casillas[CANTIDAD_DE_CASILLAS];
    }

    private Casillas[] inicializarCasillas() {
        casillas[0] = new Adelante("Salida"); // Casilla de salida (GO)
        casillas[1] = new Propiedades("Avenida Mediterráneo", 60, null, 2, false, false); // Avenida Mediterráneo
        casillas[2] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[3] = new Propiedades("Avenida Báltica", 60, null, 4, false, false); // Avenida Báltica
        casillas[4] = new Impuestos("Impuesto sobre la renta"); // Impuesto sobre la renta
        casillas[5] = new Propiedades("Ferrocarril Reading", 200, null, 25, false, true); // Ferrocarril Reading
        casillas[6] = new Propiedades("Avenida Oriental", 100, null, 6, false, false); // Avenida Oriental
        casillas[7] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[8] = new Propiedades("Avenida Vermont", 100, null, 6, false, false); // Avenida Vermont
        casillas[9] = new Propiedades("Avenida Connecticut", 120, null, 8, false, false); // Avenida Connecticut
        casillas[10] = new Carcel("Cárcel/Visita"); // Cárcel/Visita
    
        casillas[11] = new Propiedades("Plaza San Carlos", 140, null, 10, false, false); // Plaza San Carlos
        casillas[12] = new Propiedades("Compañía de Electricidad", 150, null, 0, true, false); // Compañía de Electricidad
        casillas[13] = new Propiedades("Avenida de los Estados", 140, null, 10, false, false); // Avenida de los Estados
        casillas[14] = new Propiedades("Avenida Virginia", 160, null, 12, false, false); // Avenida Virginia
        casillas[15] = new Propiedades("Ferrocarril Pennsylvania", 200, null, 25, false, true); // Ferrocarril Pennsylvania
    
        casillas[16] = new Propiedades("Plaza San Jaime", 180, null, 14, false, false); // Plaza San Jaime
        casillas[17] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[18] = new Propiedades("Avenida Tennessee", 180, null, 14, false, false); // Avenida Tennessee
        casillas[19] = new Propiedades("Avenida Nueva York", 200, null, 16, false, false); // Avenida Nueva York
    
        casillas[20] = new Estacionamiento("Estacionamiento gratuito"); // Estacionamiento gratuito
    
        casillas[21] = new Propiedades("Avenida Kentucky", 220, null, 18, false, false); // Avenida Kentucky
        casillas[22] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[23] = new Propiedades("Avenida Indiana", 220, null, 18, false, false); // Avenida Indiana
        casillas[24] = new Propiedades("Avenida Illinois", 240, null, 20, false, false); // Avenida Illinois
        casillas[25] = new Propiedades("Ferrocarril B&O", 200, null, 25, false, true); // Ferrocarril B&O
    
        casillas[26] = new Propiedades("Avenida Atlántico", 260, null, 22, false, false); // Avenida Atlántico
        casillas[27] = new Propiedades("Avenida Ventnor", 260, null, 22, false, false); // Avenida Ventnor
        casillas[28] = new Propiedades("Compañía de Agua", 150, null, 0, true, false); // Compañía de Agua
        casillas[29] = new Propiedades("Jardines Marvin", 280, null, 24, false, false); // Jardines Marvin
    
        casillas[30] = new Carcel("Ir a la cárcel"); // Ir a la cárcel
    
        casillas[31] = new Propiedades("Avenida Pacífico", 300, null, 26, false, false); // Avenida Pacífico
        casillas[32] = new Propiedades("Avenida Carolina del Norte", 300, null, 26, false, false); // Avenida Carolina del Norte
        casillas[33] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[34] = new Propiedades("Avenida Pennsylvania", 320, null, 28, false, false); // Avenida Pennsylvania
        casillas[35] = new Propiedades("Ferrocarril Short Line", 200, null, 25, false, true); // Ferrocarril Short Line
    
        casillas[36] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[37] = new Propiedades("Plaza del Parque", 350, null, 35, false, false); // Plaza del Parque
        casillas[38] = new Impuestos("Impuesto de lujo"); // Impuesto de lujo
        casillas[39] = new Propiedades("El Muelle", 400, null, 50, false, false); // El Muelle

        return casillas;
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
        tablero.inicializarCasillas();

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
            String nombreCasilla = tablero.casillas[tablero.jugadorActual().posicion].getNombre();
            System.out.println("Casilla actual: " + nombreCasilla);


            

            // Actualizar el jugador actual para el siguiente turno
            jugadorActual = tablero.jugadorActual();
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa
        scanner.close();
    }
}