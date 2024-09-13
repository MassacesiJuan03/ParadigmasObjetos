package Casillas.Estacionamiento;

import Casillas.Casilla;
import Jugador.Jugador;

public class Estacionamiento extends Casilla {
    //Constructor
    public Estacionamiento(String nombre){
        super(nombre);
    }

    @Override
    public void accion(Jugador jugador){
        System.out.println(this.nombre + " gratis: Area de descanso");
    }
}
