package Piezas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum Pieza {
    SOMBRERO, AUTO, PERRO, DEDAL, BOTA, BARCO, PLANCHA, CARRETILLA;

    private static final List<Pieza> piezasDisponibles = new ArrayList<>();

    static {
        for (Pieza pieza : Pieza.values()) {
            piezasDisponibles.add(pieza);
        }
    }

    public static Pieza elegirPieza(Scanner scanner) {
        mostrarPiezas();
        int eleccion;
        do {
            System.out.print("Introduce el número de la pieza que deseas elegir: ");
            eleccion = scanner.nextInt();
        } while (eleccion < 1 || eleccion > piezasDisponibles.size());

        return piezasDisponibles.remove(eleccion - 1);
    }

    private static void mostrarPiezas() {
        System.out.println("Piezas disponibles:");
        for (int i = 0; i < piezasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + piezasDisponibles.get(i));
        }
    }
}
