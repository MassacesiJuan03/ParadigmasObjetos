package Casillas.ArcaOCasualidad;

import java.util.ArrayList;

import Carta.Carta;
import Casillas.Casilla;
import Jugador.Jugador;
import Mazo.Mazo;

public class ArcaOCasualidad extends Casilla {
    //atributos de instancia
    protected boolean esArca;
    private Mazo mazo = new Mazo();

    //Constructor
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    private Carta sacarCarta() {
        ArrayList<Carta> mazoCartas = this.mazo.getMazo();
        // Sacar la primera carta del mazo
        Carta cartaSacada = mazoCartas.remove(0);

        // Colocar la carta sacada en la última posición
        mazoCartas.add(cartaSacada);

        // Devolver la carta sacada
        return cartaSacada;
    }

    public void usarCarta(Jugador jugador){
        Carta cartaSacada = sacarCarta();
        cartaSacada.usar(jugador);
    }

    @Override
    public void accion(Jugador jugador){
        usarCarta(jugador);
    }
}
