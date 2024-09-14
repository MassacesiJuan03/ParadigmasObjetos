package Carta.CartaIrDirectoCarcel;

import Carta.Carta;
import Casillas.Carcel.Carcel;
import Jugador.Jugador;

public class CartaIrDirectoCarcel extends Carta{
    //atributos de instancia
    private String descripcion;
    private Carcel carcel = new Carcel("Cárcel", false);

    //Constructor
    public CartaIrDirectoCarcel(String descripcion) {
        super();
        this.descripcion = descripcion;
    }

    //Métodos 
    public void usar(Jugador jugador) {
        System.out.println("Se ha usado la carta de ir directo a la cárcel: " + getDescripcion());
        jugador.setPosicion(10);
        carcel.accion(jugador);
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
