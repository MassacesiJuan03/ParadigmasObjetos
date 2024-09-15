package Casillas.Propiedades;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

import java.util.Scanner;

public class Propiedad extends Casilla implements IAccionDinero {
    Scanner scanner = new Scanner(System.in);
    // atributos de instancia
    protected int costo;
    public Jugador dueño;
    protected int renta;

    // Constructor
    public Propiedad(String nombre, Boolean juegoAutomatico, int costo, Jugador dueño, int renta) {
        super(nombre, juegoAutomatico);
        this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
    }

    public Jugador getDueño(){
        return this.dueño;
    }

    // Métodos
    private void cobrarRenta(Jugador jugador) {
        // Verificar si el dueño no es el mismo jugador
        if (this.dueño != jugador) {
            // Cobrar renta al jugador que cayó en una propiedad con dueño
            if (jugador.pagarRenta(this.renta)){ // Dar el dinero al dueño si el jugador paga la renta
                this.dueño.recibirDinero(this.renta);
                System.out.println(this.dueño.getNombre() + " Ha recibido: " + this.renta );
            }
            else{
                jugador.setEnBancarrota(true);
            }
        }
    }

    public boolean ofrecerCompra(Jugador jugador) {
        if (juegoAutomatico) {
            // En modo automático, se realiza la compra sin preguntar
            System.out.println("Compra automática de " + this.nombre + " realizada.");
            this.dueño = jugador;
            accionDinero(jugador);
            jugador.dineroRestante();
            return true;
        } else {
            boolean flag = true;

            // Verificar si la propiedad tiene dueño
            if (this.dueño != null) {
                // Verificar si el dueño es el mismo que cayó en la propiedad
                if (this.dueño == jugador) {
                    System.out.println("Usted es dueño de " + this.nombre);
                }
                return false;
            }

            // Pedirle por consola al usuario comprar la propiedad si es que no tiene dueño.
            while (flag) {
                try{
                    System.out.println("¿Desea comprar " + this.nombre + " por $" + this.costo + "? (Si/No)");
                    String option = scanner.nextLine();
    
                    if (option.equalsIgnoreCase("si")) {
                        // Verificar si el jugador tiene el dinero suficiente para comprar
                        if (jugador.getDinero()>=this.costo){ 
                            System.out.println("Compra de " + this.nombre + " realizada.");
                            this.dueño = jugador;
                            jugador.agregarPropiedad(this);
                            accionDinero(jugador);
                            jugador.dineroRestante();
                        }else{
                            System.out.println("Compra no realizada, debido a dinero insuficiente");
                        }
                        break;    
                    } else if (option.equalsIgnoreCase("no")) {
                        System.out.println("Usted ha decidido no realizar la compra de " + this.nombre);
                        break;
                    } else {
                        throw new IllegalArgumentException("Respuesta incorrecta, vuelva a intentar.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            return true;
        }
    }

    public int accionDinero(Jugador jugador) {
        jugador.setDinero(this.costo);
        return jugador.getDinero();
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    @Override
    public void accion(Jugador jugador) {
        if (!ofrecerCompra(jugador)) { // Si la propiedad tiene dueño, se cobra una renta al otro jugador
            cobrarRenta(jugador);
        }
    }
}
