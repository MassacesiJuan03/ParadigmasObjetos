
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Piezas {
    private List<String> piezasDisponibles;

    // Constructor
    public Piezas() {
        piezasDisponibles = new ArrayList<>();
        // Inicializar las piezas
        piezasDisponibles.add("Sombrero");
        piezasDisponibles.add("Auto");
        piezasDisponibles.add("Perro");
        piezasDisponibles.add("Dedal");
        piezasDisponibles.add("Bota");
        piezasDisponibles.add("Barco");
        piezasDisponibles.add("Plancha");
        piezasDisponibles.add("Carretilla");
    }

    // Método para mostrar las piezas disponibles
    public void mostrarPiezas() {
        System.out.println("Piezas disponibles:");
        for (int i = 0; i < piezasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + piezasDisponibles.get(i));
        }
    }

    // Método para elegir una pieza y removerla de la lista de disponibles
    public String elegirPieza(Scanner scanner) {
        mostrarPiezas();
        int eleccion;
        do {
            System.out.print("Introduce el número de la pieza que deseas elegir: ");
            eleccion = scanner.nextInt();
        } while (eleccion < 1 || eleccion > piezasDisponibles.size());

        // Remover la pieza elegida y retornarla
        return piezasDisponibles.remove(eleccion - 1);
    }
}