// Clase Mazo
package Mazo;

import Carta.Carta;
import Carta.CartaDinero.CartaDinero;
import Carta.CartaSalirCarcel.CartaSalirCarcel;
import Carta.CartaIrDirectoCarcel.CartaIrDirectoCarcel;
import java.util.Collections;
import java.util.ArrayList;

public class Mazo {
    //atributos de instancia
    private ArrayList<Carta> mazoDeCartas = new ArrayList<>(5);

    //Constructor
    public Mazo() {
        this.mazoDeCartas = inicializarMazo();
    }

    //Métodos
    public ArrayList<Carta> inicializarMazo() {
        ArrayList<Carta> cartas = new ArrayList<>(); // Usar ArrayList para facilitar la mezcla

        // Inicializar las 15 cartas
        cartas.add(new CartaDinero("Felicitaciones, ganaste la lotería, toma $100", 100));
        cartas.add(new CartaDinero("Paga tu seguro de automóvil, pierde $50", -50));
        cartas.add(new CartaDinero("Recibes un reembolso de impuestos, toma $200", 200));
        cartas.add(new CartaDinero("Paga tus facturas médicas, pierde $100", -100));
        cartas.add(new CartaDinero("Recibes un regalo de un amigo, toma $50", 50));
        cartas.add(new CartaDinero("Paga una multa de tráfico, pierde $20", -20));
        cartas.add(new CartaDinero("Vendiste acciones y ganaste $150", 150));
        cartas.add(new CartaDinero("Paga la reparación de tu coche, pierde $75", -75));
        cartas.add(new CartaDinero("Recibes herencia, toma $300", 300));
        cartas.add(new CartaDinero("Pagas una cuota de membresía, pierde $100", -100));
        cartas.add(new CartaSalirCarcel("Esta carta te permite salir de la cárcel."));
        cartas.add(new CartaIrDirectoCarcel("Ve directo a la cárcel."));
        cartas.add(new CartaDinero("Paga la matrícula escolar, pierde $150", -150));
        cartas.add(new CartaDinero("Recibes un bono de tu trabajo, toma $250", 250));
        cartas.add(new CartaDinero("Paga el alquiler, pierde $200", -200));

        // Mezclar las cartas para asignarles una posición aleatoria
        Collections.shuffle(cartas);

        // Pasar las cartas mezcladas al array `mazo`
        for (int i = 0; i < cartas.size(); i++) {
            mazoDeCartas.add(i, cartas.get(i));
        }
        return mazoDeCartas;
    }

    public ArrayList<Carta> getMazo() {
        return mazoDeCartas;
    }
}
