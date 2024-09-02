package Casillas;

import Jugador.Jugador;

abstract public class Casillas{
    //atributo de instancia
    protected int nroDeCasilla;

    public String nombre;

    //Constructor
    public Casillas(String nombre){
        this.nombre = nombre;
    }

    public Casillas(){
    }

    //Métodos
    public String getType() {
        return null;
    }
    public String getNombre(){
        return nombre;
    }

    //Método abstracto y polimorfico
    public abstract void accion(Jugador jugador);
}
