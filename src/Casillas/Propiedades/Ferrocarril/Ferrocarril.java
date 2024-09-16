package Casillas.Propiedades.Ferrocarril;

import Casillas.Propiedades.Propiedad;
import Jugador.Jugador;

/**
 * Representa una casilla de ferrocarril en el tablero del juego.
 * Un ferrocarril es una propiedad especial que puede ser comprada por un jugador y cobra renta a otros jugadores que caen en ella.
 * La clase `Ferrocarril` extiende la clase `Propiedad` y hereda su funcionalidad.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Ferrocarril extends Propiedad {
    //Constructor
    /**
     * Crea una nueva instancia de un ferrocarril con el nombre, el costo, el dueño y la renta especificados.
     *
     * @param nombre El nombre del ferrocarril.
     * @param juegoAutomatico Indica si el juego se realiza en modo automático.
     * @param costo El costo del ferrocarril.
     * @param dueño El jugador que es el dueño del ferrocarril. Puede ser {@code null} si no hay dueño.
     * @param renta La cantidad de renta que se cobra al caer en el ferrocarril.
     */
    public Ferrocarril(String nombre,boolean juegoAutomatico, int costo, Jugador dueño, int renta){
        super(nombre,juegoAutomatico, costo, dueño, renta);
    }
}
