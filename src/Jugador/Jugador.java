package Jugador;

// Los comentarios que comienzan con "*" son dudas.
public class Jugador {
    // Atributos de instancia
    public int posicion;
    public String pieza;
    public String nombre;
    public boolean enBancarrota;
    public int[] dadosAnteriores; // array de 1xn
    public int dinero;
    public boolean turno;
    public boolean enCarcel;
    public boolean tieneCartaSalidaDeCarcel;

    public Jugador(String pieza) {
        this.posicion = 0;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new int[0]; // Inicializar array vacío
        this.dinero = 1500; // Monto inicial estándar en Monopoly
        this.turno = false;
        this.enCarcel = false;
        this.tieneCartaSalidaDeCarcel = false;
    }

    // Métodos
    public int[] tirarDados() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int[] resultado = {dado1, dado2};

        // Agregar array de resultado en dadosAnteriores
        int[] nuevosDadosAnteriores = new int[dadosAnteriores.length + 2];
        for (int i = 0; i < dadosAnteriores.length; i++) {
            nuevosDadosAnteriores[i] = dadosAnteriores[i];
        }
        nuevosDadosAnteriores[dadosAnteriores.length] = dado1;
        nuevosDadosAnteriores[dadosAnteriores.length + 1] = dado2;
        this.dadosAnteriores = nuevosDadosAnteriores;

        return resultado;
    }

    public void imprimirDadosAnteriores() {
        if (dadosAnteriores.length == 0) {
            System.out.println("No se han lanzado dados todavía.");
            return;
        }
        for (int i = 0; i < dadosAnteriores.length; i += 2) {
            System.out.print("[" + dadosAnteriores[i] + ", " + dadosAnteriores[i + 1] + "] ");
        }
        System.out.println();
    }
    public void pagarRenta(int renta) {
        if (renta <= this.dinero){
            this.dinero -= renta;
            System.out.println("Renta de $" + renta + " pagada con éxito.");
            this.dineroRestante();
        }
    }
    public void avanzar() {
        if (this.posicion == 19){
            this.posicion = 0;
            System.out.println("Paso por la casilla 'Adelante', recibe $200");
            this.dinero += 200;
            this.dineroRestante();
        }
        else{
            this.posicion++;
        }
    }
    public void dineroRestante(){
        System.out.println("Dinero restante: $" + this.dinero);
    }
    public void recibirDinero(int monto) {
        this.dinero += monto;
    }
    public String getPieza() {
        return pieza;
    }
    public int getDinero() {
        return dinero;
    }
    public int getPosicion() {
        return posicion;
    }
    public int[] getDadosAnteriores() {
        return dadosAnteriores;
    }
    public boolean isCarcel() {
        return enCarcel;
    }
    public boolean isTieneCartaSalidaDeCarcel() {
        return tieneCartaSalidaDeCarcel;
    }
    public void setDinero(int monto) {
        this.dinero -= monto;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    public void setCarcel(boolean dentroDeCarcel) {
        this.enCarcel = dentroDeCarcel;
    }
    public void setTieneCartaSalidaDeCarcel(boolean tieneCartaSalidaDeCarcel) {
        this.tieneCartaSalidaDeCarcel = tieneCartaSalidaDeCarcel;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}