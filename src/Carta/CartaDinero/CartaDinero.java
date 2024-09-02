package Carta.CartaDinero;

import Carta.Carta;
import Jugador.Jugador;

public class CartaDinero extends Carta {
    //atributos de instancia
    public String descripcion;
    public int valor;

    //Constructor
    public CartaDinero(String descripcion, int valor) {
        super();
        this.descripcion = descripcion;
        this.valor = valor;
    }

    //Métodos 
    public void usar(Jugador jugador) {
        System.out.println("Se ha usado la carta de dinero: " + this.descripcion);
        jugador.dinero += this.valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    
}
