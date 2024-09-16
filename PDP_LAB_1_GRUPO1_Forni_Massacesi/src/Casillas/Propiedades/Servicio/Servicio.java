package Casillas.Propiedades.Servicio;

import java.util.ArrayList;

import Casillas.Propiedades.Propiedad;
import Jugador.Jugador;

/**
 * Representa una casilla de servicio en el tablero del juego.
 * Un servicio es una propiedad especial que puede ser comprada por un jugador y cobra renta basada en el 
 * resultado del dado a otros jugadores que caen en ella, la renta se calcula como 20 veces el valor del 
 * dado lanzado.
 * La clase `Servicio` extiende la clase `Propiedad` y hereda su funcionalidad.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Servicio extends Propiedad {
    //Constructor
    /**
     * Crea una nueva instancia de un servicio con el nombre, el costo, el propietario y la renta especificados.
     *
     * @param nombre El nombre del servicio.
     * @param juegoAutomatico Indica si el juego se realiza en modo automático.
     * @param costo El costo del servicio.
     * @param propietario El jugador que es el propietario del servicio. Puede ser {@code null} si no hay propietario.
     * @param renta La cantidad de renta que se cobra al caer en el servicio.
     */
    public Servicio(String nombre, Boolean juegoAutomatico, int costo, Jugador propietario, int renta){
        super(nombre,juegoAutomatico, costo, propietario, renta);
    }

    //Métodos
    /**
     * Cobra la renta al jugador que ha caído en la casilla de servicio. La renta se calcula como 20 veces el valor
     * del último dado lanzado por el jugador. Si el jugador no tiene suficiente dinero, 
     * se marca al jugador como en bancarrota.
     * 
     * @param jugador El jugador que ha caído en la casilla de servicio.
     */
    private void cobrarRenta(Jugador jugador){
        if (this.propietario != jugador){
            //Calcular la renta basado en el dado
            ArrayList<Integer> dadosAnteriores = jugador.getDadosAnteriores();
            int renta = 20 * (dadosAnteriores.get(dadosAnteriores.size() - 1));
            if (jugador.getDinero() >= renta){
                jugador.setDinero(renta);
                System.out.println("Renta de $" + renta + " pagada con éxito.");
                jugador.dineroRestante();
            }else{  
                System.out.println("Renta obigatoria de $" + renta + "no pagada, dinero insuficiente.");
                jugador.setEnBancarrota(true);
            }
        }
    }

    /**
     * Realiza la acción correspondiente cuando un jugador cae en la casilla de servicio.
     *  Si la propiedad no tiene propietario,
     * se le ofrece la opción de compra al jugador. Si la propiedad tiene propietario,
     * se cobra la renta basada en el valor del dado.
     * 
     * @param jugador El jugador que ha caído en la casilla de servicio.
     */
    @Override
    public void accion(Jugador jugador){
        if (!super.ofrecerCompra(jugador)){
            cobrarRenta(jugador);
        }
    }
}
