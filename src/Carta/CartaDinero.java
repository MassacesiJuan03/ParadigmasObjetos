package Carta;

import Jugador.Jugador;

public class CartaDinero extends Carta {
    public String descripcion;
    public int valor;
    public CartaDinero(String descripcion, int valor) {
        super();
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public void usar(Jugador jugador) {
        System.out.println("Se ha usado la carta de dinero: " + this.descripcion);
        jugador.dinero += this.valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    
}
