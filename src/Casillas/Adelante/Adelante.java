package Casillas.Adelante;

import Casillas.Casillas;
import Jugador.Jugador;

public class Adelante extends Casillas {
    //Constructores
    public Adelante(){}

    public Adelante(String nombre){
        super(nombre);
    }

    //Métodos
    public void darSueldo(Jugador jugador){
        jugador.recibirDinero(200);
    }

    @Override
    public String getType(){
        return "Adelante";
    }

}
