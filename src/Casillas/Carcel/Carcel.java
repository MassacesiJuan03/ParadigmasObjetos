package Casillas.Carcel;

import Casillas.Casilla;
import Jugador.Jugador;

import java.util.Scanner;

public class Carcel extends Casilla {
    Scanner scanner = new Scanner(System.in);
    //Constructor
    public Carcel(String nombre){
        super(nombre);
    }

    //Métodos
    private void cobrarMulta(Jugador jugador){
        //Verificar si el jugador tiene carta de salida de cárcel y si la quiere usar
        boolean salir = usarCartaSalida(tieneCartaSalida(jugador));

        if (!salir){
            if (!tirarDobles(jugador)){
                if (jugador.getDinero() >= 50){
                    jugador.setDinero(50);
                    System.out.println("Multa cobrada, sale de la carcél");
                    jugador.dineroRestante();
                    jugador.setCarcel(false);
                }
                else{
                        System.out.println("Multa no cobrada debido a saldo insuficiente, sigue en la carcél");
                    }
                }
            }
        else{
            //El jugador usó la carta y salio de la cárcel
            jugador.setTieneCartaSalidaDeCarcel(false);
        }
    }


    private boolean tieneCartaSalida(Jugador jugador){
        return jugador.isTieneCartaSalidaDeCarcel();
    }

    private boolean usarCartaSalida(boolean cartaSalida){
        if (cartaSalida){
            boolean flag = false;
            
            while (!flag) {
                System.out.println("¿Desea usar su carta 'SalidaDeCarcel' para salir de la cárcel? Si/No");
                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("Si")){
                    System.out.println("Usted decidio usar la carta. Sale de la cárcel");
                    return true;
                }else{
                    if (option.equalsIgnoreCase("No")){
                        System.out.println("Usted decidio no usar la carta. Sigue en la cárcel");
                        return false;
                    }else{
                        System.out.println("Respuesta incorrecta, intente de nuevo");
                    }
                }
            }
        }
        return false;
    }

    private boolean tirarDobles(Jugador jugador){
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;

        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);

        if (dado1 == dado2){
            System.out.println("Ha conseguido dobles: Sale de la cárcel");
            jugador.setCarcel(false);

            //Avanzar casillas
            for(int i=0; i < dado1+dado2; i++){
                jugador.avanzar();
            }
            System.out.println("Avanzas " + (dado1+dado2) + " casillas");
            return true;
        }
        System.out.println("No ha conseguido dobles: Permanece en la cárcel");
        return false;
    }

    @Override
    public void accion(Jugador jugador){
        System.out.println("¡Ve a la cárcel!");
        cobrarMulta(jugador);
    }
}

