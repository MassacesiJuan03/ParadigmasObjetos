
// Los comentarios que comienzan con "*" son dudas.
public class Jugador {
    // Atributos de instancia
    int posicion;
    String pieza;
    boolean enBancarrota;
    int[] dadosAnteriores; // array de 1xn
    float dinero;
    boolean turno;
    boolean carcel;

    public Jugador(String pieza) {
        this.posicion = 0;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new int[0]; // Inicializar array vacío
        this.dinero = 1500; // Monto inicial estándar en Monopoly
        this.turno = false;
        this.carcel = false;
    }

    // Métodos
    public int[] tirarDados() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int[] resultado = {dado1, dado2};
        return resultado;
    }

    public void comprar() {
        // Lógica para comprar propiedades
    }

    public void setPosicion(int nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void avanzar(){
        this.posicion++;
        // Implementar chequeo de paso por la casilla de salida
    }

    public void pagarRenta(int renta) {
        this.dinero -= renta;
    }

    public void recibirDinero(int monto) {
        this.dinero += monto;
    }

    public String getPieza() {
        return pieza;
    }
}