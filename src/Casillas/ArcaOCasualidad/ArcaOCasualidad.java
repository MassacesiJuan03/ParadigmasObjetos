package Casillas.ArcaOCasualidad;

import Casillas.Casillas;

public class ArcaOCasualidad extends Casillas {
    //atributos de instancia
    protected boolean esArca;

    //Métodos
    public void robarCarta(/*Carta carta*/){
        //Elegir una carta de la clase Cartas
    }

    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }
    @Override
    public String getType(){
        return "ArcaOCasualidad";
    }
}
