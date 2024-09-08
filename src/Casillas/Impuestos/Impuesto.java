package Casillas.Impuestos;

import Casillas.Casillas;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

public class Impuesto extends Casillas implements IAccionDinero{
    //Constructor
    public Impuesto(String nombre) {
        super(nombre);
    }

    //Métodos
    private void cobrarImpuesto(Jugador jugador){
        //Disminuir el dinero del jugador
        double montoImpuesto = accionDinero(jugador);
        if (montoImpuesto <= jugador.dinero){
            jugador.dinero -= montoImpuesto;
            System.out.println("Impuesto pagado!");
        }
        else{
            System.out.println("Impuesto no pagado, dinero del jugador insuficiente");
        }
    }

    public double accionDinero(Jugador jugador){
        return Math.max(200, jugador.dinero*0.10);
    }

    @Override
    public String getType() {
        return "Impuesto";
    }
    
    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        cobrarImpuesto(jugador);
    }
}
