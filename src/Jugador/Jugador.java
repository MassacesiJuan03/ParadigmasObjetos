package Jugador;

import java.util.ArrayList;

// Los comentarios que comienzan con "*" son dudas.
public class Jugador {
    // Atributos de instancia
    public int posicion;
    public String pieza;
    public String nombre;
    public boolean enBancarrota;
    public ArrayList<Integer> dadosAnteriores; // array de 1xn
    public int dinero;
    public boolean turno;
    public boolean enCarcel;
    public boolean tieneCartaSalidaDeCarcel;

    public Jugador(String pieza) {
        this.posicion = 0;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new ArrayList<>(); // Inicializar array vacío
        this.dinero = 1500; // Monto inicial estándar en Monopoly
        this.turno = false;
        this.enCarcel = false;
        this.tieneCartaSalidaDeCarcel = false;
    }

    // Métodos
    public int tirarDado() {
        int dado = (int) (Math.random() * 6) + 1;
        this.dadosAnteriores.add(dado);
        return dado;
    }

    public void imprimirDadosAnteriores() {
        if (dadosAnteriores.size() == 0) {
            System.out.println("No se han lanzado dados todavía.");
            return;
        }
        System.out.println("Dados anteriores: " + dadosAnteriores);
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
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Integer> getDadosAnteriores() {
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