package Casillas.Impuestos;

import Casillas.Casillas;
import Jugador.Jugador;

public class Impuestos extends Casillas {
    //Constructor
    public Impuestos(String nombre) {
        super(nombre);
    }

    //Métodos
    public void pagarImpuesto(Jugador jugador){
        //Disminuir el dinero del jugador
        double montoImpuesto = Math.max(200, jugador.dinero*0.10);
        if (montoImpuesto <= jugador.dinero){
            jugador.dinero -= montoImpuesto;
            System.out.println("Impuesto pagado!");
        }
        else{
            System.out.println("Impuesto no pagado, dinero del jugador insuficiente");
        }
    }

    @Override
    public String getType(){
        return "Impuestos";
    }
}
