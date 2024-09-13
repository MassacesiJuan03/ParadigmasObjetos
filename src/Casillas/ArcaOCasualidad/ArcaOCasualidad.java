package Casillas.ArcaOCasualidad;

import java.util.ArrayList;

import Carta.Carta;
import Carta.CartaDinero.CartaDinero;
import Carta.CartaIrDirectoCarcel.CartaIrDirectoCarcel;
import Carta.CartaSalirCarcel.CartaSalirCarcel;
import Casillas.Casilla;
import Jugador.Jugador;
import Mazo.Mazo;

public class ArcaOCasualidad extends Casilla {
    //atributos de instancia
    protected boolean esArca;

    //Constructor
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    private Carta sacarCarta(Mazo mazo) {
        ArrayList<Carta> mazoCartas = mazo.getMazo();
        // Sacar la primera carta del mazo
        Carta cartaSacada = mazoCartas.remove(0);

        // Colocar la carta sacada en la última posición
        mazoCartas.add(cartaSacada);

        // Devolver la carta sacada
        return cartaSacada;
    }

    /*usar cartaSacada para indicar que tipo de carta es(dinero o carcel), implemantar un mètodo para lo anterior,
    asi podemos usar el metodo abstracto 'usar'*/
    public void usarCarta(Jugador jugador){
        Mazo mazoCarta =  new Mazo();
        Carta cartaSacada = sacarCarta(mazoCarta);

        if (cartaSacada instanceof CartaDinero){
            CartaDinero cartaDinero = (CartaDinero) cartaSacada;
            cartaDinero.usar(jugador); 
        }
        if (cartaSacada instanceof CartaSalirCarcel){
            CartaSalirCarcel cartaSalir = (CartaSalirCarcel) cartaSacada;
            cartaSalir.usar(jugador); 
        }
        if (cartaSacada instanceof CartaIrDirectoCarcel){
            CartaIrDirectoCarcel cartaEntrar = (CartaIrDirectoCarcel) cartaSacada;
            cartaEntrar.usar(jugador); 
        }
    }

    @Override
    public void accion(Jugador jugador){
        usarCarta(jugador);
    }
}
