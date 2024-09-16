package Carta.CartaSalirCarcel;

import Carta.Carta;
import Jugador.Jugador;

/**
 * Representa una carta que permite al jugador salir de la cárcel.
 * Esta carta otorga al jugador la capacidad de usarla para evitar el pago de la multa de la cárcel.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class CartaSalirCarcel extends Carta{
    //atributos de instancia
    public String descripcion;

    //Constructor
    /**
     * Crea una nueva instancia de carta de "Salir de la Cárcel".
     *
     * @param descripcion Una descripción de la carta que detalla su efecto.
     */
    public CartaSalirCarcel(String descripcion) {
        super();
        this.descripcion = descripcion;
    }

    //Métodos 
    /**
     * Aplica el efecto de la carta al jugador especificado.
     * Esta carta marca al jugador como poseedor de una carta de salida de cárcel, permitiéndole usarla cuando 
     * sea necesario.
     *
     * @param jugador El jugador al que se le aplicará el efecto de la carta.
     */
    @Override
    public void usar(Jugador jugador) {
        System.out.println("Ha obtenido la carta de salir de la cárcel: " + getDescripcion());
        jugador.setTieneCartaSalidaDeCarcel(true);
    }

    /**
     * Obtiene la descripción de la carta de "Salir de la Cárcel".
     *
     * @return La descripción de la carta.
     */
    @Override
    public String getDescripcion() {
        return this.descripcion;
    }
}
