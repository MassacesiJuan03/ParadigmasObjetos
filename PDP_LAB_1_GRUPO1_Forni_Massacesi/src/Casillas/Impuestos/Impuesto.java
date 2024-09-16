package Casillas.Impuestos;

import Casillas.Casilla;
import IAccionDinero.IAccionDinero;
import Jugador.Jugador;

/**
 * Representa una casilla de impuesto en el tablero del juego.
 * Cuando un jugador cae en esta casilla, se le cobra un impuesto calculado en función de su dinero actual.
 * Si el jugador no puede pagar el impuesto, se marca como en bancarrota.
 * Implementa la interfaz {@link IAccionDinero} para manejar acciones relacionadas con el dinero.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class Impuesto extends Casilla implements IAccionDinero{
    //Constructor
    /**
     * Crea una nueva instancia de la casilla de impuesto con el nombre especificado.
     *
     * @param nombre El nombre de la casilla de impuesto.
     */
    public Impuesto(String nombre) {
        super(nombre);
    }

    //Métodos
    /**
     * Calcula y cobra el impuesto al jugador que cae en la casilla.
     * El monto del impuesto es el mayor entre el 10% del dinero del jugador y $200.
     * Si el jugador no tiene suficiente dinero para pagar el impuesto, se marca como en bancarrota.
     *
     * @param jugador El jugador al que se le cobrará el impuesto.
     */
    private void cobrarImpuesto(Jugador jugador){
        //Disminuir el dinero del jugador
        int montoImpuesto = accionDinero(jugador);
        if (montoImpuesto <= jugador.getDinero()){
            jugador.setDinero(montoImpuesto);
            System.out.println("Impuesto de $" + montoImpuesto + " pagado!");
            jugador.dineroRestante();
        }
        else{
            System.out.println("Impuesto de $" + montoImpuesto + " no pagado, dinero del jugador insuficiente.");
            jugador.setEnBancarrota(true);
        }
    }

    /**
     * Calcula el monto del impuesto a pagar en función del dinero actual del jugador.
     * El monto del impuesto es el mayor entre el 10% del dinero del jugador y $200.
     *
     * @param jugador El jugador cuyo impuesto se va a calcular.
     * @return El monto del impuesto a pagar.
     */
    @Override
    public int accionDinero(Jugador jugador){
        int monto = (int) Math.round(jugador.getDinero()*0.10);
        return Math.max(200, monto);
    }
    
    /**
     * Ejecuta la acción correspondiente cuando un jugador cae en la casilla de impuesto.
     * Esta acción incluye calcular y cobrar el impuesto al jugador.
     *
     * @param jugador El jugador que cae en la casilla de impuesto.
     */
    @Override
    public void accion(Jugador jugador){
        cobrarImpuesto(jugador);
    }
}
