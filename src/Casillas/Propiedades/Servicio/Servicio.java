package Casillas.Propiedades.Servicio;

import Casillas.Propiedades.Propiedad;
import Jugador.Jugador;

public class Servicio extends Propiedad {
    //Constructor
    public Servicio(String nombre, int costo, Jugador dueño, int renta){
        super(nombre, costo, dueño, renta);
    }

    //Métodos
    private void cobrarRenta(Jugador jugador){
        if (this.dueño != null){
            if (this.dueño != jugador){
                //Calcular la renta basado en los dados
                int[] dadosAnteriores = jugador.getDadosAnteriores();
                jugador.setDinero(4 * (dadosAnteriores[dadosAnteriores.length-1] + dadosAnteriores[dadosAnteriores.length-2]));
                System.out.println("Renta pagada con éxito.");
                System.out.println("Dinero: $" + jugador.getDinero());
            }
        }
    }

    @Override
    public String getType() {
        return "Servicio";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        if (!super.ofrecerCompra(jugador)){
            cobrarRenta(jugador);
        }
    }
}
