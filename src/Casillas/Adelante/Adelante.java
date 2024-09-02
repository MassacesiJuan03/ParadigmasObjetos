package Casillas.Adelante;

import Casillas.Casillas;
import Jugador.Jugador;

public class Adelante extends Casillas {
    //Constructores
    public Adelante(String nombre){
        super(nombre);
    }

    //Métodos
    private void darSueldo(Jugador jugador){
        jugador.recibirDinero(200);
    }

    @Override
    public String getType(){
        return "Adelante";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        darSueldo(jugador);
    }
}
