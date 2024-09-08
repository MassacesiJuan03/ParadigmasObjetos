package Casillas.ArcaOCasualidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Carta.Carta;
import Carta.CartaDinero.CartaDinero;
import Carta.CartaIrDirectoCarcel.CartaIrDirectoCarcel;
import Carta.CartaSalirCarcel.CartaSalirCarcel;
import Casillas.Casillas;
import Jugador.Jugador;

public class ArcaOCasualidad extends Casillas {
    //atributos de instancia
    protected boolean esArca;
    private Carta carta; // de agregación ya que Carta es abstracta y no puedo instanciar carta

    //Constructor
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }

    //Métodos
    public void robarCarta(Jugador jugador){
        //Elegir una carta de la clase Cartas
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaDinero("Recibes $200", 200));
        cartas.add(new CartaSalirCarcel("Sale de la cárcel gratis. Esta tarjeta puede usarse en cualquier momento"));
        cartas.add(new CartaIrDirectoCarcel("Vas directamente a la cárcel. No pasas por 'Salida'. No cobras $200"));

        //Elegir una carta aleatoria
        Random random = new Random();
        int index = random.nextInt(cartas.size());
        carta = cartas.get(index);
        carta.usar(jugador);
    }


    
    @Override
    public String getType() {
        return "ArcaOCasualidad";
    }

    //Método abstracto y polimorfico
    public void accion(Jugador jugador){
        robarCarta(jugador);
    }
}
