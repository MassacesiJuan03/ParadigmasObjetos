package Casillas.Adelante;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

public class Adelante extends Casilla implements IAccionDinero{
    //Constructores
    public Adelante(String nombre){
        super(nombre);
    }

    //Métodos
    private void darSueldo(Jugador jugador){
        accionDinero(jugador);
    }
    
    public int accionDinero(Jugador jugador){
        jugador.recibirDinero(40);
        return jugador.getDinero();
    }

    @Override
    public void accion(Jugador jugador){
        darSueldo(jugador);
    }
    
}
