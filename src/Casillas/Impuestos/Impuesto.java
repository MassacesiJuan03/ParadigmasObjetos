package Casillas.Impuestos;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

public class Impuesto extends Casilla implements IAccionDinero{
    //Constructor
    public Impuesto(String nombre) {
        super(nombre);
    }

    //Métodos
    private void cobrarImpuesto(Jugador jugador){
        //Disminuir el dinero del jugador
        int montoImpuesto = accionDinero(jugador);
        if (montoImpuesto <= jugador.getDinero()){
            jugador.setDinero(montoImpuesto);
            System.out.println("Impuesto pagado!");
            System.out.println("Dinero: $" + jugador.getDinero());
        }
        else{
            System.out.println("Impuesto no pagado, dinero del jugador insuficiente");
        }
    }

    public int accionDinero(Jugador jugador){
        int monto = (int) Math.round(jugador.getDinero()*0.10);
        return Math.max(200, monto);
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
