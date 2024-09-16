package Casillas.Carcel;

import Casillas.Casilla;
import Jugador.Jugador;

import java.util.Scanner;

/**
 * Representa una casilla de cárcel en el juego.
 * Cuando un jugador cae en esta casilla, debe pagar una multa o usar una carta de salida de la cárcel para liberarse.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Carcel extends Casilla {
    Scanner scanner = new Scanner(System.in);
    //Constructor
    /**
     * Crea una nueva instancia de la casilla de cárcel.
     *
     * @param nombre El nombre de la casilla.
     * @param juegoAutomatico Indica si el juego se encuentra en modo automático.
     */
    public Carcel(String nombre, Boolean juegoAutomatico){
        super(nombre, juegoAutomatico);
    }

    //Métodos
    /**
     * Cobra la multa al jugador o permite usar una carta de salida de la cárcel.
     *
     * @param jugador El jugador que está en la cárcel.
     */
    private void cobrarMulta(Jugador jugador){
        //Verificar si el jugador tiene carta de salida de cárcel y si la quiere usar.
        boolean salir = usarCartaSalida(tieneCartaSalida(jugador));

        if (!salir){
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
        else{
            //El jugador usó la carta y salio de la cárcel
            jugador.setTieneCartaSalidaDeCarcel(false);
        }
    }

    /**
     * Verifica si el jugador tiene una carta de salida de la cárcel.
     *
     * @param jugador El jugador a verificar.
     * @return true si el jugador tiene una carta de salida de la cárcel; false en caso contrario.
     */
    private boolean tieneCartaSalida(Jugador jugador){
        return jugador.isTieneCartaSalidaDeCarcel();
    }

    /**
     * Solicita al jugador si desea usar una carta de salida de la cárcel y devuelve la decisión.
     *
     * @param cartaSalida true si el jugador tiene una carta de salida de la cárcel; false en caso contrario.
     * @return true si el jugador decide usar la carta de salida; false en caso contrario.
     */
    private boolean usarCartaSalida(boolean cartaSalida){
        if (cartaSalida){

            boolean flag = false;

            if(juegoAutomatico == true){
                System.out.println("¿Desea usar su carta 'SalidaDeCarcel' para salir de la cárcel? (Si/No)");
                System.out.println("Usted decidio usar la carta. Sale de la cárcel.");
                return true;
            }

            while (!flag) {
                try{
                    System.out.println("¿Desea usar su carta 'SalidaDeCarcel' para salir de la cárcel? (Si/No)");
                    String option = scanner.nextLine();
    
                    if (option.equalsIgnoreCase("Si")){
                        System.out.println("Usted decidio usar la carta. Sale de la cárcel.");
                        return true;
                    }else{
                        if (option.equalsIgnoreCase("No")){
                            System.out.println("Usted decidio no usar la carta. Sigue en la cárcel.");
                            return false;
                        }else{
                            throw new IllegalArgumentException("Respuesta incorrecta, vuelva a intentar.");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en esta casilla.
     * Manda al jugador a la cárcel y cobra la multa o permite usar la carta de salida.
     *
     * @param jugador El jugador que cae en la casilla.
     */
    @Override
    public void accion(Jugador jugador){
        System.out.println("¡Ve a la cárcel!");
        cobrarMulta(jugador);
    }
}

