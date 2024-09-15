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
        if (this.dueño != jugador){
            //Calcular la renta basado en los dados
            ArrayList<Integer> dadosAnteriores = jugador.getDadosAnteriores();
            int renta = 20 * (dadosAnteriores.get(dadosAnteriores.size() - 1));
            if (jugador.getDinero() >= renta){
                jugador.setDinero(renta);
                System.out.println("Renta de $" + renta + " pagada con éxito.");
                jugador.dineroRestante();
            }else{  
                System.out.println("Renta obigatoria de $" + renta + "no pagada, dinero insuficiente.");
                jugador.setEnBancarrota(true);
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
