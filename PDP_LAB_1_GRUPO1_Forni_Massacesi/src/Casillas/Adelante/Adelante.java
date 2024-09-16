package Casillas.Adelante;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

/**
 * Clase que representa una casilla de tipo "Adelante" en el juego.
 * Esta casilla da un sueldo al jugador cuando cae en ella.
 * Implementa la interfaz {@link IAccionDinero} para manejar acciones relacionadas con el dinero.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Adelante extends Casilla implements IAccionDinero{
    //Constructores
    /**
     * Constructor de la clase Adelante.
     * 
     * @param nombre El nombre de la casilla.
     */
    public Adelante(String nombre){
        super(nombre);
    }

    //Métodos
    /**
     * Otorga un sueldo al jugador que cae en la casilla.
     * Llama al método {@link #accionDinero(Jugador)} para realizar la acción de dar dinero.
     * 
     * @param jugador El jugador que recibe el sueldo.
     */
    private void darSueldo(Jugador jugador){
        accionDinero(jugador);
    }
    
    /**
     * Otorga $100 al jugador y devuelve la cantidad total de dinero que tiene el jugador después de la acción.
     * 
     * @param jugador El jugador que recibe el dinero.
     * @return La cantidad de dinero del jugador después de recibir el sueldo.
     */
    @Override
    public int accionDinero(Jugador jugador){
        jugador.recibirDinero(100);
        return jugador.getDinero();
    }

    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en esta casilla.
     * En este caso, se llama al método {@link #darSueldo(Jugador)} para otorgar el sueldo al jugador.
     * 
     * @param jugador El jugador que cae en la casilla y recibe el sueldo.
     */
    @Override
    public void accion(Jugador jugador){
        darSueldo(jugador);
    }
}
