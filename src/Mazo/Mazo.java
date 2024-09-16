// Clase Mazo
package Mazo;

import Carta.Carta;
import Carta.CartaDinero.CartaDinero;
import Carta.CartaSalirCarcel.CartaSalirCarcel;
import Carta.CartaIrDirectoCarcel.CartaIrDirectoCarcel;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Representa un mazo de cartas en el juego.
 * El mazo contiene cartas que pueden tener diferentes efectos en el juego, como dinero, salida de cárcel o 
 * movimientos directos a la cárcel.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Mazo {
    //atributos de instancia
    private static ArrayList<Carta> mazoDeCartas = new ArrayList<>(15);

    //Constructor
    /**
     * Crea una nueva instancia del mazo de cartas e inicializa el mazo con cartas predefinidas.
     */
    public Mazo() {
        mazoDeCartas = inicializarMazo();
    }

    //Métodos
    /**
     * Inicializa el mazo de cartas con una serie de cartas predefinidas.
     * Las cartas incluyen cartas de dinero, cartas para salir de la cárcel, y cartas para ir directo a la cárcel.
     * Después de inicializar las cartas, se mezclan para asignarles una posición aleatoria en el mazo.
     *
     * @return Una lista de cartas que representa el mazo de cartas mezclado.
     */
    public ArrayList<Carta> inicializarMazo() {
        ArrayList<Carta> cartas = new ArrayList<>(); // Usar ArrayList para facilitar la mezcla

        // Inicializar las 15 cartas
        cartas.add(new CartaDinero("Felicitaciones, ganaste la lotería, toma $100", 100));
        cartas.add(new CartaDinero("Paga tu seguro de automóvil, pierde $100", -100));
        cartas.add(new CartaDinero("Recibes un reembolso de impuestos, toma $200", 200));
        cartas.add(new CartaDinero("Paga tus facturas médicas, pierde $150", -150));
        cartas.add(new CartaDinero("Recibes un regalo de un amigo, toma $50", 50));
        cartas.add(new CartaDinero("Paga una multa de tráfico, pierde $120", -120));
        cartas.add(new CartaDinero("Vendiste acciones y ganaste $150", 150));
        cartas.add(new CartaDinero("Paga la reparación de tu coche, pierde $175", -175));
        cartas.add(new CartaDinero("Recibes herencia, toma $300", 300));
        cartas.add(new CartaDinero("Pagas una cuota de membresía, pierde $120", -120));
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

    /**
     * Obtiene el mazo de cartas.
     *
     * @return La lista de cartas en el mazo.
     */
    public ArrayList<Carta> getMazo() {
        return mazoDeCartas;
    }
}
