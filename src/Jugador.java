// Los comentarios que comienzan con "*" son dudas.

public class Jugador{
    //atributos de instancia
    int posicion;
    char pieza;
    boolean enBancarrota;
    int[] dadosAnteriores; //array de 1xn
    float dinero;
    boolean turno;

    //Constructor
    public Jugador(/*pasar los atributos de instancia*/){
        //this.atributo = parámetro;
    }
    //Métodos
    public void tirarDados(){
        //calcular los dados de manera aleatoria
        //Random random = new Random();
        //int dado1 = 1 + random.nextInt(6);
        //int dado2 = 1 + random.nextInt(6);
        //faltaría insertarlos en la lista, ej: {(dado1,dado2),...}
    }
    public void elegirPieza(){
        //Pedirle al usuario ingresar la pieza que quiera
    }
    public void comprar(){
        //Darle la opción de comprar
    }

}