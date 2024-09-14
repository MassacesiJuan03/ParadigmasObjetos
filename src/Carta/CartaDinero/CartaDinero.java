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
        System.out.println("Se ha usado la carta de dinero: " + getDescripcion());
        if (this.valor < 0){
            if (jugador.getDinero() >= -this.valor){
                System.out.println(this.descripcion + ". Pagada con éxito!");
                jugador.recibirDinero(this.valor);
                jugador.dineroRestante();
            }
            else{
                System.out.println(this.descripcion + ". No ha sido pagada, saldo insuficiente");
                jugador.setEnBancarrota(true);
            }
        }else{
            jugador.recibirDinero(this.valor);
            jugador.dineroRestante();
        }
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
