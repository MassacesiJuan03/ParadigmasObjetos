package Casillas.Estacionamiento;

import Casillas.Casillas;
import Jugador.Jugador;

public class Estacionamiento extends Casillas {
    //Constructor
    public Estacionamiento(String nombre){
        super(nombre);
    }

    //Método
    @Override
    public String getType() {
        return super.getType();
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){}
}
