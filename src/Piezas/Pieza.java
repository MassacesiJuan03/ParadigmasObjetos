package Piezas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Enum que representa las piezas disponibles en el juego.
 * Las piezas son tokens que los jugadores pueden elegir para representarse en el tablero.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public enum Pieza {
    SOMBRERO, AUTO, PERRO, DEDAL, BOTA, BARCO, PLANCHA, CARRETILLA;

    // Lista estática de las piezas disponibles para elegir.
    private static final List<Pieza> piezasDisponibles = new ArrayList<>();

    // Inicialización estática para llenar la lista de piezas disponibles.
    static {
        for (Pieza pieza : Pieza.values()) {
            piezasDisponibles.add(pieza);
        }
    }

    /**
     * Permite al usuario elegir una pieza del listado de piezas disponibles.
     * Muestra las piezas disponibles y solicita al usuario que ingrese el número correspondiente.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La pieza elegida por el usuario.
     */
    public static Pieza elegirPieza(Scanner scanner) {
        mostrarPiezas();
        int eleccion = -1;
        boolean inputValido = false;

        while (!inputValido) {
            System.out.print("Introduce el número de la pieza que deseas elegir: ");
            try {
                eleccion = scanner.nextInt();
                if (eleccion >= 1 && eleccion <= piezasDisponibles.size()) {
                    inputValido = true;
                } else {
                    System.out.println("Por favor, elige un número entre 1 y " + piezasDisponibles.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            } catch (InputMismatchException e){
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }

        return piezasDisponibles.remove(eleccion - 1);
    }

    /**
     * Muestra la lista de piezas disponibles con sus números correspondientes.
     */
    private static void mostrarPiezas() {
        System.out.println("Piezas disponibles:");
        for (int i = 0; i < piezasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + piezasDisponibles.get(i));
        }
    }
}