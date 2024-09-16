package Carta.CartaIrDirectoCarcel;

import Carta.Carta;
import Casillas.Carcel.Carcel;
import Jugador.Jugador;

/**
 * Representa una carta que envía al jugador directamente a la cárcel.
 * Esta carta mueve al jugador a la casilla de la cárcel y aplica el efecto de la cárcel.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class CartaIrDirectoCarcel extends Carta{
    //atributos de instancia
    private String descripcion;
    private Carcel carcel = new Carcel("Cárcel", false);

    //Constructor
    /**
     * Crea una nueva instancia de carta de "Ir Directo a la Cárcel".
     *
     * @param descripcion Una descripción de la carta que detalla el efecto que tiene.
     */
    public CartaIrDirectoCarcel(String descripcion) {
        super();
        this.descripcion = descripcion;
    }

    //Métodos
    /**
     * Aplica el efecto de la carta al jugador especificado.
     * Esta carta mueve al jugador a la casilla de la cárcel y aplica el efecto correspondiente de la cárcel.
     *
     * @param jugador El jugador al que se le aplicará el efecto de la carta.
     */ 
    @Override
    public void usar(Jugador jugador) {
        System.out.println("Se ha usado la carta de ir directo a la cárcel: " + getDescripcion());
        jugador.setPosicion(10);
        carcel.accion(jugador);
    }

    /**
     * Obtiene la descripción de la carta de "Ir Directo a la Cárcel".
     *
     * @return La descripción de la carta.
     */
    @Override
    public String getDescripcion() {
        return this.descripcion;
    }
}
