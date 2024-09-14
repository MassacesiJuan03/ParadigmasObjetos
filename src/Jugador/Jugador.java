package Jugador;

import java.util.ArrayList;

import Casillas.Propiedades.Propiedad;

// Los comentarios que comienzan con "*" son dudas.
public class Jugador {
    // Atributos de instancia
    private int posicion;
    private String pieza;
    private String nombre;
    private boolean enBancarrota;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Integer> dadosAnteriores; // array de 1xn
    private int dinero;
    private boolean turno;
    private boolean enCarcel;
    private boolean tieneCartaSalidaDeCarcel;

    public Jugador(String pieza) {
        this.posicion = 0;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new ArrayList<>(); // Inicializar array vacío
        this.propiedades = new ArrayList<>();
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
    
    public boolean pagarRenta(int renta) {
        if (this.dinero >= renta){
            this.dinero -= renta;
            System.out.println("Renta de $" + renta + " pagada con éxito.");
            this.dineroRestante();
            return true;
        }
        System.out.println("Renta de $" + renta + " no pagada, dinero insuficiente");
        return false;
    }
    public void avanzar() {
        if (this.posicion == 19){
            this.posicion = 0;
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
    public boolean isEnBancarrota() {
        return enBancarrota;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEnBancarrota(boolean enBancarrota) {
        this.enBancarrota = enBancarrota;
    }
    public void agregarPropiedad(Propiedad propiedad){
        this.propiedades.add(propiedad);
    }
    public void mostrarPropiedades(){
        if (!this.propiedades.isEmpty()){
            System.out.print("Usted es dueño de: ");
            int i = 1;
            for (Propiedad propiedad: propiedades){
                if (i < propiedades.size()){
                    System.out.print(propiedad.getNombre() + ", ");
                    i++;
                }else{
                    System.out.println(propiedad.getNombre());
                }
            }
        }
    }
    public void eliminarPropiedad(){
        for(Propiedad propiedad: propiedades){
            propiedad.setDueño(null);
        }
        this.propiedades.clear();
    }
}