package Casillas.Estacionamiento;

import Casillas.Casillas;
import Jugador.Jugador;

public class Estacionamiento extends Casillas {
    //Constructor
    public Estacionamiento(String nombre){
        super(nombre);
    }

    //Métodos
    @Override
    public String getType(){
        return "Estacionamiento";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){}
}
