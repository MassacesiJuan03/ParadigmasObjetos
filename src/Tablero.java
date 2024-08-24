// Los comentarios que comienzan con "*" son dudas.

public class Tablero{
    //atributos de clase
    private static final int CANTIDAD_DE_CASILLAS = 40;
    //atributos de instancia
    //private boolean turno;
    private int cantidadDeJugadores;
    //* private Jugador jugador; Pasamos un objeto de tipo Jugador
    //Constructor
    public Tablero(int jugadores){
        this.cantidadDeJugadores = jugadores;
    }
    //Métodos
    public void empezarPartida(){
        //Scanner scanner = new Scanner(System.in);
        //boolean flag = false;
        //Se podría implementar un while y hacer la parte interactiva en consola
    }
    public void siguienteTurno(){
        //¿Usar relación (dependencia) y pasar el jugador como parámetro?
    }
}
