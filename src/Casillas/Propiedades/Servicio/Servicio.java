package Casillas.Propiedades.Servicio;

import Casillas.Propiedades.Propiedades;
import Jugador.Jugador;

public class Servicio extends Propiedades {
    //Constructor
    public Servicio(String nombre, int costo, Jugador dueño, int renta){
        super(nombre, costo, dueño, renta);
    }

    //Métodos
    private void cobrarRenta(Jugador jugador){
        //Calcular la renta basado en los dados
        int[] dadosAnteriores = jugador.getDadosAnteriores();
        jugador.setDinero(4 * (dadosAnteriores[dadosAnteriores.length-1] + dadosAnteriores[dadosAnteriores.length-2]));
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        cobrarRenta(jugador);
    }
}
