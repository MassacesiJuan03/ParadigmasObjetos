package Jugador;

import java.util.ArrayList;

import Casillas.Propiedades.Propiedad;

/**
 * Representa a un jugador en el juego de Monopoly.
 * La clase maneja las propiedades del jugador, su estado, y las acciones que puede realizar en el juego.
 * @author Forni Diego, Massacesi Juan Ignacio
 */

public class Jugador {
    // Atributos de instancia
    private int posicion;
    private String pieza;
    private String nombre;
    private boolean enBancarrota;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Integer> dadosAnteriores; 
    private int dinero;
    private boolean turno;
    private boolean enCarcel;
    private boolean tieneCartaSalidaDeCarcel;

    /**
     * Crea una nueva instancia de la clase Jugador.
     * 
     * @param pieza La pieza del jugador (por ejemplo, un token en el juego).
     */
    public Jugador(String pieza) {
        this.posicion = 0;
        this.pieza = pieza;
        this.enBancarrota = false;
        this.dadosAnteriores = new ArrayList<>(); 
        this.propiedades = new ArrayList<>();
        this.dinero = 1000; // Monto inicial estándar en Monopoly
        this.turno = false;
        this.enCarcel = false;
        this.tieneCartaSalidaDeCarcel = false;
    }

    // Métodos
    /**
     * Lanza un dado y agrega el resultado a la lista de dados anteriores.
     *
     * @return El valor del dado lanzado (entre 1 y 6).
     */
    public int tirarDado() {
        int dado = (int) (Math.random() * 6) + 1;
        this.dadosAnteriores.add(dado);
        return dado;
    }

    /**
     * Imprime los valores de los dados lanzados anteriormente.
     */
    public void imprimirDadosAnteriores() {
        if (dadosAnteriores.size() == 0) {
            System.out.println("No se han lanzado dados todavía.");
            return;
        }
        System.out.println("Dados anteriores: " + dadosAnteriores);
    }
    
    /**
     * Realiza un pago de renta al jugador.
     *
     * @param renta La cantidad de renta a pagar.
     * @return true si el pago se realizó con éxito; false si no hay suficiente dinero.
     */
    public boolean pagarRenta(int renta) {
        if (this.dinero >= renta){
            this.dinero -= renta;
            return true;
        }
        return false;
    }

    /**
     * Avanza la posición del jugador en el tablero.
     * La posición se reinicia a 0 si el jugador llega a la posición 19.
     */
    public void avanzar() {
        if (this.posicion == 19){
            this.posicion = 0;
        }
        else{
            this.posicion++;
        }
    }

    /**
     * Imprime el dinero restante del jugador.
     */
    public void dineroRestante(){
        System.out.println("Dinero restante: $" + this.dinero);
    }

    /**
     * Agrega dinero al saldo del jugador.
     *
     * @param monto La cantidad de dinero a recibir.
     */
    public void recibirDinero(int monto) {
        this.dinero += monto;
    }

    /**
     * Obtiene la pieza del jugador.
     *
     * @return La pieza del jugador.
     */
    public String getPieza() {
        return pieza;
    }

    /**
     * Obtiene la cantidad de dinero del jugador.
     *
     * @return El de dinero del jugador.
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Obtiene la posición actual del jugador en el tablero.
     *
     * @return La posición actual del jugador.
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la lista de valores de dados lanzados anteriormente.
     *
     * @return La lista de dados anteriores.
     */
    public ArrayList<Integer> getDadosAnteriores() {
        return dadosAnteriores;
    }

    /**
     * Verifica si el jugador está en la cárcel.
     *
     * @return true si el jugador está en la cárcel; false en caso contrario.
     */
    public boolean isCarcel() {
        return enCarcel;
    }

    /**
     * Verifica si el jugador tiene una carta de salida de la cárcel.
     *
     * @return true si el jugador tiene una carta de salida de la cárcel; false en caso contrario.
     */
    public boolean isTieneCartaSalidaDeCarcel() {
        return tieneCartaSalidaDeCarcel;
    }

    /**
     * Verifica si el jugador está en bancarrota.
     *
     * @return true si el jugador está en bancarrota; false en caso contrario.
     */
    public boolean isEnBancarrota() {
        return enBancarrota;
    }

    /**
     * Establece la cantidad de dinero del jugador.
     * Esta operación se resta del saldo actual del jugador.
     *
     * @param monto La cantidad de dinero a restar.
     */
    public void setDinero(int monto) {
        this.dinero -= monto;
    }

    /**
     * Establece si es el turno del jugador.
     *
     * @param turno true si es el turno del jugador; false en caso contrario.
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    /**
     * Establece si el jugador está en la cárcel.
     *
     * @param dentroDeCarcel true si el jugador está en la cárcel; false en caso contrario.
     */
    public void setCarcel(boolean dentroDeCarcel) {
        this.enCarcel = dentroDeCarcel;
    }

    /**
     * Establece si el jugador tiene una carta de salida de la cárcel.
     *
     * @param tieneCartaSalidaDeCarcel true si el jugador tiene una carta de salida de la cárcel; false en caso contrario.
     */
    public void setTieneCartaSalidaDeCarcel(boolean tieneCartaSalidaDeCarcel) {
        this.tieneCartaSalidaDeCarcel = tieneCartaSalidaDeCarcel;
    }

    /**
     * Establece la posición del jugador en el tablero.
     *
     * @param posicion La nueva posición del jugador.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre El nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el estado de bancarrota del jugador.
     *
     * @param enBancarrota true si el jugador está en bancarrota; false en caso contrario.
     */
    public void setEnBancarrota(boolean enBancarrota) {
        this.enBancarrota = enBancarrota;
    }

    /**
     * Agrega una propiedad a la lista de propiedades del jugador.
     *
     * @param propiedad La propiedad a agregar.
     */
    public void agregarPropiedad(Propiedad propiedad){
        this.propiedades.add(propiedad);
    }

    /**
     * Muestra todas las propiedades que posee el jugador.
     */
    public void mostrarPropiedades(){
        if (!this.propiedades.isEmpty()){
            System.out.print("Usted es propietario de: ");
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

    /**
     * Elimina todas las propiedades del jugador y las establece sin propietario.
     */
    public void eliminarPropiedad(){
        for(Propiedad propiedad: propiedades){
            propiedad.setDueño(null);
        }
        this.propiedades.clear();
    }
}