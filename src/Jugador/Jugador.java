package Jugador;

import Casillas.Casillas;
import Casillas.Adelante.Adelante;

// Los comentarios que comienzan con "*" son dudas.
public class Jugador {
    // Atributos de instancia
    public Casillas posicion;
    public String pieza;
    public String nombre;
    public boolean enBancarrota;
    public int[] dadosAnteriores; // array de 1xn
    public double dinero;
    public boolean turno;
    public boolean carcel;

    public Jugador(String pieza) {
        this.posicion = null;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new int[0]; // Inicializar array vacío
        this.dinero = 1500; // Monto inicial estándar en Monopoly
        this.turno = false;
        this.carcel = false;
    }

    // Métodos
    public int[] tirarDados() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int[] resultado = {dado1, dado2};

        // Agregar array de resultado en dadosAnteriores
        int[] nuevosDadosAnteriores = new int[dadosAnteriores.length + 2];
        for (int i = 0; i < dadosAnteriores.length; i++) {
            nuevosDadosAnteriores[i] = dadosAnteriores[i];
        }
        nuevosDadosAnteriores[dadosAnteriores.length] = dado1;
        nuevosDadosAnteriores[dadosAnteriores.length + 1] = dado2;
        this.dadosAnteriores = nuevosDadosAnteriores;

        return resultado;
    }

    public void imprimirDadosAnteriores() {
        if (dadosAnteriores.length == 0) {
            System.out.println("No se han lanzado dados todavía.");
            return;
        }
        System.out.print("Dados anteriores: ");
        for (int i = 0; i < dadosAnteriores.length; i += 2) {
            System.out.print("[" + dadosAnteriores[i] + ", " + dadosAnteriores[i + 1] + "] ");
        }
        System.out.println();
    }

    public void comprar() {
        // Lógica para comprar propiedades

    }


    public void pagarRenta(double renta) {
        if (renta <= this.dinero){
            this.dinero -= renta;
            System.out.println("Renta pagada con éxito.");
        }
    }

    public void recibirDinero(double monto) {
        this.dinero += monto;
    }

    public String getPieza() {
        return pieza;
    }
    public double getDinero() {
        return dinero;
    }
}