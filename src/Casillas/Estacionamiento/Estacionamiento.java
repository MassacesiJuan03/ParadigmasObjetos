package Casillas.Estacionamiento;

import Casillas.Casilla;
import Jugador.Jugador;

public class Estacionamiento extends Casilla {
    //Constructor
    public Estacionamiento(String nombre){
        super(nombre);
    }

    //Método
    @Override
    public String getType() {
        return "Estacionamiento";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){}
}
