package Casillas;

import Jugador.Jugador;

abstract public class Casilla{
    //atributo de instancia
    protected int nroDeCasilla;

    public String nombre;
    public Boolean juegoAutomatico;
    //Constructor
    public Casilla(String nombre, Boolean juegoAutomatico){
        this.nombre = nombre;
        this.juegoAutomatico = juegoAutomatico;

    }
    public Casilla(String nombre){
        this.nombre = nombre;

    }

    //Métodos
    public String getNombre(){
        return nombre;
    }

    //Método abstracto
    abstract public void accion(Jugador jugador);
}
