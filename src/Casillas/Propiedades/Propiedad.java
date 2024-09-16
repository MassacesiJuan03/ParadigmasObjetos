package Casillas.Propiedades;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

import java.util.Scanner;

/**
 * Representa una casilla de propiedad en el tablero del juego.
 * Una propiedad puede ser comprada por un jugador y cobra renta a otros jugadores que caen en ella.
 * La propiedad puede tener un dueño y su costo y renta se definen al crearla.
 * Implementa la interfaz {@link IAccionDinero} para manejar acciones relacionadas con el dinero.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Propiedad extends Casilla implements IAccionDinero {
    Scanner scanner = new Scanner(System.in);
    // atributos de instancia
    protected int costo;
    public Jugador dueño;
    protected int renta;

    // Constructor
    /**
     * Crea una nueva instancia de una propiedad con el nombre, el costo, el dueño y la renta especificados.
     *
     * @param nombre El nombre de la propiedad.
     * @param juegoAutomatico Indica si el juego se realiza en modo automático.
     * @param costo El costo de la propiedad.
     * @param dueño El jugador que es el dueño de la propiedad. Puede ser {@code null} si no hay dueño.
     * @param renta La cantidad de renta que se cobra al caer en la propiedad.
     */
    public Propiedad(String nombre, Boolean juegoAutomatico, int costo, Jugador dueño, int renta) {
        super(nombre, juegoAutomatico);
        this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
    }

    /**
     * Obtiene el dueño actual de la propiedad.
     *
     * @return El jugador que es el dueño de la propiedad.
     */
    public Jugador getDueño(){
        return this.dueño;
    }

    // Métodos
    /**
     * Cobra la renta al jugador que cae en la propiedad, si la propiedad tiene dueño.
     * Si el jugador no puede pagar la renta, se marca como en bancarrota.
     *
     * @param jugador El jugador que cae en la propiedad.
     */
    private void cobrarRenta(Jugador jugador) {
        // Verificar si el dueño no es el mismo jugador
        if (this.dueño != jugador) {
            // Cobrar renta al jugador que cayó en una propiedad con dueño
            if (jugador.pagarRenta(this.renta)){ // Dar el dinero al dueño si el jugador paga la renta
                System.out.println("Renta de $" + renta + " pagada con éxito.");
                jugador.dineroRestante();
                this.dueño.recibirDinero(this.renta);
                System.out.println(this.dueño.getNombre() + " Ha recibido: $" + this.renta );
            }
            else{    
            System.out.println("Renta obligatoria de $" + renta + " no pagada, dinero insuficiente.");
                jugador.setEnBancarrota(true);
            }
        }
    }

    /**
     * Permite al jugador comprar la propiedad si no tiene dueño.
     * En modo automático, la compra se realiza automáticamente si el jugador tiene suficiente dinero.
     * En modo manual, se solicita al jugador que confirme la compra.
     *
     * @param jugador El jugador que desea comprar la propiedad.
     * @return {@code true} si la operación se realizó, {@code false} si no se realizó la compra.
     */
    public boolean ofrecerCompra(Jugador jugador) {   
        boolean flag = true;
        // Verificar si la propiedad tiene dueño
        if (this.dueño != null) {
            // Verificar si el dueño es el mismo que cayó en la propiedad
            if (this.dueño == jugador) {
                System.out.println("Usted es dueño de " + this.nombre + ".");
            }
            return false;
        }else{
            if (juegoAutomatico) {
                // En modo automático, se realiza la compra sin preguntar
                if (jugador.getDinero() >= this.costo){
                    System.out.println("Compra automática de " + this.nombre + " realizada.");
                    this.dueño = jugador;
                    jugador.agregarPropiedad(this);
                    accionDinero(jugador);
                    jugador.dineroRestante();
                }else{
                    System.out.println("Dinero insuficiente para realizar la compra de " + this.nombre + ".");
                }
                return true;
            } 
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
                        System.out.println("Compra no realizada, debido a dinero insuficiente.");
                    }
                        break;    
                } else if (option.equalsIgnoreCase("no")) {
                    System.out.println("Usted ha decidido no realizar la compra de " + this.nombre + ".");
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

    /**
     * Ajusta el dinero del jugador en función del costo de la propiedad.
     * Este método se utiliza para descontar el costo de la propiedad del dinero del jugador cuando compra.
     *
     * @param jugador El jugador que está realizando la compra.
     * @return El dinero restante del jugador después de la compra.
     */
    @Override
    public int accionDinero(Jugador jugador) {
        jugador.setDinero(this.costo);
        return jugador.getDinero();
    }

    /**
     * Establece el dueño de la propiedad.
     *
     * @param dueño El nuevo dueño de la propiedad.
     */
    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en la propiedad.
     * Si la propiedad tiene dueño, se cobra renta al jugador; si no, se ofrece la posibilidad de compra.
     *
     * @param jugador El jugador que cae en la propiedad.
     */
    @Override
    public void accion(Jugador jugador) {
        if (!ofrecerCompra(jugador)) { // Si la propiedad tiene dueño, se cobra una renta al otro jugador
            cobrarRenta(jugador);
        }
    }
}
