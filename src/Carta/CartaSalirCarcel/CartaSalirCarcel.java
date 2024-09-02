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
        System.out.println("Se ha usado la carta de salir de la cárcel: " + this.descripcion);
        jugador.tieneCartaSalidaDeCarcel = true;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
