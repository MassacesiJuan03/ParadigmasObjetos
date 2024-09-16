package IAccionDinero;
import Jugador.Jugador;

/**
 * Interfaz para definir acciones relacionadas con el manejo de dinero en el juego.
 * Las clases que implementan esta interfaz deben proporcionar una implementación
 * del método {@code accionDinero} que define cómo se maneja el dinero para un jugador
 * en una situación específica.
 */
public interface IAccionDinero {
    /**
     * Realiza una acción relacionada con el manejo de dinero para el jugador especificado.
     * 
     * @param jugador El jugador para el cual se realiza la acción de dinero.
     * @return La cantidad de dinero manejada o alterada como resultado de la acción.
     */
    public int accionDinero(Jugador jugador);
}
