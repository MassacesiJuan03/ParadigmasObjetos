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

    private void crearCasillas(){
        Casillas[] casillas = new Casillas[40];
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new Casillas();
        }
        this.casillas = casillas;
    }

    private void especializarCasillas() {
        Casillas[] casillas = new Casillas[40];
    
        casillas[0] = new Adelante("Salida"); // Casilla de salida (GO)
        casillas[1] = new Propiedades("Avenida Mediterráneo", 60, null, 2); // Avenida Mediterráneo
        casillas[2] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[3] = new Propiedades("Avenida Báltica", 60, null, 4); // Avenida Báltica
        casillas[4] = new Impuestos("Impuesto sobre la renta"); // Impuesto sobre la renta
        casillas[5] = new Ferrocarril("Ferrocarril Reading", 200, null, 25); // Ferrocarril Reading
        casillas[6] = new Propiedades("Avenida Oriental", 100, null, 6); // Avenida Oriental
        casillas[7] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[8] = new Propiedades("Avenida Vermont", 100, null, 6); // Avenida Vermont
        casillas[9] = new Propiedades("Avenida Connecticut", 120, null, 8); // Avenida Connecticut
        casillas[10] = new Carcel("Cárcel/Visita"); // Cárcel/Visita
    
        casillas[11] = new Propiedades("Plaza San Carlos", 140, null, 10); // Plaza San Carlos
        casillas[12] = new Servicio("Compañía de Electricidad", 150, null, 0); // Compañía de Electricidad
        casillas[13] = new Propiedades("Avenida de los Estados", 140, null, 10); // Avenida de los Estados
        casillas[14] = new Propiedades("Avenida Virginia", 160, null, 12); // Avenida Virginia
        casillas[15] = new Ferrocarril("Ferrocarril Pennsylvania", 200, null, 25); // Ferrocarril Pennsylvania
    
        casillas[16] = new Propiedades("Plaza San Jaime", 180, null, 14); // Plaza San Jaime
        casillas[17] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[18] = new Propiedades("Avenida Tennessee", 180, null, 14); // Avenida Tennessee
        casillas[19] = new Propiedades("Avenida Nueva York", 200, null, 16); // Avenida Nueva York
    
        casillas[20] = new Estacionamiento("Estacionamiento gratuito"); // Estacionamiento gratuito
    
        casillas[21] = new Propiedades("Avenida Kentucky", 220, null, 18); // Avenida Kentucky
        casillas[22] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[23] = new Propiedades("Avenida Indiana", 220, null, 18); // Avenida Indiana
        casillas[24] = new Propiedades("Avenida Illinois", 240, null, 20); // Avenida Illinois
        casillas[25] = new Ferrocarril("Ferrocarril B&O", 200, null, 25); // Ferrocarril B&O
    
        casillas[26] = new Propiedades("Avenida Atlántico", 260, null, 22); // Avenida Atlántico
        casillas[27] = new Propiedades("Avenida Ventnor", 260, null, 22); // Avenida Ventnor
        casillas[28] = new Servicio("Compañía de Agua", 150, null, 0); // Compañía de Agua
        casillas[29] = new Propiedades("Jardines Marvin", 280, null, 24); // Jardines Marvin
    
        casillas[30] = new Carcel("Ir a la cárcel"); // Ir a la cárcel
    
        casillas[31] = new Propiedades("Avenida Pacífico", 300, null, 26); // Avenida Pacífico
        casillas[32] = new Propiedades("Avenida Carolina del Norte", 300, null, 26); // Avenida Carolina del Norte
        casillas[33] = new ArcaOCasualidad("Arca Comunal", true); // Arca Comunal
        casillas[34] = new Propiedades("Avenida Pennsylvania", 320, null, 28); // Avenida Pennsylvania
        casillas[35] = new Ferrocarril("Ferrocarril Short Line", 200, null, 25); // Ferrocarril Short Line
    
        casillas[36] = new ArcaOCasualidad("Casualidad", false); // Casualidad
        casillas[37] = new Propiedades("Plaza del Parque", 350, null, 35); // Plaza del Parque
        casillas[38] = new Impuestos("Impuesto de lujo"); // Impuesto de lujo
        casillas[39] = new Propiedades("El Muelle", 400, null, 50); // El Muelle
    
        this.casillas = casillas;
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
        tablero.crearCasillas();
        tablero.especializarCasillas();

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

            System.out.println("Dados anteriores:");
            tablero.jugadorActual().imprimirDadosAnteriores();


        
            // Actualizar el jugador actual para el siguiente turno
            jugadorActual = tablero.jugadorActual();
        }

        // Cerrar el Scanner al finalizar toda la ejecución del programa
        scanner.close();
    }
}