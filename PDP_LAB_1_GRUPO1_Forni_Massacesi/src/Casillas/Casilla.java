package Casillas;

import Jugador.Jugador;

/**
 * Clase abstracta que representa una casilla en el tablero del juego.
 * Las casillas pueden tener diferentes efectos y comportamientos que se aplican a los jugadores cuando caen en ellas.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
abstract public class Casilla{
    //atributo de instancia
    protected int nroDeCasilla;
    protected String nombre;
    protected Boolean juegoAutomatico;

    //Constructor
    /**
     * Crea una nueva instancia de la casilla con el nombre especificado y un indicador de juego automático.
     *
     * @param nombre El nombre de la casilla.
     * @param juegoAutomatico Indica si el juego debe decidir automáticamente el efecto de la casilla (true) o 
     * si se debe preguntar al jugador (false).
     */
    public Casilla(String nombre, Boolean juegoAutomatico){
        this.nombre = nombre;
        this.juegoAutomatico = juegoAutomatico;

    }

    /**
     * Crea una nueva instancia de la casilla con el nombre especificado.
     *
     * @param nombre El nombre de la casilla.
     */
    public Casilla(String nombre){
        this.nombre = nombre;
    }

    //Métodos
    /**
     * Obtiene el nombre de la casilla.
     *
     * @return El nombre de la casilla.
     */
    public String getNombre(){
        return nombre;
    }

    //Método abstracto
    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en esta casilla.
     * Este método debe ser implementado por las subclases para definir el efecto específico de la casilla.
     *
     * @param jugador El jugador que cae en la casilla.
     */
    abstract public void accion(Jugador jugador);
}
