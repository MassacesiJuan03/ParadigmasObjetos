package Casillas.Propiedades;

import Casillas.Casillas;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

import java.util.Scanner;

public class Propiedad extends Casillas implements IAccionDinero{
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
        jugador.pagarRenta(this.renta);
        this.dueño.recibirDinero(this.renta);
        System.out.println("Dinero: $" + jugador.getDinero());

    }
    public void ofrecerCompra(Jugador jugador){
        boolean flag = true;

        //Verificar si la propiedad tiene dueño
        if (this.dueño != null){
            //Verificar si el dueño es el mismo que cayó en la propiedad
            if (this.dueño == jugador){
                System.out.println("Usted es dueño de " + this.nombre);
            }
            //Cobrar renta al jugador que cayó en una propiedad con dueño
            else{
                cobrarRenta(jugador);
            }
            flag = false;
        }

        //Pedirle por consola al usuario comprar la propiedad si es que no tiene dueño.
        while (flag){
            System.out.println("¿Desea comprar la propiedad? (Si/No)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("si")){
                System.out.println("Compra de " + this.nombre + " realizada");
                this.dueño = jugador;
                accionDinero(jugador);
                flag = false;
            }
            else{
                if (option.equalsIgnoreCase("no")){
                    System.out.println("Usted ha decidido no realizar la compra de " + this.nombre);
                    flag = false;
                }else{
                    System.out.println("Respuesta incorrecta, vuelva a intentar.");
                }
            }
        }
    }

    public double accionDinero(Jugador jugador){
        jugador.setDinero(this.costo);
        System.out.println("Dinero: $" + jugador.getDinero());
        return jugador.getDinero();
    }

    @Override
    public String getType() {
        return "Propiedad";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        ofrecerCompra(jugador);
    }
}
