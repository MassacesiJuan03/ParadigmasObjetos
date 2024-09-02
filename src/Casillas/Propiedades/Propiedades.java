package Casillas.Propiedades;

import Casillas.Casillas;
import Jugador.Jugador;

import java.util.Scanner;

public class Propiedades extends Casillas {
    Scanner scanner = new Scanner(System.in);
    //atributos de instancia
    protected boolean esServicio;
    protected boolean esFerrocarril;
    protected int costo;
    protected Jugador dueño;
    protected int renta;

    //Constructor
    public Propiedades(String nombre, int costo, Jugador dueño, int renta){
        super(nombre);
        this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
    }

    //Métodos
    private void cobrarRenta(Jugador jugador){
        if (this.dueño != jugador && this.dueño != null){
            jugador.pagarRenta(this.renta);
            this.dueño.recibirDinero(this.renta);
        }

    }
    private void ofrecerCompra(Jugador jugador){
        boolean flag = true;
        //Pedirle por consola al usuario si quiere comprar la propiedad.
        while (flag){
            System.out.println("¿Desea comprar la propiedad? (Si/No)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("si")){
                jugador.dinero -= this.costo;
                this.dueño = jugador;
                System.out.println("Compra realizada, gracias.");
                flag = false;
            }
            else{
                if (option.equalsIgnoreCase("no")){
                    System.out.println("Usted ha decidido no realizar la compra, adios.");
                    flag = false;
                }
                System.out.println("Respuesta incorrecta, vuelva a intentar.");
            }
        }
        scanner.close();
    }

    @Override
    public String getType(){
        return "Propiedades";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        ofrecerCompra(jugador);
        cobrarRenta(jugador);
    }
}
