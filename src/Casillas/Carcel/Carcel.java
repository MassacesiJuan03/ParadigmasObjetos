package Casillas.Carcel;

import Casillas.Casillas;
import Jugador.Jugador;

public class Carcel extends Casillas {
    //Constructor
    public Carcel(String nombre){
        super(nombre);
    }

    //Métodos
    public void cobrarMulta(Jugador jugador){
        
    }

    public void salirDeLaCarcel(){
        //*Darle al jugador un atributo que sea un
        // booleano para saber si está fuera o dentro de la cárcel
    }

    @Override
    public String getType(){
        return "Carcel";
    }
}

