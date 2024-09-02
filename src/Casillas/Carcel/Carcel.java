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
        //Verificar si el jugador tiene carta de salida de cárcel y si la quiere usar
        boolean salir = usarCartaSalida(tieneCartaSalida(jugador));

        if (!salir){
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
    }

    private boolean tieneCartaSalida(Jugador jugador){
        return jugador.tieneCartaSalidaDeCarcel;
    }

    private boolean usarCartaSalida(boolean cartaSalida){
        if (cartaSalida){
            boolean flag = false;
            
            while (!flag) {
                System.out.println("¿Desea usar su 'SalidaDeCarcel' carta para salir de la cárcel? Si/No");
                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("Si")){
                    System.out.println("Usted decidio usar la carta. Sale de la cárcel");
                    return false;
                }else{
                    if (option.equalsIgnoreCase("No")){
                        System.out.println("Usted decidio no usar la carta. Sigue en la cárcel");
                        return true;
                    }else{
                        System.out.println("Respuesta incorrecta, intente de nuevo");
                    }
                }
            }
        }
        return false;
    }

    private void salirDeLaCarcel(Jugador jugador){
        jugador.carcel = false;
    }

    public boolean tirarDobles(Jugador jugador, Casillas[] casillas){
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;

        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);

        if (dado1 == dado2){
            System.out.println("Ha conseguido dobles!. Sale de la cárcel");
            salirDeLaCarcel(jugador);

            //Avanzar casillas
            for(int i=0; i < dado1+dado2; i++){
                jugador.avanzar(casillas);
            }
            return true;
        }
        return false;
    }

    @Override
    public String getType(){
        return "Carcel";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        cobrarMulta(jugador);
    }
}

