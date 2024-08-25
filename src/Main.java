import java.util.Scanner;
import java.util.Random;

// Los comentarios que comienzan con "*" son dudas.


class Propiedades extends Casillas{
    //atributos de instancia
    protected boolean esServicio;
    protected boolean esFerrocarril;
    protected int costo;
    protected Jugador dueño;
    protected int renta;

    //Constructor
    public Propiedades(String nombre, int costo, Jugador dueño, int renta, boolean esServicio, boolean esFerrocarril){
        super(nombre);
        {this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
        this.esFerrocarril = esFerrocarril;
        this.esServicio = esServicio;}
    }

    //Métodos
    public void cobrarRenta(Jugador jugador){
        jugador.pagarRenta(this.renta);
        this.dueño.recibirDinero(this.renta);

    }
    public void ofrecerCompra(){
        //Pedirle por consola al usuario si quiere comprar la propiedad.
    }
}

class Adelante extends Casillas{
    //Métodos
    public void darSueldo(Jugador jugador){
        jugador.recibirDinero(200);
    }

    public Adelante(String nombre){
        super(nombre);
    }
}

class ArcaOCasualidad extends Casillas{
    //atributos de instancia
    protected boolean esArca;

    //Métodos
    public void robarCarta(/*Carta carta*/){
        //Elegir una carta de la clase Cartas
    }
    
    public ArcaOCasualidad(String nombre, boolean esArca){
        super(nombre);
        this.esArca = esArca;
    }
}


class Impuestos extends Casillas{
    //Métodos
    public void pagarImpuesto(Jugador jugador){
        //Disminuir el dinero del jugador
        jugador.pagarRenta(10);
        //*Incrementar el del banco
    }

    public Impuestos(String nombre){
        super(nombre);
    }
}

class Estacionamiento extends Casillas{

    public Estacionamiento(String nombre){
        super(nombre);
    }

}

class Carcel extends Casillas{
    //Métodos
    public void cobrarMulta(){
        //Disminuir el dinero del jugador
        //*Incrementar el del banco
    }
    public void salirDeLaCarcel(){
        //*Darle al jugador un atributo que sea un
        // booleano para saber si está fuera o dentro de la cárcel
    }

    public Carcel(String nombre){
        super(nombre);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}