package Casillas.ArcaOCasualidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Carta.Carta;
import Carta.CartaDinero.CartaDinero;
import Carta.CartaIrDirectoCarcel.CartaIrDirectoCarcel;
import Carta.CartaSalirCarcel.CartaSalirCarcel;
import Casillas.Casilla;
import Jugador.Jugador;

public class ArcaOCasualidad extends Casilla {
    //atributos de instancia
    protected boolean esArca;

    //Constructor
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    public Carta sacarCarta(Mazo mazo) {
        // Sacar la primera carta del mazo
        Carta cartaSacada = mazo[0];

        // Mover todas las cartas una posición hacia adelante
        for (int i = 0; i < mazo.length - 1; i++) {
            mazo[i] = mazo[i + 1];
        }

        // Colocar la carta sacada en la última posición
        mazo[mazo.length - 1] = cartaSacada;

        // Devolver la carta sacada
        return cartaSacada;
    }

    /*usar cartaSacada para indicar que tipo de carta es(dinero o carcel), implemantar un mètodo para lo anterior,
    asi podemos usar el metodo abstracto 'usar'*/

    @Override
    public String getType() {
        return "ArcaOCasualidad";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        sacarCarta();
    }
}
