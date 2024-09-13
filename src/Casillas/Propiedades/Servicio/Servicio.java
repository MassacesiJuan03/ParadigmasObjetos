package Casillas.Propiedades.Servicio;

import java.util.ArrayList;

import Casillas.Propiedades.Propiedad;
import Jugador.Jugador;

public class Servicio extends Propiedad {
    //Constructor
    public Servicio(String nombre, Boolean juegoAutomatico, int costo, Jugador dueño, int renta){
        super(nombre,juegoAutomatico, costo, dueño, renta);
    }

    //Métodos
    private void cobrarRenta(Jugador jugador){
        if (this.dueño != null){
            if (this.dueño != jugador){
                //Calcular la renta basado en los dados
                ArrayList<Integer> dadosAnteriores = jugador.getDadosAnteriores();
                int renta = 4 * (dadosAnteriores.get(dadosAnteriores.size() - 1));
                jugador.setDinero(renta);
                System.out.println("Renta de $" + renta + " pagada con éxito.");
                jugador.dineroRestante();
            }
        }
    }

    @Override
    public void accion(Jugador jugador){
        if (!super.ofrecerCompra(jugador)){
            cobrarRenta(jugador);
        }
    }
}
