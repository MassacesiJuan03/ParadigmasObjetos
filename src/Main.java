import java.util.Scanner;
import java.util.Random;

// Los comentarios que comienzan con "*" son dudas.


class Propiedades extends Casillas{
    //atributos de instancia
    protected boolean esServicio;
    protected boolean esFerrocarril;
    protected int costo;
    protected char dueño;
    protected int renta;

    //Constructor
    public Propiedades(int costo, char dueño, int renta, boolean esServicio, boolean esFerrocarril){
        super();
        {this.costo = costo;
        this.dueño = dueño;
        this.renta = renta;
        this.esFerrocarril = esFerrocarril;
        this.esServicio = esServicio;}
    }

    //Métodos
    public void cobrarRenta(){
        //Disminuir el dinero del jugador
    }
    public void ofrecerCompra(){
        //Pedirle por consola al usuario si quiere comprar la propiedad.
    }
}

class Adelante extends Casillas{
    //Métodos
    public void darSueldo(){
        //retornar el sueldo del jugador
        //cambiar void por int al implementar
    }
}

class ArcaOCasualidad extends Casillas{
    //atributos de instancia
    protected boolean esArca;

    //Métodos
    public void robarCarta(/*Carta carta*/){
        //Elegir una carta de la clase Cartas
    }
}

class Carta extends ArcaOCasualidad{
    //agregar algunas cartas a lo sumo recibir dinero del banco y salir de la cárcel
}

class Impuestos extends Casillas{
    //Métodos
    public void pagarImpuesto(){
        //Disminuir el dinero del jugador
        //*Incrementar el del banco
    }
}

class Estacionamiento extends Casillas{

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
}

public class Main {
    public static void main(String[] args) {

    }
}