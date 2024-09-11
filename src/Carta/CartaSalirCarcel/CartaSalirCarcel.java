package Carta.CartaSalirCarcel;

import Carta.Carta;
import Jugador.Jugador;

public class CartaSalirCarcel extends Carta{
    //atributos de instancia
    public String descripcion;

    //Constructor
    public CartaSalirCarcel(String descripcion) {
        super();
        this.descripcion = descripcion;
    }

    //Métodos 
    public void usar(Jugador jugador) {
        System.out.println("Ha obtenido la carta de salir de la cárcel: " + getDescripcion());
        jugador.setTieneCartaSalidaDeCarcel(true);
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
