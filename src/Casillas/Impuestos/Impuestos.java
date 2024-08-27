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
        double montoRenta = Math.max(200, jugador.dinero*0.10);
        jugador.pagarRenta(montoRenta);
        //*Incrementar el del banco
    }

    @Override
    public String getType(){
        return "Impuestos";
    }
}
