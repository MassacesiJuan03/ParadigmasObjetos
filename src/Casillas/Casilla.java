package Casillas;

import Jugador.Jugador;

abstract public class Casilla{
    //atributo de instancia
    protected int nroDeCasilla;

    public String nombre;

    //Constructor
    public Casilla(String nombre){
        this.nombre = nombre;
    }

    //Métodos
    public String getNombre(){
        return nombre;
    }

    //Método abstracto y polimorfico
    public abstract void accion(Jugador jugador);
}
