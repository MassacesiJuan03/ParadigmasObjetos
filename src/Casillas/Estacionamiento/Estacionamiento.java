package Casillas.Estacionamiento;

import Casillas.Casillas;

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
}
