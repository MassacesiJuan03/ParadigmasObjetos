package Casillas.Estacionamiento;

import Casillas.Casilla;
import Jugador.Jugador;

/**
 * Representa una casilla de estacionamiento en el tablero del juego.
 * Esta casilla proporciona un área de descanso y no tiene ningún costo asociado para el jugador.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Estacionamiento extends Casilla {
    //Constructor
    /**
     * Crea una nueva instancia de la casilla de estacionamiento con el nombre especificado.
     *
     * @param nombre El nombre de la casilla de estacionamiento.
     */
    public Estacionamiento(String nombre){
        super(nombre);
    }

    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en la casilla de estacionamiento.
     * En este caso, muestra un mensaje indicando que es un área de descanso y que el estacionamiento es gratuito.
     *
     * @param jugador El jugador que cae en la casilla.
     */
    @Override
    public void accion(Jugador jugador){
        System.out.println(this.nombre + " gratis: Area de descanso");
    }
}
