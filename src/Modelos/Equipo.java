package Modelos;

import java.util.LinkedList;

/**
 * Un equipo de fútbol.
 * @author Camilo Andrés Molano y Martin Ostios
 * @version 1.0
 */
public class Equipo {
    private String nombre;
    private int anioFundacion;
    private int numTitulos;
    private int golesContra;
    private int partidosJugados;
    private LinkedList<Partido> misPartidos;
    private LinkedList<Aficionado> misAficionados;
    private LinkedList<Jugador> misJugadores;
    private Tecnico tecnico;
    
    /**
     * Constructor de objetos Equipo, con valores dados por el usuario
     * @param nombre nombre del equipo
     * @param anioFundacion año de fundación del equipo
     * @param numTitulos número de título obtenidos por el equipo
     * @param golesContra goles en contra hechos en la liga
     * @param partidosJugados  partidos jugados en la liga
     */
    public Equipo(String nombre, int anioFundacion, int numTitulos, int golesContra, int partidosJugados) {
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.numTitulos = numTitulos;
        this.golesContra = golesContra;
        this.partidosJugados = partidosJugados;
        this.misPartidos = new LinkedList<>();
        this.misAficionados = new LinkedList<>();
        this.misJugadores = new LinkedList<>();
    }
    
    //===Relaciones===
    //Agregación entre Equipo y Técnico
    public void agregarTecnico(Tecnico tecnico){
        this.setTecnico(tecnico);
    }
    
    //Agregación entre Equipo y Jugadores
    public void agregarJugador(Jugador jugador){
        this.getMisJugadores().add(jugador);
    }
    //================
    
    //===Métodos===
    
    /**
     * Revisa en la lista de jugadores cuál es el que tiene menos edad
     * @return objeto tipo Jugador
     */
    public Jugador jugadorMasJoven(){
        Jugador resultado = null;
        
        return resultado;
    }
    
    /**
     * Calcula el promedio de edad de las personas que hacen parte del equipo. (¿?)
     * @return promedio de edad
     */
    public double promEdad(){
        double resultado = 0.0;
        
        return resultado;
    }
    
    /**
     * Revisa en los partidos jugados, en cuáles se anotó más de 4 goles que el oponente.
     * @return suma de los partidos
     */
    public int cantPartidosGoleada(){
        int resultado = 0;
        
        return resultado;
    }
    
    /**
     * Busca el jugador con mayor cantidad de goles anotados en el equipo
     * @return objeto tipo Jugador
     */
    public Jugador jugadorMayorGoles(){
        Jugador resultado = null;
        
        return resultado;
    }
    
    /**
     * Revisa cuál es el salario del técnico y de los jugadores
     * @return suma del salario
     */
    public int totalNomina(){
        int resultado = 0;
        
        return resultado;
    }
    
    //=============

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anioFundacion
     */
    public int getAnioFundacion() {
        return anioFundacion;
    }

    /**
     * @param anioFundacion the anioFundacion to set
     */
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    /**
     * @return the numTitulos
     */
    public int getNumTitulos() {
        return numTitulos;
    }

    /**
     * @param numTitulos the numTitulos to set
     */
    public void setNumTitulos(int numTitulos) {
        this.numTitulos = numTitulos;
    }

    /**
     * @return the golesContra
     */
    public int getGolesContra() {
        return golesContra;
    }

    /**
     * @param golesContra the golesContra to set
     */
    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    /**
     * @return the partidosJugados
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * @param partidosJugados the partidosJugados to set
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * @return the misPartidos
     */
    public LinkedList<Partido> getMisPartidos() {
        return misPartidos;
    }

    /**
     * @param misPartidos the misPartidos to set
     */
    public void setMisPartidos(LinkedList<Partido> misPartidos) {
        this.misPartidos = misPartidos;
    }

    /**
     * @return the misAficionados
     */
    public LinkedList<Aficionado> getMisAficionados() {
        return misAficionados;
    }

    /**
     * @param misAficionados the misAficionados to set
     */
    public void setMisAficionados(LinkedList<Aficionado> misAficionados) {
        this.misAficionados = misAficionados;
    }

    /**
     * @return the misJugadores
     */
    public LinkedList<Jugador> getMisJugadores() {
        return misJugadores;
    }

    /**
     * @param misJugadores the misJugadores to set
     */
    public void setMisJugadores(LinkedList<Jugador> misJugadores) {
        this.misJugadores = misJugadores;
    }

    /**
     * @return the tecnico
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}
