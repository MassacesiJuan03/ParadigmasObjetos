package Casillas.Propiedades.Ferrocarril;

import Casillas.Propiedades.Propiedad;
import Jugador.Jugador;

public class Ferrocarril extends Propiedad {
    //Constructor
    public Ferrocarril(String nombre,boolean juegoAutomatico, int costo, Jugador dueño, int renta){
        super(nombre,juegoAutomatico, costo, dueño, renta);
    }
}
