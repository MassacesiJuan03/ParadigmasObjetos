package Casillas.Carcel;

import Casillas.Casillas;
import Jugador.Jugador;

import java.util.Scanner;

public class Carcel extends Casillas {
    //Constructor
    public Carcel(String nombre){
        super(nombre);
    }

    //Métodos
    public void cobrarMulta(Jugador jugador){
        Scanner scanner = new Scanner(System.in);
        //Verificar si el jugador sacó dobles.
        if (!tirarDobles(jugador)){
            System.out.println("¿Desea pagar una multa de $50? Y/N");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("Y")){
                jugador.dinero -= 50;
                System.out.println("Multa cobrada, sale de la carcél");
                salirDeLaCarcel(jugador);
            }
            else{
                if (option.equalsIgnoreCase("N")){
                    System.out.println("Decidió no pagar la multa, sigue en la carcél");
                }
            }
        }
    }

    private boolean tirarDobles(Jugador jugador){
        for (int i=0; i<2; i++){
            int dado1 = (int) (Math.random() * 6) + 1;
            int dado2 = (int) (Math.random() * 6) + 1;
            int[] resultado = {dado1, dado2};

            System.out.println("Dado 1: " + dado1);
            System.out.println("Dado 2: " + dado2);

            if (dado1 == dado2){
                System.out.println("Ha conseguido dobles!. Sale de la cárcel.");
                salirDeLaCarcel(jugador);
                // Avanzar casilla por casilla
                for (int j = 0; j < dado1+dado2; j++) {
                    jugador.avanzar();
                }
                return true;
            }
        }
        return false;
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

