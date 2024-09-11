package Casillas.Propiedades;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

import java.util.Scanner;

public class Propiedad extends Casilla implements IAccionDinero{
    Scanner scanner = new Scanner(System.in);
    //atributos de instancia
    protected int costo;
    protected Jugador dueño;
    protected int renta;

    //Constructor
    public Propiedad(String nombre, int costo, Jugador dueño, int renta){
        super(nombre);
        this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
    }

    //Métodos
    private void cobrarRenta(Jugador jugador){
        //Verificar si la propiedad tiene dueño
        if (this.dueño != null){
            if (this.dueño != jugador){
                //Cobrar renta al jugador que cayó en una propiedad con dueño
                jugador.pagarRenta(this.renta);
                this.dueño.recibirDinero(this.renta);
            }
        }
    }

    public boolean ofrecerCompra(Jugador jugador){
        boolean flag = true;

        //Verificar si la propiedad tiene dueño
        if (this.dueño != null){
            //Verificar si el dueño es el mismo que cayó en la propiedad
            if (this.dueño == jugador){
                System.out.println("Usted es dueño de " + this.nombre);
            }
            return false;
        }

        //Pedirle por consola al usuario comprar la propiedad si es que no tiene dueño.
        while (flag){
            System.out.println("¿Desea comprar " + this.nombre + " por $" + this.costo + "? (Si/No)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("si")){
                System.out.println("Compra de " + this.nombre + " realizada");
                this.dueño = jugador;
                accionDinero(jugador);
                jugador.dineroRestante();
                break;
            }
            else{
                if (option.equalsIgnoreCase("no")){
                    System.out.println("Usted ha decidido no realizar la compra de " + this.nombre);
                    break;
                }else{
                    System.out.println("Respuesta incorrecta, vuelva a intentar.");
                }
            }
        }
        return true;
    }

    public int accionDinero(Jugador jugador){
        jugador.setDinero(this.costo);
        return jugador.getDinero();
    }
    
    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        if (!ofrecerCompra(jugador)){
            cobrarRenta(jugador);
        }
    }
}
