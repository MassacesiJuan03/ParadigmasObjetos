package Casillas.Carcel;

import Casillas.Casillas;
import Jugador.Jugador;

import java.util.Scanner;

public class Carcel extends Casillas {
    Scanner scanner = new Scanner(System.in);
    //Constructor
    public Carcel(String nombre){
        super(nombre);
    }

    //Métodos
    public void cobrarMulta(Jugador jugador){
        System.out.println("¿Desea pagar una multa de $50? Si/No");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("Si")){
            jugador.dinero -= 50;
            System.out.println("Multa cobrada, sale de la carcél");
            salirDeLaCarcel(jugador);
        }
        else{
            if (option.equalsIgnoreCase("No")){
                System.out.println("Decidió no pagar la multa, sigue en la carcél");
            }
        }
    }

    private void salirDeLaCarcel(Jugador jugador){
        jugador.carcel = false;
    }

    @Override
    public String getType(){
        return "Carcel";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){

    }
}

