package Carta.CartaDinero;

import Carta.Carta;
import Jugador.Jugador;

/**
 * Representa una carta de dinero en el juego.
 * Esta carta tiene un efecto financiero en el jugador, ya sea añadiendo o restando dinero.
 * @author Forni Diego, Massacesi Juan Ignacio
 */
public class CartaDinero extends Carta {
    //atributos de instancia
    public String descripcion;
    public int valor;

    //Constructor
    /**
     * Crea una nueva instancia de carta de dinero.
     *
     * @param descripcion Una descripción de la carta que detalla el efecto que tiene.
     * @param valor El valor monetario asociado con la carta. Puede ser positivo (ganancia) o negativo (pérdida).
     */
    public CartaDinero(String descripcion, int valor) {
        super();
        this.descripcion = descripcion;
        this.valor = valor;
    }

    //Métodos 
    /**
     * Aplica el efecto de la carta de dinero al jugador especificado.
     * Si el valor es negativo, descuenta dinero del jugador. Si el valor es positivo, suma dinero al jugador.
     * Si el jugador no tiene suficiente dinero para pagar una carta con valor negativo, se marca como en bancarrota.
     *
     * @param jugador El jugador al que se le aplicará el efecto de la carta.
     */
    @Override
    public void usar(Jugador jugador) {
        System.out.println("Se ha usado la carta de dinero: " + getDescripcion());
        if (this.valor < 0){
            if (jugador.getDinero() >= -this.valor){
                System.out.println(this.descripcion + ". Pagada con éxito!");
                jugador.recibirDinero(this.valor);
                jugador.dineroRestante();
            }
            else{
                System.out.println(this.descripcion + ". No ha sido pagada, saldo insuficiente");
                jugador.setEnBancarrota(true);
            }
        }else{
            jugador.recibirDinero(this.valor);
            jugador.dineroRestante();
        }
    }

    /**
     * Obtiene la descripción de la carta de dinero.
     *
     * @return La descripción de la carta.
     */
    @Override
    public String getDescripcion() {
        return this.descripcion;
    }
}
