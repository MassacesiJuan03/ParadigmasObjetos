package Casillas.ArcaOCasualidad;

import Casillas.Casillas;
import Jugador.Jugador;

public class ArcaOCasualidad extends Casillas {
    //atributos de instancia
    protected boolean esArca;

    //Constructor
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    public void robarCarta(/*Carta carta*/){
        //Elegir una carta de la clase Cartas
    }

    @Override
    public String getType(){
        return "ArcaOCasualidad";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        
    }
}
