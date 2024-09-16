package Casillas.ArcaOCasualidad;

import java.util.ArrayList;

import Carta.Carta;
import Casillas.Casilla;
import Jugador.Jugador;
import Mazo.Mazo;

/**
 * Representa una casilla de Arca o Casualidad en el juego.
 * Esta casilla permite a los jugadores sacar cartas de un mazo que pueden tener diferentes efectos.
 * @author Forni Diego, Massacesi Juan Ignacio
 */

public class ArcaOCasualidad extends Casilla {
    //atributos de instancia
    protected boolean esArca;
    protected static Mazo mazo = new Mazo();

    //Constructor
    /**
     * Crea una nueva instancia de la casilla de Arca o Casualidad.
     *
     * @param nombre El nombre de la casilla.
     * @param esArca Indica si la casilla es del tipo "Arca" (true) o "Casualidad" (false).
     */
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    /**
     * Saca una carta del mazo y la coloca al final del mazo.
     * Esto asegura que las cartas se reciclen en el mazo después de ser usadas.
     *
     * @return La carta sacada del mazo.
     */
    private Carta sacarCarta() {;
        ArrayList<Carta> mazoCartas = mazo.getMazo();
        // Sacar la primera carta del mazo
        Carta cartaSacada = mazoCartas.remove(0);

        // Colocar la carta sacada en la última posición
        mazoCartas.add(cartaSacada);

        // Devolver la carta sacada
        return cartaSacada;
    }

    /**
     * Usa la carta sacada del mazo en el jugador especificado.
     * La carta tiene un efecto que se aplica al jugador.
     *
     * @param jugador El jugador que recibirá el efecto de la carta.
     */
    public void usarCarta(Jugador jugador){
        Carta cartaSacada = sacarCarta();
        cartaSacada.usar(jugador);
    }

    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en esta casilla.
     * Esto implica sacar una carta del mazo y aplicar su efecto al jugador.
     *
     * @param jugador El jugador que cae en la casilla.
     */
    @Override
    public void accion(Jugador jugador){
        usarCarta(jugador);
    }
}
