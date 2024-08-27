package Casillas.Propiedades.Servicio;

import Casillas.Propiedades.Propiedades;
import Jugador.Jugador;

public class Servicio extends Propiedades {
    public Servicio(String nombre, int costo, Jugador dueño, int renta){
        super(nombre, costo, dueño, renta);
    }

    public void cobrarRenta(Jugador jugador){
        //Calcular la renta basado en los dados
    }

}
