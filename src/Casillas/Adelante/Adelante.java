package Casillas.Adelante;

import Casillas.Casillas;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

public class Adelante extends Casillas implements IAccionDinero{
    //Constructores
    public Adelante(String nombre){
        super(nombre);
    }

    //Métodos
    private void darSueldo(Jugador jugador){
        accionDinero(jugador);
    }
    
    public double accionDinero(Jugador jugador){
        jugador.dinero += 200;
        return jugador.dinero;
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
