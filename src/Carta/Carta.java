package Carta;

import Jugador.Jugador;

/**
 * Clase abstracta que representa una carta en el juego.
 * Las cartas pueden tener diferentes efectos que se aplican a los jugadores.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
abstract public class Carta {
    /**
     * Aplica el efecto de la carta al jugador especificado.
     * Este método debe ser sobrescrito por las subclases para definir el efecto específico de la carta.
     *
     * @param jugador El jugador al que se aplicará el efecto de la carta.
     */
    public void usar(Jugador jugador){
        // Método vacío que debe ser implementado por las subclases.
    }

    /**
     * Obtiene la descripción de la carta.
     * Este método abstracto debe ser sobrescrito por las subclases para proporcionar una descripción específica de la carta.
     *
     * @return La descripción de la carta.
     */
    abstract public String getDescripcion();
    
}
