public class Casillas{
    //atributo de instancia
    protected int nroDeCasilla;

    public String nombre;

    //Constructor
    public Casillas(String nombre){
        this.nombre = nombre;
    }

    public Casillas(){
    }

    public String getNombre(){
        return nombre;
    }
}
